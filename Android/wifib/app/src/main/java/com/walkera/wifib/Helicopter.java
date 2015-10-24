package com.walkera.wifib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

@SuppressLint({"HandlerLeak"})
public class Helicopter extends Activity {
    static AudioManager am;
    static Animation animation;
    static Context context;
    static float density;
    static int densityDpi;
    static boolean end;
    static boolean fflag;
    static Handler hd;
    static LayoutInflater layoutInflater;
    static Matrix matrix;
    static int modelFlag;
    static Helicopter myActivity;
    static TelephonyManager phoneManager;
    static Resources resources;
    static RunSurfaceView runSurfaceView;
    static float scales;
    static float scales0;
    static int screenHeight;
    static int screenWidth;
    static boolean start;
    static int viewFlag;
    static int viewOldFlag;
    static int volume;
    CurveSurfaceView curveSurfaceView;
    LogoSurfaceView logoSurfaceView;
    ManualSurfaceView manualSurfaceView;

    /* renamed from: com.walkera.wifib.Helicopter.1 */
    class C00031 extends Handler {
        C00031() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.LOGO /*1*/:
                    Helicopter.viewOldFlag = 1;
                    Helicopter.viewFlag = 1;
                    Helicopter.this.setLogoSurfaceView();
                case Constant.MANUAL /*2*/:
                    Helicopter.viewFlag = 2;
                    Helicopter.this.setManualSurfaceView();
                case Constant.RUN /*3*/:
                    Helicopter.viewOldFlag = 3;
                    Helicopter.viewFlag = 3;
                    Helicopter.this.setRunSurfaceView();
                default:
            }
        }
    }

    static {
        matrix = new Matrix();
        end = false;
        start = true;
        fflag = false;
        modelFlag = 0;
        viewOldFlag = 0;
        viewFlag = 0;
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("state0", viewFlag);
        outState.putInt("state1", viewOldFlag);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        myActivity = this;
        resources = context.getResources();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
        density = dm.density;
        densityDpi = dm.densityDpi;
        am = (AudioManager) context.getSystemService("audio");
        volume = am.getStreamMaxVolume(3);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        phoneManager = (TelephonyManager) context.getSystemService("phone");
        phoneManager.listen(new PhoneListener(context), 32);
        if (savedInstanceState != null) {
            viewFlag = savedInstanceState.getInt("state0");
            viewOldFlag = savedInstanceState.getInt("state1");
        } else {
            viewFlag = 1;
            viewOldFlag = 1;
        }
        new UpdateManager(context).checkUpdate();
        getPreferences();
        if (start) {
            LogoSurfaceView.init();
            CurveSurfaceView.init();
            RunSurfaceView.init();
            SystemClock.sleep(200);
            start = false;
        }
        hd = new C00031();
        setView(viewFlag);
    }

    public void setOrientation() {
        if (fflag) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
    }

    public int getRot() {
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation != 2) {
            int i = getResources().getConfiguration().orientation;
        }
    }

    public String getPath(Uri uri) {
        Cursor cursor = managedQuery(uri, new String[]{"_data"}, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        }
    }

    public void getPreferences() {
        SharedPreferences settings = getSharedPreferences("backup00", 0);
        RunSurfaceView.elevinv = settings.getBoolean("elevinv", false);
        RunSurfaceView.aileinv = settings.getBoolean("aileinv", false);
        RunSurfaceView.throinv = settings.getBoolean("throinv", false);
        RunSurfaceView.ruddinv = settings.getBoolean("ruddinv", false);
        RunSurfaceView.mode = settings.getInt("mode", 1);
        RunSurfaceView.leftOn = settings.getBoolean("leftOn", false);
        RunSurfaceView.hiddenFlag = settings.getBoolean("hiddenFlag", false);
        RunSurfaceView.elevIDec = (short) settings.getInt("elevIDec", 0);
        RunSurfaceView.aileIDec = (short) settings.getInt("aileIDec", 0);
        RunSurfaceView.throIDec = (short) settings.getInt("throIDec", 0);
        RunSurfaceView.ruddIDec = (short) settings.getInt("ruddIDec", 0);
        RunSurfaceView.auxIDec = (short) settings.getInt("auxIDec", 0);
        RunSurfaceView.helmFlag = settings.getInt("helmFlag", 0);
        RunSurfaceView.BarHelmbt = settings.getInt("BarHelmbt", 100);
        RunSurfaceView.BarHelmst = settings.getInt("BarHelmst", 100);
        RunSurfaceView.BarHelmbe = settings.getInt("BarHelmbe", 100);
        RunSurfaceView.BarHelmse = settings.getInt("BarHelmse", 100);
        RunSurfaceView.BarHelmba = settings.getInt("BarHelmba", 100);
        RunSurfaceView.BarHelmsa = settings.getInt("BarHelmsa", 100);
        RunSurfaceView.BarHelmbr = settings.getInt("BarHelmbr", 100);
        RunSurfaceView.BarHelmsr = settings.getInt("BarHelmsr", 100);
        RunSurfaceView.BarBET = settings.getInt("BarBET", 0);
        RunSurfaceView.BarSET = settings.getInt("BarSET", 0);
        RunSurfaceView.BarBEE = settings.getInt("BarBEE", 0);
        RunSurfaceView.BarSEE = settings.getInt("BarSEE", 0);
        RunSurfaceView.BarBEA = settings.getInt("BarBEA", 0);
        RunSurfaceView.BarSEA = settings.getInt("BarSEA", 0);
        RunSurfaceView.BarBER = settings.getInt("BarBER", 0);
        RunSurfaceView.BarSER = settings.getInt("BarSER", 0);
        RunSurfaceView.gravityTBFlag = settings.getBoolean("gravityTBFlag", true);
        RunSurfaceView.iocTBFlag = settings.getBoolean("iocTBFlag", true);
        RunSurfaceView.followmeTBFlag = settings.getBoolean("followmeTBFlag", true);
        RunSurfaceView.takeoffTBFlag = settings.getBoolean("takeoffTBFlag", true);
        RunSurfaceView.landonTBFlag = settings.getBoolean("landonTBFlag", true);
        RunSurfaceView.landonTBFlag = settings.getBoolean("landonTBFlag", true);
    }

    public void savePreferences() {
        Editor editor = getSharedPreferences("backup00", 0).edit();
        editor.putBoolean("elevinv", RunSurfaceView.elevinv);
        editor.putBoolean("aileinv", RunSurfaceView.aileinv);
        editor.putBoolean("throinv", RunSurfaceView.throinv);
        editor.putBoolean("ruddinv", RunSurfaceView.ruddinv);
        editor.putInt("mode", RunSurfaceView.mode);
        editor.putBoolean("leftOn", RunSurfaceView.leftOn);
        editor.putBoolean("hiddenFlag", RunSurfaceView.hiddenFlag);
        editor.putInt("elevIDec", RunSurfaceView.elevIDec);
        editor.putInt("aileIDec", RunSurfaceView.aileIDec);
        editor.putInt("throIDec", RunSurfaceView.throIDec);
        editor.putInt("ruddIDec", RunSurfaceView.ruddIDec);
        editor.putInt("auxIDec", RunSurfaceView.auxIDec);
        editor.putInt("helmFlag", RunSurfaceView.helmFlag);
        editor.putInt("BarHelmbt", RunSurfaceView.BarHelmbt);
        editor.putInt("BarHelmst", RunSurfaceView.BarHelmst);
        editor.putInt("BarHelmbe", RunSurfaceView.BarHelmbe);
        editor.putInt("BarHelmse", RunSurfaceView.BarHelmse);
        editor.putInt("BarHelmba", RunSurfaceView.BarHelmba);
        editor.putInt("BarHelmsa", RunSurfaceView.BarHelmsa);
        editor.putInt("BarHelmbr", RunSurfaceView.BarHelmbr);
        editor.putInt("BarHelmsr", RunSurfaceView.BarHelmsr);
        editor.putInt("BarBET", RunSurfaceView.BarBET);
        editor.putInt("BarSET", RunSurfaceView.BarSET);
        editor.putInt("BarBEE", RunSurfaceView.BarBEE);
        editor.putInt("BarSEE", RunSurfaceView.BarSEE);
        editor.putInt("BarBEA", RunSurfaceView.BarBEA);
        editor.putInt("BarSEA", RunSurfaceView.BarSEA);
        editor.putInt("BarBER", RunSurfaceView.BarBER);
        editor.putInt("BarSER", RunSurfaceView.BarSER);
        editor.putBoolean("gravityTBFlag", RunSurfaceView.gravityTBFlag);
        editor.putBoolean("iocTBFlag", RunSurfaceView.iocTBFlag);
        editor.putBoolean("followmeTBFlag", RunSurfaceView.followmeTBFlag);
        editor.putBoolean("takeoffTBFlag", RunSurfaceView.takeoffTBFlag);
        editor.putBoolean("landonTBFlag", RunSurfaceView.landonTBFlag);
        editor.commit();
    }

    public void setLogoSurfaceView() {
        this.logoSurfaceView = new LogoSurfaceView(this);
        this.logoSurfaceView.requestFocus();
        this.logoSurfaceView.setFocusableInTouchMode(true);
        setContentView(this.logoSurfaceView);
        if (ManualSurfaceView.cool) {
            animation = AnimationUtils.loadAnimation(context, R.anim.review);
            this.logoSurfaceView.startAnimation(animation);
            ManualSurfaceView.cool = false;
            return;
        }
        animation = AnimationUtils.loadAnimation(context, R.anim.popdown);
        this.logoSurfaceView.startAnimation(animation);
    }

    public void setManualSurfaceView() {
        this.manualSurfaceView = new ManualSurfaceView(this);
        this.manualSurfaceView.requestFocus();
        this.manualSurfaceView.setFocusableInTouchMode(true);
        setContentView(this.manualSurfaceView);
    }

    public void setRunSurfaceView() {
        runSurfaceView = new RunSurfaceView(this);
        runSurfaceView.requestFocus();
        runSurfaceView.setFocusableInTouchMode(true);
        setContentView(runSurfaceView);
    }

    public static void setView(int flag) {
        switch (flag) {
            case Constant.LOGO /*1*/:
                hd.sendEmptyMessage(1);
            case Constant.MANUAL /*2*/:
                hd.sendEmptyMessage(2);
            case Constant.RUN /*3*/:
                hd.sendEmptyMessage(3);
            default:
        }
    }

    public void BitmapRotate(Canvas canvas, Bitmap bmp, int percentage) {
        matrix.reset();
        matrix.postRotate(-180.0f);
        canvas.drawBitmap(Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true), 0.0f, 200.0f, null);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap BitmapFit(Bitmap bitmap) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        float wRatio = (((float) screenWidth) * 1.0f) / ((float) bmpWidth);
        float hRatio = (((float) screenHeight) * 1.0f) / ((float) bmpHeight);
        matrix.reset();
        matrix.setScale(wRatio, hRatio);
        return Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
    }

    public static Bitmap BitmapFit0(Bitmap bitmap) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        float wRatio = (((float) screenWidth) * 1.0f) / ((float) bmpWidth);
        float hRatio = (((float) screenHeight) * 1.0f) / ((float) bmpHeight);
        matrix.reset();
        if (wRatio - hRatio > 0.0f) {
            matrix.setScale(hRatio, hRatio);
        } else {
            matrix.setScale(wRatio, wRatio);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
    }

    public static Bitmap ToFit(Bitmap bitmap, float scale) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        matrix.reset();
        matrix.setScale(scale, scale);
        return Bitmap.createBitmap(bitmap, 0, 0, bmpWidth, bmpHeight, matrix, true);
    }

    public static Bitmap Resveral(Bitmap bitmap) {
        Canvas canvas = new Canvas();
        matrix.reset();
        matrix.postRotate(-180.0f);
        Bitmap mbitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        canvas.drawBitmap(mbitmap, 0.0f, 0.0f, null);
        return mbitmap;
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onPause();
    }

    public static void onFinish() {
        end = true;
        myActivity.finish();
    }

    public void onDestroy() {
        super.onDestroy();
        savePreferences();
        if (end) {
            LogoSurfaceView.picRecycle();
            RunSurfaceView.picRecycle();
            end = false;
            System.gc();
            System.runFinalization();
            Process.killProcess(Process.myTid());
        }
    }
}
