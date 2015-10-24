package com.walkera.wifib.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.walkera.wifib.R;
import com.walkera.wifib.Constant;

public class CompassActivity extends Activity {
    ImageView compass_p;
    ImageView compass_pointer;
    LinearLayout mAngleLayout;
    protected final Handler mHandler;
    LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private String mLocationProvider;
    TextView mLocationTextView;
    private Sensor mOrientationSensor;
    private SensorEventListener mOrientationSensorEventListener;
    private SensorManager mSensorManager;
    private float mTargetDirection;
    private float predegree;

    /* renamed from: com.walkera.wifib.compass.CompassActivity.1 */
    class C00221 implements SensorEventListener {
        C00221() {
        }

        public void onSensorChanged(SensorEvent event) {
            CompassActivity.this.mTargetDirection = CompassActivity.this.normalizeDegree(event.values[0] * -1.0f);
            float degree = event.values[0];
            RotateAnimation animation = new RotateAnimation(CompassActivity.this.predegree, degree, 1, 0.5f, 1, 0.5f);
            animation.setDuration(100);
            CompassActivity.this.compass_pointer.startAnimation(animation);
            CompassActivity.this.predegree = -degree;
            CompassActivity.this.updateDirection();
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    /* renamed from: com.walkera.wifib.compass.CompassActivity.2 */
    class C00232 implements LocationListener {
        C00232() {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            if (status != 0) {
                CompassActivity.this.mLocationTextView.setBackgroundColor(-16744448);
                CompassActivity.this.updateLocation(CompassActivity.this.mLocationManager.getLastKnownLocation(CompassActivity.this.mLocationProvider));
                return;
            }
            CompassActivity.this.mLocationTextView.setBackgroundColor(-3355444);
            CompassActivity.this.mLocationTextView.setText(R.string.cannot_get_location);
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }

        public void onLocationChanged(Location location) {
            CompassActivity.this.updateLocation(location);
        }
    }

    public CompassActivity() {
        this.mHandler = new Handler();
        this.predegree = 0.0f;
        this.mOrientationSensorEventListener = new C00221();
        this.mLocationListener = new C00232();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.compass);
        initResources();
        initServices();
    }

