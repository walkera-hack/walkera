package com.walkera.wifib;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Environment;
import android.text.format.Time;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Timer;

public class EncodeDisplay {
    public static String CameraIp;
    public static String CtrlIp;
    public static String CtrlPort;
    static boolean IsFlag;
    static boolean IsFlag0;
    static String ROOT;
    static String SDPATH;
    static Canvas canvasTemp;
    static double distance;
    static boolean fflag;
    static boolean gpsFlag;
    static float hRatio;
    static int hour;
    static int hour0;
    static int hr;
    static MjpegInputStream mIn;
    static boolean mRun;
    static Matrix matrix;
    static int min;
    static int minute;
    static int minute0;
    static boolean pathFlag;
    static String pathi;
    static String pathv;
    static boolean photoFlag;
    static File photofile;
    static boolean photosFlag;
    static String photostring;
    static boolean receiveFlag;
    static boolean receiveOkFlag;
    static boolean running;
    static int sec;
    static int second;
    static int second0;
    static String str_altitude;
    static String str_latitude;
    static String str_longitude;
    static String str_velocity;
    static boolean surfaceDone;
    static MjpegViewThread thread;
    static boolean timeFlag;
    static boolean transferring;
    static boolean updateFlag;
    static boolean updateFlag0;
    static boolean videoFlag;
    static float wRatio;
    byte[] altitude;
    int bits_count;
    Bitmap bmp0;
    Bitmap bmp1;
    Bitmap bmp2;
    int bufSize;
    ByteBuffer buffer0;
    private int height;
    byte[] latitude;
    int length;
    byte[] longitude;
    private String mInUrl;
    byte[] mPixel;
    public Socket mSocketClient;
    public OutputStream send;
    Timer timer;
    String urlstr;
    byte[] velocity;
    private int width;

    /* renamed from: com.walkera.wifib.EncodeDisplay.1 */
    class C00001 extends Thread {
        C00001() {
        }

