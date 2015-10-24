package com.walkera.wifia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Scroller;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.walkera.wifia.MultiTouchGestureDetector.EventInfo;
import com.walkera.wifia.MultiTouchGestureDetector.MultiMotionEvent;
import com.walkera.wifia.MultiTouchGestureDetector.MultiTouchGestureListener;
import com.walkera.wifia.picturebrowser.PhotoVideoBrowser;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import com.walkera.wifia.R;

public class RunSurfaceView extends SurfaceView implements Callback, OnTouchListener {
    static final int AV_SHOW = 1;
    static short BASEMIN0 = (short) 0;
    static int BarBEA = 0;
    static int BarBEE = 0;
    static int BarBER = 0;
    static int BarHelmba = 0;
    static int BarHelmbe = 0;
    static int BarHelmbr = 0;
    static int BarHelmsa = 0;
    static int BarHelmse = 0;
    static int BarHelmsr = 0;
    static int BarSEA = 0;
    static int BarSEE = 0;
    static int BarSER = 0;
    static boolean MjpgRunFlag = false;
    static final int PHOTO_SHOW = 0;
    static final String WIFI_SSID_PERFIX = "WK";
    static final int WIFI_STATE_CONNECTED = 12291;
    static final int WIFI_STATE_DISABLED = 12289;
    static final int WIFI_STATE_NOT_CONNECTED = 12290;
    static SeekBar adjust;
    static float adjustratio;
    static TextView adjustv;
    static CheckBox aile;
    static int aile0;
    static short aileIDec;
    static short aileIDecB;
    static short aileQty;
    static Bitmap ailebarbmp;
    static Button ailed;
    static Button ailedi;
    static Button ailei;
    static boolean aileinv;
    static Animation animation;
    static AnimationListen animationListen;
    static int arrow;
    static short auxIDec;
    static short auxQty;
    static Shader ballBackGradient;
    static Shader ballBackGradient0;
    static Rect ballBackLRect;
    static Rect ballBackLRect0;
    static Rect ballBackRRect;
    static Rect ballBackRRect0;
    static Shader ballGradient;
    static Shader ballGradient0;
    static Rect ballLRect;
    static Rect ballLRect0;
    static Rect ballRRect;
    static Rect ballRRect0;
    static Bitmap ballbackbmp;
    static Bitmap ballbackbmp0;
    static ShapeDrawable ballbackl;
    static ShapeDrawable ballbackl0;
    static ShapeDrawable ballbackr;
    static ShapeDrawable ballbackr0;
    static Bitmap ballbmp;
    static ShapeDrawable balll;
    static ShapeDrawable balll0;
    static boolean balllCFlag;
    static boolean balllDFlag;
    static boolean balllUFlag;
    static ShapeDrawable ballr;
    static ShapeDrawable ballr0;
    static boolean ballrCFlag;
    static boolean ballrDFlag;
    static boolean ballrUFlag;
    static Bitmap bar0bmp;
    static Bitmap barbmp;
    static int barh;
    static int barh0;
    static float barw;
    static int barw0;
    static int basecoor0;
    static int basecoor00;
    static int basecoor01;
    static int basecoor02;
    static int basecoor03;
    static int basecoor1;
    static int basecoor2;
    static boolean buttonCFlag;
    static Bitmap camera0bmp;
    static Bitmap camerabmp;
    static float circlex;
    static float circlexl;
    static float circlexr;
    static float circley;
    static float circleyl;
    static float circleyr;
    static byte[] cmdBuffer;
    static char cmdBuffer0;
    static byte[] cmdBuffer00;
    static int cno;
    static boolean cool;
    static int coun;
    static Bitmap crossbmp;
    static CurveSurfaceView curve;
    static Button dec;
    static boolean dispalyFlag;
    static CheckBox elev;
    static int elev0;
    static short elevIDec;
    static short elevIDecB;
    static short elevQty;
    static Bitmap elevbarbmp;
    static CurveSurfaceView elevcurve;
    static Button elevd;
    static Button elevdi;
    static Button elevi;
    static boolean elevinv;
    static EncodeDisplay encodeDisplay;
    static boolean expFlag;
    static Button expOn;
    static boolean expSFlag;
    static float fix0;
    static float fix1;
    static float fix2;
    static float fix3;
    static float fix4;
    static float fix5;
    static float fix6;
    static float fix7;
    static float fix8;
    static float fix9;
    static float fixb;
    static float fixx;
    static Bitmap gravityoffbmp;
    static Bitmap gravityonbmp;
    static GSensor gsensor;
    static Button gyrod;
    static Button gyrodi;
    static Button gyroi;
    static int f7h;
    static int h0;
    static int he;
    static final String[] helm;
    static int helmFlag;
    static Bitmap helmexpbmp;
    static int hh;
    static int hh0;
    static boolean hiddenFlag;
    static boolean hiddenFullFlag;
    static SurfaceHolder holder;
    static Bitmap horse;
    static int hr;
    static Button inc;
    static int interval;
    static boolean isOn;
    static boolean isOnFlag;
    static Path leftL;
    static boolean leftOn;
    static Path leftU;
    static boolean leftUL;
    static boolean leftflag;
    static boolean lefth;
    static float leftx;
    static float lefty;
    static Bitmap mCurPageBitmap;
    static MultiTouchGestureDetector mGesture;
    static int mHeight;
    static GestureListener mListener;
    static Bitmap mNextPageBitmap;
    static int mWidth;
    static int make;
    static int makex;
    static int makey;
    static Bitmap manual;
    static Matrix matrix;
    static Bitmap mbitmap;
    static Bitmap mbmp;
    static int mode;
    static Button mode1;
    static Button mode2;
    static Button mode3;
    static Button mode4;
    static final String[] model;
    static int modelFlag;
    static int module;
    static Helicopter myActivity;
    static Bitmap offbmp;
    static Bitmap onbmp;
    static boolean oneF;
    static boolean orientFlag;
    static float[] outRect;
    static Paint f8p;
    static Paint p0;
    static Paint paint;
    static Path path11;
    static Path path22;
    static Path path33;
    static Path path44;
    static Path path55;
    static Path path66;
    static Path path77;
    static Path path88;
    static Path path99;
    static int percentage;
    static Bitmap photo0bmp;
    static Bitmap photobmp;
    static short[] playbuffer;
    static float point11;
    static float point11S;
    static boolean point1Flag;
    static boolean point1SFlag;
    static float point22;
    static float point22S;
    static boolean point2Flag;
    static boolean point2SFlag;
    static float point33;
    static float point33S;
    static boolean point3Flag;
    static boolean point3SFlag;
    static float point44;
    static float point44S;
    static boolean point4Flag;
    static boolean point4SFlag;
    static boolean pointHFlag;
    static float pointHH;
    static float pointHHS;
    static boolean pointHSFlag;
    static boolean pointLFlag;
    static float pointLL;
    static float pointLLS;
    static boolean pointLSFlag;
    static boolean pointMFlag;
    static float pointMM;
    static float pointMMS;
    static boolean pointMSFlag;
    static Button pointOn;
    static int popNo;
    static PopupWindow popupWindow;
    static PopupWindow popupWindow0;
    static PopupWindow popupWindow1;
    static PopupWindow popupWindow2;
    static Bitmap pvshow0bmp;
    static boolean pvshowFlag;
    static Bitmap pvshowbmp;
    static int f9r;
    static int r0;
    static int r1;
    static Button recover;
    static Path rightR;
    static Path rightU;
    static boolean rightUR;
    static boolean rightflag;
    static boolean righth;
    static float rightx;
    static float righty;
    static CheckBox rudd;
    static int rudd0;
    static short ruddIDec;
    static short ruddIDecB;
    static short ruddQty;
    static Bitmap ruddbarbmp;
    static Button ruddd;
    static Button rudddi;
    static Button ruddi;
    static boolean ruddinv;
    static boolean runFlag;
    static boolean running;
    static float scales;
    static float scales0;
    static int screenHeight;
    static int screenWidth;
    static int screw0;
    static int screwFlag;
    static short screwQty;
    static Spinner screwSpinner;
    static Bitmap screwbmp;
    static CurveSurfaceView screwcurve;
    static final String[] screwitem;
    static boolean scrollFlag;
    static boolean sensorOn;
    static Bitmap setbmp;
    static String strings;
    static boolean successFlag;
    static int f10t;
    static float th;
    static CheckBox thro;
    static int thro0;
    static int thro00;
    static int throFlag;
    static short throIDec;
    static short throIDecB;
    static short throQty;
    static Spinner throSpinner;
    static Bitmap throbarbmp;
    static CurveSurfaceView throcurve;
    static Button throd;
    static Button throdi;
    static Bitmap throexpbmp;
    static Button throi;
    static boolean throinv;
    static final String[] throitem;
    static TextView title;
    static Toast toast;
    static float tw;
    static float tw0;
    static CheckBox vibrate;
    static boolean vibratev;
    static Vibrator vibrator;
    static boolean vibratorF;
    static boolean vibratorFlag;
    static int videocount;
    static View viewh;
    static View viewp;
    static View views;
    static View viewt;
    static int f11w;
    static int w0;
    static int wd;
    static boolean wifiConFlag;
    static boolean wifiFlag;
    static Bitmap wificonbmp;
    static Bitmap wificonoffbmp;
    static int wr;
    static int ww0;
    static int xhalf;
    static int xl;
    static int xleft;
    static int xr;
    static int xright;
    static int ybottom;
    static int yhalf;
    static int yl;
    static int yr;
    static int ytop;
    boolean PagesFlag;
    boolean PhotosFlag;
    ArrayAdapter<String> adapter;
    boolean dragFlag;
    int dx;
    int dy;
    private Button ebigdi;
    private Button esmalldi;
    private long exitTime;
    private Button expdec;
    private Button expinc;
    private Button hbigdi;
    private Spinner helmSpinner;
    private Button helmdec;
    private Button helminc;
    private Button hsmalldi;
    int[] mBackShadowColors;
    GradientDrawable mBackShadowDrawableLR;
    GradientDrawable mBackShadowDrawableRL;
    PointF mBezierControl1;
    PointF mBezierControl2;
    PointF mBezierEnd1;
    PointF mBezierEnd2;
    PointF mBezierStart1;
    PointF mBezierStart2;
    PointF mBeziervertex1;
    PointF mBeziervertex2;
    ColorMatrixColorFilter mColorMatrixFilter;
    private int mCornerX;
    private int mCornerY;
    float mDegrees;
    GradientDrawable mFolderShadowDrawableLR;
    GradientDrawable mFolderShadowDrawableRL;
    int[] mFrontShadowColors;
    GradientDrawable mFrontShadowDrawableHBT;
    GradientDrawable mFrontShadowDrawableHTB;
    GradientDrawable mFrontShadowDrawableVLR;
    GradientDrawable mFrontShadowDrawableVRL;
    boolean mIsRTandLB;
    Matrix mMatrix;
    float[] mMatrixArray;
    float mMaxLength;
    float mMiddleX;
    float mMiddleY;
    Paint mPaint;
    private Path mPath0;
    private Path mPath1;
    Scroller mScroller;
    PointF mTouch;
    float mTouchToCornerDis;
    private Spinner modelSpinner;
    private int pgh0;
    private int pgw0;
    boolean photoing;
    float scr_x0;
    float scr_y0;
    public float f12x;
    private int x0;
    public float f13y;
    private int y0;

