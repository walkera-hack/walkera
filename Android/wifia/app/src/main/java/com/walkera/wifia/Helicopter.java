package com.walkera.wifia;

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
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.walkera.wifia.R;

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
    static int viewFlag;
    static int viewOldFlag;
    static int volume;
    CurveSurfaceView curveSurfaceView;
    LogoSurfaceView logoSurfaceView;
    ManualSurfaceView manualSurfaceView;
    OverSurfaceView overSurfaceView;
    ThemeSurfaceView themeSurfaceView;

    /* renamed from: com.walkera.wifia.Helicopter.1 */
    class C00021 extends Handler {
        C00021() {
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.THEME /*1*/:
                    Helicopter.viewOldFlag = 1;
                    Helicopter.viewFlag = 1;
                    Helicopter.this.setThemeSurfaceView();
                case Constant.LOGO /*2*/:
                    Helicopter.viewOldFlag = 2;
                    Helicopter.viewFlag = 2;
                    Helicopter.this.setLogoSurfaceView();
                case Constant.MANUAL /*4*/:
                    Helicopter.viewFlag = 4;
                    Helicopter.this.setManualSurfaceView();
                case Constant.RUN /*5*/:
                    Helicopter.viewOldFlag = 5;
                    Helicopter.viewFlag = 5;
                    Helicopter.this.setRunSurfaceView();
                case Constant.OVER /*6*/:
                    Helicopter.viewOldFlag = 6;
                    Helicopter.viewFlag = 6;
                    Helicopter.this.setOverSurfaceView();
                default:
            }
        }
    }

    static {
        matrix = new Matrix();
        end = false;
        fflag = false;
        modelFlag = 0;
        viewOldFlag = 0;
        viewFlag = 0;
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("state0", viewFlag);
        outState.putInt("state1", viewOldFlag);
        Log.w("Helicopter", "onSaveInstanceState happen!");
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


        LogoSurfaceView.init();

        new UpdateManager(context).checkUpdate();
        getPreferences();
        hd = new C00021();
        setView(viewFlag);
    }

    public void setOrientation() {
        if (fflag) {
            setRequestedOrientation(8);
            Log.w("Helicopter", " SCREEN_ORIENTATION_REVERSE_LANDSCAPE ");
            return;
        }
        setRequestedOrientation(0);
        Log.w("Helicopter", " SCREEN_ORIENTATION_LANDSCAPE ");
    }

    public int getRot() {
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.w("Helicopter", " onConfigurationChanged ");
        if (getResources().getConfiguration().orientation == 2) {
            Log.w("Helicopter", " ORIENTATION_LANDSCAPE ");
        } else if (getResources().getConfiguration().orientation == 1) {
            Log.w("Helicopter", " ORIENTATION_PORTRAIT ");
        }
    }

    public String getPath(Uri uri) {
        Cursor cursor = managedQuery(uri, new String[]{"_data"}, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void getPreferences() {
        modelFlag = getSharedPreferences("model", 0).getInt("modelFlag", 0);
        RunSurfaceView.modelFlag = modelFlag;
        SharedPreferences settings = null;
        if (modelFlag == 0) {
            settings = getSharedPreferences("backup0", 0);
        } else if (modelFlag == 1) {
            settings = getSharedPreferences("backup1", 0);
        } else if (modelFlag == 2) {
            settings = getSharedPreferences("backup2", 0);
        } else if (modelFlag == 3) {
            settings = getSharedPreferences("backup3", 0);
        } else if (modelFlag == 4) {
            settings = getSharedPreferences("backup4", 0);
        } else if (modelFlag == 5) {
            settings = getSharedPreferences("backup5", 0);
        }
        RunSurfaceView.elevinv = settings.getBoolean("elevinv", false);
        RunSurfaceView.aileinv = settings.getBoolean("aileinv", false);
        RunSurfaceView.throinv = settings.getBoolean("throinv", false);
        RunSurfaceView.ruddinv = settings.getBoolean("ruddinv", false);
        RunSurfaceView.vibratev = settings.getBoolean("vibratev", false);
        RunSurfaceView.mode = settings.getInt("mode", 1);
        RunSurfaceView.module = settings.getInt("module", 1);
        RunSurfaceView.leftOn = settings.getBoolean("leftOn", false);
        RunSurfaceView.hiddenFlag = settings.getBoolean("hiddenFlag", false);
        RunSurfaceView.elevIDec = (short) settings.getInt("elevIDec", 0);
        RunSurfaceView.aileIDec = (short) settings.getInt("aileIDec", 0);
        RunSurfaceView.throIDec = (short) settings.getInt("throIDec", 0);
        RunSurfaceView.ruddIDec = (short) settings.getInt("ruddIDec", 0);
        RunSurfaceView.auxIDec = (short) settings.getInt("auxIDec", 0);
        RunSurfaceView.helmFlag = settings.getInt("helmFlag", 0);
        RunSurfaceView.BarHelmbe = settings.getInt("BarHelmbe", 100);
        RunSurfaceView.BarHelmse = settings.getInt("BarHelmse", 100);
        RunSurfaceView.BarHelmba = settings.getInt("BarHelmba", 100);
        RunSurfaceView.BarHelmsa = settings.getInt("BarHelmsa", 100);
        RunSurfaceView.BarHelmbr = settings.getInt("BarHelmbr", 100);
        RunSurfaceView.BarHelmsr = settings.getInt("BarHelmsr", 100);
        RunSurfaceView.BarBEE = settings.getInt("BarBEE", 0);
        RunSurfaceView.BarSEE = settings.getInt("BarSEE", 0);
        RunSurfaceView.BarBEA = settings.getInt("BarBEA", 0);
        RunSurfaceView.BarSEA = settings.getInt("BarSEA", 0);
        RunSurfaceView.BarBER = settings.getInt("BarBER", 0);
        RunSurfaceView.BarSER = settings.getInt("BarSER", 0);
        RunSurfaceView.throFlag = settings.getInt("throFlag", 0);
        RunSurfaceView.expFlag = settings.getBoolean("expFlag", false);
        RunSurfaceView.pointLFlag = settings.getBoolean("pointLFlag", true);
        RunSurfaceView.point1Flag = settings.getBoolean("point1Flag", false);
        RunSurfaceView.point2Flag = settings.getBoolean("point2Flag", true);
        RunSurfaceView.pointMFlag = settings.getBoolean("pointMFlag", true);
        RunSurfaceView.point3Flag = settings.getBoolean("point3Flag", false);
        RunSurfaceView.point4Flag = settings.getBoolean("point4Flag", false);
        RunSurfaceView.pointHFlag = settings.getBoolean("pointHFlag", true);
        RunSurfaceView.pointLL = settings.getFloat("pointLL", 0.0f);
        RunSurfaceView.point11 = settings.getFloat("point11", 16.5f);
        RunSurfaceView.point22 = settings.getFloat("point22", 33.5f);
        RunSurfaceView.pointMM = settings.getFloat("pointMM", 50.0f);
        RunSurfaceView.point33 = settings.getFloat("point33", 66.5f);
        RunSurfaceView.point44 = settings.getFloat("point44", 83.5f);
        RunSurfaceView.pointHH = settings.getFloat("pointHH", 100.0f);
        RunSurfaceView.adjustratio = settings.getFloat("adjustratio", 0.0f);
        RunSurfaceView.screwFlag = settings.getInt("screwFlag", 0);
        RunSurfaceView.expSFlag = settings.getBoolean("expSFlag", false);
        RunSurfaceView.pointLSFlag = settings.getBoolean("pointLSFlag", true);
        RunSurfaceView.point1SFlag = settings.getBoolean("point1SFlag", false);
        RunSurfaceView.point2SFlag = settings.getBoolean("point2SFlag", false);
        RunSurfaceView.pointMSFlag = settings.getBoolean("pointMSFlag", true);
        RunSurfaceView.point3SFlag = settings.getBoolean("point3SFlag", false);
        RunSurfaceView.point4SFlag = settings.getBoolean("point4SFlag", false);
        RunSurfaceView.pointHSFlag = settings.getBoolean("pointHSFlag", true);
        RunSurfaceView.pointLLS = settings.getFloat("pointLLS", -100.0f);
        RunSurfaceView.point11S = settings.getFloat("point11S", -67.0f);
        RunSurfaceView.point22S = settings.getFloat("point22S", -33.0f);
        RunSurfaceView.pointMMS = settings.getFloat("pointMMS", 0.0f);
        RunSurfaceView.point33S = settings.getFloat("point33S", 33.0f);
        RunSurfaceView.point44S = settings.getFloat("point44S", 67.0f);
        RunSurfaceView.pointHHS = settings.getFloat("pointHHS", 100.0f);
    }

    public void savePreferences() {
        Editor mod = getSharedPreferences("model", 0).edit();
        mod.putInt("modelFlag", modelFlag);
        mod.commit();
        SharedPreferences settings = null;
        if (modelFlag == 0) {
            settings = getSharedPreferences("backup0", 0);
        } else if (modelFlag == 1) {
            settings = getSharedPreferences("backup1", 0);
        } else if (modelFlag == 2) {
            settings = getSharedPreferences("backup2", 0);
        } else if (modelFlag == 3) {
            settings = getSharedPreferences("backup3", 0);
        } else if (modelFlag == 4) {
            settings = getSharedPreferences("backup4", 0);
        } else if (modelFlag == 5) {
            settings = getSharedPreferences("backup5", 0);
        }
        Editor editor = settings.edit();
        editor.putBoolean("elevinv", RunSurfaceView.elevinv);
        editor.putBoolean("aileinv", RunSurfaceView.aileinv);
        editor.putBoolean("throinv", RunSurfaceView.throinv);
        editor.putBoolean("ruddinv", RunSurfaceView.ruddinv);
        editor.putBoolean("vibratev", RunSurfaceView.vibratev);
        editor.putInt("mode", RunSurfaceView.mode);
        editor.putInt("module", RunSurfaceView.module);
        editor.putBoolean("leftOn", RunSurfaceView.leftOn);
        editor.putBoolean("hiddenFlag", RunSurfaceView.hiddenFlag);
        editor.putInt("elevIDec", RunSurfaceView.elevIDec);
        editor.putInt("aileIDec", RunSurfaceView.aileIDec);
        editor.putInt("throIDec", RunSurfaceView.throIDec);
        editor.putInt("ruddIDec", RunSurfaceView.ruddIDec);
        editor.putInt("auxIDec", RunSurfaceView.auxIDec);
        editor.putInt("helmFlag", RunSurfaceView.helmFlag);
        editor.putInt("BarHelmbe", RunSurfaceView.BarHelmbe);
        editor.putInt("BarHelmse", RunSurfaceView.BarHelmse);
        editor.putInt("BarHelmba", RunSurfaceView.BarHelmba);
        editor.putInt("BarHelmsa", RunSurfaceView.BarHelmsa);
        editor.putInt("BarHelmbr", RunSurfaceView.BarHelmbr);
        editor.putInt("BarHelmsr", RunSurfaceView.BarHelmsr);
        editor.putInt("BarBEE", RunSurfaceView.BarBEE);
        editor.putInt("BarSEE", RunSurfaceView.BarSEE);
        editor.putInt("BarBEA", RunSurfaceView.BarBEA);
        editor.putInt("BarSEA", RunSurfaceView.BarSEA);
        editor.putInt("BarBER", RunSurfaceView.BarBER);
        editor.putInt("BarSER", RunSurfaceView.BarSER);
        editor.putInt("throFlag", RunSurfaceView.throFlag);
        editor.putBoolean("expFlag", RunSurfaceView.expFlag);
        editor.putBoolean("pointLFlag", RunSurfaceView.pointLFlag);
        editor.putBoolean("point1Flag", RunSurfaceView.point1Flag);
        editor.putBoolean("point2Flag", RunSurfaceView.point2Flag);
        editor.putBoolean("pointMFlag", RunSurfaceView.pointMFlag);
        editor.putBoolean("point3Flag", RunSurfaceView.point3Flag);
        editor.putBoolean("point4Flag", RunSurfaceView.point4Flag);
        editor.putBoolean("pointHFlag", RunSurfaceView.pointHFlag);
        editor.putFloat("pointLL", RunSurfaceView.pointLL);
        editor.putFloat("point11", RunSurfaceView.point11);
        editor.putFloat("point22", RunSurfaceView.point22);
        editor.putFloat("pointMM", RunSurfaceView.pointMM);
        editor.putFloat("point33", RunSurfaceView.point33);
        editor.putFloat("point44", RunSurfaceView.point44);
        editor.putFloat("pointHH", RunSurfaceView.pointHH);
        editor.putFloat("adjustratio", RunSurfaceView.adjustratio);
        editor.putInt("screwFlag", RunSurfaceView.screwFlag);
        editor.putBoolean("expSFlag", RunSurfaceView.expSFlag);
        editor.putBoolean("pointLSFlag", RunSurfaceView.pointLSFlag);
        editor.putBoolean("point1SFlag", RunSurfaceView.point1SFlag);
        editor.putBoolean("point2SFlag", RunSurfaceView.point2SFlag);
        editor.putBoolean("pointMSFlag", RunSurfaceView.pointMSFlag);
        editor.putBoolean("point3SFlag", RunSurfaceView.point3SFlag);
        editor.putBoolean("point4SFlag", RunSurfaceView.point4SFlag);
        editor.putBoolean("pointHSFlag", RunSurfaceView.pointHSFlag);
        editor.putFloat("pointLLS", RunSurfaceView.pointLLS);
        editor.putFloat("point11S", RunSurfaceView.point11S);
        editor.putFloat("point22S", RunSurfaceView.point22S);
        editor.putFloat("pointMMS", RunSurfaceView.pointMMS);
        editor.putFloat("point33S", RunSurfaceView.point33S);
        editor.putFloat("point44S", RunSurfaceView.point44S);
        editor.putFloat("pointHHS", RunSurfaceView.pointHHS);
        editor.commit();
    }

    public void setThemeSurfaceView() {
        ThemeSurfaceView.init();
        CurveSurfaceView.init();
        this.themeSurfaceView = new ThemeSurfaceView(this);
        this.themeSurfaceView.requestFocus();
        this.themeSurfaceView.setFocusableInTouchMode(true);
        setContentView(this.themeSurfaceView);
        animation = AnimationUtils.loadAnimation(context, R.anim.popdown);
        this.themeSurfaceView.startAnimation(animation);
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
        animation = AnimationUtils.loadAnimation(context, R.anim.viewshow);
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

    public void setOverSurfaceView() {
        this.overSurfaceView = new OverSurfaceView(this);
        this.overSurfaceView.requestFocus();
        this.overSurfaceView.setFocusableInTouchMode(true);
        setContentView(this.overSurfaceView);
        animation = AnimationUtils.loadAnimation(context, R.anim.viewshow);
        this.overSurfaceView.startAnimation(animation);
    }

    public static void setView(int flag) {
        switch (flag) {
            case Constant.THEME /*1*/:
                hd.sendEmptyMessage(1);
            case Constant.LOGO /*2*/:
                hd.sendEmptyMessage(2);
            case Constant.MANUAL /*4*/:
                hd.sendEmptyMessage(4);
            case Constant.RUN /*5*/:
                hd.sendEmptyMessage(5);
            case Constant.OVER /*6*/:
                hd.sendEmptyMessage(6);
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
        setOrientation();
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
            end = false;
            RunSurfaceView.picRecycle();
            ThemeSurfaceView.picRecycle();
            LogoSurfaceView.picRecycle();
            OverSurfaceView.picRecycle();
            System.gc();
            System.runFinalization();
            Process.killProcess(Process.myTid());
        }
    }
}
