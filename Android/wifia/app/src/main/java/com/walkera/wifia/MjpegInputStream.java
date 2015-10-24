package com.walkera.wifia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class MjpegInputStream extends DataInputStream {
    private static final int FRAME_MAX_LENGTH = 40100;
    private static final int HEADER_MAX_LENGTH = 100;
    private static final int REQUEST_TIMEOUT = 2000;
    private static final int SO_TIMEOUT = 1000;
    static DefaultHttpClient httpclient;
    private final String CONTENT_LENGTH;
    private final byte[] EOF_MARKER;
    private final byte[] SOI_MARKER;
    private int mContentLength;

    public static MjpegInputStream read(String url) {
        BasicHttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, REQUEST_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, SO_TIMEOUT);
        httpclient = new DefaultHttpClient(httpParams);
        try {
            URL url0 = new URL(url);
            UsernamePasswordCredentials upc = new UsernamePasswordCredentials("admin", "admin123");
            AuthScope as = new AuthScope(url0.getHost(), url0.getPort(), null);
            BasicCredentialsProvider bcp = new BasicCredentialsProvider();
            bcp.setCredentials(as, upc);
            httpclient.setCredentialsProvider(bcp);
            HttpResponse res = httpclient.execute(new HttpGet(url));
            if (res.getStatusLine().getStatusCode() != 200) {
                RunSurfaceView.wifiConFlag = false;
            } else {
                RunSurfaceView.wifiConFlag = true;
            }
            return new MjpegInputStream(res.getEntity().getContent());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public MjpegInputStream(InputStream in) {
        super(new BufferedInputStream(in, FRAME_MAX_LENGTH));
        this.SOI_MARKER = new byte[]{(byte) -1, (byte) -40};
        this.EOF_MARKER = new byte[]{(byte) -1, (byte) -39};
        this.CONTENT_LENGTH = "Content-Length";
        this.mContentLength = -1;
    }

    private int getEndOfSeqeunce(DataInputStream in, byte[] sequence) throws IOException {
        int seqIndex = 0;
        for (int i = 0; i < FRAME_MAX_LENGTH; i++) {
            if (((byte) in.readUnsignedByte()) == sequence[seqIndex]) {
                seqIndex++;
                if (seqIndex == sequence.length) {
                    return i + 1;
                }
            } else {
                seqIndex = 0;
            }
        }
        return -1;
    }

    private int getStartOfSequence(DataInputStream in, byte[] sequence) throws IOException {
        int end = getEndOfSeqeunce(in, sequence);
        return end < 0 ? -1 : end - sequence.length;
    }

    private int parseContentLength(byte[] headerBytes) throws IOException, NumberFormatException {
        ByteArrayInputStream headerIn = new ByteArrayInputStream(headerBytes);
        Properties props = new Properties();
        props.load(headerIn);
        return Integer.parseInt(props.getProperty("Content-Length"));
    }

    public Bitmap readMjpegFrame() throws IOException {
        byte[] frameData = null;
        mark(FRAME_MAX_LENGTH);
        int headerLen = getStartOfSequence(this, this.SOI_MARKER);
        reset();
        byte[] header = new byte[headerLen];
        readFully(header);
        try {
            this.mContentLength = parseContentLength(header);
        } catch (NumberFormatException e) {
            this.mContentLength = getEndOfSeqeunce(this, this.EOF_MARKER);
        }
        reset();
        frameData = new byte[this.mContentLength];
        skipBytes(headerLen);
        readFully(frameData);
        return BitmapFactory.decodeStream(new ByteArrayInputStream(frameData));
    }
}
