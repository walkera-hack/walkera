package com.walkera.wifib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class GSensor {
    static boolean aFlag;
    static SensorEventListener aSensorListener;
    static short aileQty0;
    static Sensor asensor;
    static float[] axyz;
    static boolean cFlag;
    static SensorEventListener cSensorListener;
    static Context context;
    static Sensor csensor;
    static short elevQty0;
    static float orient_x;
    static SensorManager sm;
    int aa;
    int bb;
    boolean onOff;
    int rr;
    boolean sensorFlag;

    /* renamed from: com.walkera.wifib.GSensor.1 */
    class C00011 implements SensorEventListener {
        C00011() {
        }

        public void onSensorChanged(SensorEvent event) {
            if (GSensor.this.onOff) {
                int hh = 0;
                int ww = 0;
                short elevQty = (short) 0;
                short aileQty = (short) 0;
                System.arraycopy(event.values, 0, GSensor.axyz, 0, 3);
                float pitch = (((float) Math.atan2((double) GSensor.axyz[0], (double) GSensor.axyz[2])) * 180.0f) / Constant.PI;
                float roll = (((float) Math.atan2((double) GSensor.axyz[1], (double) GSensor.axyz[2])) * 180.0f) / Constant.PI;
                if ((5.0f < pitch && pitch <= 60.0f) || (pitch >= -60.0f && pitch < -5.0f)) {
                    elevQty = (short) ((int) (0.0f - ((1600.0f * pitch) / 54.0f)));
                    if (elevQty > Constant.BASEMAX) {
                        elevQty = Constant.BASEMAX;
                    } else if (elevQty < Constant.BASEMIN) {
                        elevQty = Constant.BASEMIN;
                    }
                } else if (pitch < -60.0f) {
                    elevQty = Constant.BASEMAX;
                } else if (pitch > 60.0f) {
                    elevQty = Constant.BASEMIN;
                } else if (roll <= 5.0f && roll >= -5.0f) {
                    elevQty = (short) 0;
                }
                if ((5.0f < roll && roll <= 60.0f) || (roll >= -60.0f && roll < -5.0f)) {
                    aileQty = (short) ((int) (0.0f - ((1600.0f * roll) / 54.0f)));
                    if (aileQty > Constant.BASEMAX) {
                        aileQty = Constant.BASEMAX;
                    } else if (aileQty < Constant.BASEMIN) {
                        aileQty = Constant.BASEMIN;
                    }
                } else if (roll < -60.0f) {
                    aileQty = Constant.BASEMAX;
                } else if (roll > 60.0f) {
                    aileQty = Constant.BASEMIN;
                } else if (roll <= 5.0f && roll >= -5.0f) {
                    aileQty = (short) 0;
                }
                GSensor.elevQty0 = elevQty;
                GSensor.aileQty0 = aileQty;
                if (RunSurfaceView.mode == 4 || RunSurfaceView.mode == 2) {
                    if (GSensor.this.sensorFlag) {
                        GSensor.this.sensorFlag = false;
                        GSensor.this.rr = RunSurfaceView.r0 * RunSurfaceView.r0;
                        if (RunSurfaceView.hiddenFlag) {
                            ww = (RunSurfaceView.f13r - RunSurfaceView.r1) - RunSurfaceView.makex;
                            hh = (RunSurfaceView.hh - RunSurfaceView.r1) - RunSurfaceView.makey;
                        } else {
                            ww = RunSurfaceView.r0 - RunSurfaceView.make;
                            hh = ww;
                        }
                    }
                    if (RunSurfaceView.hiddenFlag) {
                        if (RunSurfaceView.mode == 4) {
                            RunSurfaceView.rightx = (float) (RunSurfaceView.xr - ((RunSurfaceView.aileQty * ww) / 1600));
                            RunSurfaceView.righty = (float) (RunSurfaceView.yr - ((RunSurfaceView.elevQty * hh) / 1600));
                            RunSurfaceView.ballrDFlag = true;
                            RunSurfaceView.ballrUFlag = false;
                            RunSurfaceView.rightflag = false;
                            RunSurfaceView.ballrCFlag = false;
                        } else if (RunSurfaceView.mode == 2) {
                            RunSurfaceView.leftx = (float) (RunSurfaceView.xl - ((RunSurfaceView.aileQty * ww) / 1600));
                            RunSurfaceView.lefty = (float) (RunSurfaceView.yl - ((RunSurfaceView.elevQty * hh) / 1600));
                            RunSurfaceView.balllDFlag = true;
                            RunSurfaceView.balllUFlag = false;
                            RunSurfaceView.leftflag = false;
                            RunSurfaceView.balllCFlag = false;
                        }
                    } else if (RunSurfaceView.mode == 4) {
                        RunSurfaceView.rightx = (float) (RunSurfaceView.xr - ((RunSurfaceView.r0 * RunSurfaceView.aileQty) / 1600));
                        RunSurfaceView.righty = (float) (RunSurfaceView.yr - ((RunSurfaceView.r0 * RunSurfaceView.elevQty) / 1600));
                        GSensor.this.aa = (int) (RunSurfaceView.rightx - ((float) RunSurfaceView.xr));
                        GSensor.this.bb = (int) (RunSurfaceView.righty - ((float) RunSurfaceView.yr));
                        if ((GSensor.this.aa * GSensor.this.aa) + (GSensor.this.bb * GSensor.this.bb) >= GSensor.this.rr) {
                            RunSurfaceView.ballrCFlag = true;
                        } else {
                            RunSurfaceView.ballrCFlag = false;
                        }
                        RunSurfaceView.ballrDFlag = true;
                        RunSurfaceView.ballrUFlag = false;
                        RunSurfaceView.rightflag = false;
                    } else if (RunSurfaceView.mode == 2) {
                        RunSurfaceView.leftx = (float) (RunSurfaceView.xl - ((RunSurfaceView.r0 * RunSurfaceView.aileQty) / 1600));
                        RunSurfaceView.lefty = (float) (RunSurfaceView.yl - ((RunSurfaceView.r0 * RunSurfaceView.elevQty) / 1600));
                        GSensor.this.aa = (int) (RunSurfaceView.leftx - ((float) RunSurfaceView.xl));
                        GSensor.this.bb = (int) (RunSurfaceView.lefty - ((float) RunSurfaceView.yl));
                        if ((GSensor.this.aa * GSensor.this.aa) + (GSensor.this.bb * GSensor.this.bb) >= GSensor.this.rr) {
                            RunSurfaceView.balllCFlag = true;
                        } else {
                            RunSurfaceView.balllCFlag = false;
                        }
                        RunSurfaceView.balllDFlag = true;
                        RunSurfaceView.balllUFlag = false;
                        RunSurfaceView.leftflag = false;
                    }
                }
                if (!EncodeDisplay.transferring) {
                    RunSurfaceView.getValue();
                }
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    /* renamed from: com.walkera.wifib.GSensor.2 */
    class C00022 implements SensorEventListener {
        C00022() {
        }

        public void onSensorChanged(SensorEvent event) {
            if (RunSurfaceView.isOn) {
                GSensor.orient_x = event.values[0];
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    static {
        aFlag = false;
        cFlag = false;
        axyz = new float[3];
    }

    public GSensor(Context context) {
        this.sensorFlag = true;
        this.onOff = false;
        sm = (SensorManager) context.getSystemService("sensor");
        asensor = sm.getDefaultSensor(1);
        if (asensor != null) {
            aFlag = true;
        }
        csensor = sm.getDefaultSensor(3);
        if (csensor != null) {
            cFlag = true;
        }
        aSensorListener = new C00011();
        cSensorListener = new C00022();
    }

    public void GSensorRegister() {
        if (aFlag) {
            sm.registerListener(aSensorListener, asensor, 1);
        }
        if (cFlag) {
            sm.registerListener(cSensorListener, csensor, 1);
        }
        this.sensorFlag = true;
    }

    public void GSensorUnRegister() {
        if (aFlag) {
            sm.unregisterListener(aSensorListener, asensor);
        }
        if (cFlag) {
            sm.unregisterListener(cSensorListener, csensor);
        }
    }
}
