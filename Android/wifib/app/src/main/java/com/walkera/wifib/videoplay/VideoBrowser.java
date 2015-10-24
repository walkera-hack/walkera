package com.walkera.wifib.videoplay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.walkera.wifib.R;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoBrowser extends Activity {
    private AlertDialog ad;
    private Builder builder;
    private File[] currentFiles;
    private File currentParent;
    private ListView listView;
    private VideoBrowser myActivity;
    private String path;
    private boolean rooFlag;
    private Map<String, Object> videoMap;
    private List<Map<String, Object>> videolist;

    /* renamed from: com.walkera.wifib.videoplay.VideoBrowser.1 */
    class C00381 implements OnItemLongClickListener {

        /* renamed from: com.walkera.wifib.videoplay.VideoBrowser.1.1 */
        class C00361 implements OnClickListener {
            private final /* synthetic */ int val$pos;

            C00361(int i) {
                this.val$pos = i;
            }

            public void onClick(DialogInterface dialog, int which) {
                VideoBrowser.deleteFile(VideoBrowser.this.currentFiles[this.val$pos]);
                if (VideoBrowser.this.rooFlag) {
                    VideoBrowser.this.videolist = VideoBrowser.this.inflateListView();
                    VideoBrowser.this.listView.setAdapter(new SimpleAdapter(VideoBrowser.this.myActivity, VideoBrowser.this.videolist, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
                    return;
                }
                VideoBrowser.this.currentFiles = VideoBrowser.this.currentParent.listFiles();
                VideoBrowser.this.videolist = VideoBrowser.this.inflateListView(VideoBrowser.this.currentFiles);
                VideoBrowser.this.listView.setAdapter(new MediaAdapter(VideoBrowser.this.myActivity, R.layout.media_row, VideoBrowser.this.videolist));
            }
        }

        /* renamed from: com.walkera.wifib.videoplay.VideoBrowser.1.2 */
        class C00372 implements OnClickListener {
            C00372() {
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }

        C00381() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            int pos = position;
            VideoBrowser.this.builder = new Builder(VideoBrowser.this.myActivity);
            VideoBrowser.this.builder.setMessage("Are you sure to delete this file!").setPositiveButton("YES", new C00361(pos));
            VideoBrowser.this.builder.setNegativeButton("NO", new C00372());
            VideoBrowser.this.ad = VideoBrowser.this.builder.create();
            VideoBrowser.this.ad.show();
            return true;
        }
    }

    /* renamed from: com.walkera.wifib.videoplay.VideoBrowser.2 */
    class C00392 implements OnItemClickListener {
        C00392() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (VideoBrowser.this.isVideoFile(VideoBrowser.this.currentFiles[position].getName())) {
                VideoBrowser.this.videoMap = (Map) VideoBrowser.this.videolist.get(position);
                Uri uri = Uri.parse((String) VideoBrowser.this.videoMap.get("path"));
                Log.w("VideoBrowser", "video file path = " + uri.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uri, "video/*");
                VideoBrowser.this.startActivity(intent);
                return;
            }
            File[] tmp = VideoBrowser.this.currentFiles[position].listFiles();
            if (tmp == null || tmp.length == 0) {
                Toast.makeText(VideoBrowser.this.myActivity, "Current Path cann't be accessed or no file included!", 0).show();
                return;
            }
            VideoBrowser.this.currentParent = VideoBrowser.this.currentFiles[position];
            VideoBrowser.this.currentFiles = tmp;
            VideoBrowser.this.videolist = VideoBrowser.this.inflateListView(VideoBrowser.this.currentFiles);
            if (VideoBrowser.this.videolist != null) {
                VideoBrowser.this.listView.setAdapter(new MediaAdapter(VideoBrowser.this.myActivity, R.layout.media_row, VideoBrowser.this.videolist));
            }
        }
    }

    /* renamed from: com.walkera.wifib.videoplay.VideoBrowser.3 */
    class C00403 implements OnClickListener {
        C00403() {
        }

        public void onClick(DialogInterface dialog, int which) {
            VideoBrowser.this.setResult(-1);
            VideoBrowser.this.finish();
        }
    }

    public VideoBrowser() {
        this.ad = null;
        this.builder = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myActivity = this;
        requestWindowFeature(7);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawableResource(R.drawable.bg0);
        setContentView(R.layout.medialist);
        this.listView = (ListView) findViewById(R.id.list);
        this.videolist = inflateListView();
        this.listView.setAdapter(new SimpleAdapter(this, this.videolist, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
        this.listView.setLongClickable(true);
        this.listView.setOnItemLongClickListener(new C00381());
        this.listView.setOnItemClickListener(new C00392());
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

    @SuppressLint({"SimpleDateFormat"})
    private List<Map<String, Object>> inflateListView() {
        List<Map<String, Object>> listItems = new ArrayList();
        File f = null;
        boolean Flag = false;
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.path = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Videos").toString();
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
            this.builder.setMessage("No SD card error!").setPositiveButton("OK", new C00403());
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
            } else if (isVideoFile(files0[i].getPath()) && files0[i].length() != 0) {
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
            if (isVideoFile(file.getPath()) && file.length() != 0) {
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                Map<String, Object> videoMap = new HashMap();
                videoMap.put("name", file.getName());
                videoMap.put("path", file.getPath());
                videoMap.put("date", str);
                listItems.add(videoMap);
            }
        }
        return listItems;
    }

    @SuppressLint({"DefaultLocale"})
    private boolean isVideoFile(String fName) {
        String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (end.equals("3gp") || end.equals("mp4") || end.equals("rmvb") || end.equals("avi") || end.equals("mov") || end.equals("flv") || end.equals("rm") || end.equals("mkv")) {
            return true;
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent e) {
        Log.w("MediaListActivity", "onKeyDown happen!");
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
                    this.videolist = inflateListView();
                    this.listView.setAdapter(new SimpleAdapter(this, this.videolist, R.layout.line, new String[]{"icon", "fileName"}, new int[]{R.id.icon, R.id.file_name}));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return true;
    }
}
