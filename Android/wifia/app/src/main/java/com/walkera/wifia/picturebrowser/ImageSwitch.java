package com.walkera.wifia.picturebrowser;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.walkera.wifia.R;

public class ImageSwitch extends Activity implements ViewFactory {
    int downX;
    private ImageSwitcher mSwitcher;
    String[] photos;
    int position;
    int size;
    int upX;
    String uri;

    /* renamed from: com.walkera.wifia.picturebrowser.ImageSwitch.1 */
    class C00231 implements OnTouchListener {
        C00231() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 0) {
                ImageSwitch.this.downX = (int) event.getX();
                Log.w("ImageSwitch", " ----------------------- ");
                Log.w("ImageSwitch", " downX = " + ImageSwitch.this.downX);
                return true;
            } else if (event.getAction() != 1) {
                return false;
            } else {
                ImageSwitch.this.upX = (int) event.getX();
                Log.w("ImageSwitch", " upX = " + ImageSwitch.this.upX);
                if (ImageSwitch.this.upX - ImageSwitch.this.downX > 100) {
                    ImageSwitch.this.mSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitch.this, R.anim.popup_enter));
                    ImageSwitch.this.mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitch.this, R.anim.popup_exit));
                    ImageSwitch imageSwitch = ImageSwitch.this;
                    imageSwitch.position--;
                    if (ImageSwitch.this.position <= 0) {
                        ImageSwitch.this.position = 0;
                    }
                    ImageSwitch.this.uri = ImageSwitch.this.photos[ImageSwitch.this.position];
                    ImageSwitch.this.mSwitcher.setImageURI(Uri.parse(ImageSwitch.this.uri));
                    Log.w("ImageSwitch", " 00 position = " + ImageSwitch.this.position);
                    return true;
                } else if (ImageSwitch.this.downX - ImageSwitch.this.upX <= 100) {
                    return true;
                } else {
                    ImageSwitch.this.mSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitch.this, R.anim.popup_enter));
                    ImageSwitch.this.mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitch.this, R.anim.popup_exit));
                    ImageSwitch imageSwitch2 = ImageSwitch.this;
                    imageSwitch2.position++;
                    if (ImageSwitch.this.position >= ImageSwitch.this.size - 1) {
                        ImageSwitch.this.position = ImageSwitch.this.size - 1;
                    }
                    ImageSwitch.this.uri = ImageSwitch.this.photos[ImageSwitch.this.position];
                    ImageSwitch.this.mSwitcher.setImageURI(Uri.parse(ImageSwitch.this.uri));
                    Log.w("ImageSwitch", " 11 position = " + ImageSwitch.this.position);
                    return true;
                }
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.imageswitcher);
        this.position = getIntent().getIntExtra("POSITION", 0);
        this.size = getIntent().getIntExtra("SIZE", 0);
        this.photos = getIntent().getStringArrayExtra("URIS");
        this.mSwitcher = (ImageSwitcher) findViewById(R.id.switcher0);
        this.mSwitcher.setFactory(this);
        this.mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.popup_enter));
        this.mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.popup_exit));
        this.uri = this.photos[this.position];
        Log.w("ImageSwitch", " uri      = " + this.uri);
        Log.w("ImageSwitch", " size     = " + this.size);
        Log.w("ImageSwitch", " position = " + this.position);
        this.mSwitcher.setImageURI(Uri.parse(this.uri));
        this.mSwitcher.setOnTouchListener(new C00231());
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        setResult(-1);
        finish();
        return true;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        this.mSwitcher.setImageURI(Uri.parse(this.uri));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(Color.BLACK);
        i.setScaleType(ScaleType.FIT_XY);
        i.setLayoutParams(new LayoutParams(-1, -1));
        return i;
    }
}
