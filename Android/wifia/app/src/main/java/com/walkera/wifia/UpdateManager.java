package com.walkera.wifia;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import com.walkera.wifia.R;

public class UpdateManager {
    private static final int DOWNLOAD = 1;
    private static final int DOWNLOAD_FINISH = 2;
    private boolean cancelUpdate;
    private Context mContext;
    private Dialog mDownloadDialog;
    private Handler mHandler;
    HashMap<String, String> mHashMap;
    private ProgressBar mProgress;
    private String mSavePath;
    private int progress;
    private int serviceCode;
    private String serviceName;
    private int versionCode;
    private String versionName;

    /* renamed from: com.walkera.wifia.UpdateManager.1 */
    class C00161 extends Handler {
        C00161() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UpdateManager.DOWNLOAD /*1*/:
                    UpdateManager.this.mProgress.setProgress(UpdateManager.this.progress);
                case UpdateManager.DOWNLOAD_FINISH /*2*/:
                    UpdateManager.this.installApk();
                default:
            }
        }
    }

    /* renamed from: com.walkera.wifia.UpdateManager.2 */
    class C00172 implements OnClickListener {
        C00172() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            UpdateManager.this.showDownloadDialog();
        }
    }

    /* renamed from: com.walkera.wifia.UpdateManager.3 */
    class C00183 implements OnClickListener {
        C00183() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.walkera.wifia.UpdateManager.4 */
    class C00194 implements OnClickListener {
        C00194() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            UpdateManager.this.cancelUpdate = true;
        }
    }

    private class downloadApkThread extends Thread {
        private downloadApkThread() {
        }

        public void run() {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    UpdateManager.this.mSavePath = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory() + "/")).append("download").toString();
                    HttpURLConnection conn = (HttpURLConnection) new URL((String) UpdateManager.this.mHashMap.get("url")).openConnection();
                    conn.connect();
                    int length = conn.getContentLength();
                    InputStream is = conn.getInputStream();
                    File file = new File(UpdateManager.this.mSavePath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    FileOutputStream fos = new FileOutputStream(new File(UpdateManager.this.mSavePath, (String) UpdateManager.this.mHashMap.get("name")));
                    int count = 0;
                    byte[] buf = new byte[1024];
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        UpdateManager.this.progress = (int) ((((float) count) / ((float) length)) * 100.0f);
                        UpdateManager.this.mHandler.sendEmptyMessage(UpdateManager.DOWNLOAD);
                        if (numread <= 0) {
                            UpdateManager.this.mHandler.sendEmptyMessage(UpdateManager.DOWNLOAD_FINISH);
                            break;
                        }
                        fos.write(buf, 0, numread);
                    } while (!UpdateManager.this.cancelUpdate);
                    fos.close();
                    is.close();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            UpdateManager.this.mDownloadDialog.dismiss();
        }
    }

    public UpdateManager(Context context) {
        this.cancelUpdate = false;
        this.mHandler = new C00161();
        this.mContext = context;
    }

    public void checkUpdate() {
        if (isUpdate()) {
            showNoticeDialog();
        }
    }

    private boolean isUpdate() {
        this.versionCode = getVersionCode(this.mContext);
        this.versionName = getVersionName(this.mContext);
        InputStream inStream = ParseXmlService.class.getClassLoader().getResourceAsStream("version.xml");
        if (inStream == null) {
            return false;
        }
        try {
            this.mHashMap = new ParseXmlService().parseXml(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mHashMap != null) {
            this.serviceCode = Integer.valueOf((String) this.mHashMap.get("version")).intValue();
            this.serviceName = (String) this.mHashMap.get("name");
            if (this.serviceCode > this.versionCode) {
                return true;
            }
        }
        return false;
    }

    private int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            android.content.pm.PackageInfo info = context.getPackageManager().getPackageInfo("com.walkera.wifia", 0);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return versionCode;
        }
    }

    private String getVersionName(Context context) {
        String versionName = null;
        try {
            return context.getPackageManager().getPackageInfo("com.walkera.wifia", 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return versionName;
        }
    }

    private void showNoticeDialog() {
        StringBuffer sb = new StringBuffer();
        sb.append("Current ver:");
        sb.append(this.versionName);
        sb.append(" Code:");
        sb.append(this.versionCode);
        sb.append(",New ver:");
        sb.append(this.serviceName);
        sb.append(" Code:");
        sb.append(this.serviceCode);
        Builder builder = new Builder(this.mContext);
        builder.setTitle(R.string.soft_update_title);
        builder.setMessage(sb.toString());
        builder.setPositiveButton(R.string.soft_update_updatebtn, new C00172());
        builder.setNegativeButton(R.string.soft_update_later, new C00183());
        builder.create().show();
    }

    private void showDownloadDialog() {
        Builder builder = new Builder(this.mContext);
        builder.setTitle(R.string.soft_updating);
        View v = LayoutInflater.from(this.mContext).inflate(R.layout.softupdate_progress, null);
        this.mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
        builder.setView(v);
        builder.setNegativeButton(R.string.soft_update_cancel, new C00194());
        this.mDownloadDialog = builder.create();
        this.mDownloadDialog.show();
        downloadApk();
    }

    private void downloadApk() {
        new downloadApkThread().start();
    }

    private void installApk() {
        File apkfile = new File(this.mSavePath, (String) this.mHashMap.get("name"));
        if (apkfile.exists()) {
            Intent i = new Intent("android.intent.action.VIEW");
            i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
            this.mContext.startActivity(i);
        }
    }
}
