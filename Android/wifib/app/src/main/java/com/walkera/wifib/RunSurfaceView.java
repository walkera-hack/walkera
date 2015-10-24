package com.walkera.wifib;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.walkera.wifib.MultiTouchGestureDetector.EventInfo;
import com.walkera.wifib.MultiTouchGestureDetector.MultiMotionEvent;
import com.walkera.wifib.MultiTouchGestureDetector.MultiTouchGestureListener;
import com.walkera.wifib.compass.CompassActivity;
import com.walkera.wifib.picturebrowser.PhotoVideoBrowser;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RunSurfaceView extends SurfaceView implements Callback, OnTouchListener {
    static final int AV_SHOW = 1;
    static short BASEMIN0 = (short) 0;
    static int BarBEA = 0;
    static int BarBEE = 0;
    static int BarBER = 0;
    static int BarBET = 0;
    static int BarHelmba = 0;
    static int BarHelmbe = 0;
    static int BarHelmbr = 0;
    static int BarHelmbt = 0;
    static int BarHelmsa = 0;
    static int BarHelmse = 0;
    static int BarHelmsr = 0;
    static int BarHelmst = 0;
    static int BarSEA = 0;
    static int BarSEE = 0;
    static int BarSER = 0;
    static int BarSET = 0;
    static boolean MjpgRunFlag = false;
    static final int PHOTO_SHOW = 0;
    static boolean PhotosFlag = false;
    static final String WIFI_SSID_PERFIX = "WK";
    static final int WIFI_STATE_CONNECTED = 12291;
    static final int WIFI_STATE_DISABLED = 12289;
    static final int WIFI_STATE_NOT_CONNECTED = 12290;
    static CheckBox aile;
    static int aile0;
    static short aileIDec;
    static short aileIDecB;
    static short aileQty;
    static Button ailed;
    static Button ailedi;
    static Button ailei;
    static boolean aileinv;
    static ToggleButton aircraftTB;
    static Animation animation;
    static AnimationListen animationListen;
    static int arrows;
    static Bitmap aux1;
    static Bitmap aux10;
    static Bitmap aux11;
    static boolean aux1Flag;
    static short aux1IDec;
    static short aux2IDec;
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
    static boolean balllCFlag;
    static boolean balllDFlag;
    static boolean balllUFlag;
    static ShapeDrawable ballr;
    static boolean ballrCFlag;
    static boolean ballrDFlag;
    static boolean ballrUFlag;
    static int barh;
    static int barh0;
    static float barw;
    static int barw0;
    static float baseValue;
    static boolean calibrationFlag;
    static Bitmap camera0bmp;
    static short cameraLRQty;
    static short cameraUDQty;
    static Bitmap camerabmp;
    static int channels;
    static float circlex;
    static float circlexl;
    static float circlexr;
    static float circley;
    static float circleyl;
    static float circleyr;
    static byte[] cmdBuffer;
    static int cno;
    static ImageView compassTB;
    static boolean cool;
    static int coun;
    static CurveSurfaceView curve;
    static boolean dispalyFlag;
    static CheckBox elev;
    static int elev0;
    static short elevIDec;
    static short elevIDecB;
    static short elevQty;
    static CurveSurfaceView elevcurve;
    static Button elevd;
    static Button elevdi;
    static Button elevi;
    static boolean elevinv;
    static EncodeDisplay encodeDisplay;
    static LinearLayout exp_layout;
    static ImageView exp_show;
    static float fix0;
    static float fix1;
    static float fix2;
    static float fix3;
    static float fix4;
    static float fix5;
    static float fix6;
    static float fixb;
    static ToggleButton followmeTB;
    static boolean followmeTBFlag;
    static ToggleButton gravityTB;
    static boolean gravityTBFlag;
    static Bitmap gravityoff0bmp;
    static Bitmap gravityoffbmp;
    static Bitmap gravityonbmp;
    static GSensor gsensor;
    static int f11h;
    static int h0;
    static int h1;
    static int he;
    static final String[] helm0;
    static int helmFlag;
    static Spinner helmSpinner;
    static ImageView helm_curve;
    static LinearLayout helm_layout;
    static ImageView helm_show;
    static boolean helmexpFlag;
    static int hh;
    static int hh0;
    static boolean hiddenFlag;
    static boolean hiddenFullFlag;
    static SurfaceHolder holder;
    static int hr;
    static int interval;
    static ToggleButton iocTB;
    static boolean iocTBFlag;
    static boolean isOn;
    static boolean isOnFlag;
    static Bitmap landon;
    static Bitmap landon0;
    static Bitmap landon1;
    static boolean landonFlag;
    static ToggleButton landonTB;
    static boolean landonTBFlag;
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
    static ImageView m_calibrate;
    static int make;
    static int makex;
    static int makey;
    static Matrix matrix;
    static Bitmap mbitmap;
    static Bitmap mbmp;
    static int mode;
    static Button mode1;
    static Button mode2;
    static Button mode3;
    static Button mode4;
    static Spinner modeSpinner;
    static final String[] mode_array;
    static Helicopter myActivity;
    static Bitmap offbmp;
    static Bitmap onbmp;
    static int op_state;
    static boolean orientFlag;
    static float[] outRect;
    static Paint f12p;
    static Paint p0;
    static Paint paint;
    static Paint paint1;
    static int percentage;
    static Bitmap photo0bmp;
    static Bitmap photobmp;
    static short[] playbuffer;
    static int popNo;
    static PopupWindow popupWindow;
    static PopupWindow popupWindow1;
    static PopupWindow popupWindow2;
    static PopupWindow popupWindow3;
    static Bitmap pvshow0bmp;
    static boolean pvshowFlag;
    static Bitmap pvshowbmp;
    static int f13r;
    static int r0;
    static int r1;
    static Button recover;
    static boolean returnFlag;
    static int return_count;
    static int return_count0;
    static Bitmap returnth;
    static Bitmap returnth0;
    static Bitmap returnth1;
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
    static Button ruddd;
    static Button rudddi;
    static Button ruddi;
    static boolean ruddinv;
    static boolean runFlag;
    public static RunSurfaceView runSurfaceView;
    static boolean running;
    static boolean scaleFlag;
    static float scales;
    static float scales0;
    static int screenHeight;
    static int screenWidth;
    static int screw0;
    static short screwQty;
    static boolean scrollFlag;
    static boolean scrollHFlag;
    static boolean sensorOn;
    static Bitmap setbmp;
    static ImageView setting;
    static int step;
    static String strings;
    static boolean successFlag;
    static int f14t;
    static Bitmap takeoff;
    static Bitmap takeoff0;
    static Bitmap takeoff1;
    static boolean takeoffFlag;
    static ToggleButton takeoffTB;
    static boolean takeoffTBFlag;
    static float th;
    static CheckBox thro;
    static int thro0;
    static int thro00;
    static short throIDec;
    static short throIDecB;
    static short throQty;
    static Button throd;
    static Button throdi;
    static Button throi;
    static boolean throinv;
    static Toast toast;
    static float tw;
    static float tw0;
    static ImageView ufo_calibrate;
    static View viewc;
    static View viewh;
    static View viewp;
    static View views;
    static int f15w;
    static int w0;
    static int w1;
    static int wd;
    static boolean wifiConFlag;
    static boolean wifiFlag;
    static Bitmap wificonbmp;
    static Bitmap wificonoffbmp;
    static int wr;
    static int ww0;
    static int xgps;
    static int xhalf;
    static int xl;
    static int xleft;
    static int xr;
    static int xright;
    static int ybottom;
    static int ygps;
    static int yhalf;
    static int yl;
    static int yr;
    static int yratio;
    static int ytop;
    boolean PagesFlag;
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
    ArrayAdapter<String> mode_adapter;
    private int pgh0;
    private int pgw0;
    boolean photoing;
    float scr_x0;
    float scr_x1;
    float scr_y0;
    float scr_y1;
    public float f16x;
    private int x0;
    public float f17y;
    private int y0;

    /* renamed from: com.walkera.wifib.RunSurfaceView.1 */
    class C00051 implements OnItemSelectedListener {
        C00051() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (RunSurfaceView.modeSpinner.getSelectedItem().toString() == "Mode1") {
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
                RunSurfaceView.this.leftRFunc();
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = true;
                }
            } else if (RunSurfaceView.modeSpinner.getSelectedItem().toString() == "Mode2") {
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
                RunSurfaceView.this.leftRFunc();
                if (RunSurfaceView.sensorOn) {
                    RunSurfaceView.gsensor.onOff = true;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.2 */
    class C00062 implements OnFocusChangeListener {
        C00062() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.30 */
    class AnonymousClass30 extends Thread {
        private final /* synthetic */ float val$x;
        private final /* synthetic */ float val$y;

        AnonymousClass30(float f, float f2) {
            this.val$x = f;
            this.val$y = f2;
        }

        public void run() {
            while (RunSurfaceView.this.photoing) {
                try {
                    if (EncodeDisplay.photosFlag) {
                        Thread.sleep(40);
                        RunSurfaceView.coun += RunSurfaceView.AV_SHOW;
                        if (RunSurfaceView.coun == 25) {
                            RunSurfaceView.this.abortAnimation();
                            RunSurfaceView.this.calcCornerXY(this.val$x, this.val$y);
                            RunSurfaceView.this.mTouch.x = this.val$x;
                            RunSurfaceView.this.mTouch.y = this.val$y;
                            RunSurfaceView.this.setBitmaps(RunSurfaceView.mbitmap, null);
                            RunSurfaceView.this.PagesFlag = true;
                            RunSurfaceView.this.dragFlag = true;
                            RunSurfaceView.this.photoing = false;
                        }
                    } else {
                        RunSurfaceView.this.abortAnimation();
                        RunSurfaceView.this.calcCornerXY(this.val$x, this.val$y);
                        RunSurfaceView.this.mTouch.x = this.val$x;
                        RunSurfaceView.this.mTouch.y = this.val$y;
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
                            RunSurfaceView.this.calcCornerXY(this.val$x, this.val$y);
                            RunSurfaceView.this.mTouch.x = this.val$x;
                            RunSurfaceView.this.mTouch.y = this.val$y;
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

    /* renamed from: com.walkera.wifib.RunSurfaceView.3 */
    class C00073 implements OnClickListener {
        private final /* synthetic */ boolean val$statusFlag;

        C00073(boolean z) {
            this.val$statusFlag = z;
        }

        public void onClick(View v) {
            if (RunSurfaceView.sensorOn) {
                RunSurfaceView.gravityTB.setChecked(this.val$statusFlag);
            } else if (RunSurfaceView.gravityTB.isChecked()) {
                RunSurfaceView.gravityTBFlag = true;
            } else {
                RunSurfaceView.gravityTBFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.4 */
    class C00084 implements OnClickListener {
        C00084() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.iocTB.isChecked()) {
                RunSurfaceView.iocTBFlag = true;
            } else {
                RunSurfaceView.iocTBFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.5 */
    class C00095 implements OnClickListener {
        private final /* synthetic */ boolean val$status0Flag;

        C00095(boolean z) {
            this.val$status0Flag = z;
        }

        public void onClick(View v) {
            if (RunSurfaceView.returnFlag) {
                RunSurfaceView.followmeTB.setChecked(this.val$status0Flag);
            } else if (RunSurfaceView.followmeTB.isChecked()) {
                RunSurfaceView.followmeTBFlag = true;
            } else {
                RunSurfaceView.followmeTBFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.6 */
    class C00106 implements OnClickListener {
        C00106() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.takeoffTB.isChecked()) {
                RunSurfaceView.takeoffTBFlag = true;
            } else {
                RunSurfaceView.takeoffTBFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.7 */
    class C00117 implements OnClickListener {
        C00117() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.landonTB.isChecked()) {
                RunSurfaceView.landonTBFlag = true;
            } else {
                RunSurfaceView.landonTBFlag = false;
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.8 */
    class C00128 implements OnClickListener {
        C00128() {
        }

        public void onClick(View v) {
            if (RunSurfaceView.calibrationFlag) {
                RunSurfaceView.calibrationFlag = false;
                RunSurfaceView.aircraftTB.setChecked(false);
            } else if (RunSurfaceView.isOn) {
                RunSurfaceView.calibrationFlag = true;
                RunSurfaceView.aircraftTB.setChecked(true);
            } else {
                RunSurfaceView.aircraftTB.setChecked(false);
            }
        }
    }

    /* renamed from: com.walkera.wifib.RunSurfaceView.9 */
    class C00139 implements OnClickListener {
        C00139() {
        }

        public void onClick(View v) {
            RunSurfaceView.compassTB.setImageResource(R.drawable.button_on);
            RunSurfaceView.this.showMCalibrateWindow();
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
            if (RunSurfaceView.op_state == RunSurfaceView.AV_SHOW) {
                RunSurfaceView.aux1Flag = true;
            } else if (RunSurfaceView.op_state == 0) {
                RunSurfaceView.aux1Flag = false;
            }
            RunSurfaceView.throQty = (short) 0;
            RunSurfaceView.calibrationFlag = false;
            if (!EncodeDisplay.pathFlag) {
                RunSurfaceView.encodeDisplay.Begin();
            }
            RunSurfaceView.hiddenFlag = false;
            RunSurfaceView.this.hiddenFunc();
            if (RunSurfaceView.getWifiStatus() == RunSurfaceView.WIFI_STATE_CONNECTED) {
                RunSurfaceView.encodeDisplay.EncodeBfeStart();
            }
        }
    }

    public class OnDismissListen implements OnDismissListener {
        public void onDismiss() {
            if (RunSurfaceView.popNo == 0) {
                RunSurfaceView.calibrationFlag = false;
                RunSurfaceView.leftUL = true;
                RunSurfaceView.rightUR = true;
                RunSurfaceView.runFlag = true;
                new Thread(new RunThread()).start();
                RunSurfaceView.getValue();
            }
        }
    }

    public class RunThread extends Thread {
        public void run() {
            Canvas canvas = null;
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
                            RunSurfaceView.PhotosFlag = true;
                        }
                    }
                    canvas = RunSurfaceView.holder.lockCanvas(null);
                    synchronized (RunSurfaceView.holder) {
                        if (canvas != null) {
                            RunSurfaceView.this.onDraw(canvas);
                        }
                    }
                    if (canvas != null) {
                        RunSurfaceView.holder.unlockCanvasAndPost(canvas);
                        canvas = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (canvas != null) {
                        RunSurfaceView.holder.unlockCanvasAndPost(canvas);
                        canvas = null;
                    }
                }
            }
            if (canvas != null) {
                RunSurfaceView.holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public class GestureListener implements MultiTouchGestureListener {

        /* renamed from: com.walkera.wifib.RunSurfaceView.GestureListener.1 */
        class C00141 extends Thread {
            C00141() {
            }

            public void run() {
                try {
                    RunSurfaceView.landonFlag = true;
                    Thread.sleep(1000);
                    RunSurfaceView.landonFlag = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: com.walkera.wifib.RunSurfaceView.GestureListener.2 */
        class C00152 extends Thread {
            C00152() {
            }

            public void run() {
                try {
                    RunSurfaceView.takeoffFlag = true;
                    Thread.sleep(1000);
                    RunSurfaceView.takeoffFlag = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: com.walkera.wifib.RunSurfaceView.GestureListener.3 */
        class C00163 extends Thread {
            C00163() {
            }

            public void run() {
                try {
                    RunSurfaceView.takeoffFlag = true;
                    Thread.sleep(1000);
                    RunSurfaceView.takeoffFlag = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: com.walkera.wifib.RunSurfaceView.GestureListener.4 */
        class C00174 extends Thread {
            C00174() {
            }

            public void run() {
                try {
                    RunSurfaceView.landonFlag = true;
                    Thread.sleep(1000);
                    RunSurfaceView.landonFlag = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public boolean onDown(MultiMotionEvent e) {
            boolean flag0 = false;
            boolean flag1 = false;
            RunSurfaceView.this.f17y = e.getY();
            RunSurfaceView.this.f16x = e.getX();
            float x1 = RunSurfaceView.this.f16x - ((float) RunSurfaceView.xl);
            float y1 = RunSurfaceView.this.f17y - ((float) RunSurfaceView.yl);
            float x2 = RunSurfaceView.this.f16x - ((float) RunSurfaceView.xr);
            float y2 = RunSurfaceView.this.f17y - ((float) RunSurfaceView.yr);
            if (RunSurfaceView.this.f16x >= ((float) (RunSurfaceView.xl - RunSurfaceView.ww0)) && RunSurfaceView.this.f16x <= ((float) (RunSurfaceView.xl + RunSurfaceView.ww0)) && RunSurfaceView.this.f17y >= ((float) (RunSurfaceView.yl - RunSurfaceView.hh0)) && RunSurfaceView.this.f17y <= ((float) (RunSurfaceView.yl + RunSurfaceView.hh0))) {
                ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId())).mCurrentDownEvent.left = true;
                RunSurfaceView.leftflag = false;
                flag0 = true;
                RunSurfaceView.balllDFlag = true;
                RunSurfaceView.balllUFlag = false;
                if (!RunSurfaceView.sensorOn) {
                    RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                    RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                } else if (RunSurfaceView.mode != 2) {
                    RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                    RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                }
                if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xl)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yl)) >= ((float) RunSurfaceView.hr)) {
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
                        if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                            if (y1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            }
                            if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                                RunSurfaceView.throQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                                RunSurfaceView.throQty = Constant.BASEMIN;
                            }
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
                        if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                            if (y1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            }
                            if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                                RunSurfaceView.throQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                                RunSurfaceView.throQty = Constant.BASEMIN;
                            }
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
            }
            if (RunSurfaceView.this.f16x >= ((float) (RunSurfaceView.xr - RunSurfaceView.ww0)) && RunSurfaceView.this.f16x <= ((float) (RunSurfaceView.xr + RunSurfaceView.ww0)) && RunSurfaceView.this.f17y >= ((float) (RunSurfaceView.yr - RunSurfaceView.hh0)) && RunSurfaceView.this.f17y <= ((float) (RunSurfaceView.yr + RunSurfaceView.hh0))) {
                ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId())).mCurrentDownEvent.right = true;
                RunSurfaceView.rightflag = false;
                flag1 = true;
                RunSurfaceView.ballrDFlag = true;
                RunSurfaceView.ballrUFlag = false;
                if (!RunSurfaceView.sensorOn) {
                    RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                    RunSurfaceView.righty = RunSurfaceView.this.f17y;
                } else if (RunSurfaceView.mode != 4) {
                    RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                    RunSurfaceView.righty = RunSurfaceView.this.f17y;
                }
                if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xr)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yr)) >= ((float) RunSurfaceView.hr)) {
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
                    if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                        if (y2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        }
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
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
                    if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                        if (y2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        }
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    }
                }
            }
            if ((flag0 || flag1) && !EncodeDisplay.transferring) {
                RunSurfaceView.getValue();
            }
            return true;
        }

        public boolean onUp(MultiMotionEvent e) {
            RunSurfaceView.this.f16x = e.getX();
            RunSurfaceView.this.f17y = e.getY();
            RunSurfaceView.baseValue = 0.0f;
            RunSurfaceView.scrollFlag = true;
            RunSurfaceView.scrollHFlag = true;
            EventInfo info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e.getId());
            if (info != null) {
                if (info.mCurrentDownEvent.left) {
                    info.mCurrentDownEvent.left = false;
                    RunSurfaceView.lefth = false;
                    if (RunSurfaceView.leftOn) {
                        if (RunSurfaceView.mode == 3) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 4) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.leftflag = true;
                        RunSurfaceView.throQty = (short) (RunSurfaceView.throIDec * 2);
                        RunSurfaceView.balllCFlag = false;
                        RunSurfaceView.leftflag = false;
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        }
                        RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                        RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    }
                }
                if (info.mCurrentDownEvent.right) {
                    info.mCurrentDownEvent.right = false;
                    RunSurfaceView.righth = false;
                    if (!RunSurfaceView.leftOn) {
                        if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 2) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.rightflag = true;
                        RunSurfaceView.throQty = (short) (RunSurfaceView.throIDec * 2);
                        RunSurfaceView.ballrCFlag = false;
                        RunSurfaceView.rightflag = false;
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 3) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        }
                        RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                        RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    }
                }
            }
            if (!RunSurfaceView.hiddenFlag) {
                if (RunSurfaceView.this.f17y > ((float) (RunSurfaceView.ybottom - RunSurfaceView.h1)) && RunSurfaceView.this.f17y < ((float) RunSurfaceView.ybottom)) {
                    if (RunSurfaceView.this.f16x > ((float) (RunSurfaceView.xright - RunSurfaceView.w1)) && RunSurfaceView.this.f16x < ((float) RunSurfaceView.xright) && RunSurfaceView.landonTBFlag && !RunSurfaceView.landonFlag && !RunSurfaceView.takeoffFlag) {
                        new C00141().start();
                    }
                    if (RunSurfaceView.this.f16x > 0.0f && RunSurfaceView.this.f16x < ((float) RunSurfaceView.w1) && RunSurfaceView.takeoffTBFlag && !RunSurfaceView.takeoffFlag && !RunSurfaceView.landonFlag) {
                        new C00152().start();
                    }
                    if (RunSurfaceView.this.f16x > ((float) (RunSurfaceView.xhalf - (RunSurfaceView.w1 / 2))) && RunSurfaceView.this.f16x < ((float) (RunSurfaceView.xhalf + (RunSurfaceView.w1 / 2))) && RunSurfaceView.followmeTBFlag) {
                        RunSurfaceView.returnFlag = !RunSurfaceView.returnFlag;
                        if (RunSurfaceView.returnFlag) {
                            RunSurfaceView.landonFlag = false;
                            RunSurfaceView.takeoffFlag = false;
                        }
                        RunSurfaceView.return_count0 = RunSurfaceView.PHOTO_SHOW;
                        RunSurfaceView.return_count = RunSurfaceView.PHOTO_SHOW;
                    }
                }
                if (RunSurfaceView.this.f17y > ((float) RunSurfaceView.ytop) && RunSurfaceView.this.f17y < ((float) (RunSurfaceView.ytop + RunSurfaceView.h0))) {
                    if (RunSurfaceView.this.f16x > ((float) RunSurfaceView.xleft) && RunSurfaceView.this.f16x < ((float) (RunSurfaceView.xleft + RunSurfaceView.w0))) {
                        RunSurfaceView.this.camera_Func();
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + RunSurfaceView.w0) + 6)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 2)) + 6))) {
                        RunSurfaceView.this.photo_Func(RunSurfaceView.this.f16x, RunSurfaceView.this.f17y);
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 2)) + 12)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 3)) + 12))) {
                        RunSurfaceView.this.pvshow_Func();
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 3)) + 18)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 4)) + 18))) {
                        RunSurfaceView.this.gravityFunc();
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 4)) + 24)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 5)) + 24))) {
                        RunSurfaceView.this.onOffFunc();
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 5)) + 30)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 6)) + 30))) {
                        RunSurfaceView.this.showPConfigureWindow();
                    }
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 6)) + 36)) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.xleft + (RunSurfaceView.w0 * 7)) + 36)) && RunSurfaceView.iocTBFlag) {
                        RunSurfaceView.aux1Flag = !RunSurfaceView.aux1Flag;
                        if (RunSurfaceView.aux1Flag) {
                            RunSurfaceView.op_state = RunSurfaceView.AV_SHOW;
                        } else {
                            RunSurfaceView.op_state = RunSurfaceView.PHOTO_SHOW;
                        }
                    }
                }
            }
            RunSurfaceView.updateValue();
            if (!EncodeDisplay.transferring) {
                RunSurfaceView.getValue();
            }
            return true;
        }

        public boolean onShowPress(MultiMotionEvent e) {
            if (RunSurfaceView.hiddenFlag) {
                if (RunSurfaceView.this.f16x > ((float) (RunSurfaceView.xhalf - (RunSurfaceView.w1 / 2))) && RunSurfaceView.this.f16x < ((float) (RunSurfaceView.xhalf + (RunSurfaceView.w1 / 2)))) {
                    if (RunSurfaceView.this.f17y > ((float) RunSurfaceView.ytop) && RunSurfaceView.this.f17y < ((float) (RunSurfaceView.ytop + RunSurfaceView.h1)) && RunSurfaceView.takeoffTBFlag && !RunSurfaceView.takeoffFlag && !RunSurfaceView.landonFlag) {
                        new C00163().start();
                    }
                    if (RunSurfaceView.this.f17y > ((float) ((RunSurfaceView.ytop + RunSurfaceView.h1) + 4)) && RunSurfaceView.this.f17y < ((float) ((RunSurfaceView.ytop + (RunSurfaceView.h1 * 2)) + 4)) && RunSurfaceView.landonTBFlag && !RunSurfaceView.landonFlag && !RunSurfaceView.takeoffFlag) {
                        new C00174().start();
                    }
                    if (RunSurfaceView.this.f17y > ((float) (RunSurfaceView.ybottom - RunSurfaceView.h1)) && RunSurfaceView.this.f17y < ((float) RunSurfaceView.ybottom) && RunSurfaceView.followmeTBFlag) {
                        RunSurfaceView.returnFlag = !RunSurfaceView.returnFlag;
                        if (RunSurfaceView.returnFlag) {
                            RunSurfaceView.landonFlag = false;
                            RunSurfaceView.takeoffFlag = false;
                        }
                        RunSurfaceView.return_count0 = RunSurfaceView.PHOTO_SHOW;
                        RunSurfaceView.return_count = RunSurfaceView.PHOTO_SHOW;
                    }
                }
                RunSurfaceView.updateValue();
                if (!EncodeDisplay.transferring) {
                    RunSurfaceView.getValue();
                }
            }
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
            RunSurfaceView.this.f16x = e2.getX();
            RunSurfaceView.this.f17y = e2.getY();
            float x1 = RunSurfaceView.this.f16x - ((float) RunSurfaceView.xl);
            float y1 = RunSurfaceView.this.f17y - ((float) RunSurfaceView.yl);
            float x2 = RunSurfaceView.this.f16x - ((float) RunSurfaceView.xr);
            float y2 = RunSurfaceView.this.f17y - ((float) RunSurfaceView.yr);
            if (!RunSurfaceView.hiddenFlag) {
                if (RunSurfaceView.scrollFlag) {
                    if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                        RunSurfaceView.this.scr_x0 = RunSurfaceView.this.f16x;
                        RunSurfaceView.this.scr_y0 = RunSurfaceView.this.f17y;
                        RunSurfaceView.scrollFlag = false;
                    }
                } else if (RunSurfaceView.this.f16x <= ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) || RunSurfaceView.this.f16x >= ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2)))) {
                    RunSurfaceView.scrollFlag = true;
                } else if (Math.abs(RunSurfaceView.this.f17y - RunSurfaceView.this.scr_y0) >= 120.0f) {
                    RunSurfaceView.scrollFlag = true;
                    RunSurfaceView.hiddenFlag = true;
                    RunSurfaceView.this.hiddenFunc();
                }
                if (RunSurfaceView.scrollHFlag) {
                    if (RunSurfaceView.this.f17y > ((float) (RunSurfaceView.ybottom - RunSurfaceView.h0)) && RunSurfaceView.this.f17y < ((float) RunSurfaceView.ybottom) && !RunSurfaceView.lefth && !RunSurfaceView.righth) {
                        RunSurfaceView.this.scr_x1 = RunSurfaceView.this.f16x;
                        RunSurfaceView.this.scr_y1 = RunSurfaceView.this.f17y;
                        RunSurfaceView.scrollHFlag = false;
                    }
                } else if (RunSurfaceView.this.f17y <= ((float) (RunSurfaceView.ybottom - RunSurfaceView.h0)) || RunSurfaceView.this.f17y >= ((float) RunSurfaceView.ybottom) || RunSurfaceView.lefth || RunSurfaceView.righth) {
                    RunSurfaceView.scrollHFlag = true;
                } else if (Math.abs(RunSurfaceView.this.f16x - RunSurfaceView.this.scr_x1) >= 120.0f) {
                    RunSurfaceView.scrollHFlag = true;
                    RunSurfaceView.this.manualFunc();
                }
            } else if (RunSurfaceView.scrollFlag) {
                if (RunSurfaceView.this.f16x > ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) && RunSurfaceView.this.f16x < ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2))) && RunSurfaceView.this.f17y > ((float) RunSurfaceView.h0) && RunSurfaceView.this.f17y < ((float) (RunSurfaceView.screenHeight - RunSurfaceView.h0))) {
                    RunSurfaceView.this.scr_x0 = RunSurfaceView.this.f16x;
                    RunSurfaceView.this.scr_y0 = RunSurfaceView.this.f17y;
                    RunSurfaceView.scrollFlag = false;
                }
            } else if (RunSurfaceView.this.f16x <= ((float) ((RunSurfaceView.screenWidth / 2) - (RunSurfaceView.w0 / 2))) || RunSurfaceView.this.f16x >= ((float) ((RunSurfaceView.screenWidth / 2) + (RunSurfaceView.w0 / 2))) || RunSurfaceView.this.f17y <= ((float) RunSurfaceView.h0) || RunSurfaceView.this.f17y >= ((float) (RunSurfaceView.screenHeight - RunSurfaceView.h0))) {
                RunSurfaceView.scrollFlag = true;
            } else if (Math.abs(RunSurfaceView.this.f17y - RunSurfaceView.this.scr_y0) >= 120.0f) {
                RunSurfaceView.scrollFlag = true;
                RunSurfaceView.hiddenFullFlag = !RunSurfaceView.hiddenFullFlag;
                RunSurfaceView.baseValue = 0.0f;
                if (!RunSurfaceView.hiddenFullFlag) {
                    RunSurfaceView.scaleFlag = false;
                }
            }
            if (RunSurfaceView.this.f16x > ((float) (RunSurfaceView.xl - RunSurfaceView.ww0)) && RunSurfaceView.this.f16x < ((float) (RunSurfaceView.xl + RunSurfaceView.ww0)) && RunSurfaceView.this.f17y > ((float) (RunSurfaceView.yl - RunSurfaceView.hh0)) && RunSurfaceView.this.f17y < ((float) (RunSurfaceView.yl + RunSurfaceView.hh0))) {
                if (!RunSurfaceView.lefth) {
                    ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId())).mCurrentDownEvent.left = true;
                    RunSurfaceView.leftflag = false;
                    RunSurfaceView.lefth = true;
                }
                RunSurfaceView.balllDFlag = true;
                RunSurfaceView.balllUFlag = false;
                if (!RunSurfaceView.sensorOn) {
                    RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                    RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                } else if (RunSurfaceView.mode != 2) {
                    RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                    RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                }
                if (RunSurfaceView.mode != 2) {
                    if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xl)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yl)) >= ((float) RunSurfaceView.hr)) {
                        RunSurfaceView.balllCFlag = true;
                    } else {
                        RunSurfaceView.balllCFlag = false;
                    }
                } else if (!RunSurfaceView.sensorOn) {
                    if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xl)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yl)) >= ((float) RunSurfaceView.hr)) {
                        RunSurfaceView.balllCFlag = true;
                    } else {
                        RunSurfaceView.balllCFlag = false;
                    }
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
                        if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                            if (y1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            }
                            if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                                RunSurfaceView.throQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                                RunSurfaceView.throQty = Constant.BASEMIN;
                            }
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
                        if (Math.abs(y1) > ((float) RunSurfaceView.interval)) {
                            if (y1 >= ((float) RunSurfaceView.interval)) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            } else if (y1 <= ((float) (-RunSurfaceView.interval))) {
                                RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y1) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                            }
                            if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                                RunSurfaceView.throQty = Constant.BASEMAX;
                            }
                            if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                                RunSurfaceView.throQty = Constant.BASEMIN;
                            }
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
            } else if (RunSurfaceView.lefth) {
                info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId());
                if (RunSurfaceView.this.f16x < ((float) (RunSurfaceView.xhalf + (RunSurfaceView.r1 / 2)))) {
                    if (info.mCurrentDownEvent.left) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                            RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                            RunSurfaceView.balllCFlag = true;
                        } else if (RunSurfaceView.mode != 2) {
                            RunSurfaceView.leftx = RunSurfaceView.this.f16x;
                            RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                            RunSurfaceView.balllCFlag = true;
                        } else {
                            info.mCurrentDownEvent.left = false;
                            RunSurfaceView.lefth = false;
                        }
                    }
                } else if (info.mCurrentDownEvent.left) {
                    if (RunSurfaceView.leftOn) {
                        RunSurfaceView.leftx = (float) RunSurfaceView.xl;
                        RunSurfaceView.lefty = RunSurfaceView.this.f17y;
                        RunSurfaceView.balllCFlag = true;
                        if (RunSurfaceView.mode == 3) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 4) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.leftflag = true;
                        RunSurfaceView.throQty = (short) (RunSurfaceView.throIDec * 2);
                        RunSurfaceView.balllCFlag = false;
                        RunSurfaceView.leftflag = false;
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    } else if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        }
                        RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    } else if (RunSurfaceView.mode == 2 && !RunSurfaceView.sensorOn) {
                        RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        RunSurfaceView.balllDFlag = false;
                        RunSurfaceView.balllUFlag = true;
                    }
                    info.mCurrentDownEvent.left = false;
                    RunSurfaceView.lefth = false;
                }
            }
            if (RunSurfaceView.this.f16x >= ((float) (RunSurfaceView.xr - RunSurfaceView.ww0)) && RunSurfaceView.this.f16x <= ((float) (RunSurfaceView.xr + RunSurfaceView.ww0)) && RunSurfaceView.this.f17y >= ((float) (RunSurfaceView.yr - RunSurfaceView.hh0)) && RunSurfaceView.this.f17y <= ((float) (RunSurfaceView.yr + RunSurfaceView.hh0))) {
                if (!RunSurfaceView.righth) {
                    ((EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId())).mCurrentDownEvent.right = true;
                    RunSurfaceView.rightflag = false;
                    RunSurfaceView.righth = true;
                }
                RunSurfaceView.ballrDFlag = true;
                RunSurfaceView.ballrUFlag = false;
                if (!RunSurfaceView.sensorOn) {
                    RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                    RunSurfaceView.righty = RunSurfaceView.this.f17y;
                } else if (RunSurfaceView.mode != 4) {
                    RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                    RunSurfaceView.righty = RunSurfaceView.this.f17y;
                }
                if (RunSurfaceView.mode != 4) {
                    if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xr)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yr)) >= ((float) RunSurfaceView.hr)) {
                        RunSurfaceView.ballrCFlag = true;
                    } else {
                        RunSurfaceView.ballrCFlag = false;
                    }
                } else if (!RunSurfaceView.sensorOn) {
                    if (Math.abs(RunSurfaceView.this.f16x - ((float) RunSurfaceView.xr)) >= ((float) RunSurfaceView.wr) || Math.abs(RunSurfaceView.this.f17y - ((float) RunSurfaceView.yr)) >= ((float) RunSurfaceView.hr)) {
                        RunSurfaceView.ballrCFlag = true;
                    } else {
                        RunSurfaceView.ballrCFlag = false;
                    }
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
                    if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                        if (y2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        }
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
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
                    if (Math.abs(y2) > ((float) RunSurfaceView.interval)) {
                        if (y2 >= ((float) RunSurfaceView.interval)) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) + ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        } else if (y2 <= ((float) (-RunSurfaceView.interval))) {
                            RunSurfaceView.throQty = (short) ((int) (((1600.0f * ((0.0f - y2) - ((float) RunSurfaceView.interval))) / ((float) (RunSurfaceView.hr - RunSurfaceView.interval))) + ((float) (RunSurfaceView.throIDec * 2))));
                        }
                        if (RunSurfaceView.throQty >= Constant.BASEMAX) {
                            RunSurfaceView.throQty = Constant.BASEMAX;
                        }
                        if (RunSurfaceView.throQty <= Constant.BASEMIN) {
                            RunSurfaceView.throQty = Constant.BASEMIN;
                        }
                    }
                }
            } else if (RunSurfaceView.righth) {
                info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(e1.getId());
                if (RunSurfaceView.this.f16x > ((float) (RunSurfaceView.xhalf - (RunSurfaceView.r1 / 2)))) {
                    if (info.mCurrentDownEvent.right) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                            RunSurfaceView.righty = RunSurfaceView.this.f17y;
                            RunSurfaceView.ballrCFlag = true;
                        } else if (RunSurfaceView.mode != 4) {
                            RunSurfaceView.rightx = RunSurfaceView.this.f16x;
                            RunSurfaceView.righty = RunSurfaceView.this.f17y;
                            RunSurfaceView.ballrCFlag = true;
                        } else {
                            info.mCurrentDownEvent.right = false;
                            RunSurfaceView.righth = false;
                        }
                    }
                } else if (info.mCurrentDownEvent.right) {
                    if (!RunSurfaceView.leftOn) {
                        RunSurfaceView.rightx = (float) RunSurfaceView.xr;
                        RunSurfaceView.righty = RunSurfaceView.this.f17y;
                        RunSurfaceView.ballrCFlag = true;
                        if (RunSurfaceView.mode == RunSurfaceView.AV_SHOW) {
                            if (!RunSurfaceView.sensorOn) {
                                RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                            }
                        } else if (RunSurfaceView.mode == 2) {
                            RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        }
                        RunSurfaceView.rightflag = true;
                        RunSurfaceView.throQty = (short) (RunSurfaceView.throIDec * 2);
                        RunSurfaceView.ballrCFlag = false;
                        RunSurfaceView.rightflag = false;
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 3) {
                        if (!RunSurfaceView.sensorOn) {
                            RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        }
                        RunSurfaceView.ruddQty = (short) (RunSurfaceView.ruddIDec * 2);
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    } else if (RunSurfaceView.mode == 4 && !RunSurfaceView.sensorOn) {
                        RunSurfaceView.elevQty = (short) (RunSurfaceView.elevIDec * 2);
                        RunSurfaceView.aileQty = (short) (RunSurfaceView.aileIDec * 2);
                        RunSurfaceView.ballrDFlag = false;
                        RunSurfaceView.ballrUFlag = true;
                    }
                    info.mCurrentDownEvent.right = false;
                    RunSurfaceView.righth = false;
                }
            }
            if (!EncodeDisplay.transferring) {
                RunSurfaceView.getValue();
            }
            return true;
        }
    }

    static {
        calibrationFlag = false;
        running = false;
        MjpgRunFlag = false;
        gravityTBFlag = true;
        iocTBFlag = true;
        followmeTBFlag = true;
        takeoffTBFlag = true;
        landonTBFlag = true;
        wifiFlag = false;
        elevinv = false;
        aileinv = false;
        throinv = false;
        ruddinv = false;
        mode = AV_SHOW;
        popNo = PHOTO_SHOW;
        make = PHOTO_SHOW;
        makex = PHOTO_SHOW;
        makey = PHOTO_SHOW;
        channels = 8;
        helmFlag = PHOTO_SHOW;
        BarHelmbt = 100;
        BarHelmst = 100;
        BarHelmbe = 100;
        BarHelmse = 100;
        BarHelmba = 100;
        BarHelmsa = 100;
        BarHelmbr = 100;
        BarHelmsr = 100;
        BarBET = PHOTO_SHOW;
        BarSET = PHOTO_SHOW;
        BarBEE = PHOTO_SHOW;
        BarSEE = PHOTO_SHOW;
        BarBEA = PHOTO_SHOW;
        BarSEA = PHOTO_SHOW;
        BarBER = PHOTO_SHOW;
        BarSER = PHOTO_SHOW;
        helmexpFlag = true;
        helm0 = new String[]{"ELEV", "AILE", "THRO", "RUDD"};
        mode_array = new String[]{"Mode1", "Mode2"};
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
        balllCFlag = false;
        ballrCFlag = false;
        balllDFlag = false;
        ballrDFlag = false;
        balllUFlag = true;
        ballrUFlag = true;
        aux1Flag = false;
        returnFlag = false;
        takeoffFlag = false;
        landonFlag = false;
        return_count0 = PHOTO_SHOW;
        return_count = PHOTO_SHOW;
        op_state = PHOTO_SHOW;
        outRect = new float[]{8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f};
        screwQty = Constant.BASEMIN;
        elevQty = (short) 0;
        aileQty = (short) 0;
        throQty = Constant.BASEMIN;
        ruddQty = (short) 0;
        auxQty = (short) 0;
        auxIDec = (short) 0;
        cameraLRQty = (short) 0;
        cameraUDQty = (short) 0;
        aux1IDec = Constant.BASEMIN;
        aux2IDec = Constant.BASEMIN;
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
        isOnFlag = false;
        pvshowFlag = false;
        wifiConFlag = false;
        orientFlag = false;
        toast = null;
        barw0 = PHOTO_SHOW;
        barh0 = PHOTO_SHOW;
        barw = 0.0f;
        barh = PHOTO_SHOW;
        interval = PHOTO_SHOW;
        PhotosFlag = true;
        scrollFlag = true;
        scrollHFlag = true;
        scaleFlag = false;
        baseValue = 0.0f;
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
        runSurfaceView = this;
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
        runSurfaceView = this;
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
        aux1 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.aux1);
        aux10 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.aux10);
        aux11 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.aux11);
        ballbackbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.ballback);
        ballbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.stick);
        takeoff = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.takeoff);
        takeoff0 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.takeoff0);
        landon = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.landon);
        landon0 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.landon0);
        returnth = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.returnth);
        returnth0 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.returnth0);
        takeoff1 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.takeoff1);
        landon1 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.landon1);
        returnth1 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.returnth1);
        camerabmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.camera);
        camera0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.camera0);
        photobmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.photo);
        photo0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.photo0);
        pvshowbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.pvshow);
        pvshow0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.pvshow0);
        gravityonbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.gravityon);
        gravityoffbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.gravityoff);
        gravityoff0bmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.gravityoff0);
        onbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.on);
        offbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.off);
        wificonbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.wificon);
        wificonoffbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.wificon0);
        setbmp = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.setting);
        screenHeight = Helicopter.screenHeight;
        screenWidth = Helicopter.screenWidth;
        scales = Helicopter.scales;
        scales0 = Helicopter.scales0;
        aux1 = Helicopter.ToFit(aux1, scales0);
        aux10 = Helicopter.ToFit(aux10, scales0);
        aux11 = Helicopter.ToFit(aux11, scales0);
        ballbackbmp = Helicopter.ToFit(ballbackbmp, scales0);
        ballbmp = Helicopter.ToFit(ballbmp, scales0);
        takeoff = Helicopter.ToFit(takeoff, scales0);
        takeoff0 = Helicopter.ToFit(takeoff0, scales0);
        landon = Helicopter.ToFit(landon, scales0);
        landon0 = Helicopter.ToFit(landon0, scales0);
        returnth = Helicopter.ToFit(returnth, scales0);
        returnth0 = Helicopter.ToFit(returnth0, scales0);
        takeoff1 = Helicopter.ToFit(takeoff1, scales0);
        landon1 = Helicopter.ToFit(landon1, scales0);
        returnth1 = Helicopter.ToFit(returnth1, scales0);
        camerabmp = Helicopter.ToFit(camerabmp, scales0);
        camera0bmp = Helicopter.ToFit(camera0bmp, scales0);
        photobmp = Helicopter.ToFit(photobmp, scales0);
        photo0bmp = Helicopter.ToFit(photo0bmp, scales0);
        pvshowbmp = Helicopter.ToFit(pvshowbmp, scales0);
        pvshow0bmp = Helicopter.ToFit(pvshow0bmp, scales0);
        gravityonbmp = Helicopter.ToFit(gravityonbmp, scales0);
        gravityoffbmp = Helicopter.ToFit(gravityoffbmp, scales0);
        gravityoff0bmp = Helicopter.ToFit(gravityoff0bmp, scales0);
        onbmp = Helicopter.ToFit(onbmp, scales0);
        offbmp = Helicopter.ToFit(offbmp, scales0);
        wificonbmp = Helicopter.ToFit(wificonbmp, scales0);
        wificonoffbmp = Helicopter.ToFit(wificonoffbmp, scales0);
        setbmp = Helicopter.ToFit(setbmp, scales0);
        mbitmap = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.background);
        mbitmap = Helicopter.BitmapFit(mbitmap);
        matrix = new Matrix();
        f15w = mbitmap.getWidth();
        f11h = mbitmap.getHeight();
        arrows = (int) ((((float) f15w) * 50.0f) / 720.0f);
        w0 = setbmp.getWidth();
        h0 = setbmp.getHeight();
        w1 = returnth.getWidth();
        h1 = returnth.getHeight();
        xhalf = screenWidth / 2;
        yhalf = screenHeight / 2;
        xl = xhalf - (f15w / 4);
        yl = yhalf;
        xr = xhalf + (f15w / 4);
        yr = yhalf;
        r0 = ballbackbmp.getWidth() / 2;
        r1 = ballbmp.getWidth() / 2;
        f13r = r0 + r1;
        hh = screenHeight / 2;
        f14t = hh - r1;
        interval = r1 / 2;
        make = (int) (scales0 * 10.0f);
        ww0 = f13r - make;
        hh0 = f13r - make;
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
        ballbackbmp = Helicopter.ToFit(ballbackbmp, ((float) f13r) / ((float) r0));
        xleft = PHOTO_SHOW;
        xright = mWidth;
        xleft = (mWidth / 2) - (((w0 + 6) * 8) / 2);
        fix0 = (float) ((xleft + w0) + 6);
        fix1 = (float) ((xleft + (w0 * 2)) + 12);
        fix2 = (float) ((xleft + (w0 * 3)) + 18);
        fix3 = (float) ((xleft + (w0 * 4)) + 24);
        fix4 = (float) ((xleft + (w0 * 5)) + 30);
        fix5 = (float) ((xleft + (w0 * 6)) + 36);
        fix6 = (float) ((xleft + (w0 * 7)) + 42);
        tw0 = ((float) xleft) + (2.0f * scales);
        tw = ((float) xleft) + (scales * 12.0f);
        ytop = yhalf - (f11h / 2);
        ybottom = yhalf + (f11h / 2);
        fixb = (float) (ybottom - h0);
        th = ((float) (ytop + h0)) + (scales * 10.0f);
        paint = new Paint();
        paint.setColor(-7829368);
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setFakeBoldText(true);
        paint.setTextSize(scales * 12.0f);
        paint1 = new Paint();
        paint1.setColor(-1);
        paint1.setAntiAlias(true);
        paint1.setStyle(Style.STROKE);
        paint1.setFakeBoldText(true);
        paint1.setTextSize(scales * 12.0f);
        f12p = new Paint();
        f12p.setColor(-29696);
        f12p.setAntiAlias(true);
        f12p.setStyle(Style.FILL);
        f12p.setFakeBoldText(true);
        f12p.setTextSize(scales * 12.0f);
        p0 = new Paint();
        p0.setColor(-1);
        p0.setAntiAlias(true);
        p0.setStyle(Style.FILL);
        p0.setFakeBoldText(true);
        p0.setTextSize(18.0f * scales);
        ballBackGradient = new BitmapShader(ballbackbmp, TileMode.REPEAT, TileMode.MIRROR);
        ballBackGradient0 = new BitmapShader(ballbackbmp0, TileMode.REPEAT, TileMode.MIRROR);
        ballGradient = new BitmapShader(ballbmp, TileMode.REPEAT, TileMode.MIRROR);
        ballBackLRect = new Rect(xl - f13r, yl - f13r, xl + f13r, yl + f13r);
        ballbackl = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballbackl.getPaint().setShader(ballBackGradient);
        ballbackl.setBounds(ballBackLRect);
        ballBackRRect = new Rect(xr - f13r, yr - f13r, xr + f13r, yr + f13r);
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
        ballLRect0 = new Rect(xl - r1, ((yl + f13r) - make) - (r1 * 2), xl + r1, (yl - make) + f13r);
        ballRRect0 = new Rect(xr - r1, ((yr + f13r) - make) - (r1 * 2), xr + r1, (yr - make) + f13r);
        balll = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        balll.getPaint().setShader(ballGradient);
        ballr = new ShapeDrawable(new RoundRectShape(outRect, null, null));
        ballr.getPaint().setShader(ballGradient);
        leftU = new Path();
        leftL = new Path();
        rightU = new Path();
        rightR = new Path();
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
        int nAll = PHOTO_SHOW;
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
        CurveSurfaceView.helm_max = BarHelmbt;
        CurveSurfaceView.helm_min = BarHelmst;
        CurveSurfaceView.helm_adjustb = BarBET;
        CurveSurfaceView.helm_adjusts = BarSET;
        thro0 = curve.CountExp(throQty);
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
        if (op_state == 0) {
            playbuffer[4] = Constant.BASEMAX;
        } else if (op_state == AV_SHOW) {
            playbuffer[4] = Constant.BASEMIN;
        }
        if (takeoffFlag || landonFlag) {
            if (takeoffFlag) {
                playbuffer[5] = Constant.BASEMAX;
            }
            if (landonFlag) {
                playbuffer[5] = Constant.BASEMIN;
            }
        } else {
            playbuffer[5] = (short) 0;
        }
        playbuffer[6] = (short) ((int) ((GSensor.orient_x - 180.0f) * 12.0f));
        if (returnFlag) {
            playbuffer[7] = Constant.BASEMAX;
        } else {
            playbuffer[7] = Constant.BASEMIN;
        }
        if (isOn) {
            cmdBuffer[PHOTO_SHOW] = (byte) -127;
        } else if (isOnFlag) {
            playbuffer[PHOTO_SHOW] = Constant.BASEMIN;
            cmdBuffer[PHOTO_SHOW] = (byte) -127;
            cno += AV_SHOW;
            if (cno == 8) {
                cno = PHOTO_SHOW;
                isOnFlag = false;
                returnFlag = false;
                takeoffFlag = false;
                landonFlag = false;
                return_count = PHOTO_SHOW;
                isOn = false;
                encodeDisplay.CmdSendStop();
            }
        } else {
            cmdBuffer[PHOTO_SHOW] = Byte.MIN_VALUE;
        }
        if (calibrationFlag) {
            playbuffer[PHOTO_SHOW] = Constant.BASEMIN;
            playbuffer[AV_SHOW] = Constant.BASEMAX;
            playbuffer[2] = Constant.BASEMIN;
            playbuffer[3] = Constant.BASEMIN;
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
        }
    }

    public void modeSelect() {
        if (mode == AV_SHOW) {
            mode1.setTextColor(-16711936);
            mode2.setTextColor(-7829368);
            mode3.setTextColor(-7829368);
            mode4.setTextColor(-7829368);
        } else if (mode == 2) {
            mode1.setTextColor(-7829368);
            mode2.setTextColor(-16711936);
            mode3.setTextColor(-7829368);
            mode4.setTextColor(-7829368);
        } else if (mode == 3) {
            mode1.setTextColor(-7829368);
            mode2.setTextColor(-7829368);
            mode3.setTextColor(-16711936);
            mode4.setTextColor(-7829368);
        } else if (mode == 4) {
            mode1.setTextColor(-7829368);
            mode2.setTextColor(-7829368);
            mode3.setTextColor(-7829368);
            mode4.setTextColor(-16711936);
        }
    }

    void ModelSet_Func() {
        myActivity.savePreferences();
    }

    public void showPConfigureWindow() {
        runFlag = false;
        calibrationFlag = false;
        viewc = Helicopter.layoutInflater.inflate(R.layout.configuration, null);
        modeSpinner = (Spinner) viewc.findViewById(R.id.mode_Spinner);
        this.mode_adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, mode_array);
        this.mode_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        modeSpinner.setAdapter(this.mode_adapter);
        gravityTB = (ToggleButton) viewc.findViewById(R.id.toggleButton1);
        iocTB = (ToggleButton) viewc.findViewById(R.id.toggleButton2);
        followmeTB = (ToggleButton) viewc.findViewById(R.id.toggleButton3);
        takeoffTB = (ToggleButton) viewc.findViewById(R.id.toggleButton4);
        landonTB = (ToggleButton) viewc.findViewById(R.id.toggleButton5);
        aircraftTB = (ToggleButton) viewc.findViewById(R.id.toggleButton6);
        compassTB = (ImageView) viewc.findViewById(R.id.compass_on);
        elevcurve = (CurveSurfaceView) viewc.findViewById(R.id.my_CurveSurfaceView);
        CurveSurfaceView.elevhelm = true;
        CurveSurfaceView.throhelm = false;
        CurveSurfaceView.screwpitch = false;
        showHelmWindow(viewc);
        if (mode == AV_SHOW) {
            modeSpinner.setSelection(PHOTO_SHOW);
        } else if (mode == 4) {
            modeSpinner.setSelection(AV_SHOW);
        }
        if (gravityTBFlag) {
            gravityTB.setChecked(true);
        } else {
            gravityTB.setChecked(false);
        }
        if (iocTBFlag) {
            iocTB.setChecked(true);
        } else {
            iocTB.setChecked(false);
        }
        if (followmeTBFlag) {
            followmeTB.setChecked(true);
        } else {
            followmeTB.setChecked(false);
        }
        if (takeoffTBFlag) {
            takeoffTB.setChecked(true);
        } else {
            takeoffTB.setChecked(false);
        }
        if (landonTBFlag) {
            landonTB.setChecked(true);
        } else {
            landonTB.setChecked(false);
        }
        aircraftTB.setChecked(false);
        compassTB.setImageResource(R.drawable.button_off);
        popupWindow1 = new PopupWindow(viewc, mWidth, mHeight);
        popNo = 2;
        popupWindow1.setAnimationStyle(R.style.PopupAnimation);
        popupWindow1.showAtLocation(viewc, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow1.update();
        SystemClock.sleep(100);
        elevcurve.invalidate();
        modeSpinner.setOnItemSelectedListener(new C00051());
        modeSpinner.setOnFocusChangeListener(new C00062());
        gravityTB.setOnClickListener(new C00073(gravityTB.isChecked()));
        iocTB.setOnClickListener(new C00084());
        followmeTB.setOnClickListener(new C00095(followmeTB.isChecked()));
        takeoffTB.setOnClickListener(new C00106());
        landonTB.setOnClickListener(new C00117());
        aircraftTB.setOnClickListener(new C00128());
        compassTB.setOnClickListener(new C00139());
        popupWindow1.setOnDismissListener(new OnDismissListen());
    }

    public void showMCalibrateWindow() {
        runFlag = false;
        viewp = Helicopter.layoutInflater.inflate(R.layout.msensor_calibration, null);
        viewp.setBackgroundResource(R.drawable.background0);
        ImageView compass = (ImageView) viewp.findViewById(R.id.compass);
        popupWindow2 = new PopupWindow(viewp, mWidth, mHeight);
        popNo = 3;
        popupWindow2.setAnimationStyle(R.style.viewAnimation);
        popupWindow2.showAtLocation(viewp, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow2.update();
        compass.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!GSensor.cFlag) {
                    RunSurfaceView.this.showToast("No related sensor");
                } else if (RunSurfaceView.isOn) {
                    RunSurfaceView.this.showToast("Please turn off the control first!");
                } else {
                    Intent intent = new Intent();
                    intent.setClass(RunSurfaceView.myActivity, CompassActivity.class);
                    RunSurfaceView.myActivity.startActivityForResult(intent, 3);
                }
            }
        });
        popupWindow2.setOnDismissListener(new OnDismissListen());
    }

    public void showConfigureWindow() {
        runFlag = false;
        views = Helicopter.layoutInflater.inflate(R.layout.setting, null);
        views.setBackgroundResource(R.drawable.background0);
        elev = (CheckBox) views.findViewById(R.id.aa);
        aile = (CheckBox) views.findViewById(R.id.bb);
        thro = (CheckBox) views.findViewById(R.id.cc);
        rudd = (CheckBox) views.findViewById(R.id.dd);
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
        recover = (Button) views.findViewById(R.id.recover);
        mode1 = (Button) views.findViewById(R.id.mode1);
        mode2 = (Button) views.findViewById(R.id.mode2);
        mode3 = (Button) views.findViewById(R.id.mode3);
        mode4 = (Button) views.findViewById(R.id.mode4);
        popupWindow = new PopupWindow(views, mWidth, mHeight);
        elev.setChecked(elevinv);
        aile.setChecked(aileinv);
        thro.setChecked(throinv);
        rudd.setChecked(ruddinv);
        elevdi.setText("ELEV: " + elevIDec);
        ailedi.setText("AILE: " + aileIDec);
        throdi.setText("THRO: " + throIDec);
        rudddi.setText("RUDD: " + ruddIDec);
        modeSelect();
        popNo = AV_SHOW;
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(views, 17, PHOTO_SHOW, PHOTO_SHOW);
        popupWindow.update();
        elev.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    RunSurfaceView.elevinv = true;
                } else {
                    RunSurfaceView.elevinv = false;
                }
            }
        });
        aile.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    RunSurfaceView.aileinv = true;
                } else {
                    RunSurfaceView.aileinv = false;
                }
            }
        });
        thro.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    RunSurfaceView.throinv = true;
                } else {
                    RunSurfaceView.throinv = false;
                }
            }
        });
        rudd.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    RunSurfaceView.ruddinv = true;
                } else {
                    RunSurfaceView.ruddinv = false;
                }
            }
        });
        mode1.setOnClickListener(new OnClickListener() {
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
            }
        });
        mode2.setOnClickListener(new OnClickListener() {
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
            }
        });
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
            }
        });
        recover.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!RunSurfaceView.isOn) {
                    RunSurfaceView.elevinv = false;
                    RunSurfaceView.aileinv = false;
                    RunSurfaceView.throinv = false;
                    RunSurfaceView.ruddinv = false;
                    RunSurfaceView.mode = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.leftOn = false;
                    RunSurfaceView.hiddenFlag = false;
                    RunSurfaceView.helmFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarHelmbt = 40;
                    RunSurfaceView.BarHelmst = 40;
                    RunSurfaceView.BarHelmbe = 40;
                    RunSurfaceView.BarHelmse = 40;
                    RunSurfaceView.BarHelmba = 40;
                    RunSurfaceView.BarHelmsa = 40;
                    RunSurfaceView.BarHelmbr = 100;
                    RunSurfaceView.BarHelmsr = 100;
                    RunSurfaceView.BarBET = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSET = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarBEE = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSEE = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarBEA = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSEA = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarBER = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.BarSER = RunSurfaceView.PHOTO_SHOW;
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
                    RunSurfaceView.elev.setChecked(false);
                    RunSurfaceView.aile.setChecked(false);
                    RunSurfaceView.thro.setChecked(false);
                    RunSurfaceView.rudd.setChecked(false);
                    RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                    RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                    RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                    RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                    RunSurfaceView.this.modeSelect();
                    RunSurfaceView.this.leftRFunc();
                    RunSurfaceView.this.initState();
                    RunSurfaceView.updateValue();
                    RunSurfaceView.getValue();
                    RunSurfaceView.this.showToast("RESET");
                }
            }
        });
        elevd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.elevIDec = (short) (RunSurfaceView.elevIDec - 4);
                if (RunSurfaceView.elevIDec <= (short) -200) {
                    RunSurfaceView.elevIDec = (short) -200;
                }
                RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                RunSurfaceView.updateValue();
            }
        });
        elevi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.elevIDec = (short) (RunSurfaceView.elevIDec + 4);
                if (RunSurfaceView.elevIDec >= Constant.MACROBASE) {
                    RunSurfaceView.elevIDec = Constant.MACROBASE;
                }
                RunSurfaceView.elevdi.setText("ELEV: " + RunSurfaceView.elevIDec);
                RunSurfaceView.updateValue();
            }
        });
        ailed.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.aileIDec = (short) (RunSurfaceView.aileIDec - 4);
                if (RunSurfaceView.aileIDec <= (short) -200) {
                    RunSurfaceView.aileIDec = (short) -200;
                }
                RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                RunSurfaceView.updateValue();
            }
        });
        ailei.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.aileIDec = (short) (RunSurfaceView.aileIDec + 4);
                if (RunSurfaceView.aileIDec >= Constant.MACROBASE) {
                    RunSurfaceView.aileIDec = Constant.MACROBASE;
                }
                RunSurfaceView.ailedi.setText("AILE: " + RunSurfaceView.aileIDec);
                RunSurfaceView.updateValue();
            }
        });
        throd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.throIDec = (short) (RunSurfaceView.throIDec - 4);
                if (RunSurfaceView.throIDec <= (short) -200) {
                    RunSurfaceView.throIDec = (short) -200;
                }
                RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                RunSurfaceView.updateValue();
            }
        });
        throi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.throIDec = (short) (RunSurfaceView.throIDec + 4);
                if (RunSurfaceView.throIDec >= Constant.MACROBASE) {
                    RunSurfaceView.throIDec = Constant.MACROBASE;
                }
                RunSurfaceView.throdi.setText("THRO: " + RunSurfaceView.throIDec);
                RunSurfaceView.updateValue();
            }
        });
        ruddd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.ruddIDec = (short) (RunSurfaceView.ruddIDec - 4);
                if (RunSurfaceView.ruddIDec <= (short) -200) {
                    RunSurfaceView.ruddIDec = (short) -200;
                }
                RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                RunSurfaceView.updateValue();
            }
        });
        ruddi.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.ruddIDec = (short) (RunSurfaceView.ruddIDec + 4);
                if (RunSurfaceView.ruddIDec >= Constant.MACROBASE) {
                    RunSurfaceView.ruddIDec = Constant.MACROBASE;
                }
                RunSurfaceView.rudddi.setText("RUDD: " + RunSurfaceView.ruddIDec);
                RunSurfaceView.updateValue();
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
            r0 = (f13r - r1) - makex;
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
            r0 = (f13r - r1) - makex;
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

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (hiddenFlag) {
            if (!EncodeDisplay.updateFlag) {
                canvas.drawBitmap(mbitmap, 0.0f, 0.0f, paint);
            } else if (scaleFlag) {
                canvas.drawBitmap(mbitmap, 0.0f, 0.0f, paint);
                if (EncodeDisplay.fflag) {
                    mbmp = Helicopter.BitmapFit0(encodeDisplay.bmp2);
                } else {
                    mbmp = Helicopter.BitmapFit0(encodeDisplay.bmp1);
                }
                canvas.drawBitmap(mbmp, (float) ((screenWidth / 2) - (mbmp.getWidth() / 2)), (float) ((screenHeight / 2) - (mbmp.getHeight() / 2)), paint);
            } else {
                if (EncodeDisplay.fflag) {
                    mbmp = Helicopter.BitmapFit(encodeDisplay.bmp2);
                } else {
                    mbmp = Helicopter.BitmapFit(encodeDisplay.bmp1);
                }
                canvas.drawBitmap(mbmp, 0.0f, 0.0f, paint);
            }
            if (!hiddenFullFlag) {
                ballbackl0.draw(canvas);
                ballbackr0.draw(canvas);
                ControlRunning(canvas);
            }
            if (!hiddenFullFlag) {
                int sw = xhalf - (w1 / 2);
                int sh = (ytop + h1) + 4;
                if (!takeoffTBFlag) {
                    canvas.drawBitmap(takeoff1, (float) sw, (float) ytop, paint);
                } else if (takeoffFlag) {
                    canvas.drawBitmap(takeoff0, (float) sw, (float) ytop, paint);
                } else {
                    canvas.drawBitmap(takeoff, (float) sw, (float) ytop, paint);
                }
                if (!landonTBFlag) {
                    canvas.drawBitmap(landon1, (float) sw, (float) sh, paint);
                } else if (landonFlag) {
                    canvas.drawBitmap(landon0, (float) sw, (float) sh, paint);
                } else {
                    canvas.drawBitmap(landon, (float) sw, (float) sh, paint);
                }
                if (!followmeTBFlag) {
                    canvas.drawBitmap(returnth1, (float) sw, (float) (ybottom - h1), paint);
                } else if (returnFlag) {
                    canvas.drawBitmap(returnth0, (float) sw, (float) (ybottom - h1), paint);
                } else {
                    canvas.drawBitmap(returnth, (float) sw, (float) (ybottom - h1), paint);
                }
            }
        } else {
            if (EncodeDisplay.updateFlag) {
                if (EncodeDisplay.fflag) {
                    mbmp = Helicopter.BitmapFit(encodeDisplay.bmp2);
                } else {
                    mbmp = Helicopter.BitmapFit(encodeDisplay.bmp1);
                }
                canvas.drawBitmap(mbmp, 0.0f, 0.0f, paint);
            } else {
                canvas.drawBitmap(mbitmap, 0.0f, 0.0f, paint);
            }
            if (wifiFlag) {
                canvas.drawBitmap(camera0bmp, (float) xleft, (float) ytop, paint1);
                if (EncodeDisplay.updateFlag) {
                    strings = encodeDisplay.getT();
                    if (EncodeDisplay.hr == 0) {
                        canvas.drawText(strings, tw, th, p0);
                    } else {
                        canvas.drawText(strings, tw0, th, p0);
                    }
                }
            } else {
                EncodeDisplay.timeFlag = true;
                canvas.drawBitmap(camerabmp, (float) xleft, (float) ytop, paint1);
            }
            if (PhotosFlag) {
                canvas.drawBitmap(photobmp, fix0, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(photo0bmp, fix0, (float) ytop, paint1);
            }
            if (pvshowFlag) {
                canvas.drawBitmap(pvshow0bmp, fix1, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(pvshowbmp, fix1, (float) ytop, paint1);
            }
            if (!gravityTBFlag) {
                canvas.drawBitmap(gravityoff0bmp, fix2, (float) ytop, paint1);
            } else if (sensorOn) {
                canvas.drawBitmap(gravityonbmp, fix2, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(gravityoffbmp, fix2, (float) ytop, paint1);
            }
            if (isOn) {
                canvas.drawBitmap(onbmp, fix3, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(offbmp, fix3, (float) ytop, paint1);
            }
            canvas.drawBitmap(setbmp, fix4, (float) ytop, paint1);
            if (!iocTBFlag) {
                canvas.drawBitmap(aux11, fix5, (float) ytop, paint1);
            } else if (aux1Flag) {
                canvas.drawBitmap(aux10, fix5, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(aux1, fix5, (float) ytop, paint1);
            }
            if (wifiConFlag) {
                canvas.drawBitmap(wificonbmp, fix6, (float) ytop, paint1);
            } else {
                canvas.drawBitmap(wificonoffbmp, fix6, (float) ytop, paint1);
            }
            if (!takeoffTBFlag) {
                canvas.drawBitmap(takeoff1, 0.0f, (float) (ybottom - h1), paint);
            } else if (takeoffFlag) {
                canvas.drawBitmap(takeoff0, 0.0f, (float) (ybottom - h1), paint);
            } else {
                canvas.drawBitmap(takeoff, 0.0f, (float) (ybottom - h1), paint);
            }
            if (!landonTBFlag) {
                canvas.drawBitmap(landon1, (float) (screenWidth - w1), (float) (ybottom - h1), paint);
            } else if (landonFlag) {
                canvas.drawBitmap(landon0, (float) (screenWidth - w1), (float) (ybottom - h1), paint);
            } else {
                canvas.drawBitmap(landon, (float) (screenWidth - w1), (float) (ybottom - h1), paint);
            }
            if (!followmeTBFlag) {
                canvas.drawBitmap(returnth1, (float) (xhalf - (w1 / 2)), (float) (ybottom - h1), paint);
            } else if (returnFlag) {
                canvas.drawBitmap(returnth0, (float) (xhalf - (w1 / 2)), (float) (ybottom - h1), paint);
            } else {
                canvas.drawBitmap(returnth, (float) (xhalf - (w1 / 2)), (float) (ybottom - h1), paint);
            }
            ballbackl.draw(canvas);
            ballbackr.draw(canvas);
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
                    PhotosFlag = true;
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
                        f3 = (float) (f13r - 2);
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
                        f3 = (float) (f13r - 2);
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
                balll.setBounds(ballLRect);
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
            ballr.setBounds(ballRRect);
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
                r0 = f13r;
            }
            leftU.reset();
            leftU.moveTo((float) xl, (float) (yl - r0));
            leftU.lineTo((float) xl, (float) yl);
            leftL.reset();
            leftL.moveTo((float) (xl - f13r), (float) yl);
            leftL.lineTo((float) xl, (float) yl);
        }
        if (leftOn) {
            if (mode == 3) {
                canvas.drawTextOnPath("THRO", leftU, 0.0f, 0.0f, f12p);
                canvas.drawTextOnPath("AILE", leftL, 0.0f, 0.0f, f12p);
            } else if (mode == 4) {
                canvas.drawTextOnPath("THRO", leftU, 0.0f, 0.0f, f12p);
                canvas.drawTextOnPath("RUDD", leftL, 0.0f, 0.0f, f12p);
            }
        } else if (mode == AV_SHOW) {
            canvas.drawTextOnPath("ELEV", leftU, 0.0f, 0.0f, f12p);
            canvas.drawTextOnPath("RUDD", leftL, 0.0f, 0.0f, f12p);
        } else if (mode == 2) {
            canvas.drawTextOnPath("ELEV", leftU, 0.0f, 0.0f, f12p);
            canvas.drawTextOnPath("AILE", leftL, 0.0f, 0.0f, f12p);
        }
    }

    public void rightN(Canvas canvas) {
        if (rightUR) {
            int r0;
            rightUR = false;
            if (hiddenFlag) {
                r0 = hh;
            } else {
                r0 = f13r;
            }
            rightU.reset();
            rightU.moveTo((float) xr, (float) (yr - r0));
            rightU.lineTo((float) xr, (float) yr);
            rightR.reset();
            rightR.moveTo((float) (xr - f13r), (float) yr);
            rightR.lineTo((float) xr, (float) yr);
        }
        if (leftOn) {
            if (mode == 3) {
                canvas.drawTextOnPath("ELEV", rightU, 0.0f, 0.0f, f12p);
                canvas.drawTextOnPath("RUDD", rightR, 0.0f, 0.0f, f12p);
            } else if (mode == 4) {
                canvas.drawTextOnPath("ELEV", rightU, 0.0f, 0.0f, f12p);
                canvas.drawTextOnPath("AILE", rightR, 0.0f, 0.0f, f12p);
            }
        } else if (mode == AV_SHOW) {
            canvas.drawTextOnPath("THRO", rightU, 0.0f, 0.0f, f12p);
            canvas.drawTextOnPath("AILE", rightR, 0.0f, 0.0f, f12p);
        } else if (mode == 2) {
            canvas.drawTextOnPath("THRO", rightU, 0.0f, 0.0f, f12p);
            canvas.drawTextOnPath("RUDD", rightR, 0.0f, 0.0f, f12p);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode == 4) {
            if (popNo == AV_SHOW) {
                if (popupWindow.isShowing()) {
                    popNo = 2;
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.dismiss();
                    ModelSet_Func();
                    return true;
                }
            } else if (popNo == 2) {
                if (popupWindow1.isShowing()) {
                    popNo = PHOTO_SHOW;
                    popupWindow1.setOutsideTouchable(true);
                    popupWindow1.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow1.dismiss();
                    ModelSet_Func();
                    return true;
                }
            } else if (popNo == 3) {
                if (popupWindow2.isShowing()) {
                    popNo = 2;
                    popupWindow2.setOutsideTouchable(true);
                    popupWindow2.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow2.dismiss();
                    return true;
                }
            } else if (popNo == 4) {
                if (popupWindow3.isShowing()) {
                    popNo = 2;
                    popupWindow3.setOutsideTouchable(true);
                    popupWindow3.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow3.dismiss();
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
                Helicopter.onFinish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, e);
    }

    void onOffFunc() {
        isOn = !isOn;
        if (isOn) {
            if (gravityTBFlag) {
                sensorOn = true;
                gsensor.sensorFlag = true;
                gsensor.onOff = true;
            }
            holder.setKeepScreenOn(true);
            initState();
            if (EncodeDisplay.updateFlag0) {
                encodeDisplay.CmdSendStart();
                return;
            }
            return;
        }
        holder.setKeepScreenOn(false);
        cno = PHOTO_SHOW;
        isOnFlag = true;
        initState();
        if (gravityTBFlag) {
            sensorOn = false;
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
    }

    void leftRFunc() {
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
        if (gravityTBFlag) {
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
    }

    void camera_Func() {
        boolean z = true;
        if (EncodeDisplay.updateFlag) {
            if (wifiFlag) {
                z = false;
            }
            wifiFlag = z;
            if (wifiFlag) {
                EncodeDisplay.hr = PHOTO_SHOW;
                EncodeDisplay.min = PHOTO_SHOW;
                EncodeDisplay.sec = PHOTO_SHOW;
                encodeDisplay.EncodeBegin();
                return;
            }
            encodeDisplay.EncodeEnd();
            return;
        }
        wifiFlag = true;
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    RunSurfaceView.wifiFlag = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    void photo_Func(float xx, float yy) {
        float x = xx;
        float y = yy;
        if (!EncodeDisplay.updateFlag) {
            PhotosFlag = false;
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(200);
                        RunSurfaceView.PhotosFlag = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } else if (PhotosFlag && !this.photoing) {
            this.PagesFlag = false;
            this.dragFlag = false;
            PhotosFlag = false;
            coun = PHOTO_SHOW;
            this.photoing = true;
            this.pgw0 = f15w;
            this.pgh0 = f11h;
            encodeDisplay.TakePic();
            SystemClock.sleep(10);
            if (scaleFlag) {
                new Thread() {
                    public void run() {
                        while (RunSurfaceView.this.photoing) {
                            try {
                                if (!EncodeDisplay.photosFlag) {
                                    RunSurfaceView.this.photoing = false;
                                    RunSurfaceView.PhotosFlag = true;
                                }
                                if (RunSurfaceView.this.photoing) {
                                    Thread.sleep(25);
                                    RunSurfaceView.coun += RunSurfaceView.AV_SHOW;
                                    if (RunSurfaceView.coun == 40) {
                                        RunSurfaceView.this.photoing = false;
                                        RunSurfaceView.PhotosFlag = true;
                                    }
                                }
                            } catch (Exception e) {
                                RunSurfaceView.this.photoing = false;
                                RunSurfaceView.PhotosFlag = true;
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            } else {
                new AnonymousClass30(x, y).start();
            }
        }
    }

    void pvshow_Func() {
        if (encodeDisplay.checkSDCard()) {
            pvshowFlag = true;
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
            Intent intent = new Intent();
            intent.setClass(myActivity, PhotoVideoBrowser.class);
            myActivity.startActivityForResult(intent, 2);
            return;
        }
        showToast("No SD Card Found!");
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
        Helicopter.setView(AV_SHOW);
    }

    void hiddenFunc() {
        leftUL = true;
        rightUR = true;
        gsensor.sensorFlag = true;
        int yll;
        int yrr;
        if (hiddenFlag) {
            f13r = (screenWidth - (w0 * 2)) / 4;
            ww0 = f13r - makex;
            hh0 = hh - makey;
            wr = (f13r - r1) - makex;
            hr = (hh - r1) - makey;
            xl = f13r;
            yl = hh;
            xr = screenWidth - f13r;
            yr = hh;
            yll = (yl + f14t) - makey;
            yrr = (yr + f14t) - makey;
            ballLRect0.setEmpty();
            ballRRect0.setEmpty();
            ballLRect0.set(xl - r1, yll - (r1 * 2), xl + r1, hh + yll);
            ballRRect0.set(xr - r1, yrr - (r1 * 2), xr + r1, hh + yrr);
            if (leftOn) {
                circleyl = (float) (yl - (((f14t - makey) * throQty) / 1600));
                balllDFlag = true;
                balllUFlag = false;
                leftflag = true;
                balllCFlag = false;
            } else {
                circleyr = (float) (yr - (((f14t - makey) * throQty) / 1600));
                ballrDFlag = true;
                ballrUFlag = false;
                rightflag = true;
                ballrCFlag = false;
            }
        } else {
            f13r = r0 + r1;
            ww0 = f13r - make;
            hh0 = f13r - make;
            wr = r0 - make;
            hr = r0 - make;
            xl = xhalf - (f15w / 4);
            yl = yhalf;
            xr = xhalf + (f15w / 4);
            yr = yhalf;
            yll = (yl + f13r) - make;
            yrr = (yr + f13r) - make;
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
        if (!hiddenFlag || !hiddenFullFlag || event.getAction() != 2 || event.getPointerCount() != 2) {
            return mGesture.onTouchEvent(event);
        }
        float x = event.getX(PHOTO_SHOW) - event.getX(AV_SHOW);
        float y = event.getY(PHOTO_SHOW) - event.getY(AV_SHOW);
        float value = (float) Math.sqrt((double) ((x * x) + (y * y)));
        if (baseValue == 0.0f) {
            baseValue = value;
            return true;
        } else if (value - baseValue >= 100.0f) {
            scaleFlag = false;
            return true;
        } else if (value - baseValue > -100.0f) {
            return true;
        } else {
            scaleFlag = true;
            return true;
        }
    }

    public void showHelmWindow(View v) {
        viewh = v;
        runFlag = false;
        helm_show = (ImageView) viewh.findViewById(R.id.helm_show);
        exp_show = (ImageView) viewh.findViewById(R.id.exp_show);
        helm_layout = (LinearLayout) viewh.findViewById(R.id.helm_layout);
        exp_layout = (LinearLayout) viewh.findViewById(R.id.exp_layout);
        this.helmdec = (Button) viewh.findViewById(R.id.helmdec);
        this.helminc = (Button) viewh.findViewById(R.id.helminc);
        this.hbigdi = (Button) viewh.findViewById(R.id.hbigdi);
        this.hsmalldi = (Button) viewh.findViewById(R.id.hsmalldi);
        this.expdec = (Button) viewh.findViewById(R.id.expdec);
        this.expinc = (Button) viewh.findViewById(R.id.expinc);
        this.ebigdi = (Button) viewh.findViewById(R.id.ebigdi);
        this.esmalldi = (Button) viewh.findViewById(R.id.esmalldi);
        helmSpinner = (Spinner) viewh.findViewById(R.id.helmSpinner);
        this.adapter = new ArrayAdapter(Helicopter.context, R.layout.simple_spinner_item, helm0);
        this.adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        helmSpinner.setAdapter(this.adapter);
        if (helmexpFlag) {
            helm_layout.setVisibility(PHOTO_SHOW);
            exp_layout.setVisibility(4);
            helm_show.setImageResource(R.drawable.dual_rate_icon);
            exp_show.setImageResource(R.drawable.exp0);
        } else {
            helm_layout.setVisibility(4);
            exp_layout.setVisibility(PHOTO_SHOW);
            helm_show.setImageResource(R.drawable.dual_rate_icon0);
            exp_show.setImageResource(R.drawable.exp);
        }
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
        } else if (helmFlag == 3) {
            this.hbigdi.setText(BarHelmbt + "%");
            this.hsmalldi.setText(BarHelmst + "%");
            if (BarBET == 0 || BarSET == 0) {
                if (BarBET == 0) {
                    this.ebigdi.setText("beeline");
                } else {
                    this.ebigdi.setText(BarBET + "%");
                }
                if (BarSET == 0) {
                    this.esmalldi.setText("beeline");
                } else {
                    this.esmalldi.setText(BarSET + "%");
                }
            } else {
                this.ebigdi.setText(BarBET + "%");
                this.esmalldi.setText(BarSET + "%");
            }
        }
        helmSpinner.setSelection(helmFlag);
        helmSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (RunSurfaceView.helmSpinner.getSelectedItem().toString() == "ELEV") {
                    RunSurfaceView.helmFlag = RunSurfaceView.PHOTO_SHOW;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmbe + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmse + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBEE + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSEE + "%");
                } else if (RunSurfaceView.helmSpinner.getSelectedItem().toString() == "AILE") {
                    RunSurfaceView.helmFlag = RunSurfaceView.AV_SHOW;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmba + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmsa + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBEA + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSEA + "%");
                } else if (RunSurfaceView.helmSpinner.getSelectedItem().toString() == "RUDD") {
                    RunSurfaceView.helmFlag = 2;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmbr + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmsr + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBER + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSER + "%");
                } else if (RunSurfaceView.helmSpinner.getSelectedItem().toString() == "THRO") {
                    RunSurfaceView.helmFlag = 3;
                    RunSurfaceView.this.hbigdi.setText(RunSurfaceView.BarHelmbt + "%");
                    RunSurfaceView.this.hsmalldi.setText(RunSurfaceView.BarHelmst + "%");
                    RunSurfaceView.this.ebigdi.setText(RunSurfaceView.BarBET + "%");
                    RunSurfaceView.this.esmalldi.setText(RunSurfaceView.BarSET + "%");
                }
                RunSurfaceView.elevcurve.invalidate();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        helmSpinner.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });
        helm_show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.helmexpFlag = true;
                RunSurfaceView.helm_layout.setVisibility(RunSurfaceView.PHOTO_SHOW);
                RunSurfaceView.exp_layout.setVisibility(4);
                RunSurfaceView.helm_show.setImageResource(R.drawable.dual_rate_icon);
                RunSurfaceView.exp_show.setImageResource(R.drawable.exp0);
            }
        });
        exp_show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RunSurfaceView.helmexpFlag = false;
                RunSurfaceView.helm_layout.setVisibility(4);
                RunSurfaceView.exp_layout.setVisibility(RunSurfaceView.PHOTO_SHOW);
                RunSurfaceView.helm_show.setImageResource(R.drawable.dual_rate_icon0);
                RunSurfaceView.exp_show.setImageResource(R.drawable.exp);
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
        } else if (helmFlag == 3) {
            BarHelmbt--;
            if (BarHelmbt < 0) {
                BarHelmbt = PHOTO_SHOW;
            }
            temp = BarHelmbt;
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
        } else if (helmFlag == 3) {
            BarBET--;
            if (BarBET < -100) {
                BarBET = -100;
            }
            temp = BarBET;
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
        } else if (helmFlag == 3) {
            BarHelmst--;
            if (BarHelmst < 0) {
                BarHelmst = PHOTO_SHOW;
            }
            temp = BarHelmst;
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
        } else if (helmFlag == 3) {
            BarSET--;
            if (BarSET < -100) {
                BarSET = -100;
            }
            temp = BarSET;
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
        } else if (helmFlag == 3) {
            BarHelmbt += AV_SHOW;
            if (BarHelmbt > 125) {
                BarHelmbt = 125;
            }
            temp = BarHelmbt;
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
        } else if (helmFlag == 3) {
            BarBET += AV_SHOW;
            if (BarBET > 100) {
                BarBET = 100;
            }
            temp = BarBET;
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
        } else if (helmFlag == 3) {
            BarHelmst += AV_SHOW;
            if (BarHelmst > 125) {
                BarHelmst = 125;
            }
            temp = BarHelmst;
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
        } else if (helmFlag == 3) {
            BarSET += AV_SHOW;
            if (BarSET > 100) {
                BarSET = 100;
            }
            temp = BarSET;
        }
        this.esmalldi.setText(new StringBuilder(String.valueOf(temp)).append("%").toString());
        elevcurve.postInvalidate();
    }

    public static void picRecycle() {
        if (mbitmap != null && Helicopter.end) {
            mbitmap.recycle();
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
            wificonbmp.recycle();
            setbmp.recycle();
            mbitmap = null;
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
            wificonbmp = null;
            setbmp = null;
            ballGradient = null;
            ballBackGradient = null;
            ballBackGradient0 = null;
            ballGradient0 = null;
            balll.setCallback(null);
            ballr.setCallback(null);
            ballbackl.setCallback(null);
            ballbackr.setCallback(null);
            ballbackl0.setCallback(null);
            ballbackr0.setCallback(null);
            balll = null;
            ballr = null;
            ballbackl = null;
            ballbackr = null;
            ballbackl0 = null;
            ballbackr0 = null;
            matrix = null;
            paint = null;
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
        if (popupWindow3 != null) {
            if (popupWindow3.isShowing()) {
                popupWindow3.dismiss();
            }
            popupWindow3 = null;
        }
        popNo = PHOTO_SHOW;
    }

    void initState() {
        lefth = false;
        righth = false;
        leftflag = false;
        rightflag = false;
        balllDFlag = false;
        ballrDFlag = false;
        balllUFlag = true;
        ballrUFlag = true;
        throQty = (short) 0;
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
            case Constant.MANUAL /*2*/:
            case 4:
                return WIFI_STATE_DISABLED;
            case Constant.RUN /*3*/:
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
        cool = false;
        cno = PHOTO_SHOW;
        isOn = false;
        isOnFlag = false;
        initState();
        this.PagesFlag = false;
        PhotosFlag = true;
        this.photoing = false;
        runFlag = false;
        wifiConFlag = false;
        pvshowFlag = false;
        MjpgRunFlag = false;
        scrollFlag = true;
        scrollHFlag = true;
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
                    RunSurfaceView.returnFlag = false;
                    RunSurfaceView.takeoffFlag = false;
                    RunSurfaceView.landonFlag = false;
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
