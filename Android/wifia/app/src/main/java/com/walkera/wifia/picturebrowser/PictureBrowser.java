package com.walkera.wifia.picturebrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.walkera.wifia.R;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PictureBrowser extends Activity {
    private AlertDialog ad;
    private Builder builder;
    private File[] currentFiles;
    private File currentParent;
    private ListView listView;
    private PictureBrowser myActivity;
    private String path;
    private Button photoBtn;
    private List<Map<String, Object>> photolist;
    private boolean rooFlag;

    /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.1 */
    class C00261 implements OnClickListener {
        C00261() {
        }

        public void onClick(View v) {
            Intent intent = new Intent(PictureBrowser.this, Browser.class);
            intent.putExtra("File", PictureBrowser.this.currentParent.toString());
            PictureBrowser.this.startActivity(intent);
        }
    }

    /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.2 */
    class C00292 implements OnItemLongClickListener {

        /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.2.1 */
        class C00271 implements DialogInterface.OnClickListener {
            private final /* synthetic */ int val$pos;

            C00271(int i) {
                this.val$pos = i;
            }

            public void onClick(DialogInterface dialog, int which) {
                PictureBrowser.deleteFile(PictureBrowser.this.currentFiles[this.val$pos]);
                if (PictureBrowser.this.rooFlag) {
                    PictureBrowser.this.photolist = PictureBrowser.this.inflateListView();
                    PictureBrowser.this.listView.setAdapter(new SimpleAdapter(PictureBrowser.this.myActivity, PictureBrowser.this.photolist, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
                    return;
                }
                PictureBrowser.this.currentFiles = PictureBrowser.this.currentParent.listFiles();
                PictureBrowser.this.photolist = PictureBrowser.this.inflateListView(PictureBrowser.this.currentFiles);
                PictureBrowser.this.listView.setAdapter(new PhotoAdapter(PictureBrowser.this.myActivity, R.layout.photo_row, PictureBrowser.this.photolist));
            }
        }

        /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.2.2 */
        class C00282 implements DialogInterface.OnClickListener {
            C00282() {
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }

        C00292() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            int pos = position;
            PictureBrowser.this.builder = new Builder(PictureBrowser.this.myActivity);
            PictureBrowser.this.builder.setMessage("Are you sure to delete this file!").setPositiveButton("YES", new C00271(pos));
            PictureBrowser.this.builder.setNegativeButton("NO", new C00282());
            PictureBrowser.this.ad = PictureBrowser.this.builder.create();
            PictureBrowser.this.ad.show();
            return true;
        }
    }

    /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.3 */
    class C00303 implements OnItemClickListener {
        C00303() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (PictureBrowser.this.isImageFile(PictureBrowser.this.currentFiles[position].getName())) {
                int size = PictureBrowser.this.photolist.size();
                String[] photos = new String[size];
                for (int i = 0; i < size; i++) {
                    photos[i] = (String) ((Map) PictureBrowser.this.photolist.get(i)).get("path");
                }
                Intent intent = new Intent(PictureBrowser.this, ImageSwitch.class);
                intent.putExtra("POSITION", position);
                intent.putExtra("SIZE", size);
                intent.putExtra("URIS", photos);
                PictureBrowser.this.startActivity(intent);
                return;
            }
            File[] tmp = PictureBrowser.this.currentFiles[position].listFiles();
            if (tmp == null || tmp.length == 0) {
                Toast.makeText(PictureBrowser.this.myActivity, "It cann't be accessed or no file!", 0).show();
                return;
            }
            PictureBrowser.this.currentParent = PictureBrowser.this.currentFiles[position];
            PictureBrowser.this.currentFiles = tmp;
            PictureBrowser.this.photolist = PictureBrowser.this.inflateListView(PictureBrowser.this.currentFiles);
            if (PictureBrowser.this.photolist != null) {
                PictureBrowser.this.listView.setAdapter(new PhotoAdapter(PictureBrowser.this.myActivity, R.layout.photo_row, PictureBrowser.this.photolist));
            }
        }
    }

    /* renamed from: com.walkera.wifia.picturebrowser.PictureBrowser.4 */
    class C00314 implements DialogInterface.OnClickListener {
        C00314() {
        }

        public void onClick(DialogInterface dialog, int which) {
            PictureBrowser.this.setResult(-1);
            PictureBrowser.this.finish();
        }
    }

    public PictureBrowser() {
        this.ad = null;
        this.builder = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myActivity = this;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.photolist);
        this.listView = (ListView) findViewById(R.id.list);
        this.photoBtn = (Button) findViewById(R.id.photoPlay);
        this.photolist = inflateListView();
        this.listView.setAdapter(new SimpleAdapter(this, this.photolist, R.layout.photoline, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
        this.listView.setLongClickable(true);
        this.photoBtn.setOnClickListener(new C00261());
        this.listView.setOnItemLongClickListener(new C00292());
        this.listView.setOnItemClickListener(new C00303());
    }

    public static void deleteFile(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null && files.length > 0) {
                for (File deleteFile : files) {
                    deleteFile(deleteFile);
                }
            }
        }
        f.delete();
    }

    private List<Map<String, Object>> inflateListView() {
        List<Map<String, Object>> listItems = new ArrayList();
        File f = null;
        boolean Flag = false;
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.path = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Photos").toString();
            f = new File(this.path);
            if (!f.exists()) {
                try {
                    f.mkdirs();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Flag = true;
        }
        if (Flag) {
            this.builder = new Builder(this);
            this.builder.setMessage("No SD card error!").setPositiveButton("OK", new C00314());
            this.ad = this.builder.create();
            this.ad.show();
            return null;
        }
        this.rooFlag = true;
        this.currentParent = f;
        this.currentFiles = f.listFiles();
        File[] files0 = f.listFiles();
        int i = 0;
        while (i < files0.length) {
            Map<String, Object> listItem = new HashMap();
            if (files0[i].isDirectory()) {
                listItem.put("icon", Integer.valueOf(R.drawable.folder));
                listItem.put("fileName", files0[i].getName());
                listItems.add(listItem);
            } else if (isImageFile(files0[i].getPath()) && files0[i].length() != 0) {
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(files0[i].lastModified()));
                listItem.put("icon", Integer.valueOf(R.drawable.video));
                listItem.put("name", files0[i].getName());
                listItem.put("path", files0[i].getPath());
                listItem.put("date", str);
                listItem.put("fileName", files0[i].getName());
                listItems.add(listItem);
            }
            i++;
        }
        return listItems;
    }

    private List<Map<String, Object>> inflateListView(File[] files) {
        List<Map<String, Object>> listItems = new ArrayList();
        this.rooFlag = false;
        for (File file : files) {
            if (isImageFile(file.getPath()) && file.length() != 0) {
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                Map<String, Object> videoMap = new HashMap();
                videoMap.put("name", file.getName());
                videoMap.put("path", file.getPath());
                Log.w("PictureBrowser", " file.getPath() = " + file.getPath());
                videoMap.put("date", str);
                listItems.add(videoMap);
            }
        }
        return listItems;
    }

    private boolean isImageFile(String fName) {
        String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg") || end.equals("bmp")) {
            return true;
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, e);
        }
        if (this.rooFlag) {
            setResult(-1);
            finish();
        } else {
            try {
                if (!this.currentParent.getCanonicalPath().equals(this.path)) {
                    this.currentParent = this.currentParent.getParentFile();
                    this.currentFiles = this.currentParent.listFiles();
                    this.photolist = inflateListView();
                    this.listView.setAdapter(new SimpleAdapter(this, this.photolist, R.layout.photoline, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return true;
    }
}