    /* renamed from: com.walkera.wifia.RunSurfaceView.1 */
    class C00051 implements OnItemSelectedListener {
        C00051() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            RunSurfaceView.buttonCFlag = true;
            if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model1") {
                RunSurfaceView.modelFlag = RunSurfaceView.PHOTO_SHOW;
            } else if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model2") {
                RunSurfaceView.modelFlag = RunSurfaceView.AV_SHOW;
            } else if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model3") {
                RunSurfaceView.modelFlag = 2;
            } else if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model4") {
                RunSurfaceView.modelFlag = 3;
            } else if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model5") {
                RunSurfaceView.modelFlag = 4;
            } else if (RunSurfaceView.this.modelSpinner.getSelectedItem().toString() == "Model6") {
                RunSurfaceView.modelFlag = 5;
            }
            if (RunSurfaceView.isOn) {
                RunSurfaceView.this.modelSpinner.setSelection(Helicopter.modelFlag);
                return;
            }
            if (Helicopter.modelFlag != RunSurfaceView.modelFlag) {
                RunSurfaceView.myActivity.savePreferences();
                Editor mod = Helicopter.context.getSharedPreferences("model", RunSurfaceView.PHOTO_SHOW).edit();
                mod.putInt("modelFlag", RunSurfaceView.modelFlag);
                mod.commit();
                RunSurfaceView.myActivity.getPreferences();
            }
            if (RunSurfaceView.vibratev) {
                if (RunSurfaceView.vibratorF) {
                    RunSurfaceView.vibratorFlag = true;
                } else {
                    RunSurfaceView.vibratorFlag = false;
                }
                RunSurfaceView.vibrate.setChecked(true);
            } else {
                RunSurfaceView.vibratorFlag = false;
                RunSurfaceView.vibrate.setChecked(false);
            }
            RunSurfaceView.elev.setChecked(RunSurfaceView.elevinv);
            RunSurfaceView.aile.setChecked(RunSurfaceView.aileinv);
            RunSurfaceView.thro.setChecked(RunSurfaceView.throinv);
            RunSurfaceView.rudd.setChecked(RunSurfaceView.ruddinv);
            RunSurfaceView.vibrate.setChecked(RunSurfaceView.vibratev);
            RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
            RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
            RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
            RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
            RunSurfaceView.gyrodi.setText("GYRO:" + Float.toString((((float) RunSurfaceView.auxIDec) / 32.0f) + 50.0f) + "%");
            CurveSurfaceView.init();
            RunSurfaceView.this.initState();
            RunSurfaceView.updateValue();
            RunSurfaceView.getValue();
            RunSurfaceView.this.vibratorV();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.2 */
    class C00062 implements OnFocusChangeListener {
        C00062() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.3 */
    class C00073 implements OnCheckedChangeListener {
        C00073() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            RunSurfaceView.buttonCFlag = true;
            if (isChecked) {
                RunSurfaceView.elevinv = true;
            } else {
                RunSurfaceView.elevinv = false;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.4 */
    class C00084 implements OnCheckedChangeListener {
        C00084() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            RunSurfaceView.buttonCFlag = true;
            if (isChecked) {
                RunSurfaceView.aileinv = true;
            } else {
                RunSurfaceView.aileinv = false;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.5 */
    class C00095 implements OnCheckedChangeListener {
        C00095() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            RunSurfaceView.buttonCFlag = true;
            if (isChecked) {
                RunSurfaceView.throinv = true;
            } else {
                RunSurfaceView.throinv = false;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.6 */
    class C00106 implements OnCheckedChangeListener {
        C00106() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            RunSurfaceView.buttonCFlag = true;
            if (isChecked) {
                RunSurfaceView.ruddinv = true;
            } else {
                RunSurfaceView.ruddinv = false;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.7 */
    class C00117 implements OnCheckedChangeListener {
        C00117() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                RunSurfaceView.vibratev = true;
                if (!RunSurfaceView.vibratev) {
                    RunSurfaceView.vibratorFlag = false;
                    return;
                } else if (RunSurfaceView.vibratorF) {
                    RunSurfaceView.vibratorFlag = true;
                    return;
                } else {
                    RunSurfaceView.vibratorFlag = false;
                    return;
                }
            }
            RunSurfaceView.vibratev = false;
            if (!RunSurfaceView.vibratev) {
                RunSurfaceView.vibratorFlag = false;
            } else if (RunSurfaceView.vibratorF) {
                RunSurfaceView.vibratorFlag = true;
            } else {
                RunSurfaceView.vibratorFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.8 */
    class C00128 implements OnClickListener {
        C00128() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.sensorOn) {
                RunSurfaceView.gsensor.onOff = false;
                if (RunSurfaceView.mode == 4) {
                    RunSurfaceView.ballrDFlag = false;
                    RunSurfaceView.ballrUFlag = true;
                } else if (RunSurfaceView.mode == 2) {
                    RunSurfaceView.balllDFlag = false;
                    RunSurfaceView.balllUFlag = true;
                }
            }
            RunSurfaceView.mode = RunSurfaceView.AV_SHOW;
            RunSurfaceView.this.modeSelect();
            RunSurfaceView.this.leftRFunc();
            if (RunSurfaceView.sensorOn) {
                RunSurfaceView.gsensor.onOff = true;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    /* renamed from: com.walkera.wifia.RunSurfaceView.9 */
    class C00139 implements OnClickListener {
        C00139() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.sensorOn) {
                RunSurfaceView.gsensor.onOff = false;
                if (RunSurfaceView.mode == 4) {
                    RunSurfaceView.ballrDFlag = false;
                    RunSurfaceView.ballrUFlag = true;
                } else if (RunSurfaceView.mode == 2) {
                    RunSurfaceView.balllDFlag = false;
                    RunSurfaceView.balllUFlag = true;
                }
            }
            RunSurfaceView.mode = 2;
            RunSurfaceView.this.modeSelect();
            RunSurfaceView.this.leftRFunc();
            if (RunSurfaceView.sensorOn) {
                RunSurfaceView.gsensor.onOff = true;
            }
            RunSurfaceView.this.vibratorV();
        }
    }

    public class AnimationListen implements AnimationListener {
        public void onAnimationEnd(Animation animation) {
            RunSurfaceView.this.update();
            RunSurfaceView.getValue();
            RunSurfaceView.runFlag = true;
            new Thread(new RunThread()).start();
            SystemClock.sleep(25);
            RunSurfaceView.this.setBackgroundResource(RunSurfaceView.PHOTO_SHOW);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class OnDismissListen implements OnDismissListener {
        public void onDismiss() {
            RunSurfaceView.leftUL = true;
            RunSurfaceView.rightUR = true;
            RunSurfaceView.runFlag = true;
            new Thread(new RunThread()).start();
            RunSurfaceView.getValue();
        }
    }

    public class RunThread extends Thread {
        public void run() {
            while (RunSurfaceView.runFlag) {
                try {
                    if (RunSurfaceView.this.PagesFlag && RunSurfaceView.this.mScroller.computeScrollOffset()) {
                        float x = (float) RunSurfaceView.this.mScroller.getCurrX();
                        float y = (float) RunSurfaceView.this.mScroller.getCurrY();
                        RunSurfaceView.this.mTouch.x = x;
                        RunSurfaceView.this.mTouch.y = y;
                        if (x == ((float) RunSurfaceView.this.x0) && y == ((float) RunSurfaceView.this.y0)) {
                            RunSurfaceView.this.abortAnimation();
                            RunSurfaceView.this.PagesFlag = false;
                            RunSurfaceView.this.dragFlag = false;
                            RunSurfaceView.this.PhotosFlag = true;
                        }
                    }
                    Canvas canvas = RunSurfaceView.holder.lockCanvas(null);
                    synchronized (RunSurfaceView.holder) {
                        if (canvas != null) {
                            RunSurfaceView.this.onDraw(canvas);
                        }
                    }
                    if (canvas != null) {
                        RunSurfaceView.holder.unlockCanvasAndPost(canvas);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class GestureListener implements MultiTouchGestureListener {

        /* renamed from: com.walkera.wifia.RunSurfaceView.GestureListener.1 */
        class C00141 extends Thread {
            C00141() {
            }

            public void run() {
                while (RunSurfaceView.this.photoing) {
                    try {
                        if (EncodeDisplay.photosFlag) {
                            Thread.sleep(25);
                            RunSurfaceView.coun += RunSurfaceView.AV_SHOW;
                            if (RunSurfaceView.coun == 20) {
                                RunSurfaceView.this.abortAnimation();
                                RunSurfaceView.this.calcCornerXY(RunSurfaceView.this.f12x, RunSurfaceView.this.f13y);
                                RunSurfaceView.this.mTouch.x = RunSurfaceView.this.f12x;
                                RunSurfaceView.this.mTouch.y = RunSurfaceView.this.f13y;
                                RunSurfaceView.this.setBitmaps(RunSurfaceView.mbitmap, null);
                                RunSurfaceView.this.PagesFlag = true;
                                RunSurfaceView.this.dragFlag = true;
                                RunSurfaceView.this.photoing = false;
                            }
                        } else {
                            RunSurfaceView.this.abortAnimation();
                            RunSurfaceView.this.calcCornerXY(RunSurfaceView.this.f12x, RunSurfaceView.this.f13y);
                            RunSurfaceView.this.mTouch.x = RunSurfaceView.this.f12x;
                            RunSurfaceView.this.mTouch.y = RunSurfaceView.this.f13y;
                            RunSurfaceView.successFlag = false;
                            File photofile = new File(EncodeDisplay.photostring);
                            if (!(photofile == null || photofile.length() == 0)) {
                                RunSurfaceView.successFlag = true;
                            }
                            if (RunSurfaceView.successFlag) {
                                RunSurfaceView.this.setBitmaps(RunSurfaceView.mbmp, null);
                                RunSurfaceView.this.PagesFlag = true;
                                RunSurfaceView.this.dragFlag = true;
                            } else {
                                RunSurfaceView.this.abortAnimation();
                                RunSurfaceView.this.calcCornerXY(RunSurfaceView.this.f12x, RunSurfaceView.this.f13y);
                                RunSurfaceView.this.mTouch.x = RunSurfaceView.this.f12x;
                                RunSurfaceView.this.mTouch.y = RunSurfaceView.this.f13y;
                                RunSurfaceView.this.setBitmaps(RunSurfaceView.mbitmap, null);
                                RunSurfaceView.this.PagesFlag = true;
                                RunSurfaceView.this.dragFlag = true;
                            }
                            RunSurfaceView.this.photoing = false;
                        }
                    } catch (Exception e) {
                        RunSurfaceView.this.PagesFlag = true;
                        RunSurfaceView.this.dragFlag = true;
                        RunSurfaceView.this.photoing = false;
                        e.printStackTrace();
                    }
                }
            }
        }

        public boolean onDown(MultiMotionEvent e) {
            boolean flag0 = false;
            boolean flag1 = false;
            RunSurfaceView.this.f13y = e.getY();
            RunSurfaceView.this.f12x = e.getX();
            float x1 = RunSurfaceView.this.f12x - ((float) RunSurfaceView.xl);
            float y1 = RunSurfaceView.this.f13y - ((float) RunSurfaceView.yl);
            float x2 = RunSurfaceView.this.f12x - ((float) RunSurfaceView.xr);
            float y2 = RunSurfaceView.this.f13y - ((float) RunSurfaceView.yr);
            if (RunSurfaceView.this.f12x >= ((float) (RunSurfaceView.xl - RunSurfaceView.ww0)) && RunSurfaceView.this.f12x <= ((float) (RunSurfaceView.xl + RunSurfaceView.ww0)) && RunSurfaceView.this.f13y >= ((float) (RunSurfaceView.yl - RunSurfaceView.hh0)) && RunSurfaceView.this.f13y <= ((float) (RunSurfaceView.yl + RunSurfaceView.hh0))) {
                ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId())).mCurrentDownEvent.left = true;
                RunSurfaceView.leftflag = false;
                flag0 = true;
                RunSurfaceView.balllDFlag = true;
                RunSurfaceView.balllUFlag = false;
                RunSurfaceView.leftx = RunSurfaceView.this.f12x;
                RunSurfaceView.lefty = RunSurfaceView.this.f13y;
                if (Math.abs(RunSurfaceView.this.f12x - ((float) RunSurfaceView.xl)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f13y - ((float) RunSurfaceView.yl)) >= ((float) RunSurfaceView.hr)) {
                    RunSurfaceView.balllCFlag = true;
                } else {
                    RunSurfaceView.balllCFlag = false;
                }
                if (RunSurfaceView.leftOn) {
                    if (RunSurfaceView.mode == 3) {
                        if (!RunSurfaceView.sensorOn && Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                            if (x1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            }
                            if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                                RunSurfaceView.aileQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                                RunSurfaceView.aileQty = Constant.BASEMIN;
                            }
                        }
                        RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y1)) / ((float) RunSurfaceView.hr)));
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    } else if (RunSurfaceView.mode == 4) {
                        if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                            if (x1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            }
                            if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                                RunSurfaceView.ruddQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                                RunSurfaceView.ruddQty = Constant.BASEMIN;
                            }
                        }
                        RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y1)) / ((float) RunSurfaceView.hr)));
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    }
                } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                    if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                        if (x1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        }
                        if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                            RunSurfaceView.ruddQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                            RunSurfaceView.ruddQty = Constant.BASEMIN;
                        }
                    }
                    if (!RunSurfaceView.sensorOn && Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                        if (y1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        }
                        if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                            RunSurfaceView.elevQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                            RunSurfaceView.elevQty = Constant.BASEMIN;
                        }
                    }
                } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                    if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                        if (x1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        }
                        if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                            RunSurfaceView.aileQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                            RunSurfaceView.aileQty = Constant.BASEMIN;
                        }
                    }
                    if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                        if (y1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        }
                        if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                            RunSurfaceView.elevQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                            RunSurfaceView.elevQty = Constant.BASEMIN;
                        }
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            }
            if (RunSurfaceView.this.f12x >= ((float) (RunSurfaceView.xr - RunSurfaceView.ww0)) && RunSurfaceView.this.f12x <= ((float) (RunSurfaceView.xr + RunSurfaceView.ww0)) && RunSurfaceView.this.f13y >= ((float) (RunSurfaceView.yr - RunSurfaceView.hh0)) && RunSurfaceView.this.f13y <= ((float) (RunSurfaceView.yr + RunSurfaceView.hh0))) {
                ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId())).mCurrentDownEvent.right = true;
                RunSurfaceView.rightflag = false;
                flag1 = true;
                RunSurfaceView.ballrDFlag = true;
                RunSurfaceView.ballrUFlag = false;
                RunSurfaceView.rightx = RunSurfaceView.this.f12x;
                RunSurfaceView.righty = RunSurfaceView.this.f13y;
                if (Math.abs(RunSurfaceView.this.f12x - ((float) RunSurfaceView.xr)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f13y - ((float) RunSurfaceView.yr)) >= ((float) RunSurfaceView.hr)) {
                    RunSurfaceView.ballrCFlag = true;
                } else {
                    RunSurfaceView.ballrCFlag = false;
                }
                if (RunSurfaceView.leftOn) {
                    if (RunSurfaceView.mode == 3) {
                        if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                            if (x2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            }
                            if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                                RunSurfaceView.ruddQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                                RunSurfaceView.ruddQty = Constant.BASEMIN;
                            }
                        }
                        if (!RunSurfaceView.sensorOn && Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                            if (y2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            }
                            if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                                RunSurfaceView.elevQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                                RunSurfaceView.elevQty = Constant.BASEMIN;
                            }
                        }
                    } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                        if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                            if (x2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            }
                            if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                                RunSurfaceView.aileQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                                RunSurfaceView.aileQty = Constant.BASEMIN;
                            }
                        }
                        if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                            if (y2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            }
                            if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                                RunSurfaceView.elevQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                                RunSurfaceView.elevQty = Constant.BASEMIN;
                            }
                        }
                    }
                } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                    if (!RunSurfaceView.sensorOn && Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                        if (x2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        }
                        if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                            RunSurfaceView.aileQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                            RunSurfaceView.aileQty = Constant.BASEMIN;
                        }
                    }
                    RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y2)) / ((float) RunSurfaceView.hr)));
                    if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                        RunSurfaceView.throQty = Constant.BASEMAX;
                    }
                    if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                        RunSurfaceView.throQty = Constant.BASEMIN;
                    }
                } else if (RunSurfaceView.mode == 2) {
                    if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                        if (x2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        }
                        if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                            RunSurfaceView.ruddQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                            RunSurfaceView.ruddQty = Constant.BASEMIN;
                        }
                    }
                    RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y2)) / ((float) RunSurfaceView.hr)));
                    if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                        RunSurfaceView.throQty = Constant.BASEMAX;
                    }
                    if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                        RunSurfaceView.throQty = Constant.BASEMIN;
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            }
            if ((flag0 || flag1) && !EncodeDisplay.transferring) {
                RunSurfaceView.getValue();
            }
            return true;
        }

        public boolean onUp(MultiMotionEvent e) {
            boolean z = false;
            RunSurfaceView.this.f12x = e.getX();
            RunSurfaceView.this.f13y = e.getY();
            RunSurfaceView.scrollFlag = true;
            EventInfo info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId());
            if (info != null) {
                if (info.mCurrentDownEvent.left) {
                    info.mCurrentDownEvent.left = false;
                    RunSurfaceView.lefth = false;
                    if (RunSurfaceView.vibratorFlag) {
                        RunSurfaceView.vibrator.cancel();
                    }
                    if (RunSurfaceView.leftOn) {
                        if (RunSurfaceView.mode == 3) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 4) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.leftflag = true;
                    } else {
                        if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                            }
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                            RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        }
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    }
                }
                if (info.mCurrentDownEvent.right) {
                    info.mCurrentDownEvent.right = false;
                    RunSurfaceView.righth = false;
                    if (RunSurfaceView.vibratorFlag) {
                        RunSurfaceView.vibrator.cancel();
                    }
                    if (RunSurfaceView.leftOn) {
                        if (RunSurfaceView.mode == 3) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                            }
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                            RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        }
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else {
                        if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 2) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.rightflag = true;
                    }
                }
            }
            if (!RunSurfaceView.hiddenFlag) {
                if (RunSurfaceView.this.f13y > ((float) (RunSurfaceView.ybottom - RunSurfaceView.h0)) && RunSurfaceView.this.f13y < ((float) RunSurfaceView.ybottom)) {
                    if (RunSurfaceView.this.f12x > ((float) RunSurfaceView.xleft) && RunSurfaceView.this.f12x < ((float) (RunSurfaceView.xleft + RunSurfaceView.w0))) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.this.manualFunc();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xright - (RunSurfaceView.w0 * 4)) - 12)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xright - (RunSurfaceView.w0 * 3)) - 12))) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.this.showConfigureWindow();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xright - (RunSurfaceView.w0 * 3)) - 8)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xright - (RunSurfaceView.w0 * 2)) - 8))) {
                        RunSurfaceView.buttonCFlag = true;
                        CurveSurfaceView.elevhelm = false;
                        CurveSurfaceView.throhelm = true;
                        CurveSurfaceView.screwpitch = false;
                        RunSurfaceView.this.showThroWindow();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xright - (RunSurfaceView.w0 * 2)) - 4)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xright - RunSurfaceView.w0) - 4))) {
                        RunSurfaceView.buttonCFlag = true;
                        CurveSurfaceView.elevhelm = true;
                        CurveSurfaceView.throhelm = false;
                        CurveSurfaceView.screwpitch = false;
                        RunSurfaceView.this.showHelmWindow();
                    }
                    if (RunSurfaceView.this.f12x > ((float) (RunSurfaceView.xright - RunSurfaceView.w0)) && RunSurfaceView.this.f12x < ((float) RunSurfaceView.xright)) {
                        RunSurfaceView.buttonCFlag = true;
                        CurveSurfaceView.elevhelm = false;
                        CurveSurfaceView.throhelm = false;
                        CurveSurfaceView.screwpitch = true;
                        RunSurfaceView.this.showScrewWindow();
                    }
                }
                if (RunSurfaceView.this.f13y > ((float) RunSurfaceView.ytop) && RunSurfaceView.this.f13y < ((float) (RunSurfaceView.ytop + RunSurfaceView.h0))) {
                    if (RunSurfaceView.this.f12x > ((float) RunSurfaceView.xleft) && RunSurfaceView.this.f12x < ((float) (RunSurfaceView.xleft + RunSurfaceView.w0))) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.wifiFlag = !RunSurfaceView.wifiFlag;
                        if (RunSurfaceView.wifiFlag) {
                            EncodeDisplay.hr = RunSurfaceView.PHOTO_SHOW;
                            EncodeDisplay.min = RunSurfaceView.PHOTO_SHOW;
                            EncodeDisplay.sec = RunSurfaceView.PHOTO_SHOW;
                            RunSurfaceView.encodeDisplay.EncodeBegin();
                        } else {
                            RunSurfaceView.encodeDisplay.EncodeEnd();
                        }
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xleft + RunSurfaceView.w0) + 4)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 2)) + 4)) && RunSurfaceView.this.PhotosFlag && !RunSurfaceView.this.photoing) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.this.PagesFlag = false;
                        RunSurfaceView.this.dragFlag = false;
                        RunSurfaceView.this.PhotosFlag = false;
                        RunSurfaceView.coun = RunSurfaceView.PHOTO_SHOW;
                        RunSurfaceView.this.pgw0 = RunSurfaceView.f11w;
                        RunSurfaceView.this.pgh0 = RunSurfaceView.f7h;
                        RunSurfaceView.this.photoing = true;
                        RunSurfaceView.encodeDisplay.TakePic();
                        SystemClock.sleep(10);
                        new C00141().start();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 2)) + 8)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 3)) + 8))) {
                        if (RunSurfaceView.encodeDisplay.checkSDCard()) {
                            RunSurfaceView.buttonCFlag = true;
                            RunSurfaceView.pvshowFlag = true;
                            RunSurfaceView.isOn = false;
                            RunSurfaceView.encodeDisplay.CmdSendStop();
                            if (RunSurfaceView.sensorOn) {
                                RunSurfaceView.sensorOn = false;
                                RunSurfaceView.gsensor.onOff = false;
                                RunSurfaceView.elevQty = (short) 0;
                                RunSurfaceView.aileQty = (short) 0;
                            }
                            if (RunSurfaceView.wifiFlag) {
                                RunSurfaceView.wifiFlag = false;
                                RunSurfaceView.encodeDisplay.EncodeEnd();
                            }
                            Intent intent = new Intent();
                            intent.setClass(RunSurfaceView.myActivity, PhotoVideoBrowser.class);
                            RunSurfaceView.myActivity.startActivityForResult(intent, 2);
                        } else {
                            RunSurfaceView.this.showToast("No SD Card Found!");
                        }
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 3)) + 12)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 4)) + 12))) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.this.gravityFunc();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 4)) + 16)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 5)) + 16))) {
                        RunSurfaceView.buttonCFlag = true;
                        RunSurfaceView.this.onOffFunc();
                    }
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 5)) + 20)) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 6)) + 20))) {
                        RunSurfaceView.buttonCFlag = true;
                        if (!RunSurfaceView.orientFlag) {
                            z = true;
                        }
                        RunSurfaceView.orientFlag = z;
                        Helicopter.fflag = RunSurfaceView.orientFlag;
                        RunSurfaceView.myActivity.setOrientation();
                    }
                }
            }
            RunSurfaceView.updateValue();
            RunSurfaceView.this.vibratorV();
            RunSurfaceView.getValue();
            return true;
        }

        public boolean onShowPress(MultiMotionEvent e) {
            return true;
        }

        public boolean onSingleTapUp(MultiMotionEvent e) {
            return true;
        }

        public boolean onLongPress(MultiMotionEvent e) {
            return true;
        }

        public boolean onFling(MultiMotionEvent e1, MultiMotionEvent e2, float velocityX, float velocityY) {
            return true;
        }

        public boolean onScroll(MultiMotionEvent e1, MultiMotionEvent e2, float distanceX, float distanceY) {
            EventInfo info;
            RunSurfaceView.this.f12x = e2.getX();
            RunSurfaceView.this.f13y = e2.getY();
            float x1 = RunSurfaceView.this.f12x - ((float) RunSurfaceView.xl);
            float y1 = RunSurfaceView.this.f13y - ((float) RunSurfaceView.yl);
            float x2 = RunSurfaceView.this.f12x - ((float) RunSurfaceView.xr);
            float y2 = RunSurfaceView.this.f13y - ((float) RunSurfaceView.yr);
            if (RunSurfaceView.hiddenFlag) {
                if (RunSurfaceView.scrollFlag) {
                    if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                        RunSurfaceView.this.scr_x0 = RunSurfaceView.this.f12x;
                        RunSurfaceView.this.scr_y0 = RunSurfaceView.this.f13y;
                        RunSurfaceView.scrollFlag = false;
                    }
                } else if (RunSurfaceView.this.f12x <= ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) || RunSurfaceView.this.f12x >= ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                    RunSurfaceView.scrollFlag = true;
                } else if (Math.abs(RunSurfaceView.this.f13y - RunSurfaceView.this.scr_y0) >= 150.0f) {
                    RunSurfaceView.scrollFlag = true;
                    RunSurfaceView.hiddenFullFlag = !RunSurfaceView.hiddenFullFlag;
                }
            } else if (RunSurfaceView.scrollFlag) {
                if (RunSurfaceView.this.f12x > ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) && RunSurfaceView.this.f12x < ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                    RunSurfaceView.this.scr_x0 = RunSurfaceView.this.f12x;
                    RunSurfaceView.this.scr_y0 = RunSurfaceView.this.f13y;
                    RunSurfaceView.scrollFlag = false;
                }
            } else if (RunSurfaceView.this.f12x <= ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) || RunSurfaceView.this.f12x >= ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                RunSurfaceView.scrollFlag = true;
            } else if (Math.abs(RunSurfaceView.this.f13y - RunSurfaceView.this.scr_y0) >= 150.0f) {
                RunSurfaceView.scrollFlag = true;
                RunSurfaceView.hiddenFlag = true;
                RunSurfaceView.this.hiddenFunc();
            }
            if (RunSurfaceView.this.f12x <= ((float) (RunSurfaceView.xl - RunSurfaceView.ww0)) || RunSurfaceView.this.f12x >= ((float) (RunSurfaceView.xl + RunSurfaceView.ww0)) || RunSurfaceView.this.f13y <= ((float) (RunSurfaceView.yl - RunSurfaceView.hh0)) || RunSurfaceView.this.f13y >= ((float) (RunSurfaceView.yl + RunSurfaceView.hh0))) {
                if (RunSurfaceView.lefth) {
                    info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId());
                    if (RunSurfaceView.this.f12x < ((float) (RunSurfaceView.xhalf + (RunSurfaceView.r1 / 2)))) {
                        if (info.mCurrentDownEvent.left) {
                            RunSurfaceView.leftx = RunSurfaceView.this.f12x;
                            RunSurfaceView.lefty = RunSurfaceView.this.f13y;
                            RunSurfaceView.balllCFlag = true;
                        }
                    } else if (info.mCurrentDownEvent.left) {
                        if (RunSurfaceView.leftOn) {
                            RunSurfaceView.leftx = (float) RunSurfaceView.xl;
                            RunSurfaceView.lefty = RunSurfaceView.this.f13y;
                            RunSurfaceView.balllCFlag = true;
                            if (RunSurfaceView.mode == 3) {
                                if (!RunSurfaceView.sensorOn) {
                                    RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                                }
                            } else if (RunSurfaceView.mode == 4) {
                                RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                            }
                            RunSurfaceView.leftflag = true;
                        } else {
                            if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                                if (!RunSurfaceView.sensorOn) {
                                    RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                                    RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                                }
                            } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                                RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                            RunSurfaceView.balllDFlag = false;
                            RunSurfaceView.balllUFlag = true;
                        }
                        info.mCurrentDownEvent.left = false;
                        RunSurfaceView.lefth = false;
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            } else {
                if (!RunSurfaceView.lefth) {
                    ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId())).mCurrentDownEvent.left = true;
                    RunSurfaceView.leftflag = false;
                    RunSurfaceView.lefth = true;
                }
                RunSurfaceView.balllDFlag = true;
                RunSurfaceView.balllUFlag = false;
                RunSurfaceView.leftx = RunSurfaceView.this.f12x;
                RunSurfaceView.lefty = RunSurfaceView.this.f13y;
                if (Math.abs(RunSurfaceView.this.f12x - ((float) RunSurfaceView.xl)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f13y - ((float) RunSurfaceView.yl)) >= ((float) RunSurfaceView.hr)) {
                    RunSurfaceView.balllCFlag = true;
                } else {
                    RunSurfaceView.balllCFlag = false;
                }
                if (RunSurfaceView.leftOn) {
                    if (RunSurfaceView.mode == 3) {
                        if (!RunSurfaceView.sensorOn && Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                            if (x1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            }
                            if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                                RunSurfaceView.aileQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                                RunSurfaceView.aileQty = Constant.BASEMIN;
                            }
                        }
                        RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y1)) / ((float) RunSurfaceView.hr)));
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    } else if (RunSurfaceView.mode == 4) {
                        if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                            if (x1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            }
                            if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                                RunSurfaceView.ruddQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                                RunSurfaceView.ruddQty = Constant.BASEMIN;
                            }
                        }
                        RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y1)) / ((float) RunSurfaceView.hr)));
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    }
                } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                    if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                        if (x1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        }
                        if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                            RunSurfaceView.ruddQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                            RunSurfaceView.ruddQty = Constant.BASEMIN;
                        }
                    }
                    if (!RunSurfaceView.sensorOn && Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                        if (y1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        }
                        if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                            RunSurfaceView.elevQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                            RunSurfaceView.elevQty = Constant.BASEMIN;
                        }
                    }
                } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                    if (Math.abs(x1) > ((float) RunSurfaceView.interval)) {
                        if (x1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        } else if (x1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        }
                        if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                            RunSurfaceView.aileQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                            RunSurfaceView.aileQty = Constant.BASEMIN;
                        }
                    }
                    if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                        if (y1 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                        }
                        if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                            RunSurfaceView.elevQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                            RunSurfaceView.elevQty = Constant.BASEMIN;
                        }
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            }
            if (RunSurfaceView.this.f12x < ((float) (RunSurfaceView.xr - RunSurfaceView.ww0)) || RunSurfaceView.this.f12x > ((float) (RunSurfaceView.xr + RunSurfaceView.ww0)) || RunSurfaceView.this.f13y < ((float) (RunSurfaceView.yr - RunSurfaceView.hh0)) || RunSurfaceView.this.f13y > ((float) (RunSurfaceView.yr + RunSurfaceView.hh0))) {
                if (RunSurfaceView.righth) {
                    info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId());
                    if (RunSurfaceView.this.f12x > ((float) (RunSurfaceView.xhalf - (RunSurfaceView.r1 / 2)))) {
                        if (info.mCurrentDownEvent.right) {
                            RunSurfaceView.rightx = RunSurfaceView.this.f12x;
                            RunSurfaceView.righty = RunSurfaceView.this.f13y;
                            RunSurfaceView.ballrCFlag = true;
                        }
                    } else if (info.mCurrentDownEvent.right) {
                        if (RunSurfaceView.leftOn) {
                            if (RunSurfaceView.mode == 3) {
                                if (!RunSurfaceView.sensorOn) {
                                    RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                                }
                                RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                            } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                                RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                            RunSurfaceView.ballrDFlag = false;
                            RunSurfaceView.ballrUFlag = true;
                        } else {
                            RunSurfaceView.rightx = (float) RunSurfaceView.xr;
                            RunSurfaceView.righty = RunSurfaceView.this.f13y;
                            RunSurfaceView.ballrCFlag = true;
                            if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                                if (!RunSurfaceView.sensorOn) {
                                    RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                                }
                            } else if (RunSurfaceView.mode == 2) {
                                RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                            }
                            RunSurfaceView.rightflag = true;
                        }
                        info.mCurrentDownEvent.right = false;
                        RunSurfaceView.righth = false;
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            } else {
                if (!RunSurfaceView.righth) {
                    ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId())).mCurrentDownEvent.right = true;
                    RunSurfaceView.rightflag = false;
                    RunSurfaceView.righth = true;
                }
                RunSurfaceView.ballrDFlag = true;
                RunSurfaceView.ballrUFlag = false;
                RunSurfaceView.rightx = RunSurfaceView.this.f12x;
                RunSurfaceView.righty = RunSurfaceView.this.f13y;
                if (Math.abs(RunSurfaceView.this.f12x - ((float) RunSurfaceView.xr)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f13y - ((float) RunSurfaceView.yr)) >= ((float) RunSurfaceView.hr)) {
                    RunSurfaceView.ballrCFlag = true;
                } else {
                    RunSurfaceView.ballrCFlag = false;
                }
                if (RunSurfaceView.leftOn) {
                    if (RunSurfaceView.mode == 3) {
                        if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                            if (x2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                            }
                            if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                                RunSurfaceView.ruddQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                                RunSurfaceView.ruddQty = Constant.BASEMIN;
                            }
                        }
                        if (!RunSurfaceView.sensorOn && Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                            if (y2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            }
                            if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                                RunSurfaceView.elevQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                                RunSurfaceView.elevQty = Constant.BASEMIN;
                            }
                        }
                    } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                        if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                            if (x2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                            }
                            if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                                RunSurfaceView.aileQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                                RunSurfaceView.aileQty = Constant.BASEMIN;
                            }
                        }
                        if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                            if (y2 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.elevQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.elevIDec * 2))));
                            }
                            if (RunSurfaceView.elevQty >= Constant.BASEMAX) {
                                RunSurfaceView.elevQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.elevQty <= Constant.BASEMIN) {
                                RunSurfaceView.elevQty = Constant.BASEMIN;
                            }
                        }
                    }
                } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                    if (!RunSurfaceView.sensorOn && Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                        if (x2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.aileQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.aileIDec * 2))));
                        }
                        if (RunSurfaceView.aileQty >= Constant.BASEMAX) {
                            RunSurfaceView.aileQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.aileQty <= Constant.BASEMIN) {
                            RunSurfaceView.aileQty = Constant.BASEMIN;
                        }
                    }
                    RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y2)) / ((float) RunSurfaceView.hr)));
                    if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                        RunSurfaceView.throQty = Constant.BASEMAX;
                    }
                    if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                        RunSurfaceView.throQty = Constant.BASEMIN;
                    }
                } else if (RunSurfaceView.mode == 2) {
                    if (Math.abs(x2) > ((float) RunSurfaceView.interval)) {
                        if (x2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        } else if (x2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.ruddQty = (short) ((int) (((1600.0f * ((0.0f - x2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.wr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.ruddIDec * 2))));
                        }
                        if (RunSurfaceView.ruddQty >= Constant.BASEMAX) {
                            RunSurfaceView.ruddQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.ruddQty <= Constant.BASEMIN) {
                            RunSurfaceView.ruddQty = Constant.BASEMIN;
                        }
                    }
                    RunSurfaceView.throQty = (short) ((int) ((1600.0f * (0.0f - y2)) / ((float) RunSurfaceView.hr)));
                    if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                        RunSurfaceView.throQty = Constant.BASEMAX;
                    }
                    if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                        RunSurfaceView.throQty = Constant.BASEMIN;
                    }
                }
                if (RunSurfaceView.vibratorFlag) {
                    RunSurfaceView.vibrator.vibrate(200);
                }
            }
            if (!EncodeDisplay.transferring) {
                RunSurfaceView.getValue();
            }
            return true;
        }
    }

    static {
        vibratorFlag = false;
        vibratorF = false;
        running = false;
        MjpgRunFlag = false;
        wifiFlag = false;
        elevinv = false;
        aileinv = false;
        throinv = false;
        ruddinv = false;
        vibratev = false;
        modelFlag = PHOTO_SHOW;
        mode = AV_SHOW;
        module = 2;
        popNo = PHOTO_SHOW;
        make = PHOTO_SHOW;
        makex = PHOTO_SHOW;
        makey = PHOTO_SHOW;
        arrow = PHOTO_SHOW;
        model = new String[]{"Model1", "Model2", "Model3", "Model4", "Model5", "Model6"};
        helmFlag = PHOTO_SHOW;
        BarHelmbe = 100;
        BarHelmse = 100;
        BarHelmba = 100;
        BarHelmsa = 100;
        BarHelmbr = 100;
        BarHelmsr = 100;
        BarBEE = PHOTO_SHOW;
        BarSEE = PHOTO_SHOW;
        BarBEA = PHOTO_SHOW;
        BarSEA = PHOTO_SHOW;
        BarBER = PHOTO_SHOW;
        BarSER = PHOTO_SHOW;
        helm = new String[]{"ELEV", "AILE", "RUDD"};
        throFlag = PHOTO_SHOW;
        expFlag = false;
        pointLFlag = true;
        point1Flag = false;
        point2Flag = true;
        pointMFlag = true;
        point3Flag = false;
        point4Flag = false;
        pointHFlag = true;
        pointLL = 0.0f;
        point11 = 16.5f;
        point22 = 33.5f;
        pointMM = 50.0f;
        point33 = 66.5f;
        point44 = 83.5f;
        pointHH = 100.0f;
        adjustratio = 0.0f;
        throitem = new String[]{"L:0.0%", "1:16.5%", "2:33.5%", "M:50.0%", "3:66.5%", "4:83.5%", "H:100.0%"};
        screwFlag = PHOTO_SHOW;
        expSFlag = false;
        pointLSFlag = true;
        point1SFlag = false;
        point2SFlag = false;
        pointMSFlag = true;
        point3SFlag = false;
        point4SFlag = false;
        pointHSFlag = true;
        pointLLS = -100.0f;
        point11S = -67.0f;
        point22S = -33.0f;
        pointMMS = 0.0f;
        point33S = 33.0f;
        point44S = 67.0f;
        pointHHS = 100.0f;
        screwitem = new String[]{"L:-100.0%", "1:-67.0%", "2:-33.0%", "M:0.0%", "3:33.0%", "4:67.0%", "H:100.0%"};
        scales0 = 1.0f;
        leftUL = true;
        rightUR = true;
        leftflag = false;
        rightflag = false;
        dispalyFlag = false;
        lefth = false;
        righth = false;
        hiddenFlag = false;
        hiddenFullFlag = false;
        cool = false;
        isOn = false;
        leftOn = false;
        sensorOn = false;
        runFlag = true;
        buttonCFlag = true;
        balllCFlag = false;
        ballrCFlag = false;
        balllDFlag = false;
        ballrDFlag = false;
        balllUFlag = true;
        ballrUFlag = true;
        outRect = new float[]{8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f};
        screwQty = Constant.BASEMIN;
        elevQty = (short) 0;
        aileQty = (short) 0;
        throQty = Constant.BASEMIN;
        ruddQty = (short) 0;
        auxQty = (short) 0;
        auxIDec = (short) 0;
        elevIDec = (short) 0;
        aileIDec = (short) 0;
        throIDec = (short) 0;
        ruddIDec = (short) 0;
        elevIDecB = elevIDec;
        aileIDecB = aileIDec;
        throIDecB = throIDec;
        ruddIDecB = ruddIDec;
        BASEMIN0 = Constant.BASEMIN;
        playbuffer = new short[8];
        cmdBuffer = new byte[18];
        cmdBuffer00 = new byte[2];
        isOnFlag = false;
        cno = PHOTO_SHOW;
        pvshowFlag = false;
        wifiConFlag = false;
        orientFlag = false;
        toast = null;
        barw0 = PHOTO_SHOW;
        barh0 = PHOTO_SHOW;
        barw = 0.0f;
        barh = PHOTO_SHOW;
        interval = PHOTO_SHOW;
        scrollFlag = true;
    }

    public RunSurfaceView(Context context) {
        super(context);
        this.mCornerX = PHOTO_SHOW;
        this.mCornerY = PHOTO_SHOW;
        this.x0 = PHOTO_SHOW;
        this.y0 = PHOTO_SHOW;
        this.mTouch = new PointF();
        this.mBezierStart1 = new PointF();
        this.mBezierControl1 = new PointF();
        this.mBeziervertex1 = new PointF();
        this.mBezierEnd1 = new PointF();
        this.mBezierStart2 = new PointF();
        this.mBezierControl2 = new PointF();
        this.mBeziervertex2 = new PointF();
        this.mBezierEnd2 = new PointF();
        this.mMatrixArray = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.mMaxLength = (float) Math.hypot((double) mWidth, (double) mHeight);
        this.exitTime = 0;
        myActivity = (Helicopter) context;
        gsensor = new GSensor(context);
        curve = new CurveSurfaceView(context);
        PagesWidget();
        holder = getHolder();
        holder.addCallback(this);
        mListener = new GestureListener();
        mGesture = new MultiTouchGestureDetector(context, mListener);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public RunSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCornerX = PHOTO_SHOW;
        this.mCornerY = PHOTO_SHOW;
        this.x0 = PHOTO_SHOW;
        this.y0 = PHOTO_SHOW;
        this.mTouch = new PointF();
        this.mBezierStart1 = new PointF();
        this.mBezierControl1 = new PointF();
        this.mBeziervertex1 = new PointF();
        this.mBezierEnd1 = new PointF();
        this.mBezierStart2 = new PointF();
        this.mBezierControl2 = new PointF();
        this.mBeziervertex2 = new PointF();
        this.mBezierEnd2 = new PointF();
        this.mMatrixArray = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.mMaxLength = (float) Math.hypot((double) mWidth, (double) mHeight);
        this.exitTime = 0;
        myActivity = (Helicopter) context;
        gsensor = new GSensor(context);
        curve = new CurveSurfaceView(context);
        PagesWidget();
        holder = getHolder();
        holder.addCallback(this);
        mListener = new GestureListener();
        mGesture = new MultiTouchGestureDetector(context, mListener);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public void PagesWidget() {
        this.mPath0 = new Path();
        this.mPath1 = new Path();
        createDrawable();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.FILL);
        ColorMatrix cm = new ColorMatrix();
        cm.set(new float[]{0.55f, 0.0f, 0.0f, 0.0f, 80.0f, 0.0f, 0.55f, 0.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.55f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f});
        this.mColorMatrixFilter = new ColorMatrixColorFilter(cm);
        this.mMatrix = new Matrix();
        this.mScroller = new Scroller(getContext());
        this.mTouch.x = 0.01f;
        this.mTouch.y = 0.01f;
    }

    public void calcCornerXY(float x, float y) {
        if (x <= ((float) (mWidth / 2))) {
            this.mCornerX = PHOTO_SHOW;
        } else {
            this.mCornerX = mWidth;
        }
        if (y <= ((float) (mHeight / 2))) {
            this.mCornerY = PHOTO_SHOW;
        } else {
            this.mCornerY = mHeight;
        }
        if ((this.mCornerX == 0 && this.mCornerY == mHeight) || (this.mCornerX == mWidth && this.mCornerY == 0)) {
            this.mIsRTandLB = true;
        } else {
            this.mIsRTandLB = false;
        }
    }

    public boolean doTouchEvent0() {
        calcPoints();
        if (!canDragOver()) {
            return false;
        }
        startAnimation0(800);
        return true;
    }

    public PointF getCross(PointF P1, PointF P2, PointF P3, PointF P4) {
        PointF CrossP = new PointF();
        float a1 = (P2.y - P1.y) / (P2.x - P1.x);
        float b1 = ((P1.x * P2.y) - (P2.x * P1.y)) / (P1.x - P2.x);
        CrossP.x = ((((P3.x * P4.y) - (P4.x * P3.y)) / (P3.x - P4.x)) - b1) / (a1 - ((P4.y - P3.y) / (P4.x - P3.x)));
        CrossP.y = (CrossP.x * a1) + b1;
        return CrossP;
    }

    private void calcPoints() {
        this.mMiddleX = (this.mTouch.x + ((float) this.mCornerX)) / 2.0f;
        this.mMiddleY = (this.mTouch.y + ((float) this.mCornerY)) / 2.0f;
        this.mBezierControl1.x = this.mMiddleX - (((((float) this.mCornerY) - this.mMiddleY) * (((float) this.mCornerY) - this.mMiddleY)) / (((float) this.mCornerX) - this.mMiddleX));
        this.mBezierControl1.y = (float) this.mCornerY;
        this.mBezierControl2.x = (float) this.mCornerX;
        this.mBezierControl2.y = this.mMiddleY - (((((float) this.mCornerX) - this.mMiddleX) * (((float) this.mCornerX) - this.mMiddleX)) / (((float) this.mCornerY) - this.mMiddleY));
        this.mBezierStart1.x = this.mBezierControl1.x - ((((float) this.mCornerX) - this.mBezierControl1.x) / 2.0f);
        this.mBezierStart1.y = (float) this.mCornerY;
        if (this.mTouch.x > 0.0f && this.mTouch.x < ((float) mWidth) && (this.mBezierStart1.x < 0.0f || this.mBezierStart1.x > ((float) mWidth))) {
            if (this.mBezierStart1.x < 0.0f) {
                this.mBezierStart1.x = ((float) mWidth) - this.mBezierStart1.x;
            }
            float f1 = Math.abs(((float) this.mCornerX) - this.mTouch.x);
            float f2 = (((float) mWidth) * f1) / this.mBezierStart1.x;
            this.mTouch.x = Math.abs(((float) this.mCornerX) - f2);
            float f3 = (Math.abs(((float) this.mCornerX) - this.mTouch.x) * Math.abs(((float) this.mCornerY) - this.mTouch.y)) / f1;
            this.mTouch.y = Math.abs(((float) this.mCornerY) - f3);
            this.mMiddleX = (this.mTouch.x + ((float) this.mCornerX)) / 2.0f;
            this.mMiddleY = (this.mTouch.y + ((float) this.mCornerY)) / 2.0f;
            this.mBezierControl1.x = this.mMiddleX - (((((float) this.mCornerY) - this.mMiddleY) * (((float) this.mCornerY) - this.mMiddleY)) / (((float) this.mCornerX) - this.mMiddleX));
            this.mBezierControl1.y = (float) this.mCornerY;
            this.mBezierControl2.x = (float) this.mCornerX;
            this.mBezierControl2.y = this.mMiddleY - (((((float) this.mCornerX) - this.mMiddleX) * (((float) this.mCornerX) - this.mMiddleX)) / (((float) this.mCornerY) - this.mMiddleY));
            this.mBezierStart1.x = this.mBezierControl1.x - ((((float) this.mCornerX) - this.mBezierControl1.x) / 2.0f);
        }
        this.mBezierStart2.x = (float) this.mCornerX;
        this.mBezierStart2.y = this.mBezierControl2.y - ((((float) this.mCornerY) - this.mBezierControl2.y) / 2.0f);
        this.mTouchToCornerDis = (float) Math.hypot((double) (this.mTouch.x - ((float) this.mCornerX)), (double) (this.mTouch.y - ((float) this.mCornerY)));
        this.mBezierEnd1 = getCross(this.mTouch, this.mBezierControl1, this.mBezierStart1, this.mBezierStart2);
        this.mBezierEnd2 = getCross(this.mTouch, this.mBezierControl2, this.mBezierStart1, this.mBezierStart2);
        this.mBeziervertex1.x = ((this.mBezierStart1.x + (this.mBezierControl1.x * 2.0f)) + this.mBezierEnd1.x) / 4.0f;
        this.mBeziervertex1.y = (((this.mBezierControl1.y * 2.0f) + this.mBezierStart1.y) + this.mBezierEnd1.y) / 4.0f;
        this.mBeziervertex2.x = ((this.mBezierStart2.x + (this.mBezierControl2.x * 2.0f)) + this.mBezierEnd2.x) / 4.0f;
        this.mBeziervertex2.y = (((this.mBezierControl2.y * 2.0f) + this.mBezierStart2.y) + this.mBezierEnd2.y) / 4.0f;
    }

    private void drawCurrentPageArea(Canvas canvas, Bitmap bitmap, Path path) {
        this.mPath0.reset();
        this.mPath0.moveTo(this.mBezierStart1.x, this.mBezierStart1.y);
        this.mPath0.quadTo(this.mBezierControl1.x, this.mBezierControl1.y, this.mBezierEnd1.x, this.mBezierEnd1.y);
        this.mPath0.lineTo(this.mTouch.x, this.mTouch.y);
        this.mPath0.lineTo(this.mBezierEnd2.x, this.mBezierEnd2.y);
        this.mPath0.quadTo(this.mBezierControl2.x, this.mBezierControl2.y, this.mBezierStart2.x, this.mBezierStart2.y);
        this.mPath0.lineTo((float) this.mCornerX, (float) this.mCornerY);
        this.mPath0.close();
        canvas.save();
        canvas.clipPath(path, Op.XOR);
        canvas.drawBitmap(bitmap, (float) ((mWidth - this.pgw0) / 2), (float) ((mHeight - this.pgh0) / 2), null);
        canvas.restore();
    }

    private void drawNextPageAreaAndShadow(Canvas canvas, Bitmap bitmap) {
        int leftx;
        int rightx;
        GradientDrawable mBackShadowDrawable;
        this.mPath1.reset();
        this.mPath1.moveTo(this.mBezierStart1.x, this.mBezierStart1.y);
        this.mPath1.lineTo(this.mBeziervertex1.x, this.mBeziervertex1.y);
        this.mPath1.lineTo(this.mBeziervertex2.x, this.mBeziervertex2.y);
        this.mPath1.lineTo(this.mBezierStart2.x, this.mBezierStart2.y);
        this.mPath1.lineTo((float) this.mCornerX, (float) this.mCornerY);
        this.mPath1.close();
        this.mDegrees = (float) Math.toDegrees(Math.atan2((double) (this.mBezierControl1.x - ((float) this.mCornerX)), (double) (this.mBezierControl2.y - ((float) this.mCornerY))));
        if (this.mIsRTandLB) {
            leftx = (int) this.mBezierStart1.x;
            rightx = (int) (this.mBezierStart1.x + (this.mTouchToCornerDis / 4.0f));
            mBackShadowDrawable = this.mBackShadowDrawableLR;
        } else {
            leftx = (int) (this.mBezierStart1.x - (this.mTouchToCornerDis / 4.0f));
            rightx = (int) this.mBezierStart1.x;
            mBackShadowDrawable = this.mBackShadowDrawableRL;
        }
        canvas.save();
        canvas.clipPath(this.mPath0);
        canvas.clipPath(this.mPath1, Op.INTERSECT);
        canvas.drawBitmap(bitmap, (float) ((mWidth - this.pgw0) / 2), (float) ((mHeight - this.pgh0) / 2), null);
        canvas.rotate(this.mDegrees, this.mBezierStart1.x, this.mBezierStart1.y);
        mBackShadowDrawable.setBounds(leftx, (int) this.mBezierStart1.y, rightx, (int) (this.mMaxLength + this.mBezierStart1.y));
        mBackShadowDrawable.draw(canvas);
        canvas.restore();
    }

    public void setBitmaps(Bitmap bm1, Bitmap bm2) {
        mCurPageBitmap = bm1;
        mNextPageBitmap = bm2;
    }

    private void createDrawable() {
        int[] color = new int[]{3355443, -1338821837};
        this.mFolderShadowDrawableRL = new GradientDrawable(Orientation.RIGHT_LEFT, color);
        this.mFolderShadowDrawableRL.setGradientType(PHOTO_SHOW);
        this.mFolderShadowDrawableLR = new GradientDrawable(Orientation.LEFT_RIGHT, color);
        this.mFolderShadowDrawableLR.setGradientType(PHOTO_SHOW);
        this.mBackShadowColors = new int[]{-15658735, 1118481};
        this.mBackShadowDrawableRL = new GradientDrawable(Orientation.RIGHT_LEFT, this.mBackShadowColors);
        this.mBackShadowDrawableRL.setGradientType(PHOTO_SHOW);
        this.mBackShadowDrawableLR = new GradientDrawable(Orientation.LEFT_RIGHT, this.mBackShadowColors);
        this.mBackShadowDrawableLR.setGradientType(PHOTO_SHOW);
        this.mFrontShadowColors = new int[]{-2146365167, 1118481};
        this.mFrontShadowDrawableVLR = new GradientDrawable(Orientation.LEFT_RIGHT, this.mFrontShadowColors);
        this.mFrontShadowDrawableVLR.setGradientType(PHOTO_SHOW);
        this.mFrontShadowDrawableVRL = new GradientDrawable(Orientation.RIGHT_LEFT, this.mFrontShadowColors);
        this.mFrontShadowDrawableVRL.setGradientType(PHOTO_SHOW);
        this.mFrontShadowDrawableHTB = new GradientDrawable(Orientation.TOP_BOTTOM, this.mFrontShadowColors);
        this.mFrontShadowDrawableHTB.setGradientType(PHOTO_SHOW);
        this.mFrontShadowDrawableHBT = new GradientDrawable(Orientation.BOTTOM_TOP, this.mFrontShadowColors);
        this.mFrontShadowDrawableHBT.setGradientType(PHOTO_SHOW);
    }

    public void drawCurrentPageShadow(Canvas canvas) {
        double degree;
        float y;
        int leftx;
        int rightx;
        GradientDrawable mCurrentPageShadow;
        float temp;
        if (this.mIsRTandLB) {
            degree = 0.7853981633974483d - Math.atan2((double) (this.mBezierControl1.y - this.mTouch.y), (double) (this.mTouch.x - this.mBezierControl1.x));
        } else {
            degree = 0.7853981633974483d - Math.atan2((double) (this.mTouch.y - this.mBezierControl1.y), (double) (this.mTouch.x - this.mBezierControl1.x));
        }
        double d1 = 35.35d * Math.cos(degree);
        double d2 = 35.35d * Math.sin(degree);
        float x = (float) (((double) this.mTouch.x) + d1);
        if (this.mIsRTandLB) {
            y = (float) (((double) this.mTouch.y) + d2);
        } else {
            y = (float) (((double) this.mTouch.y) - d2);
        }
        this.mPath1.reset();
        this.mPath1.moveTo(x, y);
        this.mPath1.lineTo(this.mTouch.x, this.mTouch.y);
        this.mPath1.lineTo(this.mBezierControl1.x, this.mBezierControl1.y);
        this.mPath1.lineTo(this.mBezierStart1.x, this.mBezierStart1.y);
        this.mPath1.close();
        canvas.save();
        canvas.clipPath(this.mPath0, Op.XOR);
        canvas.clipPath(this.mPath1, Op.INTERSECT);
        if (this.mIsRTandLB) {
            leftx = (int) this.mBezierControl1.x;
            rightx = ((int) this.mBezierControl1.x) + 25;
            mCurrentPageShadow = this.mFrontShadowDrawableVLR;
        } else {
            leftx = (int) (this.mBezierControl1.x - 25.0f);
            rightx = ((int) this.mBezierControl1.x) + AV_SHOW;
            mCurrentPageShadow = this.mFrontShadowDrawableVRL;
        }
        canvas.rotate((float) Math.toDegrees(Math.atan2((double) (this.mTouch.x - this.mBezierControl1.x), (double) (this.mBezierControl1.y - this.mTouch.y))), this.mBezierControl1.x, this.mBezierControl1.y);
        mCurrentPageShadow.setBounds(leftx, (int) (this.mBezierControl1.y - this.mMaxLength), rightx, (int) this.mBezierControl1.y);
        mCurrentPageShadow.draw(canvas);
        canvas.restore();
        this.mPath1.reset();
        this.mPath1.moveTo(x, y);
        this.mPath1.lineTo(this.mTouch.x, this.mTouch.y);
        this.mPath1.lineTo(this.mBezierControl2.x, this.mBezierControl2.y);
        this.mPath1.lineTo(this.mBezierStart2.x, this.mBezierStart2.y);
        this.mPath1.close();
        canvas.save();
        canvas.clipPath(this.mPath0, Op.XOR);
        canvas.clipPath(this.mPath1, Op.INTERSECT);
        if (this.mIsRTandLB) {
            leftx = (int) this.mBezierControl2.y;
            rightx = (int) (this.mBezierControl2.y + 25.0f);
            mCurrentPageShadow = this.mFrontShadowDrawableHTB;
        } else {
            leftx = (int) (this.mBezierControl2.y - 25.0f);
            rightx = (int) (this.mBezierControl2.y + 1.0f);
            mCurrentPageShadow = this.mFrontShadowDrawableHBT;
        }
        canvas.rotate((float) Math.toDegrees(Math.atan2((double) (this.mBezierControl2.y - this.mTouch.y), (double) (this.mBezierControl2.x - this.mTouch.x))), this.mBezierControl2.x, this.mBezierControl2.y);
        if (this.mBezierControl2.y < 0.0f) {
            temp = this.mBezierControl2.y - ((float) mHeight);
        } else {
            temp = this.mBezierControl2.y;
        }
        int hmg = (int) Math.hypot((double) this.mBezierControl2.x, (double) temp);
        if (((float) hmg) > this.mMaxLength) {
            mCurrentPageShadow.setBounds(((int) (this.mBezierControl2.x - 25.0f)) - hmg, leftx, ((int) (this.mBezierControl2.x + this.mMaxLength)) - hmg, rightx);
        } else {
            mCurrentPageShadow.setBounds((int) (this.mBezierControl2.x - this.mMaxLength), leftx, (int) this.mBezierControl2.x, rightx);
        }
        mCurrentPageShadow.draw(canvas);
        canvas.restore();
    }

    private void drawCurrentBackArea(Canvas canvas, Bitmap bitmap) {
        int left;
        int right;
        GradientDrawable mFolderShadowDrawable;
        float f3 = Math.min(Math.abs(((float) (((int) (this.mBezierStart1.x + this.mBezierControl1.x)) / 2)) - this.mBezierControl1.x), Math.abs(((float) (((int) (this.mBezierStart2.y + this.mBezierControl2.y)) / 2)) - this.mBezierControl2.y));
        this.mPath1.reset();
        this.mPath1.moveTo(this.mBeziervertex2.x, this.mBeziervertex2.y);
        this.mPath1.lineTo(this.mBeziervertex1.x, this.mBeziervertex1.y);
        this.mPath1.lineTo(this.mBezierEnd1.x, this.mBezierEnd1.y);
        this.mPath1.lineTo(this.mTouch.x, this.mTouch.y);
        this.mPath1.lineTo(this.mBezierEnd2.x, this.mBezierEnd2.y);
        this.mPath1.close();
        if (this.mIsRTandLB) {
            left = (int) (this.mBezierStart1.x - 1.0f);
            right = (int) ((this.mBezierStart1.x + f3) + 1.0f);
            mFolderShadowDrawable = this.mFolderShadowDrawableLR;
        } else {
            left = (int) ((this.mBezierStart1.x - f3) - 1.0f);
            right = (int) (this.mBezierStart1.x + 1.0f);
            mFolderShadowDrawable = this.mFolderShadowDrawableRL;
        }
        canvas.save();
        canvas.clipPath(this.mPath0);
        canvas.clipPath(this.mPath1, Op.INTERSECT);
        this.mPaint.setColorFilter(this.mColorMatrixFilter);
        float dis = (float) Math.hypot((double) (((float) this.mCornerX) - this.mBezierControl1.x), (double) (this.mBezierControl2.y - ((float) this.mCornerY)));
        float f8 = (((float) this.mCornerX) - this.mBezierControl1.x) / dis;
        float f9 = (this.mBezierControl2.y - ((float) this.mCornerY)) / dis;
        this.mMatrixArray[PHOTO_SHOW] = 1.0f - ((2.0f * f9) * f9);
        this.mMatrixArray[AV_SHOW] = (2.0f * f8) * f9;
        this.mMatrixArray[3] = this.mMatrixArray[AV_SHOW];
        this.mMatrixArray[4] = 1.0f - ((2.0f * f8) * f8);
        this.mMatrix.reset();
        this.mMatrix.setValues(this.mMatrixArray);
        this.mMatrix.preTranslate(-this.mBezierControl1.x, -this.mBezierControl1.y);
        this.mMatrix.postTranslate(this.mBezierControl1.x, this.mBezierControl1.y);
        canvas.drawBitmap(bitmap, this.mMatrix, this.mPaint);
        this.mPaint.setColorFilter(null);
        canvas.rotate(this.mDegrees, this.mBezierStart1.x, this.mBezierStart1.y);
        mFolderShadowDrawable.setBounds(left, (int) this.mBezierStart1.y, right, (int) (this.mBezierStart1.y + this.mMaxLength));
        mFolderShadowDrawable.draw(canvas);
        canvas.restore();
    }

    private void startAnimation0(int delayMillis) {
        if (this.mCornerX > 0) {
            this.dx = -((int) (((float) mWidth) + this.mTouch.x));
        } else {
            this.dx = (int) ((((float) mWidth) - this.mTouch.x) + ((float) mWidth));
        }
        if (this.mCornerY > 0) {
            this.dy = (int) (1.0f - this.mTouch.y);
        } else {
            this.dy = (int) (((float) mHeight) - this.mTouch.y);
        }
        this.x0 = ((int) this.mTouch.x) + this.dx;
        this.y0 = ((int) this.mTouch.y) + this.dy;
        this.mScroller.startScroll((int) this.mTouch.x, (int) this.mTouch.y, this.dx, this.dy, delayMillis);
    }

    public void abortAnimation() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
    }

    public boolean canDragOver() {
        if (this.mTouchToCornerDis > ((float) (mWidth / 10))) {
            return true;
        }
        return false;
    }

    public boolean DragToRight() {
        if (this.mCornerX > 0) {
            return false;
        }
        return true;
    }

    public static void init() {
        mWidth = Helicopter.screenWidth;
        mHeight = Helicopter.screenHeight;
        encodeDisplay = new EncodeDisplay();
        barbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.bar);
        bar0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.bar0);
        throbarbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.progressbar);
        elevbarbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.elevbar);
        ruddbarbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.ruddbar);
        ailebarbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.ailebar);
        ballbackbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.ballback);
        ballbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.stick);
        camerabmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.camera);
        camera0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.camera0);
        photobmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.photo);
        photo0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.photo0);
        pvshowbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.pvshow);
        pvshow0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.pvshow0);
        gravityonbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.gravityon);
        gravityoffbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.gravityoff);
        onbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.on);
        offbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.off);
        crossbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.cross);
        wificonbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.wificon);
        wificonoffbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.wificon0);
        setbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.setting);
        manual = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.back);
        helmexpbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.helmexp);
        throexpbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.thro);
        screwbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.screw);
        screenHeight = Helicopter.screenHeight;
        screenWidth = Helicopter.screenWidth;
        scales = Helicopter.scales;
        scales0 = Helicopter.scales0;
        barbmp = Helicopter.ToFit(barbmp, scales0);
        bar0bmp = Helicopter.ToFit(bar0bmp, scales0);
        throbarbmp = Helicopter.ToFit(throbarbmp, scales0);
        elevbarbmp = Helicopter.ToFit(elevbarbmp, scales0);
        ruddbarbmp = Helicopter.ToFit(ruddbarbmp, scales0);
        ailebarbmp = Helicopter.ToFit(ailebarbmp, scales0);
        ballbackbmp = Helicopter.ToFit(ballbackbmp, scales0);
        ballbmp = Helicopter.ToFit(ballbmp, scales0);
        camerabmp = Helicopter.ToFit(camerabmp, scales0);
        camera0bmp = Helicopter.ToFit(camera0bmp, scales0);
        photobmp = Helicopter.ToFit(photobmp, scales0);
        photo0bmp = Helicopter.ToFit(photo0bmp, scales0);
        pvshowbmp = Helicopter.ToFit(pvshowbmp, scales0);
        pvshow0bmp = Helicopter.ToFit(pvshow0bmp, scales0);
        gravityonbmp = Helicopter.ToFit(gravityonbmp, scales0);
        gravityoffbmp = Helicopter.ToFit(gravityoffbmp, scales0);
        onbmp = Helicopter.ToFit(onbmp, scales0);
        offbmp = Helicopter.ToFit(offbmp, scales0);
        crossbmp = Helicopter.ToFit(crossbmp, scales0);
        wificonbmp = Helicopter.ToFit(wificonbmp, scales0);
        wificonoffbmp = Helicopter.ToFit(wificonoffbmp, scales0);
        setbmp = Helicopter.ToFit(setbmp, scales0);
        manual = Helicopter.ToFit(manual, scales0);
        helmexpbmp = Helicopter.ToFit(helmexpbmp, scales0);
        throexpbmp = Helicopter.ToFit(throexpbmp, scales0);
        screwbmp = Helicopter.ToFit(screwbmp, scales0);
        mbitmap = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.background);
        mbitmap = Helicopter.ToFit(mbitmap, ThemeSurfaceView.scales0);
        matrix = new Matrix();
        f11w = mbitmap.getWidth();
        f7h = mbitmap.getHeight();
        arrow = (int) ((((float) f11w) * 50.0f) / 720.0f);
        w0 = setbmp.getWidth();
        h0 = setbmp.getHeight();
        barw0 = throbarbmp.getWidth();
        barh0 = throbarbmp.getHeight();
        barw = ((float) elevbarbmp.getWidth()) / 1600.0f;
        barh = elevbarbmp.getHeight();
        xhalf = screenWidth / 2;
        yhalf = screenHeight / 2;
        xl = xhalf - (f11w / 4);
        yl = yhalf;
        xr = xhalf + (f11w / 4);
        yr = yhalf;
        r0 = ballbackbmp.getWidth() / 2;
        r1 = ballbmp.getWidth() / 2;
        f9r = r0 + r1;
        hh = screenHeight / 2;
        f10t = hh - r1;
        interval = r1 / 2;
        make = (int) (10.0f * scales0);
        ww0 = f9r - make;
        hh0 = f9r - make;
        wr = r0 - r1;
        hr = r0 - r1;
        float rx = ((float) ((screenWidth - (w0 * 2)) / 2)) / ((float) ballbackbmp.getWidth());
        float ry = ((float) screenHeight) / ((float) ballbackbmp.getHeight());
        int bmpWidth = ballbackbmp.getWidth();
        int bmpHeight = ballbackbmp.getHeight();
        matrix.reset();
        matrix.setScale(rx, ry);
        ballbackbmp0 = Bitmap.createBitmap(ballbackbmp, PHOTO_SHOW, PHOTO_SHOW, bmpWidth, bmpHeight, matrix, true);
        makex = (int) (((float) make) * rx);
        makey = (int) (((float) make) * ry);
        ballbackbmp = Helicopter.ToFit(ballbackbmp, ((float) f9r) / ((float) r0));
        xleft = xhalf - (f11w / 2);
        xright = xhalf + (f11w / 2);
        ytop = yhalf - (f7h / 2);
        ybottom = yhalf + (f7h / 2);
        fix0 = (float) ((xleft + w0) + 4);
        fix1 = (float) ((xleft + (w0 * 2)) + 8);
        fix2 = (float) ((xleft + (w0 * 3)) + 12);
        fix3 = (float) ((xleft + (w0 * 4)) + 16);
        fix4 = (float) ((xleft + (w0 * 5)) + 20);
        fix5 = (float) ((xleft + (w0 * 6)) + 24);
        fix6 = (float) ((xright - (w0 * 4)) - 12);
        fix7 = (float) ((xright - (w0 * 3)) - 8);
        fix8 = (float) ((xright - (w0 * 2)) - 4);
        fix9 = (float) ((xleft + (w0 * 4)) + 16);
        fixx = (float) (xright - w0);
        fixb = (float) (ybottom - h0);
        tw0 = ((float) xleft) + (2.0f * scales);
        tw = ((float) xleft) + (12.0f * scales);
        th = ((float) (ytop + h0)) + (10.0f * scales);
        basecoor0 = (int) (14.0f * scales);
        basecoor1 = (int) (72.0f * scales);
        basecoor2 = (int) (42.0f * scales);
        basecoor00 = (int) (18.0f * scales);
        basecoor01 = (int) (38.0f * scales);
        basecoor02 = (int) (58.0f * scales);
        basecoor03 = (int) (78.0f * scales);
        paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setFakeBoldText(true);
        paint.setTextSize(12.0f * scales);
        f8p = new Paint();
        f8p.setColor(-29696);
        f8p.setAntiAlias(true);
        f8p.setStyle(Style.FILL);
        f8p.setFakeBoldText(true);
        f8p.setTextSize(12.0f * scales);
        p0 = new Paint();
        p0.setColor(-29696);
        p0.setAntiAlias(true);
        p0.setStyle(Style.FILL);
        p0.setFakeBoldText(true);
        p0.setTextSize(18.0f * scales);
        ballBackGradient = new BitmapShader(ballbackbmp, TileMode.REPEAT, TileMode.MIRROR);
        ballBackGradient0 = new BitmapShader(ballbackbmp0, TileMode.REPEAT, TileMode.MIRROR);
        ballGradient = new BitmapShader(ballbmp, TileMode.REPEAT, TileMode.MIRROR);
        ballBackLRect = new Rect(xl - f9r, yl - f9r, xl + f9r, yl + f9r);
        ballbackl = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballbackl.getPaint().setShader(ballBackGradient);
        ballbackl.setBounds(ballBackLRect);
        ballBackRRect = new Rect(xr - f9r, yr - f9r, xr + f9r, yr + f9r);
        ballbackr = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballbackr.getPaint().setShader(ballBackGradient);
        ballbackr.setBounds(ballBackRRect);
        int rc = (screenWidth - (w0 * 2)) / 4;
        ballBackLRect0 = new Rect(PHOTO_SHOW, yl - hh, rc * 2, yl + hh);
        ballbackl0 = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballbackl0.getPaint().setShader(ballBackGradient0);
        ballbackl0.setBounds(ballBackLRect0);
        ballBackRRect0 = new Rect(screenWidth - (rc * 2), yr - hh, screenWidth, yr + hh);
        ballbackr0 = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballbackr0.getPaint().setShader(ballBackGradient0);
        ballbackr0.setBounds(ballBackRRect0);
        ballLRect = new Rect(xl - r1, yl - r1, xl + r1, yl + r1);
        ballRRect = new Rect(xr - r1, yr - r1, xr + r1, yr + r1);
        ballLRect0 = new Rect(xl - r1, ((yl + f9r) - make) - (r1 * 2), xl + r1, (yl - make) + f9r);
        ballRRect0 = new Rect(xr - r1, ((yr + f9r) - make) - (r1 * 2), xr + r1, (yr - make) + f9r);
        balll = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        balll.getPaint().setShader(ballGradient);
        ballr = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballr.getPaint().setShader(ballGradient);
        balll0 = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        balll0.getPaint().setShader(ballGradient);
        ballr0 = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballr0.getPaint().setShader(ballGradient);
        float basecor = (35.0f * scales) + ((float) barw0);
        float basecor0 = (float) barw0;
        float basecor1 = 14.0f * scales;
        path11 = new Path();
        path11.moveTo(((float) xright) - basecor, ((float) ytop) + basecor1);
        path11.lineTo(((float) xright) - (30.0f * scales), ((float) ytop) + basecor1);
        basecor1 = 26.0f * scales;
        path33 = new Path();
        path33.moveTo(((float) xright) - basecor, ((float) ytop) + basecor1);
        path33.lineTo(((float) xright) - basecor0, ((float) ytop) + basecor1);
        path22 = new Path();
        path22.moveTo((float) (xright - basecoor1), (((float) ytop) + basecor1) - ((float) barh0));
        path22.lineTo((float) (xright - basecoor2), (((float) ytop) + basecor1) - ((float) barh0));
        basecor1 = 46.0f * scales;
        path55 = new Path();
        path55.moveTo(((float) xright) - basecor, ((float) ytop) + basecor1);
        path55.lineTo(((float) xright) - basecor0, ((float) ytop) + basecor1);
        path44 = new Path();
        path44.moveTo((float) (xright - basecoor1), (((float) ytop) + basecor1) - ((float) barh0));
        path44.lineTo((float) (xright - basecoor2), (((float) ytop) + basecor1) - ((float) barh0));
        basecor1 = 66.0f * scales;
        path77 = new Path();
        path77.moveTo(((float) xright) - basecor, ((float) ytop) + basecor1);
        path77.lineTo(((float) xright) - basecor0, ((float) ytop) + basecor1);
        path66 = new Path();
        path66.moveTo((float) (xright - basecoor1), (((float) ytop) + basecor1) - ((float) barh0));
        path66.lineTo((float) (xright - basecoor2), (((float) ytop) + basecor1) - ((float) barh0));
        basecor1 = 86.0f * scales;
        path99 = new Path();
        path99.moveTo(((float) xright) - basecor, ((float) ytop) + basecor1);
        path99.lineTo(((float) xright) - basecor0, ((float) ytop) + basecor1);
        path88 = new Path();
        path88.moveTo((float) (xright - basecoor1), (((float) ytop) + basecor1) - ((float) barh0));
        path88.lineTo((float) (xright - basecoor2), (((float) ytop) + basecor1) - ((float) barh0));
        leftU = new Path();
        leftL = new Path();
        rightU = new Path();
        rightR = new Path();
        Vibrator vibrator = (Vibrator) Helicopter.context.getSystemService("vibrator");
        vibrator = vibrator;
        if (vibrator != null) {
            vibratorF = true;
        }
        if (!vibratev) {
            vibratorFlag = false;
        } else if (vibratorF) {
            vibratorFlag = true;
        } else {
            vibratorFlag = false;
        }
        cno = PHOTO_SHOW;
        isOnFlag = false;
    }

    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(Helicopter.context, msg, PHOTO_SHOW);
            toast.setGravity(17, PHOTO_SHOW, PHOTO_SHOW);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public void update() {
        if (mode == AV_SHOW || mode == 2) {
            leftOn = false;
        } else {
            leftOn = true;
        }
        elevQty = (short) (elevQty + (elevIDec * 2));
        if (elevQty >= Constant.BASEMAX) {
            elevQty = Constant.BASEMAX;
        }
        if (elevQty <= Constant.BASEMIN) {
            elevQty = Constant.BASEMIN;
        }
        ruddQty = (short) (ruddQty + (ruddIDec * 2));
        if (ruddQty >= Constant.BASEMAX) {
            ruddQty = Constant.BASEMAX;
        }
        if (ruddQty <= Constant.BASEMIN) {
            ruddQty = Constant.BASEMIN;
        }
        aileQty = (short) (aileQty + (aileIDec * 2));
        if (aileQty >= Constant.BASEMAX) {
            aileQty = Constant.BASEMAX;
        }
        if (aileQty <= Constant.BASEMIN) {
            aileQty = Constant.BASEMIN;
        }
        if (vibratorFlag) {
            vibrator.vibrate(100);
        }
    }

    public void locations() {
        float tempx = circlexl;
        float tempy = circleyl;
        circlexl = circlexr;
        circleyl = circleyr;
        circlexr = tempx;
        circleyr = tempy;
        boolean temp = balllCFlag;
        balllCFlag = ballrCFlag;
        ballrCFlag = temp;
        temp = balllDFlag;
        balllDFlag = ballrDFlag;
        ballrDFlag = temp;
        temp = balllUFlag;
        balllUFlag = ballrUFlag;
        ballrUFlag = temp;
        temp = leftflag;
        leftflag = rightflag;
        rightflag = temp;
    }

    public static void getValue() {
        if (sensorOn) {
            elevQty = GSensor.elevQty0;
            aileQty = GSensor.aileQty0;
        }
        CurveSurfaceView.helm_max = BarHelmbe;
        CurveSurfaceView.helm_min = BarHelmse;
        CurveSurfaceView.helm_adjustb = BarBEE;
        CurveSurfaceView.helm_adjusts = BarSEE;
        elev0 = curve.CountExp(elevQty);
        CurveSurfaceView.helm_max = BarHelmba;
        CurveSurfaceView.helm_min = BarHelmsa;
        CurveSurfaceView.helm_adjustb = BarBEA;
        CurveSurfaceView.helm_adjusts = BarSEA;
        aile0 = curve.CountExp(aileQty);
        CurveSurfaceView.helm_max = BarHelmbr;
        CurveSurfaceView.helm_min = BarHelmsr;
        CurveSurfaceView.helm_adjustb = BarBER;
        CurveSurfaceView.helm_adjusts = BarSER;
        rudd0 = curve.CountExp(ruddQty);
        thro0 = curve.GetThroCurveValue(throQty, throIDec * 2, CurveSurfaceView.ch_en, CurveSurfaceView.ch_out, CurveSurfaceView.expOn);
        screw0 = curve.GetThroCurveValue(throQty, PHOTO_SHOW, CurveSurfaceView.ch_ens, CurveSurfaceView.ch_outs, CurveSurfaceView.expSOn);
        if (throinv) {
            thro0 = 0 - thro0;
        }
        playbuffer[PHOTO_SHOW] = (short) thro0;
        if (ruddinv) {
            rudd0 = 0 - rudd0;
        }
        playbuffer[AV_SHOW] = (short) rudd0;
        if (elevinv) {
            elev0 = 0 - elev0;
        }
        playbuffer[2] = (short) elev0;
        if (aileinv) {
            aile0 = 0 - aile0;
        }
        playbuffer[3] = (short) aile0;
        playbuffer[4] = auxIDec;
        playbuffer[5] = (short) screw0;
        playbuffer[6] = (short) 0;
        playbuffer[7] = (short) 0;
        int nAll = PHOTO_SHOW;
        if (isOn) {
            cmdBuffer[PHOTO_SHOW] = (byte) 97;
        } else if (isOnFlag) {
            playbuffer[PHOTO_SHOW] = Constant.BASEMIN;
            cmdBuffer[PHOTO_SHOW] = (byte) 97;
            cno += AV_SHOW;
            if (cno == 8) {
                cno = PHOTO_SHOW;
                isOnFlag = false;
                isOn = false;
                encodeDisplay.CmdSendStop();
            }
        } else {
            cmdBuffer[PHOTO_SHOW] = (byte) 96;
        }
        int j = AV_SHOW;
        int i = PHOTO_SHOW;
        while (i < 8) {
            int temp;
            if (i == 0 || i == 5) {
                temp = ((playbuffer[i] + 1600) / 4) + 700;
            } else if (i == 2 || i == 3) {
                temp = ((playbuffer[i] * 5) / 16) + 1100;
            } else {
                temp = (playbuffer[i] / 4) + 1100;
            }
            cmdBuffer[j] = (byte) ((65280 & temp) >> 8);
            cmdBuffer[j + AV_SHOW] = (byte) (temp & 255);
            i += AV_SHOW;
            j += 2;
        }
        for (i = PHOTO_SHOW; i < 17; i += AV_SHOW) {
            nAll += cmdBuffer[i];
        }
        cmdBuffer[17] = (byte) nAll;
    }

    public static void updateValue() {
        if (elevIDec != elevIDecB) {
            elevQty = (short) ((elevQty - (elevIDecB * 2)) + (elevIDec * 2));
            elevIDecB = elevIDec;
            if (elevQty >= Constant.BASEMAX) {
                elevQty = Constant.BASEMAX;
            }
            if (elevQty <= Constant.BASEMIN) {
                elevQty = Constant.BASEMIN;
            }
            if (vibratorFlag) {
                vibrator.vibrate(100);
            }
        }
        if (aileIDec != aileIDecB) {
            aileQty = (short) ((aileQty - (aileIDecB * 2)) + (aileIDec * 2));
            aileIDecB = aileIDec;
            if (aileQty >= Constant.BASEMAX) {
                aileQty = Constant.BASEMAX;
            }
            if (aileQty <= Constant.BASEMIN) {
                aileQty = Constant.BASEMIN;
            }
            if (vibratorFlag) {
                vibrator.vibrate(100);
            }
        }
        if (ruddIDec != ruddIDecB) {
            ruddQty = (short) ((ruddQty - (ruddIDecB * 2)) + (ruddIDec * 2));
            ruddIDecB = ruddIDec;
            if (ruddQty >= Constant.BASEMAX) {
                ruddQty = Constant.BASEMAX;
            }
            if (ruddQty <= Constant.BASEMIN) {
                ruddQty = Constant.BASEMIN;
            }
            if (vibratorFlag) {
                vibrator.vibrate(100);
            }
        }
    }

    public void vibratorV() {
        if (buttonCFlag) {
            if (vibratorFlag) {
                vibrator.vibrate(100);
            }
            buttonCFlag = false;
        }
    }

    public void modeSelect() {
        if (mode == AV_SHOW) {
            mode1.setTextColor(Color.GREEN);
            mode2.setTextColor(Color.GRAY);
            mode3.setTextColor(Color.GRAY);
            mode4.setTextColor(Color.GRAY);
        } else if (mode == 2) {
            mode1.setTextColor(Color.GRAY);
            mode2.setTextColor(Color.GREEN);
            mode3.setTextColor(Color.GRAY);
            mode4.setTextColor(Color.GRAY);
        } else if (mode == 3) {
            mode1.setTextColor(Color.GRAY);
            mode2.setTextColor(Color.GRAY);
            mode3.setTextColor(Color.GREEN);
            mode4.setTextColor(Color.GRAY);
        } else if (mode == 4) {
            mode1.setTextColor(Color.GRAY);
            mode2.setTextColor(Color.GRAY);
            mode3.setTextColor(Color.GRAY);
            mode4.setTextColor(Color.GREEN);
        }
    }

    public void showConfigureWindow() {
        runFlag = false;
        views = Helicopter.layoutInflater.inflate(R.layout.setting, null);
        views.setBackgroundResource(R.drawable.background0);
        elev = (CheckBox) views.findViewById(R.id.aa);
        aile = (CheckBox) views.findViewById(R.id.bb);
        thro = (CheckBox) views.findViewById(R.id.cc);
        rudd = (CheckBox) views.findViewById(R.id.dd);
        vibrate = (CheckBox) views.findViewById(R.id.vibrator);
        elevd = (Button) views.findViewById(R.id.elevd);
        elevdi = (Button) views.findViewById(R.id.elevdi);
        elevi = (Button) views.findViewById(R.id.elevi);
        ailed = (Button) views.findViewById(R.id.ailed);
        ailedi = (Button) views.findViewById(R.id.ailedi);
        ailei = (Button) views.findViewById(R.id.ailei);
        throd = (Button) views.findViewById(R.id.throd);
        throdi = (Button) views.findViewById(R.id.throdi);
        throi = (Button) views.findViewById(R.id.throi);
        ruddd = (Button) views.findViewById(R.id.ruddd);
        rudddi = (Button) views.findViewById(R.id.rudddi);
        ruddi = (Button) views.findViewById(R.id.ruddi);
        gyrod = (Button) views.findViewById(R.id.gyrod);
        gyrodi = (Button) views.findViewById(R.id.gyrodi);
        gyroi = (Button) views.findViewById(R.id.gyroi);
        recover = (Button) views.findViewById(R.id.recover);
        mode1 = (Button) views.findViewById(R.id.mode1);
        mode2 = (Button) views.findViewById(R.id.mode2);
        mode3 = (Button) views.findViewById(R.id.mode3);
        mode4 = (Button) views.findViewById(R.id.mode4);
        this.modelSpinner = (Spinner) views.findViewById(R.id.modelSpinner);
        this.adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, model);
        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        this.modelSpinner.setAdapter(this.adapter);
        popupWindow = new PopupWindow(views, f11w, f7h);
        elev.setChecked(elevinv);
        aile.setChecked(aileinv);
        thro.setChecked(throinv);
        rudd.setChecked(ruddinv);
        if (vibratev) {
            if (vibratorF) {
                vibratorFlag = true;
            } else {
                vibratorFlag = false;
            }
            vibrate.setChecked(true);
        } else {
            vibratorFlag = false;
            vibrate.setChecked(false);
        }
        elevdi.setText("ELEV: " + elevIDec);
        ailedi.setText("AILE: " + aileIDec);
        throdi.setText("THRO: " + throIDec);
        rudddi.setText("RUDD: " + ruddIDec);
        gyrodi.setText("GYRO:" + Float.toString((((float) auxIDec) / 32.0f) + 50.0f) + "%");
        this.modelSpinner.setSelection(modelFlag);
        modeSelect();
        popNo = AV_SHOW;
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(views, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow.update();
        this.modelSpinner.setOnItemSelectedListener(new C00051());
        this.modelSpinner.setOnFocusChangeListener(new C00062());
        elev.setOnCheckedChangeListener(new C00073());
        aile.setOnCheckedChangeListener(new C00084());
        thro.setOnCheckedChangeListener(new C00095());
        rudd.setOnCheckedChangeListener(new C00106());
        vibrate.setOnCheckedChangeListener(new C00117());
        mode1.setOnClickListener(new C00128());
        mode2.setOnClickListener(new C00139());
        mode3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = false;
                    if (RunSurfaceView.mode == 4) {
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 2) {
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    }
                }
                RunSurfaceView.mode = 3;
                RunSurfaceView.this.modeSelect();
                RunSurfaceView.this.leftRFunc();
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = true;
                }
                RunSurfaceView.this.vibratorV();
            }
        });
        mode4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = false;
                    if (RunSurfaceView.mode == 4) {
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 2) {
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    }
                }
                RunSurfaceView.mode = 4;
                RunSurfaceView.this.modeSelect();
                RunSurfaceView.this.leftRFunc();
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = true;
                }
                RunSurfaceView.this.vibratorV();
            }
        });
        recover.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!RunSurfaceView.isOn) {
                    RunSurfaceView.buttonCFlag = true;
                    RunSurfaceView.elevinv = false;
                    RunSurfaceView.aileinv = false;
                    RunSurfaceView.throinv = false;
                    RunSurfaceView.ruddinv = false;
                    RunSurfaceView.vibratev = false;
                    RunSurfaceView.mode = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.leftOn = false;
                    RunSurfaceView.hiddenFlag = false;
                    RunSurfaceView.helmFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarHelmbe = 40;
                    RunSurfaceView.BarHelmse = 40;
                    RunSurfaceView.BarHelmba = 40;
                    RunSurfaceView.BarHelmsa = 40;
                    RunSurfaceView.BarHelmbr = 100;
                    RunSurfaceView.BarHelmsr = 100;
                    RunSurfaceView.BarBEE = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSEE = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarBEA = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSEA = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarBER = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSER = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.throFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.expFlag = false;
                    RunSurfaceView.pointLFlag = true;
                    RunSurfaceView.point1Flag = false;
                    RunSurfaceView.point2Flag = true;
                    RunSurfaceView.pointMFlag = true;
                    RunSurfaceView.point3Flag = false;
                    RunSurfaceView.point4Flag = false;
                    RunSurfaceView.pointHFlag = true;
                    RunSurfaceView.pointLL = 0.0f;
                    RunSurfaceView.point11 = 30.0f;
                    RunSurfaceView.point22 = 28.0f;
                    RunSurfaceView.pointMM = 45.0f;
                    RunSurfaceView.point33 = 66.5f;
                    RunSurfaceView.point44 = 83.5f;
                    RunSurfaceView.pointHH = 75.0f;
                    RunSurfaceView.adjustratio = 0.0f;
                    RunSurfaceView.screwFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.expSFlag = false;
                    RunSurfaceView.pointLSFlag = true;
                    RunSurfaceView.point1SFlag = false;
                    RunSurfaceView.point2SFlag = false;
                    RunSurfaceView.pointMSFlag = true;
                    RunSurfaceView.point3SFlag = false;
                    RunSurfaceView.point4SFlag = false;
                    RunSurfaceView.pointHSFlag = true;
                    RunSurfaceView.pointLLS = -100.0f;
                    RunSurfaceView.point11S = -67.0f;
                    RunSurfaceView.point22S = -33.0f;
                    RunSurfaceView.pointMMS = 0.0f;
                    RunSurfaceView.point33S = 33.0f;
                    RunSurfaceView.point44S = 67.0f;
                    RunSurfaceView.pointHHS = 100.0f;
                    RunSurfaceView.elevIDecB = (short) 0;
                    RunSurfaceView.aileIDecB = (short) 0;
                    RunSurfaceView.throIDecB = (short) 0;
                    RunSurfaceView.ruddIDecB = (short) 0;
                    RunSurfaceView.elevIDec = (short) 0;
                    RunSurfaceView.aileIDec = (short) 0;
                    RunSurfaceView.throIDec = (short) 0;
                    RunSurfaceView.ruddIDec = (short) 0;
                    RunSurfaceView.auxQty = (short) 0;
                    RunSurfaceView.auxIDec = (short) 0;
                    if (RunSurfaceView.vibratev) {
                        if (RunSurfaceView.vibratorF) {
                            RunSurfaceView.vibratorFlag = true;
                        } else {
                            RunSurfaceView.vibratorFlag = false;
                        }
                        RunSurfaceView.vibrate.setChecked(true);
                    } else {
                        RunSurfaceView.vibratorFlag = false;
                        RunSurfaceView.vibrate.setChecked(false);
                    }
                    RunSurfaceView.elev.setChecked(false);
                    RunSurfaceView.aile.setChecked(false);
                    RunSurfaceView.thro.setChecked(false);
                    RunSurfaceView.rudd.setChecked(false);
                    RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                    RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                    RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                    RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                    RunSurfaceView.gyrodi.setText("GYRO:" + Float.toString((((float) RunSurfaceView.auxIDec) / 32.0f) + 50.0f) + "%");
                    RunSurfaceView.mode = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.this.modeSelect();
                    RunSurfaceView.this.leftRFunc();
                    RunSurfaceView.this.initState();
                    RunSurfaceView.updateValue();
                    RunSurfaceView.getValue();
                    RunSurfaceView.this.vibratorV();
                    RunSurfaceView.this.showToast("RESET");
                }
            }
        });
        elevd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.elevIDec = (short) (RunSurfaceView.elevIDec - 4);
                if (RunSurfaceView.elevIDec <= (short) -200) {
                    RunSurfaceView.elevIDec = (short) -200;
                }
                RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        elevi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.elevIDec = (short) (RunSurfaceView.elevIDec + 4);
                if (RunSurfaceView.elevIDec >= Constant.MACROBASE) {
                    RunSurfaceView.elevIDec = Constant.MACROBASE;
                }
                RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        ailed.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.aileIDec = (short) (RunSurfaceView.aileIDec - 4);
                if (RunSurfaceView.aileIDec <= (short) -200) {
                    RunSurfaceView.aileIDec = (short) -200;
                }
                RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        ailei.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.aileIDec = (short) (RunSurfaceView.aileIDec + 4);
                if (RunSurfaceView.aileIDec >= Constant.MACROBASE) {
                    RunSurfaceView.aileIDec = Constant.MACROBASE;
                }
                RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        throd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.throIDec = (short) (RunSurfaceView.throIDec - 4);
                if (RunSurfaceView.throIDec <= (short) -200) {
                    RunSurfaceView.throIDec = (short) -200;
                }
                RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        throi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.throIDec = (short) (RunSurfaceView.throIDec + 4);
                if (RunSurfaceView.throIDec >= Constant.MACROBASE) {
                    RunSurfaceView.throIDec = Constant.MACROBASE;
                }
                RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        ruddd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.ruddIDec = (short) (RunSurfaceView.ruddIDec - 4);
                if (RunSurfaceView.ruddIDec <= (short) -200) {
                    RunSurfaceView.ruddIDec = (short) -200;
                }
                RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        ruddi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.ruddIDec = (short) (RunSurfaceView.ruddIDec + 4);
                if (RunSurfaceView.ruddIDec >= Constant.MACROBASE) {
                    RunSurfaceView.ruddIDec = Constant.MACROBASE;
                }
                RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                RunSurfaceView.updateValue();
                RunSurfaceView.this.vibratorV();
            }
        });
        gyrod.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.auxIDec = (short) (RunSurfaceView.auxIDec - 16);
                if (RunSurfaceView.auxIDec <= Constant.BASEMIN) {
                    RunSurfaceView.auxIDec = Constant.BASEMIN;
                }
                RunSurfaceView.gyrodi.setText("GYRO:" + Float.toString((((float) RunSurfaceView.auxIDec) / 32.0f) + 50.0f) + "%");
                RunSurfaceView.this.vibratorV();
            }
        });
        gyroi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.buttonCFlag = true;
                RunSurfaceView.auxIDec = (short) (RunSurfaceView.auxIDec + 16);
                if (RunSurfaceView.auxIDec >= Constant.BASEMAX) {
                    RunSurfaceView.auxIDec = Constant.BASEMAX;
                }
                RunSurfaceView.gyrodi.setText("GYRO:" + Float.toString((((float) RunSurfaceView.auxIDec) / 32.0f) + 50.0f) + "%");
                RunSurfaceView.this.vibratorV();
            }
        });
        popupWindow.setOnDismissListener(new OnDismissListen());
    }

    public float getRad0(float px1, float py1, float px2, float py2) {
        float x = px2 - px1;
        float rad = (float) Math.acos((double) (x / ((float) Math.sqrt(Math.pow((double) x, 2.0d) + Math.pow((double) (py1 - py2), 2.0d)))));
        if (py2 < py1) {
            return -rad;
        }
        return rad;
    }

    public float getRad(float px1, float py1, float px2, float py2) {
        float x = px2 - px1;
        float rad = (float) Math.acos((double) (x / ((float) Math.sqrt(Math.pow((double) x, 2.0d) + Math.pow((double) (py1 - py2), 2.0d)))));
        if (py2 > py1) {
            return -rad;
        }
        return rad;
    }

    public void getXY(float centerx, float centery, float R, double rad) {
        circlex = ((float) (((double) R) * Math.cos(rad))) + centerx;
        circley = ((float) (((double) R) * Math.sin(rad))) + centery;
    }

    public void getXYL(float centerx, float centery, float R, double rad) {
        int r0 = 0;
        int hh = 0;
        float xl = centerx;
        float yl = centery;
        if (hiddenFlag) {
            r0 = (f9r - r1) - makex;
            hh = (hh - r1) - makey;
        } else {
            r0 = r0 - make;
            hh = r0;
        }
        if (rad >= -0.7853981852531433d && rad <= 0.7853981852531433d) {
            circlexl = ((float) r0) + xl;
            if (lefty < yl - ((float) hh)) {
                circleyl = yl - ((float) hh);
            }
            if (lefty > ((float) hh) + yl) {
                circleyl = ((float) hh) + yl;
            }
            if (lefty >= yl - ((float) hh) && lefty <= ((float) hh) + yl) {
                circleyl = lefty;
            }
        }
        if ((rad >= 2.356194496154785d && rad <= 3.1415927410125732d) || (rad > -3.1415927410125732d && rad <= -2.356194496154785d)) {
            circlexl = xl - ((float) r0);
            if (lefty < yl - ((float) hh)) {
                circleyl = yl - ((float) hh);
            }
            if (lefty > ((float) hh) + yl) {
                circleyl = ((float) hh) + yl;
            }
            if (lefty >= yl - ((float) hh) && lefty <= ((float) hh) + yl) {
                circleyl = lefty;
            }
        }
        if (rad > 0.7853981852531433d && rad < 2.356194496154785d) {
            if (leftx < xl - ((float) r0)) {
                circlexl = xl - ((float) r0);
            }
            if (leftx > ((float) r0) + xl) {
                circlexl = ((float) r0) + xl;
            }
            if (leftx >= xl - ((float) r0) && leftx <= ((float) r0) + xl) {
                circlexl = leftx;
            }
            circleyl = yl - ((float) hh);
        }
        if (rad > -2.356194496154785d && rad < -0.7853981852531433d) {
            if (leftx < xl - ((float) r0)) {
                circlexl = xl - ((float) r0);
            }
            if (leftx > ((float) r0) + xl) {
                circlexl = ((float) r0) + xl;
            }
            if (leftx >= xl - ((float) r0) && leftx <= ((float) r0) + xl) {
                circlexl = leftx;
            }
            circleyl = ((float) hh) + yl;
        }
    }

    public void getXYR(float centerx, float centery, float R, double rad) {
        int r0 = 0;
        int hh = 0;
        float xr = centerx;
        float yr = centery;
        if (hiddenFlag) {
            r0 = (f9r - r1) - makex;
            hh = (hh - r1) - makey;
        } else {
            r0 = r0 - make;
            hh = r0;
        }
        if (rad >= -0.7853981852531433d && rad <= 0.7853981852531433d) {
            circlexr = ((float) r0) + xr;
            if (righty < yr - ((float) hh)) {
                circleyr = yr - ((float) hh);
            }
            if (righty > ((float) hh) + yr) {
                circleyr = ((float) hh) + yr;
            }
            if (righty >= yr - ((float) hh) && righty <= ((float) hh) + yr) {
                circleyr = righty;
            }
        }
        if ((rad >= 2.356194496154785d && rad <= 3.1415927410125732d) || (rad > -3.1415927410125732d && rad <= -2.356194496154785d)) {
            circlexr = xr - ((float) r0);
            if (righty < yr - ((float) hh)) {
                circleyr = yr - ((float) hh);
            }
            if (righty > ((float) hh) + yr) {
                circleyr = ((float) hh) + yr;
            }
            if (righty >= yr - ((float) hh) && righty <= ((float) hh) + yr) {
                circleyr = righty;
            }
        }
        if (rad > 0.7853981852531433d && rad < 2.356194496154785d) {
            if (rightx < xr - ((float) r0)) {
                circlexr = xr - ((float) r0);
            }
            if (rightx > ((float) r0) + xr) {
                circlexr = ((float) r0) + xr;
            }
            if (rightx >= xr - ((float) r0) && rightx <= ((float) r0) + xr) {
                circlexr = rightx;
            }
            circleyr = yr - ((float) hh);
        }
        if (rad > -2.356194496154785d && rad < -0.7853981852531433d) {
            if (rightx < xr - ((float) r0)) {
                circlexr = xr - ((float) r0);
            }
            if (rightx > ((float) r0) + xr) {
                circlexr = ((float) r0) + xr;
            }
            if (rightx >= xr - ((float) r0) && rightx <= ((float) r0) + xr) {
                circlexr = rightx;
            }
            circleyr = ((float) hh) + yr;
        }
    }

    public void progress(Canvas canvas) {
        Bitmap bitbmp = null;
        canvas.drawTextOnPath("Progress :", path11, 0.0f, 0.0f, f8p);
        canvas.drawTextOnPath("Thro:", path33, 0.0f, 0.0f, f8p);
        canvas.drawTextOnPath("Rudd:", path55, 0.0f, 0.0f, f8p);
        canvas.drawTextOnPath("Elev:", path77, 0.0f, 0.0f, f8p);
        canvas.drawTextOnPath("Aile:", path99, 0.0f, 0.0f, f8p);
        canvas.drawTextOnPath(new StringBuilder(String.valueOf(Integer.toString((thro0 + 1600) / 32))).append("%").toString(), path22, 0.0f, 0.0f, paint);
        canvas.drawBitmap(barbmp, (float) (xright - barw0), (float) (ytop + basecoor00), paint);
        if (thro0 > -1600) {
            percentage = (barw0 * (thro0 + 1600)) / 3200;
            if (percentage > 0) {
                if (percentage > barw0) {
                    percentage = barw0;
                }
                bitbmp = Bitmap.createBitmap(throbarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh0);
                canvas.drawBitmap(bitbmp, (float) (xright - barw0), (float) (ytop + basecoor00), paint);
            }
        }
        if (bitbmp != null) {
            bitbmp.recycle();
            bitbmp = null;
        }
        canvas.drawTextOnPath(new StringBuilder(String.valueOf(Integer.toString(Math.abs(rudd0) / 32))).append("%").toString(), path44, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bar0bmp, (float) (xright - barw0), (float) (ytop + basecoor01), paint);
        if (rudd0 > 0) {
            percentage = (int) (barw * ((float) rudd0));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(ruddbarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) (xright - (barw0 / 2)), (float) (ytop + basecoor01), paint);
            }
        }
        if (rudd0 < 0) {
            percentage = (int) (barw * ((float) (0 - rudd0)));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(ruddbarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) ((xright - (barw0 / 2)) - percentage), (float) (ytop + basecoor01), paint);
            }
        }
        if (bitbmp != null) {
            bitbmp.recycle();
            bitbmp = null;
        }
        canvas.drawTextOnPath(new StringBuilder(String.valueOf(Integer.toString(Math.abs(elev0) / 32))).append("%").toString(), path66, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bar0bmp, (float) (xright - barw0), (float) (ytop + basecoor02), paint);
        if (elev0 > 0) {
            percentage = (int) (barw * ((float) elev0));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(elevbarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) (xright - (barw0 / 2)), (float) (ytop + basecoor02), paint);
            }
        }
        if (elev0 < 0) {
            percentage = (int) (barw * ((float) (0 - elev0)));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(elevbarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) ((xright - (barw0 / 2)) - percentage), (float) (ytop + basecoor02), paint);
            }
        }
        if (bitbmp != null) {
            bitbmp.recycle();
            bitbmp = null;
        }
        canvas.drawTextOnPath(new StringBuilder(String.valueOf(Integer.toString(Math.abs(aile0) / 32))).append("%").toString(), path88, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bar0bmp, (float) (xright - barw0), (float) (ytop + basecoor03), paint);
        if (aile0 > 0) {
            percentage = (int) (barw * ((float) aile0));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(ailebarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) (xright - (barw0 / 2)), (float) (ytop + basecoor03), paint);
            }
        }
        if (aile0 < 0) {
            percentage = (int) (barw * ((float) (0 - aile0)));
            if (percentage > 0) {
                bitbmp = Bitmap.createBitmap(ailebarbmp, PHOTO_SHOW, PHOTO_SHOW, percentage, barh);
                canvas.drawBitmap(bitbmp, (float) ((xright - (barw0 / 2)) - percentage), (float) (ytop + basecoor03), paint);
            }
        }
        if (bitbmp != null) {
            bitbmp.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!hiddenFlag) {
            canvas.drawColor(-16777216);
            if (EncodeDisplay.updateFlag) {
                if (EncodeDisplay.fflag) {
                    mbmp = encodeDisplay.BitmapFit(encodeDisplay.bmp2);
                } else {
                    mbmp = encodeDisplay.BitmapFit(encodeDisplay.bmp1);
                }
                canvas.drawBitmap(mbmp, (float) ((screenWidth - f11w) / 2), (float) ((screenHeight - f7h) / 2), paint);
            } else {
                canvas.drawBitmap(mbitmap, (float) ((screenWidth - f11w) / 2), (float) ((screenHeight - f7h) / 2), paint);
            }
            if (wifiFlag) {
                canvas.drawBitmap(camera0bmp, (float) xleft, (float) ytop, paint);
                strings = encodeDisplay.getT();
                if (EncodeDisplay.hr == 0) {
                    canvas.drawText(strings, tw, th, p0);
                } else {
                    canvas.drawText(strings, tw0, th, p0);
                }
            } else {
                EncodeDisplay.timeFlag = true;
                canvas.drawBitmap(camerabmp, (float) xleft, (float) ytop, paint);
            }
            if (this.PhotosFlag) {
                canvas.drawBitmap(photobmp, fix0, (float) ytop, paint);
            } else {
                canvas.drawBitmap(photo0bmp, fix0, (float) ytop, paint);
            }
            canvas.drawBitmap(pvshowbmp, fix1, (float) ytop, paint);
            if (sensorOn) {
                canvas.drawBitmap(gravityonbmp, fix2, (float) ytop, paint);
            } else {
                canvas.drawBitmap(gravityoffbmp, fix2, (float) ytop, paint);
            }
            if (isOn) {
                canvas.drawBitmap(onbmp, fix3, (float) ytop, paint);
            } else {
                canvas.drawBitmap(offbmp, fix3, (float) ytop, paint);
            }
            canvas.drawBitmap(crossbmp, fix4, (float) ytop, paint);
            if (wifiConFlag) {
                canvas.drawBitmap(wificonbmp, fix5, (float) ytop, paint);
            } else {
                canvas.drawBitmap(wificonoffbmp, fix5, (float) ytop, paint);
            }
            canvas.drawBitmap(setbmp, fix6, fixb, paint);
            canvas.drawBitmap(throexpbmp, fix7, fixb, paint);
            canvas.drawBitmap(helmexpbmp, fix8, fixb, paint);
            canvas.drawBitmap(screwbmp, fixx, fixb, paint);
            canvas.drawBitmap(manual, (float) xleft, fixb, paint);
        } else if (EncodeDisplay.updateFlag) {
            if (EncodeDisplay.fflag) {
                mbmp = Helicopter.BitmapFit(encodeDisplay.bmp2);
            } else {
                mbmp = Helicopter.BitmapFit(encodeDisplay.bmp1);
            }
            canvas.drawBitmap(mbmp, 0.0f, 0.0f, paint);
        } else {
            canvas.drawBitmap(mbitmap, 0.0f, 0.0f, paint);
        }
        if (!hiddenFlag) {
            ballbackl.draw(canvas);
            ballbackr.draw(canvas);
            ControlRunning(canvas);
        } else if (!hiddenFullFlag) {
            ballbackl0.draw(canvas);
            ballbackr0.draw(canvas);
            ControlRunning(canvas);
        }
        if (this.PagesFlag) {
            calcPoints();
            drawCurrentPageArea(canvas, mCurPageBitmap, this.mPath0);
            drawCurrentPageShadow(canvas);
            drawCurrentBackArea(canvas, mCurPageBitmap);
            if (this.dragFlag) {
                this.dragFlag = false;
                if (!doTouchEvent0()) {
                    this.PagesFlag = false;
                    this.PhotosFlag = true;
                }
            }
        }
    }

    public void ControlRunning(Canvas canvas) {
        int xx;
        int yy;
        float f;
        float f2;
        float f3;
        if (balllDFlag) {
            balllUFlag = false;
            leftN(canvas);
            if (leftflag) {
                xx = xl;
                yy = (int) circleyl;
                balllCFlag = false;
                balll.setBounds(new Rect(xx - r1, yy - r1, r1 + xx, r1 + yy));
                balll.draw(canvas);
            } else {
                if (balllCFlag) {
                    if (hiddenFlag) {
                        f = (float) xl;
                        f2 = (float) yl;
                        f3 = (float) (f9r - 2);
                        getXYL(f, f2, f3, (double) getRad((float) xl, (float) yl, leftx, lefty));
                    } else {
                        f = (float) xl;
                        f2 = (float) yl;
                        f3 = (float) r0;
                        getXY(f, f2, f3, (double) getRad0((float) xl, (float) yl, leftx, lefty));
                        circlexl = circlex;
                        circleyl = circley;
                    }
                    xx = (int) circlexl;
                    yy = (int) circleyl;
                } else {
                    xx = (int) leftx;
                    yy = (int) lefty;
                }
                circlexl = (float) xx;
                circleyl = (float) yy;
                balll.setBounds(new Rect(xx - r1, yy - r1, r1 + xx, r1 + yy));
                balll.draw(canvas);
            }
        }
        if (ballrDFlag) {
            ballrUFlag = false;
            rightN(canvas);
            if (rightflag) {
                xx = xr;
                yy = (int) circleyr;
                ballrCFlag = false;
                ballr.setBounds(new Rect(xx - r1, yy - r1, r1 + xx, r1 + yy));
                ballr.draw(canvas);
            } else {
                if (ballrCFlag) {
                    if (hiddenFlag) {
                        f = (float) xr;
                        f2 = (float) yr;
                        f3 = (float) (f9r - 2);
                        getXYR(f, f2, f3, (double) getRad((float) xr, (float) yr, rightx, righty));
                    } else {
                        f = (float) xr;
                        f2 = (float) yr;
                        f3 = (float) r0;
                        getXY(f, f2, f3, (double) getRad0((float) xr, (float) yr, rightx, righty));
                        circlexr = circlex;
                        circleyr = circley;
                    }
                    xx = (int) circlexr;
                    yy = (int) circleyr;
                } else {
                    xx = (int) rightx;
                    yy = (int) righty;
                }
                circlexr = (float) xx;
                circleyr = (float) yy;
                ballr.setBounds(new Rect(xx - r1, yy - r1, r1 + xx, r1 + yy));
                ballr.draw(canvas);
            }
        }
        if (balllUFlag) {
            balllDFlag = false;
            balllCFlag = false;
            leftN(canvas);
            if (leftOn) {
                balll.setBounds(ballLRect0);
                balll.draw(canvas);
            } else {
                balll.setBounds(ballLRect);
                balll.draw(canvas);
            }
        }
        if (ballrUFlag) {
            ballrDFlag = false;
            ballrCFlag = false;
            rightN(canvas);
            if (leftOn) {
                ballr.setBounds(ballRRect);
                ballr.draw(canvas);
                return;
            }
            ballr.setBounds(ballRRect0);
            ballr.draw(canvas);
        }
    }

    public void leftN(Canvas canvas) {
        if (leftUL) {
            int r0;
            leftUL = false;
            if (hiddenFlag) {
                r0 = hh;
            } else {
                r0 = f9r;
            }
            leftU.reset();
            leftU.moveTo((float) xl, (float) (yl - r0));
            leftU.lineTo((float) xl, (float) yl);
            leftL.reset();
            leftL.moveTo((float) (xl - f9r), (float) yl);
            leftL.lineTo((float) xl, (float) yl);
        }
        if (leftOn) {
            if (mode == 3) {
                canvas.drawTextOnPath("THRO", leftU, 0.0f, 0.0f, f8p);
                canvas.drawTextOnPath("AILE", leftL, 0.0f, 0.0f, f8p);
            } else if (mode == 4) {
                canvas.drawTextOnPath("THRO", leftU, 0.0f, 0.0f, f8p);
                canvas.drawTextOnPath("RUDD", leftL, 0.0f, 0.0f, f8p);
            }
        } else if (mode == AV_SHOW) {
            canvas.drawTextOnPath("ELEV", leftU, 0.0f, 0.0f, f8p);
            canvas.drawTextOnPath("RUDD", leftL, 0.0f, 0.0f, f8p);
        } else if (mode == 2) {
            canvas.drawTextOnPath("ELEV", leftU, 0.0f, 0.0f, f8p);
            canvas.drawTextOnPath("AILE", leftL, 0.0f, 0.0f, f8p);
        }
    }

    public void rightN(Canvas canvas) {
        if (rightUR) {
            int r0;
            rightUR = false;
            if (hiddenFlag) {
                r0 = hh;
            } else {
                r0 = f9r;
            }
            rightU.reset();
            rightU.moveTo((float) xr, (float) (yr - r0));
            rightU.lineTo((float) xr, (float) yr);
            rightR.reset();
            rightR.moveTo((float) (xr - f9r), (float) yr);
            rightR.lineTo((float) xr, (float) yr);
        }
        if (leftOn) {
            if (mode == 3) {
                canvas.drawTextOnPath("ELEV", rightU, 0.0f, 0.0f, f8p);
                canvas.drawTextOnPath("RUDD", rightR, 0.0f, 0.0f, f8p);
            } else if (mode == 4) {
                canvas.drawTextOnPath("ELEV", rightU, 0.0f, 0.0f, f8p);
                canvas.drawTextOnPath("AILE", rightR, 0.0f, 0.0f, f8p);
            }
        } else if (mode == AV_SHOW) {
            canvas.drawTextOnPath("THRO", rightU, 0.0f, 0.0f, f8p);
            canvas.drawTextOnPath("AILE", rightR, 0.0f, 0.0f, f8p);
        } else if (mode == 2) {
            canvas.drawTextOnPath("THRO", rightU, 0.0f, 0.0f, f8p);
            canvas.drawTextOnPath("RUDD", rightR, 0.0f, 0.0f, f8p);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode == 4) {
            if (popNo == AV_SHOW) {
                if (popupWindow.isShowing()) {
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.dismiss();
                    popNo = PHOTO_SHOW;
                    return true;
                }
            } else if (popNo == 2) {
                if (popupWindow0.isShowing()) {
                    popupWindow0.setOutsideTouchable(true);
                    popupWindow0.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow0.dismiss();
                    popNo = PHOTO_SHOW;
                    return true;
                }
            } else if (popNo == 3) {
                if (popupWindow1.isShowing()) {
                    popupWindow1.setOutsideTouchable(true);
                    popupWindow1.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow1.dismiss();
                    popNo = PHOTO_SHOW;
                    return true;
                }
            } else if (popNo == 4) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.setOutsideTouchable(true);
                    popupWindow2.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow2.dismiss();
                    popNo = PHOTO_SHOW;
                    return true;
                }
            } else if (hiddenFlag) {
                hiddenFlag = false;
                hiddenFunc();
                return true;
            } else if (System.currentTimeMillis() - this.exitTime > 2500) {
                this.exitTime = System.currentTimeMillis();
                return true;
            } else {
                toast = null;
                cno = PHOTO_SHOW;
                isOn = false;
                isOnFlag = true;
                if (sensorOn) {
                    sensorOn = false;
                    gsensor.onOff = false;
                    elevQty = (short) 0;
                    aileQty = (short) 0;
                }
                if (wifiFlag) {
                    wifiFlag = false;
                    encodeDisplay.EncodeEnd();
                }
                runFlag = false;
                Helicopter.setView(6);
                return true;
            }
        }
        return super.onKeyDown(keyCode, e);
    }

    void onOffFunc() {
        isOn = !isOn;
        if (isOn) {
            initState();
            if (EncodeDisplay.updateFlag0) {
                encodeDisplay.CmdSendStart();
                return;
            }
            return;
        }
        holder.setKeepScreenOn(false);
        isOnFlag = true;
        initState();
    }

    void leftRFunc() {
        buttonCFlag = true;
        boolean flags = leftOn;
        if (mode == AV_SHOW || mode == 2) {
            leftOn = false;
        } else {
            leftOn = true;
        }
        if (flags != leftOn) {
            locations();
        }
    }

    void gravityFunc() {
        sensorOn = !sensorOn;
        if (sensorOn) {
            gsensor.sensorFlag = true;
            gsensor.onOff = true;
            return;
        }
        gsensor.onOff = false;
        elevQty = (short) 0;
        aileQty = (short) 0;
        if (mode == 4) {
            ballrDFlag = false;
            ballrUFlag = true;
        } else if (mode == 2) {
            balllDFlag = false;
            balllUFlag = true;
        }
    }

    void manualFunc() {
        runFlag = false;
        encodeDisplay.EncodeAftEnd();
        isOn = false;
        encodeDisplay.CmdSendStop();
        if (sensorOn) {
            sensorOn = false;
            gsensor.onOff = false;
            elevQty = (short) 0;
            aileQty = (short) 0;
        }
        if (wifiFlag) {
            wifiFlag = false;
            encodeDisplay.EncodeEnd();
        }
        ManualSurfaceView.cool = true;
        Helicopter.setView(2);
    }

    void hiddenFunc() {
        if (hiddenFlag) {
            mbitmap = Helicopter.BitmapFit(mbitmap);
        } else {
            mbitmap = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.background);
            mbitmap = Helicopter.ToFit(mbitmap, ThemeSurfaceView.scales0);
        }
        leftUL = true;
        rightUR = true;
        gsensor.sensorFlag = true;
        int yll;
        int yrr;
        if (hiddenFlag) {
            f9r = (screenWidth - (w0 * 2)) / 4;
            ww0 = f9r - makex;
            hh0 = hh - makey;
            wr = (f9r - r1) - makex;
            hr = (hh - r1) - makey;
            xl = f9r;
            yl = hh;
            xr = screenWidth - f9r;
            yr = hh;
            yll = (yl + f10t) - makey;
            yrr = (yr + f10t) - makey;
            ballLRect0.setEmpty();
            ballRRect0.setEmpty();
            ballLRect0.set(xl - r1, yll - (r1 * 2), xl + r1, hh + yll);
            ballRRect0.set(xr - r1, yrr - (r1 * 2), xr + r1, hh + yrr);
            if (leftOn) {
                circleyl = (float) (yl - (((f10t - makey) * throQty) / 1600));
                balllDFlag = true;
                balllUFlag = false;
                leftflag = true;
                balllCFlag = false;
            } else {
                circleyr = (float) (yr - (((f10t - makey) * throQty) / 1600));
                ballrDFlag = true;
                ballrUFlag = false;
                rightflag = true;
                ballrCFlag = false;
            }
        } else {
            f9r = r0 + r1;
            ww0 = f9r - make;
            hh0 = f9r - make;
            wr = r0 - make;
            hr = r0 - make;
            xl = xhalf - (f11w / 4);
            yl = yhalf;
            xr = xhalf + (f11w / 4);
            yr = yhalf;
            yll = (yl + f9r) - make;
            yrr = (yr + f9r) - make;
            ballLRect0.setEmpty();
            ballRRect0.setEmpty();
            ballLRect0.set(xl - r1, yll - (r1 * 2), xl + r1, yll);
            ballRRect0.set(xr - r1, yrr - (r1 * 2), xr + r1, yrr);
            if (leftOn) {
                if (cool) {
                    cool = false;
                    throQty = (short) (0 - throQty);
                    circleyl = (float) (yl - (((r0 - make) * throQty) / 1600));
                } else {
                    circleyl = (float) (yl - (((r0 - make) * throQty) / 1600));
                }
                balllDFlag = true;
                balllUFlag = false;
                leftflag = true;
                balllCFlag = false;
            } else {
                if (cool) {
                    cool = false;
                    throQty = (short) (0 - throQty);
                    circleyr = (float) (yr - (((r0 - make) * throQty) / 1600));
                } else {
                    circleyr = (float) (yr - (((r0 - make) * throQty) / 1600));
                }
                ballrDFlag = true;
                ballrUFlag = false;
                rightflag = true;
                ballrCFlag = false;
            }
        }
        ballLRect.setEmpty();
        ballLRect.set(xl - r1, yl - r1, xl + r1, yl + r1);
        ballRRect.setEmpty();
        ballRRect.set(xr - r1, yr - r1, xr + r1, yr + r1);
    }

    public boolean onTouch(View v, MotionEvent event) {
        return mGesture.onTouchEvent(event);
    }

    public void showHelmWindow() {
        runFlag = false;
        viewh = Helicopter.layoutInflater.inflate(R.layout.helm, null);
        elevcurve = (CurveSurfaceView) viewh.findViewById(R.id.myCurveSurfaceView);
        this.helmdec = (Button) viewh.findViewById(R.id.helmdec);
        this.helminc = (Button) viewh.findViewById(R.id.helminc);
        this.hbigdi = (Button) viewh.findViewById(R.id.hbigdi);
        this.hsmalldi = (Button) viewh.findViewById(R.id.hsmalldi);
        this.expdec = (Button) viewh.findViewById(R.id.expdec);
        this.expinc = (Button) viewh.findViewById(R.id.expinc);
        this.ebigdi = (Button) viewh.findViewById(R.id.ebigdi);
        this.esmalldi = (Button) viewh.findViewById(R.id.esmalldi);
        this.helmSpinner = (Spinner) viewh.findViewById(R.id.helmSpinner);
        this.adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, helm);
        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        this.helmSpinner.setAdapter(this.adapter);
        if (helmFlag == 0) {
            this.hbigdi.setText(BarHelmbe + "%");
            this.hsmalldi.setText(BarHelmse + "%");
            if (BarBEE == 0 || BarSEE == 0) {
                if (BarBEE == 0) {
                    this.ebigdi.setText("beeline");
                } else {
                    this.ebigdi.setText(BarBEE + "%");
                }
                if (BarSEE == 0) {
                    this.esmalldi.setText("beeline");
                } else {
                    this.esmalldi.setText(BarSEE + "%");
                }
            } else {
                this.ebigdi.setText(BarBEE + "%");
                this.esmalldi.setText(BarSEE + "%");
            }
        } else if (helmFlag == AV_SHOW) {
            this.hbigdi.setText(BarHelmba + "%");
            this.hsmalldi.setText(BarHelmsa + "%");
            if (BarBEA == 0 || BarSEA == 0) {
                if (BarBEA == 0) {
                    this.ebigdi.setText("beeline");
                } else {
                    this.ebigdi.setText(BarBEA + "%");
                }
                if (BarSEA == 0) {
                    this.esmalldi.setText("beeline");
                } else {
                    this.esmalldi.setText(BarSEA + "%");
                }
            } else {
                this.ebigdi.setText(BarBEA + "%");
                this.esmalldi.setText(BarSEA + "%");
            }
        } else if (helmFlag == 2) {
            this.hbigdi.setText(BarHelmbr + "%");
            this.hsmalldi.setText(BarHelmsr + "%");
            if (BarBER == 0 || BarSER == 0) {
                if (BarBER == 0) {
                    this.ebigdi.setText("beeline");
                } else {
                    this.ebigdi.setText(BarBER + "%");
                }
                if (BarSER == 0) {
                    this.esmalldi.setText("beeline");
                } else {
                    this.esmalldi.setText(BarSER + "%");
                }
            } else {
                this.ebigdi.setText(BarBER + "%");
                this.esmalldi.setText(BarSER + "%");
            }
        }
        this.helmSpinner.setSelection(helmFlag);
        popupWindow0 = new PopupWindow(viewh, f11w, f7h);
        popNo = 2;
        popupWindow0.setAnimationStyle(R.style.PopupAnimation);
        popupWindow0.showAtLocation(viewh, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow0.update();
        SystemClock.sleep(100);
        elevcurve.invalidate();
        this.helmSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (RunSurfaceView.this.helmSpinner.getSelectedItem().toString() == "ELEV") {
                    RunSurfaceView.helmFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmbe + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmse + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBEE + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSEE + "%");
                } else if (RunSurfaceView.this.helmSpinner.getSelectedItem().toString() == "AILE") {
                    RunSurfaceView.helmFlag = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmba + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmsa + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBEA + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSEA + "%");
                } else if (RunSurfaceView.this.helmSpinner.getSelectedItem().toString() == "RUDD") {
                    RunSurfaceView.helmFlag = 2;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmbr + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmsr + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBER + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSER + "%");
                }
                RunSurfaceView.elevcurve.invalidate();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.helmSpinner.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });
        this.helmdec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.decbHFunc();
                RunSurfaceView.this.decsHFunc();
            }
        });
        this.helminc.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.incbHFunc();
                RunSurfaceView.this.incsHFunc();
            }
        });
        this.expdec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.decbEFunc();
                RunSurfaceView.this.decsEFunc();
            }
        });
        this.expinc.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.incbEFunc();
                RunSurfaceView.this.incsEFunc();
            }
        });
        popupWindow0.setOnDismissListener(new OnDismissListen());
    }

    public void decbHFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarHelmbe--;
            if (BarHelmbe < 0) {
                BarHelmbe = PHOTO_SHOW;
            }
            temp = BarHelmbe;
        } else if (helmFlag == AV_SHOW) {
            BarHelmba--;
            if (BarHelmba < 0) {
                BarHelmba = PHOTO_SHOW;
            }
            temp = BarHelmba;
        } else if (helmFlag == 2) {
            BarHelmbr--;
            if (BarHelmbr < 0) {
                BarHelmbr = PHOTO_SHOW;
            }
            temp = BarHelmbr;
        }
        this.hbigdi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void decbEFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarBEE--;
            if (BarBEE < -100) {
                BarBEE = -100;
            }
            temp = BarBEE;
        } else if (helmFlag == AV_SHOW) {
            BarBEA--;
            if (BarBEA < -100) {
                BarBEA = -100;
            }
            temp = BarBEA;
        } else if (helmFlag == 2) {
            BarBER--;
            if (BarBER < -100) {
                BarBER = -100;
            }
            temp = BarBER;
        }
        this.ebigdi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void decsHFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarHelmse--;
            if (BarHelmse < 0) {
                BarHelmse = PHOTO_SHOW;
            }
            temp = BarHelmse;
        } else if (helmFlag == AV_SHOW) {
            BarHelmsa--;
            if (BarHelmsa < 0) {
                BarHelmsa = PHOTO_SHOW;
            }
            temp = BarHelmsa;
        } else if (helmFlag == 2) {
            BarHelmsr--;
            if (BarHelmsr < 0) {
                BarHelmsr = PHOTO_SHOW;
            }
            temp = BarHelmsr;
        }
        this.hsmalldi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void decsEFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarSEE--;
            if (BarSEE < -100) {
                BarSEE = -100;
            }
            temp = BarSEE;
        } else if (helmFlag == AV_SHOW) {
            BarSEA--;
            if (BarSEA < -100) {
                BarSEA = -100;
            }
            temp = BarSEA;
        } else if (helmFlag == 2) {
            BarSER--;
            if (BarSER < -100) {
                BarSER = -100;
            }
            temp = BarSER;
        }
        this.esmalldi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void incbHFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarHelmbe += AV_SHOW;
            if (BarHelmbe > 125) {
                BarHelmbe = 125;
            }
            temp = BarHelmbe;
        } else if (helmFlag == AV_SHOW) {
            BarHelmba += AV_SHOW;
            if (BarHelmba > 125) {
                BarHelmba = 125;
            }
            temp = BarHelmba;
        } else if (helmFlag == 2) {
            BarHelmbr += AV_SHOW;
            if (BarHelmbr > 125) {
                BarHelmbr = 125;
            }
            temp = BarHelmbr;
        }
        this.hbigdi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void incbEFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarBEE += AV_SHOW;
            if (BarBEE > 100) {
                BarBEE = 100;
            }
            temp = BarBEE;
        } else if (helmFlag == AV_SHOW) {
            BarBEA += AV_SHOW;
            if (BarBEA > 100) {
                BarBEA = 100;
            }
            temp = BarBEA;
        } else if (helmFlag == 2) {
            BarBER += AV_SHOW;
            if (BarBER > 100) {
                BarBER = 100;
            }
            temp = BarBER;
        }
        this.ebigdi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void incsHFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarHelmse += AV_SHOW;
            if (BarHelmse > 125) {
                BarHelmse = 125;
            }
            temp = BarHelmse;
        } else if (helmFlag == AV_SHOW) {
            BarHelmsa += AV_SHOW;
            if (BarHelmsa > 125) {
                BarHelmsa = 125;
            }
            temp = BarHelmsa;
        } else if (helmFlag == 2) {
            BarHelmsr += AV_SHOW;
            if (BarHelmsr > 125) {
                BarHelmsr = 125;
            }
            temp = BarHelmsr;
        }
        this.hsmalldi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void incsEFunc() {
        int temp = PHOTO_SHOW;
        if (helmFlag == 0) {
            BarSEE += AV_SHOW;
            if (BarSEE > 100) {
                BarSEE = 100;
            }
            temp = BarSEE;
        } else if (helmFlag == AV_SHOW) {
            BarSEA += AV_SHOW;
            if (BarSEA > 100) {
                BarSEA = 100;
            }
            temp = BarSEA;
        } else if (helmFlag == 2) {
            BarSER += AV_SHOW;
            if (BarSER > 100) {
                BarSER = 100;
            }
            temp = BarSER;
        }
        this.esmalldi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public void showThroWindow() {
        runFlag = false;
        viewt = Helicopter.layoutInflater.inflate(R.layout.thro, null);
        throcurve = (CurveSurfaceView) viewt.findViewById(R.id.my0CurveSurfaceView);
        pointOn = (Button) viewt.findViewById(R.id.pointOn);
        dec = (Button) viewt.findViewById(R.id.dec);
        inc = (Button) viewt.findViewById(R.id.inc);
        expOn = (Button) viewt.findViewById(R.id.expOn);
        adjust = (SeekBar) viewt.findViewById(R.id.adjustSeekBar);
        adjustv = (TextView) viewt.findViewById(R.id.adjustRatio);
        throSpinner = (Spinner) viewt.findViewById(R.id.throSpinner);
        this.adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, throitem);
        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        throSpinner.setAdapter(this.adapter);
        throFlag = PHOTO_SHOW;
        pointOn.setText("ON");
        adjust.setProgress((int) (pointLL * 2.0f));
        adjustv.setText(pointLL + "%");
        if (expFlag) {
            expOn.setText("EXP ON");
        } else {
            expOn.setText("EXP OFF");
        }
        popupWindow1 = new PopupWindow(viewt, f11w, f7h);
        popNo = 3;
        popupWindow1.setAnimationStyle(R.style.PopupAnimation);
        popupWindow1.showAtLocation(viewt, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow1.update();
        SystemClock.sleep(100);
        throcurve.invalidate();
        throSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "L:0.0%") {
                    RunSurfaceView.throFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointLL * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointLL + "%");
                    RunSurfaceView.pointOn.setText("ON");
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "1:16.5%") {
                    RunSurfaceView.throFlag = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point11 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point11 + "%");
                    if (RunSurfaceView.point1Flag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "2:33.5%") {
                    RunSurfaceView.throFlag = 2;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point22 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point22 + "%");
                    if (RunSurfaceView.point2Flag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "M:50.0%") {
                    RunSurfaceView.throFlag = 3;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointMM * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointMM + "%");
                    if (RunSurfaceView.pointMFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "3:66.5%") {
                    RunSurfaceView.throFlag = 4;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point33 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point33 + "%");
                    if (RunSurfaceView.point3Flag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "4:83.5%") {
                    RunSurfaceView.throFlag = 5;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point44 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point44 + "%");
                    if (RunSurfaceView.point4Flag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.throSpinner.getSelectedItem().toString() == "H:100.0%") {
                    RunSurfaceView.throFlag = 6;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointHH * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointHH + "%");
                    RunSurfaceView.pointOn.setText("ON");
                }
                RunSurfaceView.throcurve.invalidate();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        throSpinner.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });
        pointOn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.throFlag == RunSurfaceView.AV_SHOW) {
                    if (RunSurfaceView.point1Flag) {
                        RunSurfaceView.point1Flag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point11 = 16.5f;
                    } else {
                        RunSurfaceView.point1Flag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point11 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point11 + "%");
                }
                if (RunSurfaceView.throFlag == 2) {
                    if (RunSurfaceView.point2Flag) {
                        RunSurfaceView.point2Flag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point22 = 33.5f;
                    } else {
                        RunSurfaceView.point2Flag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point22 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point22 + "%");
                }
                if (RunSurfaceView.throFlag == 3) {
                    if (RunSurfaceView.pointMFlag) {
                        RunSurfaceView.pointMFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.pointMM = 50.0f;
                    } else {
                        RunSurfaceView.pointMFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointMM * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointMM + "%");
                }
                if (RunSurfaceView.throFlag == 4) {
                    if (RunSurfaceView.point3Flag) {
                        RunSurfaceView.point3Flag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point33 = 66.5f;
                    } else {
                        RunSurfaceView.point3Flag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point33 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point33 + "%");
                }
                if (RunSurfaceView.throFlag == 5) {
                    if (RunSurfaceView.point4Flag) {
                        RunSurfaceView.point4Flag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point44 = 83.5f;
                    } else {
                        RunSurfaceView.point4Flag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point44 * 2.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point44 + "%");
                }
                RunSurfaceView.throcurve.invalidate();
            }
        });
        adjust.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RunSurfaceView.adjustratio = ((float) progress) * 0.5f;
                RunSurfaceView.adjustv.setText(RunSurfaceView.adjustratio + "%");
                if (RunSurfaceView.throFlag == 0) {
                    RunSurfaceView.pointLL = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == RunSurfaceView.AV_SHOW) {
                    RunSurfaceView.point11 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 2) {
                    RunSurfaceView.point22 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 3) {
                    RunSurfaceView.pointMM = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 4) {
                    RunSurfaceView.point33 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 5) {
                    RunSurfaceView.point44 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 6) {
                    RunSurfaceView.pointHH = RunSurfaceView.adjustratio;
                }
                RunSurfaceView.throcurve.invalidate();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                RunSurfaceView.adjustratio = ((float) seekBar.getProgress()) * 0.5f;
                RunSurfaceView.adjustv.setText(RunSurfaceView.adjustratio + "%");
                if (RunSurfaceView.throFlag == 0) {
                    RunSurfaceView.pointLL = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == RunSurfaceView.AV_SHOW) {
                    RunSurfaceView.point11 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 2) {
                    RunSurfaceView.point22 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 3) {
                    RunSurfaceView.pointMM = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 4) {
                    RunSurfaceView.point33 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 5) {
                    RunSurfaceView.point44 = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.throFlag == 6) {
                    RunSurfaceView.pointHH = RunSurfaceView.adjustratio;
                }
                RunSurfaceView.throcurve.invalidate();
            }
        });
        dec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.decT();
            }
        });
        inc.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.incT();
            }
        });
        expOn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.expFlag) {
                    RunSurfaceView.expOn.setText("EXP OFF");
                    RunSurfaceView.expFlag = false;
                } else {
                    RunSurfaceView.expOn.setText("EXP ON");
                    RunSurfaceView.expFlag = true;
                }
                RunSurfaceView.throcurve.invalidate();
            }
        });
        popupWindow1.setOnDismissListener(new OnDismissListen());
    }

    public void decT() {
        float temp = 0.0f;
        if (throFlag == 0) {
            pointLL -= 0.5f;
            if (pointLL < 0.0f) {
                pointLL = 0.0f;
            }
            temp = pointLL;
        } else if (throFlag == AV_SHOW) {
            point11 -= 0.5f;
            if (point11 < 0.0f) {
                point11 = 0.0f;
            }
            temp = point11;
        } else if (throFlag == 2) {
            point22 -= 0.5f;
            if (point22 < 0.0f) {
                point22 = 0.0f;
            }
            temp = point22;
        } else if (throFlag == 3) {
            pointMM -= 0.5f;
            if (pointMM < 0.0f) {
                pointMM = 0.0f;
            }
            temp = pointMM;
        } else if (throFlag == 4) {
            point33 -= 0.5f;
            if (point33 < 0.0f) {
                point33 = 200.0f;
            }
            temp = point33;
        } else if (throFlag == 5) {
            point44 -= 0.5f;
            if (point44 < 0.0f) {
                point44 = 0.0f;
            }
            temp = point44;
        } else if (throFlag == 6) {
            pointHH -= 0.5f;
            if (pointHH < 0.0f) {
                pointHH = 0.0f;
            }
            temp = pointHH;
        }
        adjust.setProgress((int) (2.0f * temp));
    }

    public void incT() {
        float temp = 0.0f;
        if (throFlag == 0) {
            pointLL += 0.5f;
            if (pointLL > 100.0f) {
                pointLL = 100.0f;
            }
            temp = pointLL;
        } else if (throFlag == AV_SHOW) {
            point11 += 0.5f;
            if (point11 > 100.0f) {
                point11 = 100.0f;
            }
            temp = point11;
        } else if (throFlag == 2) {
            point22 += 0.5f;
            if (point22 > 100.0f) {
                point22 = 100.0f;
            }
            temp = point22;
        } else if (throFlag == 3) {
            pointMM += 0.5f;
            if (pointMM > 100.0f) {
                pointMM = 100.0f;
            }
            temp = pointMM;
        } else if (throFlag == 4) {
            point33 += 0.5f;
            if (point33 > 100.0f) {
                point33 = 100.0f;
            }
            temp = point33;
        } else if (throFlag == 5) {
            point44 += 0.5f;
            if (point44 > 100.0f) {
                point44 = 100.0f;
            }
            temp = point44;
        } else if (throFlag == 6) {
            pointHH += 0.5f;
            if (pointHH > 100.0f) {
                pointHH = 100.0f;
            }
            temp = pointHH;
        }
        adjust.setProgress((int) (2.0f * temp));
    }

    public void showScrewWindow() {
        runFlag = false;
        viewp = Helicopter.layoutInflater.inflate(R.layout.thro, null);
        screwcurve = (CurveSurfaceView) viewp.findViewById(R.id.my0CurveSurfaceView);
        title = (TextView) viewp.findViewById(R.id.title);
        pointOn = (Button) viewp.findViewById(R.id.pointOn);
        dec = (Button) viewp.findViewById(R.id.dec);
        inc = (Button) viewp.findViewById(R.id.inc);
        expOn = (Button) viewp.findViewById(R.id.expOn);
        adjust = (SeekBar) viewp.findViewById(R.id.adjustSeekBar);
        adjustv = (TextView) viewp.findViewById(R.id.adjustRatio);
        screwSpinner = (Spinner) viewp.findViewById(R.id.throSpinner);
        this.adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, screwitem);
        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        screwSpinner.setAdapter(this.adapter);
        title.setText("PIT");
        screwFlag = PHOTO_SHOW;
        pointOn.setText("ON");
        adjust.setProgress((int) (pointLLS + 100.0f));
        adjustv.setText(pointLLS + "%");
        if (expSFlag) {
            expOn.setText("EXP ON");
        } else {
            expOn.setText("EXP OFF");
        }
        popupWindow2 = new PopupWindow(viewp, f11w, f7h);
        popNo = 4;
        popupWindow2.setAnimationStyle(R.style.PopupAnimation);
        popupWindow2.showAtLocation(viewp, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow2.update();
        SystemClock.sleep(100);
        screwcurve.invalidate();
        screwSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "L:-100.0%") {
                    RunSurfaceView.screwFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointLLS + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointLLS + "%");
                    RunSurfaceView.pointOn.setText("ON");
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "1:-67.0%") {
                    RunSurfaceView.screwFlag = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point11S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point11S + "%");
                    if (RunSurfaceView.point1SFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "2:-33.0%") {
                    RunSurfaceView.screwFlag = 2;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point22S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point22S + "%");
                    if (RunSurfaceView.point2SFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "M:0.0%") {
                    RunSurfaceView.screwFlag = 3;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointMMS + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointMMS + "%");
                    if (RunSurfaceView.pointMSFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "3:33.0%") {
                    RunSurfaceView.screwFlag = 4;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point33S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point33S + "%");
                    if (RunSurfaceView.point3SFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "4:67.0%") {
                    RunSurfaceView.screwFlag = 5;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point44S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point44S + "%");
                    if (RunSurfaceView.point4SFlag) {
                        RunSurfaceView.pointOn.setText("ON");
                    } else {
                        RunSurfaceView.pointOn.setText("OFF");
                    }
                } else if (RunSurfaceView.screwSpinner.getSelectedItem().toString() == "H:100.0%") {
                    RunSurfaceView.screwFlag = 6;
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointHHS + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointHHS + "%");
                    RunSurfaceView.pointOn.setText("ON");
                }
                RunSurfaceView.screwcurve.invalidate();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        screwSpinner.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });
        pointOn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.screwFlag == RunSurfaceView.AV_SHOW) {
                    if (RunSurfaceView.point1SFlag) {
                        RunSurfaceView.point1SFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point11S = -67.0f;
                    } else {
                        RunSurfaceView.point1SFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point11S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point11S + "%");
                }
                if (RunSurfaceView.screwFlag == 2) {
                    if (RunSurfaceView.point2SFlag) {
                        RunSurfaceView.point2SFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point22S = -33.0f;
                    } else {
                        RunSurfaceView.point2SFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point22S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point22S + "%");
                }
                if (RunSurfaceView.screwFlag == 3) {
                    if (RunSurfaceView.pointMSFlag) {
                        RunSurfaceView.pointMSFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.pointMMS = 0.0f;
                    } else {
                        RunSurfaceView.pointMSFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.pointMMS + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.pointMMS + "%");
                }
                if (RunSurfaceView.screwFlag == 4) {
                    if (RunSurfaceView.point3SFlag) {
                        RunSurfaceView.point3SFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point33S = 33.0f;
                    } else {
                        RunSurfaceView.point3SFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point33S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point33S + "%");
                }
                if (RunSurfaceView.screwFlag == 5) {
                    if (RunSurfaceView.point4SFlag) {
                        RunSurfaceView.point4SFlag = false;
                        RunSurfaceView.pointOn.setText("OFF");
                        RunSurfaceView.point44S = 67.0f;
                    } else {
                        RunSurfaceView.point4SFlag = true;
                        RunSurfaceView.pointOn.setText("ON");
                    }
                    RunSurfaceView.adjust.setProgress((int) (RunSurfaceView.point44S + 100.0f));
                    RunSurfaceView.adjustv.setText(RunSurfaceView.point44S + "%");
                }
                RunSurfaceView.screwcurve.invalidate();
            }
        });
        adjust.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RunSurfaceView.adjustratio = (float) (progress - 100);
                RunSurfaceView.adjustv.setText(RunSurfaceView.adjustratio + "%");
                if (RunSurfaceView.screwFlag == 0) {
                    RunSurfaceView.pointLLS = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == RunSurfaceView.AV_SHOW) {
                    RunSurfaceView.point11S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 2) {
                    RunSurfaceView.point22S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 3) {
                    RunSurfaceView.pointMMS = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 4) {
                    RunSurfaceView.point33S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 5) {
                    RunSurfaceView.point44S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 6) {
                    RunSurfaceView.pointHHS = RunSurfaceView.adjustratio;
                }
                RunSurfaceView.screwcurve.invalidate();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                RunSurfaceView.adjustratio = (float) (seekBar.getProgress() - 100);
                RunSurfaceView.adjustv.setText(RunSurfaceView.adjustratio + "%");
                if (RunSurfaceView.screwFlag == 0) {
                    RunSurfaceView.pointLLS = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == RunSurfaceView.AV_SHOW) {
                    RunSurfaceView.point11S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 2) {
                    RunSurfaceView.point22S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 3) {
                    RunSurfaceView.pointMMS = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 4) {
                    RunSurfaceView.point33S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 5) {
                    RunSurfaceView.point44S = RunSurfaceView.adjustratio;
                } else if (RunSurfaceView.screwFlag == 6) {
                    RunSurfaceView.pointHHS = RunSurfaceView.adjustratio;
                }
                RunSurfaceView.screwcurve.invalidate();
            }
        });
        dec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.decS();
            }
        });
        inc.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.this.incS();
            }
        });
        expOn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RunSurfaceView.expSFlag) {
                    RunSurfaceView.expOn.setText("EXP OFF");
                    RunSurfaceView.expSFlag = false;
                } else {
                    RunSurfaceView.expOn.setText("EXP ON");
                    RunSurfaceView.expSFlag = true;
                }
                RunSurfaceView.screwcurve.invalidate();
            }
        });
        popupWindow2.setOnDismissListener(new OnDismissListen());
    }

    public void decS() {
        int temp = PHOTO_SHOW;
        if (screwFlag == 0) {
            pointLLS -= 1.0f;
            if (pointLLS < -100.0f) {
                pointLLS = -100.0f;
            }
            temp = (int) pointLLS;
        } else if (screwFlag == AV_SHOW) {
            point11S -= 1.0f;
            if (point11S < -100.0f) {
                point11S = -100.0f;
            }
            temp = (int) point11S;
        } else if (screwFlag == 2) {
            point22S -= 1.0f;
            if (point22S < -100.0f) {
                point22S = -100.0f;
            }
            temp = (int) point22S;
        } else if (screwFlag == 3) {
            pointMMS -= 1.0f;
            if (pointMMS < -100.0f) {
                pointMMS = -100.0f;
            }
            temp = (int) pointMMS;
        } else if (screwFlag == 4) {
            point33S -= 1.0f;
            if (point33S < -100.0f) {
                point33S = -100.0f;
            }
            temp = (int) point33S;
        } else if (screwFlag == 5) {
            point44S -= 1.0f;
            if (point44S < -100.0f) {
                point44S = -100.0f;
            }
            temp = (int) point44S;
        } else if (screwFlag == 6) {
            pointHHS -= 1.0f;
            if (pointHHS < -100.0f) {
                pointHHS = -100.0f;
            }
            temp = (int) pointHHS;
        }
        adjust.setProgress(temp + 100);
    }

    public void incS() {
        int temp = PHOTO_SHOW;
        if (screwFlag == 0) {
            pointLLS += 1.0f;
            if (pointLLS > 100.0f) {
                pointLLS = 100.0f;
            }
            temp = (int) pointLLS;
        } else if (screwFlag == AV_SHOW) {
            point11S += 1.0f;
            if (point11S > 100.0f) {
                point11S = 100.0f;
            }
            temp = (int) point11S;
        } else if (screwFlag == 2) {
            point22S += 1.0f;
            if (point22S > 100.0f) {
                point22S = 100.0f;
            }
            temp = (int) point22S;
        } else if (screwFlag == 3) {
            pointMMS += 1.0f;
            if (pointMMS > 100.0f) {
                pointMMS = 100.0f;
            }
            temp = (int) pointMMS;
        } else if (screwFlag == 4) {
            point33S += 1.0f;
            if (point33S > 100.0f) {
                point33S = 100.0f;
            }
            temp = (int) point33S;
        } else if (screwFlag == 5) {
            point44S += 1.0f;
            if (point44S > 100.0f) {
                point44S = 100.0f;
            }
            temp = (int) point44S;
        } else if (screwFlag == 6) {
            pointHHS += 1.0f;
            if (pointHHS > 100.0f) {
                pointHHS = 100.0f;
            }
            temp = (int) pointHHS;
        }
        adjust.setProgress(temp + 100);
    }

    public static void picRecycle() {
        if (mbitmap != null) {
            mbitmap.recycle();
            barbmp.recycle();
            bar0bmp.recycle();
            throbarbmp.recycle();
            elevbarbmp.recycle();
            ruddbarbmp.recycle();
            ailebarbmp.recycle();
            ballbackbmp.recycle();
            ballbmp.recycle();
            camerabmp.recycle();
            camera0bmp.recycle();
            photobmp.recycle();
            photo0bmp.recycle();
            pvshowbmp.recycle();
            pvshow0bmp.recycle();
            gravityonbmp.recycle();
            gravityoffbmp.recycle();
            onbmp.recycle();
            offbmp.recycle();
            crossbmp.recycle();
            wificonbmp.recycle();
            setbmp.recycle();
            manual.recycle();
            helmexpbmp.recycle();
            throexpbmp.recycle();
            screwbmp.recycle();
            mbitmap = null;
            barbmp = null;
            bar0bmp = null;
            throbarbmp = null;
            elevbarbmp = null;
            ruddbarbmp = null;
            ailebarbmp = null;
            ballbackbmp = null;
            ballbmp = null;
            camerabmp = null;
            camera0bmp = null;
            photobmp = null;
            photo0bmp = null;
            pvshowbmp = null;
            pvshow0bmp = null;
            gravityonbmp = null;
            gravityoffbmp = null;
            onbmp = null;
            offbmp = null;
            crossbmp = null;
            wificonbmp = null;
            setbmp = null;
            manual = null;
            helmexpbmp = null;
            throexpbmp = null;
            screwbmp = null;
            ballGradient = null;
            ballBackGradient = null;
            ballBackGradient0 = null;
            ballGradient0 = null;
            balll.setCallback(null);
            ballr.setCallback(null);
            balll0.setCallback(null);
            ballr0.setCallback(null);
            ballbackl.setCallback(null);
            ballbackr.setCallback(null);
            ballbackl0.setCallback(null);
            ballbackr0.setCallback(null);
            balll = null;
            ballr = null;
            balll0 = null;
            ballr0 = null;
            ballbackl = null;
            ballbackr = null;
            ballbackl0 = null;
            ballbackr0 = null;
            manual = null;
            matrix = null;
            paint = null;
            f8p = null;
            ballLRect.setEmpty();
            ballRRect.setEmpty();
            ballLRect0.setEmpty();
            ballRRect0.setEmpty();
            ballBackLRect.setEmpty();
            ballBackRRect.setEmpty();
            ballBackLRect0.setEmpty();
            ballBackRRect0.setEmpty();
            ballLRect = null;
            ballRRect = null;
            ballLRect0 = null;
            ballRRect0 = null;
            ballBackLRect = null;
            ballBackRRect = null;
            ballBackLRect0 = null;
            ballBackRRect0 = null;
            path11.reset();
            path33.reset();
            path55.reset();
            path77.reset();
            path99.reset();
            path22.reset();
            path44.reset();
            path66.reset();
            path88.reset();
            path11 = null;
            path33 = null;
            path55 = null;
            path77 = null;
            path99 = null;
            path22 = null;
            path44 = null;
            path66 = null;
            path88 = null;
            animationListen = null;
            animation = null;
            popWindowDismiss();
        }
    }

    public static void popWindowDismiss() {
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            popupWindow = null;
        }
        if (popupWindow0 != null) {
            if (popupWindow0.isShowing()) {
                popupWindow0.dismiss();
            }
            popupWindow0 = null;
        }
        if (popupWindow1 != null) {
            if (popupWindow1.isShowing()) {
                popupWindow1.dismiss();
            }
            popupWindow1 = null;
        }
        if (popupWindow2 != null) {
            if (popupWindow2.isShowing()) {
                popupWindow2.dismiss();
            }
            popupWindow2 = null;
        }
        popNo = PHOTO_SHOW;
    }

    void initState() {
        lefth = false;
        righth = false;
        leftflag = false;
        rightflag = false;
        buttonCFlag = true;
        balllDFlag = false;
        ballrDFlag = false;
        balllUFlag = true;
        ballrUFlag = true;
        throQty = Constant.BASEMIN;
        ruddQty = (short) 0;
        elevQty = (short) 0;
        aileQty = (short) 0;
    }

    public static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static int getWifiStatus() {
        WifiManager mWifiMng = (WifiManager) Helicopter.context.getSystemService("wifi");
        switch (mWifiMng.getWifiState()) {
            case PHOTO_SHOW /*0*/:
            case AV_SHOW /*1*/:
            case Constant.LOGO /*2*/:
            case Constant.MANUAL /*4*/:
                return WIFI_STATE_DISABLED;
            case Constant.CONFIGURE /*3*/:
                int status = WIFI_STATE_NOT_CONNECTED;
                if (State.CONNECTED != ((ConnectivityManager) myActivity.getSystemService("connectivity")).getNetworkInfo(AV_SHOW).getState()) {
                    return WIFI_STATE_NOT_CONNECTED;
                }
                WifiInfo info = mWifiMng.getConnectionInfo();
                if (info != null) {
                    String SSID = info.getSSID();
                    if (SSID != null && SSID.length() > 0 && SSID.contains(WIFI_SSID_PERFIX)) {
                        status = WIFI_STATE_CONNECTED;
                    }
                }
                try {
                    InetAddress serverIp = InetAddress.getByName(intToIp(mWifiMng.getDhcpInfo().serverAddress));
                    if (status != WIFI_STATE_CONNECTED) {
                        return status;
                    }
                    if (serverIp.toString().equals("/192.168.10.1")) {
                        return WIFI_STATE_CONNECTED;
                    }
                    return WIFI_STATE_NOT_CONNECTED;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    return status;
                }
            default:
                return WIFI_STATE_DISABLED;
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
        gsensor.GSensorRegister();
        if (getWifiStatus() == WIFI_STATE_CONNECTED) {
            encodeDisplay.EncodeBfeStart();
        }
        encodeDisplay.Begin();
        cool = false;
        cno = PHOTO_SHOW;
        isOn = false;
        isOnFlag = false;
        this.PagesFlag = false;
        this.PhotosFlag = true;
        this.photoing = false;
        runFlag = false;
        wifiConFlag = false;
        pvshowFlag = false;
        MjpgRunFlag = false;
        leftUL = true;
        rightUR = true;
        animationListen = new AnimationListen();
        animation = AnimationUtils.loadAnimation(Helicopter.context, R.anim.viewshow);
        animation.setAnimationListener(animationListen);
        startAnimation(animation);
        setKeepScreenOn(false);
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        gsensor.GSensorUnRegister();
        encodeDisplay.EncodeAftEnd();
        popWindowDismiss();
        setKeepScreenOn(false);
        new Thread() {
            public void run() {
                try {
                    RunSurfaceView.runFlag = false;
                    EncodeDisplay.updateFlag = false;
                    RunSurfaceView.cno = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.isOn = false;
                    RunSurfaceView.isOnFlag = true;
                    if (RunSurfaceView.sensorOn) {
                        RunSurfaceView.sensorOn = false;
                        RunSurfaceView.gsensor.onOff = false;
                        RunSurfaceView.elevQty = (short) 0;
                        RunSurfaceView.aileQty = (short) 0;
                    }
                    if (RunSurfaceView.wifiFlag) {
                        RunSurfaceView.wifiFlag = false;
                        RunSurfaceView.encodeDisplay.EncodeEnd();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
