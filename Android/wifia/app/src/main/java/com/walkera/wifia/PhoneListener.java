package com.walkera.wifia;

import android.content.Context;
import android.os.Vibrator;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

public class PhoneListener extends PhoneStateListener {
    static String incomingNumber0;
    static int tel_status;
    static TextView tv;
    static Vibrator vibrator;
    static WindowManager wm;

    static {
        tel_status = -1;
    }

    PhoneListener(Context context) {
        wm = (WindowManager) context.getSystemService("window");
    }

    void dialog() {
        LayoutParams params = new LayoutParams();
        params.type = 2006;
        params.flags = 40;
        params.windowAnimations = 16973828;
        params.setTitle("Incoming Ring:");
        params.width = -2;
        params.height = -2;
        params.gravity = 17;
        params.x = 0;
        params.y = 0;
        params.format = 1;
        params.alpha = 10.0f;
        tv = new TextView(Helicopter.context);
        tv.setText("Ringing No: " + incomingNumber0);
        wm.addView(tv, params);
        Vibrator vibrator = (Vibrator) Helicopter.context.getSystemService("vibrator");
        vibrator = vibrator;
        if (vibrator != null) {
            vibrator.vibrate(new long[]{150, 150, 150, 150}, -1);
        }
    }

    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            case 0:
                tel_status = 0;
                Log.w("##CALL_STATE_IDLE##" + tel_status, "OK!");
                if (tv != null) {
                    wm.removeView(tv);
                }
                if (vibrator != null) {
                    vibrator = null;
                    break;
                }
                break;
            case Constant.THEME /*1*/:
                tel_status = 2;
                Log.w("##CALL_STATE_RINGING##" + tel_status, "OK!");
                incomingNumber0 = incomingNumber;
                dialog();
                break;
            case Constant.LOGO /*2*/:
                tel_status = 1;
                Log.w("##CALL_STATE_OFFHOOK##" + tel_status, "OK!");
                break;
        }
        super.onCallStateChanged(state, incomingNumber);
    }
}
