package com.walkera.wifib.picturebrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.walkera.wifib.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Browser extends Activity implements OnItemSelectedListener, ViewFactory {
    static List<String> ImageList;
    static int counts;
    private AlertDialog ad;
    private Builder builder;
    private ImageSwitcher mSwitcher;
    TextView mTextView;

    /* renamed from: com.walkera.wifib.picturebrowser.Browser.1 */
    class C00241 implements OnItemClickListener {
        C00241() {
        }

        public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        }
    }

    /* renamed from: com.walkera.wifib.picturebrowser.Browser.2 */
    class C00252 implements OnClickListener {
        C00252() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Browser.this.setResult(-1);
            Browser.this.finish();
        }
    }

    /* renamed from: com.walkera.wifib.picturebrowser.Browser.3 */
    class C00263 implements OnClickListener {
        C00263() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Browser.this.setResult(-1);
            Browser.this.finish();
        }
    }

    public Browser() {
        this.ad = null;
        this.builder = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.image);
        this.mTextView = (TextView) findViewById(R.id.logo);
        ImageList = getImagesFrom(new File(getIntent().getStringExtra("File")));
        if (ImageList != null && ImageList.size() != 0) {
            this.mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
            this.mSwitcher.setFactory(this);
            this.mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, 17432578));
            this.mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, 17432579));
            Gallery g = (Gallery) findViewById(R.id.mygallery);
            g.setAdapter(new ImageAdapter(this, ImageList));
            g.setOnItemSelectedListener(this);
            g.setOnItemClickListener(new C00241());
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        setResult(-1);
        finish();
        return true;
    }

    private List<String> getImagesFrom(File filepath) {
        List<String> imageList = new ArrayList();
        boolean Flag = false;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Flag = true;
        } else if (!new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Photos").toString()).exists()) {
            Flag = true;
        }
        if (Flag) {
            this.builder = new Builder(this);
            this.builder.setMessage("No SD card error!").setPositiveButton("OK", new C00252());
            this.ad = this.builder.create();
            this.ad.show();
        } else {
            File[] files = filepath.listFiles();
            if (files == null || files.length == 0) {
                this.builder = new Builder(this);
                this.builder.setMessage("No flight picture for browsing...").setPositiveButton("OK", new C00263());
                this.ad = this.builder.create();
                this.ad.show();
            } else {
                counts = 0;
                for (File file : files) {
                    if (isImageFile(file.getPath()) && file.length() != 0) {
                        counts++;
                        imageList.add(file.getPath());
                    } else if (file.isDirectory()) {
                        File[] files0 = file.listFiles();
                        for (File file0 : files0) {
                            if (isImageFile(file0.getPath()) && file0.length() != 0) {
                                imageList.add(file0.getPath());
                            }
                        }
                    }
                }
            }
        }
        return imageList;
    }

    private boolean isImageFile(String fName) {
        String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg") || end.equals("bmp")) {
            return true;
        }
        return false;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String photoURL = (String) ImageList.get(position);
        this.mTextView.setText(photoURL.substring(photoURL.lastIndexOf("/") + 1, photoURL.length()).toLowerCase());
        this.mSwitcher.setImageURI(Uri.parse(photoURL));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(-16777216);
        i.setScaleType(ScaleType.FIT_XY);
        i.setLayoutParams(new LayoutParams(-1, -1));
        return i;
    }
}