        public void run() {
            setPriority(9);
            long time0 = 0;
            int i = 0;
            int j = 0;
            int sum = 0;
            while (EncodeDisplay.videoFlag) {
                try {
                    Thread.sleep(66 - time0);
                    time0 = System.currentTimeMillis();
                    EncodeDisplay.sec += EncodeDisplay.EncodeRun(i);
                    if (EncodeDisplay.sec == 60) {
                        EncodeDisplay.sec = 0;
                        EncodeDisplay.min++;
                        if (EncodeDisplay.min == 60) {
                            EncodeDisplay.min = 0;
                            EncodeDisplay.hr++;
                            if (EncodeDisplay.hr == 12) {
                                EncodeDisplay.hr = 0;
                            }
                        }
                    }
                    j++;
                    i = 0;
                    time0 = System.currentTimeMillis() - time0;
                    if (time0 >= 66 && time0 <= 100) {
                        sum = (int) (((long) sum) + (time0 - 66));
                        time0 = 66;
                        if (sum >= 66) {
                            sum -= 66;
                            i = 1;
                        }
                    } else if (time0 > 100 && time0 <= 132) {
                        i = 1;
                        time0 = 66;
                    } else if (time0 > 132) {
                        i = 2;
                        time0 = 66;
                    }
                    if (j >= 15 && i == 0) {
                        i = 1;
                        j = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            EncodeDisplay.EncodeStop();
        }
    }

    class CommandSend extends Thread {
        public OutputStream send;

        public CommandSend() {
            EncodeDisplay.transferring = true;
            try {
                EncodeDisplay.this.mSocketClient = new Socket(EncodeDisplay.CtrlIp, Integer.parseInt(EncodeDisplay.CtrlPort));
                this.send = EncodeDisplay.this.mSocketClient.getOutputStream();
            } catch (NumberFormatException e) {
                EncodeDisplay.transferring = false;
                e.printStackTrace();
            } catch (UnknownHostException e2) {
                EncodeDisplay.transferring = false;
                e2.printStackTrace();
            } catch (IOException e3) {
                EncodeDisplay.transferring = false;
                e3.printStackTrace();
            }
        }

        public void run() {
            setPriority(7);
            while (EncodeDisplay.transferring) {
                try {
                    if (EncodeDisplay.updateFlag0) {
                        RunSurfaceView.getValue();
                        this.send.write(RunSurfaceView.cmdBuffer);
                        this.send.flush();
                        Thread.sleep(30);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (this.send != null) {
                        try {
                            this.send.close();
                            this.send = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (EncodeDisplay.this.mSocketClient != null) {
                        try {
                            EncodeDisplay.this.mSocketClient.close();
                            EncodeDisplay.this.mSocketClient = null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        EncodeDisplay.this.mSocketClient = new Socket(EncodeDisplay.CtrlIp, Integer.parseInt(EncodeDisplay.CtrlPort));
                        this.send = EncodeDisplay.this.mSocketClient.getOutputStream();
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                    } catch (UnknownHostException e12) {
                        e12.printStackTrace();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
            }
            if (this.send != null) {
                try {
                    this.send.close();
                    this.send = null;
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
            if (EncodeDisplay.this.mSocketClient != null) {
                try {
                    EncodeDisplay.this.mSocketClient.close();
                    EncodeDisplay.this.mSocketClient = null;
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            }
            EncodeDisplay.transferring = false;
        }
    }

    public class MjpegViewThread extends Thread {
        public void run() {
            boolean flag1 = true;
            while (EncodeDisplay.mRun) {
                if (EncodeDisplay.surfaceDone) {
                    try {
                        if (EncodeDisplay.mIn != null || EncodeDisplay.this.mInUrl == null) {
                            EncodeDisplay.this.bmp0 = null;
                            EncodeDisplay.this.bmp0 = EncodeDisplay.mIn.readMjpegFrame();
                            if (EncodeDisplay.this.bmp0 != null) {
                                if (flag1) {
                                    EncodeDisplay.IsFlag = true;
                                    EncodeDisplay.this.width = EncodeDisplay.this.bmp0.getWidth();
                                    EncodeDisplay.this.height = EncodeDisplay.this.bmp0.getHeight();
                                    EncodeDisplay.this.length = (EncodeDisplay.this.width * EncodeDisplay.this.height) * 2;
                                    if (EncodeDisplay.this.bmp0.getConfig().compareTo(Config.RGB_565) != 0) {
                                        EncodeDisplay.this.bmp1 = Bitmap.createBitmap(EncodeDisplay.this.width, EncodeDisplay.this.height, Config.RGB_565);
                                        EncodeDisplay.canvasTemp = new Canvas(EncodeDisplay.this.bmp1);
                                        EncodeDisplay.fflag = true;
                                    } else {
                                        EncodeDisplay.fflag = false;
                                    }
                                    EncodeDisplay.this.mPixel = new byte[EncodeDisplay.this.length];
                                    for (int j = 0; j < EncodeDisplay.this.length; j++) {
                                        EncodeDisplay.this.mPixel[j] = (byte) 0;
                                    }
                                    EncodeDisplay.this.buffer0 = ByteBuffer.wrap(EncodeDisplay.this.mPixel);
                                    flag1 = false;
                                }
                                if (EncodeDisplay.this.bmp0.getConfig().compareTo(Config.RGB_565) != 0) {
                                    EncodeDisplay.this.bmp2 = EncodeDisplay.this.bmp0;
                                    EncodeDisplay.canvasTemp.drawBitmap(EncodeDisplay.this.bmp0, 0.0f, 0.0f, null);
                                } else {
                                    EncodeDisplay.this.bmp1 = EncodeDisplay.this.bmp0;
                                }
                                if (EncodeDisplay.photoFlag) {
                                    EncodeDisplay.photoFlag = false;
                                    new TakePicThread().start();
                                }
                                if (EncodeDisplay.videoFlag) {
                                    EncodeDisplay.this.buffer0.clear();
                                    EncodeDisplay.this.bmp1.copyPixelsToBuffer(EncodeDisplay.this.buffer0);
                                    EncodeDisplay.EncodeBitmap(EncodeDisplay.this.buffer0.array());
                                }
                                EncodeDisplay.updateFlag = true;
                                EncodeDisplay.updateFlag0 = true;
                            }
                        } else if (RunSurfaceView.getWifiStatus() == 12291) {
                            EncodeDisplay.mIn = MjpegInputStream.read(EncodeDisplay.this.mInUrl);
                            if (EncodeDisplay.mIn != null && RunSurfaceView.isOn) {
                                new CommandSend().start();
                            }
                        } else {
                            EncodeDisplay.mRun = false;
                            EncodeDisplay.surfaceDone = false;
                        }
                    } catch (Exception e) {
                        if (EncodeDisplay.mIn != null) {
                            try {
                                EncodeDisplay.mIn.close();
                                EncodeDisplay.mIn = null;
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        EncodeDisplay.this.CmdSendStop();
                        EncodeDisplay.updateFlag0 = false;
                        RunSurfaceView.wifiConFlag = false;
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class TakePicThread extends Thread {
        TakePicThread() {
        }

        public void run() {
            try {
                EncodeDisplay.this.Photo();
                if (EncodeDisplay.photofile != null) {
                    FileOutputStream fos = new FileOutputStream(EncodeDisplay.photofile);
                    if (EncodeDisplay.this.bmp1 != null) {
                        EncodeDisplay.this.bmp1.compress(CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
                    } else if (EncodeDisplay.photofile.exists()) {
                        EncodeDisplay.photofile.delete();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            EncodeDisplay.photosFlag = false;
        }
    }

    private static native void EncodeBitmap(byte[] bArr);

    private static native void EncodePcm(byte[] bArr, int i);

    private static native int EncodeRun(int i);

    private static native void EncodeStart();

    private static native void EncodeStop();

    private static native void FileName(String str, int i, int i2);

    private static native void FilePcm(String str);

    private static native int GetCount();

    private static native double GetNumber();

    private static native int GetState();

    private static native String getFFmpegVersion();

    static {
        IsFlag = true;
        IsFlag0 = true;
        fflag = false;
        receiveFlag = false;
        receiveOkFlag = false;
        str_longitude = "";
        str_latitude = "";
        str_altitude = "";
        str_velocity = "";
        gpsFlag = false;
        pathFlag = false;
        mIn = null;
        mRun = false;
        surfaceDone = false;
        matrix = new Matrix();
        photofile = null;
        updateFlag = false;
        updateFlag0 = false;
        photoFlag = false;
        photosFlag = false;
        videoFlag = false;
        running = false;
        transferring = false;
        timeFlag = true;
        System.loadLibrary("mp3lame");
        System.loadLibrary("x264");
        System.loadLibrary("ffmpeg");
        System.loadLibrary("mux");
    }

    public EncodeDisplay() {
        this.bufSize = 12;
        this.bits_count = 0;
        this.latitude = new byte[this.bufSize];
        this.longitude = new byte[this.bufSize];
        this.altitude = new byte[this.bufSize];
        this.velocity = new byte[this.bufSize];
        this.mInUrl = null;
        CameraIp = "http://192.168.10.1:8080/?action=stream";
        CtrlIp = "192.168.10.1";
        CtrlPort = "2001";
        this.urlstr = CameraIp;
    }

    public byte[] readStream(InputStream inStream) throws Exception {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        while (true) {
            int len = inStream.read(buffer);
            if (len == -1) {
                byte[] data = outStream.toByteArray();
                outStream.close();
                inStream.close();
                return data;
            }
            outStream.write(buffer, 0, len);
        }
    }

    public Bitmap BitmapFit0(Bitmap bitmap) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        if (IsFlag0) {
            if (Helicopter.screenWidth >= bmpWidth) {
                wRatio = (((float) Helicopter.screenWidth) * 1.0f) / ((float) bmpWidth);
            } else {
                wRatio = (((float) bmpWidth) * 1.0f) / ((float) Helicopter.screenWidth);
            }
            if (Helicopter.screenHeight >= bmpHeight) {
                hRatio = (((float) Helicopter.screenHeight) * 1.0f) / ((float) bmpHeight);
            } else {
                hRatio = (((float) bmpHeight) * 1.0f) / ((float) Helicopter.screenHeight);
            }
            IsFlag0 = false;
        }
        matrix.reset();
        matrix.setScale(wRatio, hRatio);
        return Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
    }

    public Bitmap BitmapFit(Bitmap bitmap) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        if (IsFlag) {
            if (LogoSurfaceView.f3w >= bmpWidth) {
                wRatio = (((float) LogoSurfaceView.f3w) * 1.0f) / ((float) bmpWidth);
            } else {
                wRatio = (((float) bmpWidth) * 1.0f) / ((float) LogoSurfaceView.f3w);
            }
            if (LogoSurfaceView.f2h >= bmpHeight) {
                hRatio = (((float) LogoSurfaceView.f2h) * 1.0f) / ((float) bmpHeight);
            } else {
                hRatio = (((float) bmpHeight) * 1.0f) / ((float) LogoSurfaceView.f2h);
            }
            IsFlag = false;
        }
        matrix.reset();
        matrix.setScale(wRatio, hRatio);
        return Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
    }

    public boolean checkSDCard() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        ROOT = Environment.getExternalStorageDirectory().getPath();
        SDPATH = ROOT + "/DCIM/Horse/";
        return true;
    }

    public String getDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int hour = ca.get(Calendar.HOUR);
        int minute = ca.get(Calendar.MINUTE);
        int second = ca.get(Calendar.SECOND);
        int millisecond = ca.get(Calendar.MILLISECOND);
        return "" + year + (month + 1) + day + hour + minute + second + millisecond;
    }

    public String getTime() {
        String time0 = "";
        Time mTime = new Time();
        mTime.setToNow();
        if (timeFlag) {
            hour0 = mTime.hour;
            minute0 = mTime.minute;
            second0 = mTime.second;
            timeFlag = false;
            return new StringBuilder(String.valueOf(time0)).append("00:00").toString();
        }
        hour = mTime.hour;
        minute = mTime.minute;
        second = mTime.second;
        if (second < second0) {
            second = (second + 60) - second0;
            if (minute > 0) {
                minute--;
            } else {
                hour--;
                minute = (minute + 60) - 1;
            }
        } else {
            second -= second0;
        }
        if (minute < minute0) {
            minute = (minute + 60) - minute0;
            hour--;
        } else {
            minute -= minute0;
        }
        hour -= hour0;
        if (hour != 0) {
            if (hour < 10) {
                time0 = new StringBuilder(String.valueOf(time0)).append("0").append(hour).append(":").toString();
            } else if (hour >= 10) {
                time0 = new StringBuilder(String.valueOf(time0)).append(hour).append(":").toString();
                if (hour == 12) {
                    timeFlag = true;
                }
            }
        }
        if (minute < 10) {
            time0 = new StringBuilder(String.valueOf(time0)).append("0").append(minute).append(":").toString();
        } else {
            time0 = new StringBuilder(String.valueOf(time0)).append(minute).append(":").toString();
        }
        if (second < 10) {
            return new StringBuilder(String.valueOf(time0)).append("0").append(second).toString();
        }
        return new StringBuilder(String.valueOf(time0)).append(second).toString();
    }

    public String getT() {
        String tim = "";
        if (hr != 0) {
            if (hr < 10) {
                tim = new StringBuilder(String.valueOf(tim)).append("0").append(hr).append(":").toString();
            } else if (hr >= 10) {
                tim = new StringBuilder(String.valueOf(tim)).append(hr).append(":").toString();
            }
        }
        if (min < 10) {
            tim = new StringBuilder(String.valueOf(tim)).append("0").append(min).append(":").toString();
        } else {
            tim = new StringBuilder(String.valueOf(tim)).append(min).append(":").toString();
        }
        if (sec < 10) {
            return new StringBuilder(String.valueOf(tim)).append("0").append(sec).toString();
        }
        return new StringBuilder(String.valueOf(tim)).append(sec).toString();
    }

    public String getDate0() {
        Time mTime = new Time();
        mTime.setToNow();
        int year = mTime.year;
        int month = mTime.month;
        int day = mTime.monthDay;
        if (month >= 9) {
            return year + "-" + (month + 1) + "-" + day;
        }
        return year + "-0" + (month + 1) + "-" + day;
    }

    public String getDate1() {
        Time mTime = new Time();
        mTime.setToNow();
        int year = mTime.year;
        int month = mTime.month;
        int day = mTime.monthDay;
        int hour = mTime.hour;
        int minute = mTime.minute;
        int second = mTime.second;
        if (month >= 9) {
            if (hour < 10) {
                return year + (month + 1) + day + "0" + hour + minute + second;
            }
            return "" + year + (month + 1) + day + hour + minute + second;
        } else if (hour < 10) {
            return year + "0" + (month + 1) + day + "0" + hour + minute + second;
        } else {
            return year + "0" + (month + 1) + day + hour + minute + second;
        }
    }

    public void Photo() {
        photofile = null;
        photostring = null;
        if (checkSDCard()) {
            if (pathFlag) {
                pathi = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Photos").toString();
                File f0 = new File(pathi);
                if (!f0.exists()) {
                    try {
                        f0.mkdirs();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            File f = new File(pathi + "/" + getDate0());
            if (!f.exists()) {
                try {
                    f.mkdirs();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            photostring = f + "/" + getDate1() + ".jpg";
            photofile = new File(f + "/" + getDate1() + ".jpg");
            try {
                photofile.createNewFile();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void TakePic() {
        if (!photoFlag) {
            photoFlag = true;
            photosFlag = true;
        }
    }

    public void EncodeEnd() {
        if (updateFlag0 && videoFlag) {
            videoFlag = false;
            RunSurfaceView.wifiFlag = false;
        }
    }

    public void Begin() {
        if (checkSDCard()) {
            pathv = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Videos").toString();
            File f = new File(pathv);
            if (!f.exists()) {
                try {
                    f.mkdirs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            pathi = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Photos").toString();
            File f0 = new File(pathi);
            if (!f0.exists()) {
                try {
                    f0.mkdirs();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            pathFlag = true;
            return;
        }
        pathFlag = false;
    }

    public void EncodeBegin() {
        hr = 0;
        min = 0;
        sec = 0;
        if (updateFlag0 && checkSDCard()) {
            if (pathFlag) {
                pathv = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Videos").toString();
                File f0 = new File(pathv);
                if (!f0.exists()) {
                    try {
                        f0.mkdirs();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            File f = new File(pathv + "/" + getDate0());
            if (!f.exists()) {
                try {
                    f.mkdirs();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            String videoname = f + "/" + getDate1() + ".mp4";
            try {
                new File(videoname).createNewFile();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            FileName(videoname, this.width, this.height);
            EncodeStart();
            videoFlag = true;
            new C00001().start();
        }
    }

    public void EncodeBfeStart() {
        updateFlag0 = false;
        startPlayback();
    }

    public void EncodeAftEnd() {
        updateFlag0 = false;
        IsFlag = false;
        stopPlayback();
    }

    public void CmdSendStop() {
        transferring = false;
    }

    public void CmdSendStart() {
        new CommandSend().start();
    }

    public void startPlayback() {
        this.mInUrl = CameraIp;
        if (mIn != null) {
            try {
                mIn.close();
                mIn = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (mIn == null || this.mInUrl != null) {
            mRun = true;
            surfaceDone = true;
            thread = new MjpegViewThread();
            try {
                thread.start();
            } catch (IllegalThreadStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void stopPlayback() {
        mRun = false;
        surfaceDone = false;
        boolean retry = true;
        while (retry) {
            try {
                if (thread != null && thread.isAlive()) {
                    thread.join(10);
                }
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
