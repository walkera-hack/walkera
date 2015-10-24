package com.walkera.wifib.picturebrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.walkera.wifib.R;
import com.walkera.wifib.videoplay.VideoBrowser;

public class PhotoVideoBrowser extends Activity {
    private ImageView photos;
    private ImageView videos;

    /* renamed from: com.walkera.wifib.picturebrowser.PhotoVideoBrowser.1 */
    class C00281 implements OnClickListener {
        C00281() {
        }

        public void onClick(View v) {
            PhotoVideoBrowser.this.startActivity(new Intent(PhotoVideoBrowser.this, PictureBrowser.class));
        }
    }

    /* renamed from: com.walkera.wifib.picturebrowser.PhotoVideoBrowser.2 */
    class C00292 implements OnClickListener {
        C00292() {
        }

        public void onClick(View v) {
            PhotoVideoBrowser.this.startActivity(new Intent(PhotoVideoBrowser.this, VideoBrowser.class));
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(7);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawableResource(R.drawable.bg0);
        setContentView(R.layout.photo_video);
        this.photos = (ImageView) findViewById(R.id.photos);
        this.videos = (ImageView) findViewById(R.id.videos);
        this.photos.setOnClickListener(new C00281());
        this.videos.setOnClickListener(new C00292());
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
