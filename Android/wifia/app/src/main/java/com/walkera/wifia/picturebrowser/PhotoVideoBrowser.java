package com.walkera.wifia.picturebrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.walkera.wifia.R;
import com.walkera.wifia.videoplay.VideoBrowser;

public class PhotoVideoBrowser extends Activity {
    private ImageView photos;
    private ImageView videos;

    /* renamed from: com.walkera.wifia.picturebrowser.PhotoVideoBrowser.1 */
    class C00241 implements OnClickListener {
        C00241() {
        }

        public void onClick(View v) {
            PhotoVideoBrowser.this.startActivity(new Intent(PhotoVideoBrowser.this, PictureBrowser.class));
        }
    }

    /* renamed from: com.walkera.wifia.picturebrowser.PhotoVideoBrowser.2 */
    class C00252 implements OnClickListener {
        C00252() {
        }

        public void onClick(View v) {
            PhotoVideoBrowser.this.startActivity(new Intent(PhotoVideoBrowser.this, VideoBrowser.class));
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.photo_video);
        this.photos = (ImageView) findViewById(R.id.photos);
        this.videos = (ImageView) findViewById(R.id.videos);
        this.photos.setOnClickListener(new C00241());
        this.videos.setOnClickListener(new C00252());
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
