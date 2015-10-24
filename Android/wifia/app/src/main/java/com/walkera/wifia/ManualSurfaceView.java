package com.walkera.wifia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import java.lang.ref.SoftReference;
import com.walkera.wifia.R;

public class ManualSurfaceView extends SurfaceView implements Callback {
    static Bitmap[] bitmap0;
    static SoftReference<Bitmap> bmp;
    static Bitmap bmp0;
    static boolean cool;
    static int f4h;
    static PopupWindow popupWindow;
    static float scales0;
    static View view;
    static int f5w;
    Context context;
    ImageView mView;
    Helicopter myActivity;
    boolean running;

    static {
        cool = false;
        bitmap0 = new Bitmap[6];
        scales0 = 1.0f;
    }

    public ManualSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setLongClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        cool = true;
        setBackgroundColor(17170446);
    }

    public ManualSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setLongClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        cool = true;
        setBackgroundColor(17170446);
    }

    public void showWindow() {
        f5w = ThemeSurfaceView.f15w;
        f4h = ThemeSurfaceView.f14h;
        view = Helicopter.layoutInflater.inflate(R.layout.manual, null);
        popupWindow = new PopupWindow(view, f5w, f4h);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.viewAnimation);
        popupWindow.showAtLocation(view, 17, 0, 0);
        popupWindow.update();
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        Helicopter.setView(Helicopter.viewOldFlag);
        return true;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceCreated(SurfaceHolder holder) {
        showWindow();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        if (popupWindow.isShowing()) {
            popupWindow.setBackgroundDrawable(null);
            popupWindow.dismiss();
            popupWindow = null;
        }
        this.running = false;
    }
}
