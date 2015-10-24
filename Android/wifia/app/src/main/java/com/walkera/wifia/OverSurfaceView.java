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
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.walkera.wifia.R;

public class OverSurfaceView extends SurfaceView implements Callback {
    static Bitmap overbmp;
    static boolean runFlag;
    static boolean runend;
    static int xleft;
    static int ytop;

    public class AnimationListen implements AnimationListener {

        /* renamed from: com.walkera.wifia.OverSurfaceView.AnimationListen.1 */
        class C00031 extends Thread {
            C00031() {
            }

            public void run() {
                while (OverSurfaceView.runFlag) {
                    try {
                        Thread.sleep(50);
                        if (OverSurfaceView.runend) {
                            OverSurfaceView.runFlag = false;
                            Helicopter.onFinish();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void onAnimationEnd(Animation animation) {
            OverSurfaceView.runend = true;
            new C00031().start();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static {
        runFlag = true;
        runend = false;
    }

    public OverSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public OverSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setBackgroundColor(17170446);
    }

    public static void init() {
        overbmp = BitmapFactory.decodeResource(Helicopter.context.getResources(), R.drawable.over);
        overbmp = Helicopter.ToFit(overbmp, Helicopter.scales0);
        xleft = (Helicopter.screenWidth / 2) - (overbmp.getWidth() / 2);
        ytop = (Helicopter.screenHeight / 2) - (overbmp.getHeight() / 2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(overbmp, (float) xleft, (float) ytop, null);
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, e);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    public static void picRecycle() {
        if (overbmp != null) {
            overbmp.recycle();
            overbmp = null;
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
        runend = false;
        runFlag = true;
        init();
        getAnimation().setAnimationListener(new AnimationListen());
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        runFlag = false;
    }
}