    protected void onResume() {
        super.onResume();
        if (this.mLocationProvider != null) {
            updateLocation(this.mLocationManager.getLastKnownLocation(this.mLocationProvider));
            this.mLocationManager.requestLocationUpdates(this.mLocationProvider, 10000, 10.0f, this.mLocationListener);
        } else {
            this.mLocationTextView.setText(R.string.cannot_get_location);
        }
        if (this.mOrientationSensor != null) {
            this.mSensorManager.registerListener(this.mOrientationSensorEventListener, this.mOrientationSensor, 1);
            return;
        }
        Toast toast = Toast.makeText(this, R.string.cannot_get_sensor, 0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    protected void onPause() {
        super.onPause();
        if (this.mOrientationSensor != null) {
            this.mSensorManager.unregisterListener(this.mOrientationSensorEventListener);
        }
        if (this.mLocationProvider != null) {
            this.mLocationManager.removeUpdates(this.mLocationListener);
        }
    }

    private void initResources() {
        this.mTargetDirection = 0.0f;
        this.compass_pointer = (ImageView) findViewById(R.id.compass_pointer);
        this.mLocationTextView = (TextView) findViewById(R.id.textview_location);
        this.mAngleLayout = (LinearLayout) findViewById(R.id.layout_angle);
    }

    private void initServices() {
        this.mSensorManager = (SensorManager) getSystemService("sensor");
        this.mOrientationSensor = this.mSensorManager.getDefaultSensor(3);
        this.mLocationManager = (LocationManager) getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        this.mLocationProvider = this.mLocationManager.getBestProvider(criteria, true);
    }

    private void updateDirection() {
        LayoutParams lp = new LayoutParams(-2, -2);
        this.mAngleLayout.removeAllViews();
        ImageView east = null;
        ImageView west = null;
        ImageView south = null;
        ImageView north = null;
        float direction = normalizeDegree(this.mTargetDirection * -1.0f);
        if (direction > 22.5f && direction < 157.5f) {
            east = new ImageView(this);
            east.setImageResource(R.drawable.e);
            east.setLayoutParams(lp);
        } else if (direction > 202.5f && direction < 337.5f) {
            west = new ImageView(this);
            west.setImageResource(R.drawable.w);
            west.setLayoutParams(lp);
        }
        if (direction > 112.5f && direction < 247.5f) {
            south = new ImageView(this);
            south.setImageResource(R.drawable.s);
            south.setLayoutParams(lp);
        } else if (((double) direction) < 67.5d || direction > 292.5f) {
            north = new ImageView(this);
            north.setImageResource(R.drawable.n);
            north.setLayoutParams(lp);
        }
        if (south != null) {
            this.mAngleLayout.addView(south);
        }
        if (north != null) {
            this.mAngleLayout.addView(north);
        }
        if (east != null) {
            this.mAngleLayout.addView(east);
        }
        if (west != null) {
            this.mAngleLayout.addView(west);
        }
        int direction2 = (int) direction;
        boolean show = false;
        if (direction2 >= 100) {
            this.mAngleLayout.addView(getNumberImage(direction2 / 100));
            direction2 %= 100;
            show = true;
        }
        if (direction2 >= 10 || show) {
            this.mAngleLayout.addView(getNumberImage(direction2 / 10));
            direction2 %= 10;
        }
        this.mAngleLayout.addView(getNumberImage(direction2));
        ImageView degreeImageView = new ImageView(this);
        degreeImageView.setImageResource(R.drawable.degree);
        degreeImageView.setLayoutParams(lp);
        this.mAngleLayout.addView(degreeImageView);
    }

    private ImageView getNumberImage(int number) {
        ImageView image = new ImageView(this);
        LayoutParams lp = new LayoutParams(-2, -2);
        switch (number) {
            case 0:
                image.setImageResource(R.drawable.number_0);
                break;
            case Constant.LOGO /*1*/:
                image.setImageResource(R.drawable.number_1);
                break;
            case Constant.MANUAL /*2*/:
                image.setImageResource(R.drawable.number_2);
                break;
            case Constant.RUN /*3*/:
                image.setImageResource(R.drawable.number_3);
                break;
            case 4:
                image.setImageResource(R.drawable.number_4);
                break;
            case 5:
                image.setImageResource(R.drawable.number_5);
                break;
            case 6:
                image.setImageResource(R.drawable.number_6);
                break;
            case 7:
                image.setImageResource(R.drawable.number_7);
                break;
            case 8:
                image.setImageResource(R.drawable.number_8);
                break;
            case 9:
                image.setImageResource(R.drawable.number_9);
                break;
        }
        image.setLayoutParams(lp);
        return image;
    }

    private void updateLocation(Location location) {
        if (location == null) {
            this.mLocationTextView.setText(R.string.getting_location);
            return;
        }
        StringBuilder sb = new StringBuilder();
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        if (latitude >= 0.0d) {
            sb.append(getString(R.string.location_north, new Object[]{getLocationString(latitude)}));
        } else {
            sb.append(getString(R.string.location_south, new Object[]{getLocationString(-1.0d * latitude)}));
        }
        sb.append("    ");
        if (longitude >= 0.0d) {
            sb.append(getString(R.string.location_east, new Object[]{getLocationString(longitude)}));
        } else {
            sb.append(getString(R.string.location_west, new Object[]{getLocationString(-1.0d * longitude)}));
        }
        this.mLocationTextView.setText(sb.toString());
    }

    private String getLocationString(double input) {
        int du = (int) input;
        return String.valueOf(du) + "\u00b0" + String.valueOf(((int) ((input - ((double) du)) * 3600.0d)) / 60) + "\u2032" + String.valueOf(((int) ((input - ((double) du)) * 3600.0d)) % 60) + "\u2033";
    }

    private float normalizeDegree(float degree) {
        return (720.0f + degree) % 360.0f;
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        setResult(-1);
        finish();
        return true;
    }
}
