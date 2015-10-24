package com.walkera.wifia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.walkera.wifia.R;

public class ThemeSurfaceView extends SurfaceView implements Callback {
    static int count;
    static int densityDpi;
    static int f14h;
    static boolean loadFlag;
    static float scaleHeight;
    static float scaleWidth;
    static float scalef;
    static float scales;
    static float scales0;
    static float scales1;
    static int screenHeight;
    static int screenWidth;
    static Bitmap theme;
    static int f15w;
    static int xhalf;
    static int xleft;
    static int xright;
    static int ybottom;
    static int yhalf;
    static int ytop;

    /* renamed from: com.walkera.wifia.ThemeSurfaceView.1 */
    class C00151 extends Thread {
        C00151() {
        }

        public void run() {
            while (ThemeSurfaceView.loadFlag) {
                try {
                    Thread.sleep(20);
                    ThemeSurfaceView.count++;
                    if (ThemeSurfaceView.count == 20) {
                        RunSurfaceView.init();
                        LogoSurfaceView.init();
                        OverSurfaceView.init();
                        Helicopter.setView(2);
                        ThemeSurfaceView.loadFlag = false;
                        ThemeSurfaceView.count = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ThemeSurfaceView.count++;
                    if (ThemeSurfaceView.count == 20) {
                        RunSurfaceView.init();
                        LogoSurfaceView.init();
                        OverSurfaceView.init();
                        Helicopter.setView(2);
                        ThemeSurfaceView.loadFlag = false;
                        ThemeSurfaceView.count = 0;
                    }
                } catch (Throwable th) {
                    ThemeSurfaceView.count++;
                    if (ThemeSurfaceView.count == 20) {
                        RunSurfaceView.init();
                        LogoSurfaceView.init();
                        OverSurfaceView.init();
                        Helicopter.setView(2);
                        ThemeSurfaceView.loadFlag = false;
                        ThemeSurfaceView.count = 0;
                    }
                }
            }
        }
    }

    static {
        scales0 = 1.0f;
        scales1 = 1.0f;
        scaleWidth = 1.0f;
        scaleHeight = 1.0f;
        loadFlag = true;
        count = 0;
    }

    public ThemeSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public ThemeSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public static void init() {
        theme = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.theme);
        screenHeight = Helicopter.screenHeight;
        screenWidth = Helicopter.screenWidth;
        densityDpi = Helicopter.densityDpi;
        f15w = theme.getWidth();
        f14h = theme.getHeight();
        if (densityDpi > 160) {
            scalef = 160.0f / ((float) densityDpi);
        } else {
            scalef = 160.0f / ((float) densityDpi);
        }
        theme = Helicopter.ToFit(theme, scalef);
        f15w = theme.getWidth();
        f14h = theme.getHeight();
        if (f15w <= screenWidth && f14h <= screenHeight) {
            if (Math.abs(screenWidth - f15w) <= Math.abs(screenHeight - f14h)) {
                scales0 = (scaleWidth * ((float) screenWidth)) / ((float) f15w);
            } else {
                scales0 = (scaleHeight * ((float) screenHeight)) / ((float) f14h);
            }
        }
        if (f15w > screenWidth || f14h > screenHeight) {
            if (Math.abs(screenWidth - f15w) >= Math.abs(screenHeight - f14h)) {
                scales0 = (scaleWidth * ((float) screenWidth)) / ((float) f15w);
            } else {
                scales0 = (scaleHeight * ((float) screenHeight)) / ((float) f14h);
            }
        }
        theme = Helicopter.ToFit(theme, scales0);
        f15w = theme.getWidth();
        f14h = theme.getHeight();
        if (f15w > screenWidth || f14h > screenHeight) {
            if (Math.abs(screenWidth - f15w) >= Math.abs(screenHeight - f14h)) {
                scales1 = (scaleWidth * ((float) screenWidth)) / ((float) f15w);
            } else {
                scales1 = (scaleHeight * ((float) screenHeight)) / ((float) f14h);
            }
        }
        theme = Helicopter.ToFit(theme, scales1);
        f15w = theme.getWidth();
        f14h = theme.getHeight();
        scales = scales0 * scales1;
        scales0 = (scales0 * scales1) * scalef;
        Helicopter.scales = scales;
        Helicopter.scales0 = scales0;
        yhalf = screenHeight / 2;
        xhalf = screenWidth / 2;
        xleft = xhalf - (f15w / 2);
        xright = xhalf + (f15w / 2);
        ytop = yhalf - (f14h / 2);
        ybottom = yhalf + (f14h / 2);
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, e);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public static void picRecycle() {
        if (theme != null) {
            theme.recycle();
            theme = null;
        }
        System.gc();
        System.runFinalization();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(theme, (float) xleft, (float) ytop, null);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
        loadFlag = true;
        count = 0;
        new C00151().start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        loadFlag = false;
        count = 0;
        picRecycle();
    }
}
