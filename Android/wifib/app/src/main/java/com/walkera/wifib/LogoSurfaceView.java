package com.walkera.wifib;

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
import android.view.animation.AnimationUtils;

public class LogoSurfaceView extends SurfaceView implements Callback {
    static Bitmap bmp0;
    static Bitmap bmp1;
    static int densityDpi;
    static int f2h;
    static int h0;
    static int h1;
    static int hh;
    static Bitmap logo;
    static float scaleHeight;
    static float scaleWidth;
    static float scalef;
    static float scales;
    static float scales0;
    static float scales1;
    static int screenHeight;
    static int screenWidth;
    static int f3w;
    static int w0;
    static int w1;
    static int xhalf;
    static int xleft;
    static int xright;
    static int ybottom;
    static int yhalf;
    static int ytop;

    static {
        scales0 = 1.0f;
        scales1 = 1.0f;
        scaleWidth = 1.0f;
        scaleHeight = 1.0f;
    }

    public LogoSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public LogoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public static void init() {
        logo = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.logo);
        bmp0 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.go);
        bmp1 = BitmapFactory.decodeResource(Helicopter.resources, R.drawable.i);
        screenHeight = Helicopter.screenHeight;
        screenWidth = Helicopter.screenWidth;
        densityDpi = Helicopter.densityDpi;
        f3w = logo.getWidth();
        f2h = logo.getHeight();
        if (densityDpi > 160) {
            scalef = 160.0f / ((float) densityDpi);
        } else {
            scalef = 160.0f / ((float) densityDpi);
        }
        logo = Helicopter.ToFit(logo, scalef);
        f3w = logo.getWidth();
        f2h = logo.getHeight();
        if (f3w <= screenWidth && f2h <= screenHeight) {
            if (Math.abs(screenWidth - f3w) <= Math.abs(screenHeight - f2h)) {
                scales0 = (scaleWidth * ((float) screenWidth)) / ((float) f3w);
            } else {
                scales0 = (scaleHeight * ((float) screenHeight)) / ((float) f2h);
            }
        }
        if (f3w > screenWidth || f2h > screenHeight) {
            if (Math.abs(screenWidth - f3w) >= Math.abs(screenHeight - f2h)) {
                scales0 = (scaleWidth * ((float) screenWidth)) / ((float) f3w);
            } else {
                scales0 = (scaleHeight * ((float) screenHeight)) / ((float) f2h);
            }
        }
        logo = Helicopter.ToFit(logo, scales0);
        f3w = logo.getWidth();
        f2h = logo.getHeight();
        if (f3w > screenWidth || f2h > screenHeight) {
            if (Math.abs(screenWidth - f3w) >= Math.abs(screenHeight - f2h)) {
                scales1 = (scaleWidth * ((float) screenWidth)) / ((float) f3w);
            } else {
                scales1 = (scaleHeight * ((float) screenHeight)) / ((float) f2h);
            }
        }
        scales = scales0 * scales1;
        scales0 = (scales0 * scales1) * scalef;
        Helicopter.scales = scales;
        Helicopter.scales0 = scales0;
        bmp0 = Helicopter.ToFit(bmp0, Helicopter.scales0);
        bmp1 = Helicopter.ToFit(bmp1, Helicopter.scales0);
        logo = Helicopter.BitmapFit(logo);
        f3w = logo.getWidth();
        f2h = logo.getHeight();
        w0 = bmp0.getWidth();
        h0 = bmp0.getHeight();
        w1 = bmp1.getWidth();
        h1 = bmp1.getHeight();
        hh = (int) (60.0f * scales0);
        yhalf = Helicopter.screenHeight / 2;
        xhalf = Helicopter.screenWidth / 2;
        xleft = 0;
        xright = Helicopter.screenWidth;
        ytop = yhalf - (f2h / 2);
        ybottom = yhalf + (f2h / 2);
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        startAnimation(AnimationUtils.loadAnimation(Helicopter.context, R.anim.viewhidden));
        Helicopter.onFinish();
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            float x = event.getX();
            float y = event.getY();
            if (x > ((float) (xhalf - (w0 / 2))) && x < ((float) (xhalf + (w0 / 2))) && y > ((float) (yhalf + hh)) && y < ((float) ((yhalf + hh) + h0))) {
                Helicopter.setView(3);
                return true;
            } else if (x > ((float) (xright - w1)) && x < ((float) xright) && y > ((float) (ybottom - h1)) && y < ((float) ybottom)) {
                Helicopter.setView(2);
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    public static void picRecycle() {
        if (logo != null) {
            logo.recycle();
            logo = null;
        }
        if (bmp0 != null) {
            bmp0.recycle();
            bmp0 = null;
        }
        if (bmp1 != null) {
            bmp1.recycle();
            bmp1 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(logo, 0.0f, 0.0f, null);
        canvas.drawBitmap(bmp0, (float) (xhalf - (w0 / 2)), (float) (yhalf + hh), null);
        canvas.drawBitmap(bmp1, (float) (xright - w1), (float) (ybottom - h1), null);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
