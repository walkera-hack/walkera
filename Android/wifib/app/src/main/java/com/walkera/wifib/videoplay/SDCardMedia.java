package com.walkera.wifib.videoplay;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SDCardMedia {
    private static List<String> pathList;
    private static List<Map<String, Object>> videoDataList;
    private ContentResolver contentResolver;

    public SDCardMedia(Context context) {
        videoDataList = new ArrayList();
        pathList = new ArrayList();
        this.contentResolver = context.getContentResolver();
    }

    public List<Map<String, Object>> getAllVideos() {
        Cursor videoCursor = this.contentResolver.query(Uri.parse(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Videos").toString()), null, null, null, "title");
        if (videoCursor != null) {
            Log.w("SDCardMedia", "getAllVideos videoCursor.getCount()  = " + videoCursor.getCount());
            if (videoCursor.getCount() == 0) {
                return videoDataList;
            }
            while (videoCursor.moveToNext()) {
                String title = videoCursor.getString(videoCursor.getColumnIndex("title"));
                String type = videoCursor.getString(videoCursor.getColumnIndex("mime_type"));
                long size = videoCursor.getLong(videoCursor.getColumnIndex("_size"));
                String path = videoCursor.getString(videoCursor.getColumnIndex("_data"));
                long duration = videoCursor.getLong(videoCursor.getColumnIndex("duration"));
                long createdT = videoCursor.getLong(videoCursor.getColumnIndex("date_modified"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String str = simpleDateFormat.format(new Date(createdT));
                Map<String, Object> videoMap = new HashMap();
                videoMap.put("title", title);
                videoMap.put("type", type);
                videoMap.put("size", Long.valueOf(size));
                videoMap.put("path", path);
                videoMap.put("duration", Long.valueOf(duration));
                videoMap.put("date", str);
                if (videoDataList.isEmpty()) {
                    videoDataList.add(videoMap);
                    pathList.add(path);
                } else if (!pathList.contains(path)) {
                    pathList.add(path);
                    videoDataList.add(videoMap);
                }
            }
            videoCursor.close();
            if (!pathList.isEmpty()) {
                for (int i = 0; i < pathList.size(); i++) {
                    if (!new File((String) pathList.get(i)).exists()) {
                        pathList.remove(i);
                        videoDataList.remove(i);
                    }
                }
            }
            return videoDataList;
        }
        Log.w("SDCardMedia", "getAllVideos videoCursor == null!");
        return videoDataList;
    }

    public static boolean addVideos(String[] filepaths) {
        boolean exist = true;
        int i = 0;
        while (i < filepaths.length) {
            File file = new File(filepaths[i]);
            if (file.exists() && !pathList.contains(filepaths[i])) {
                long size = file.length();
                String title = file.getName().substring(0, file.getName().lastIndexOf("."));
                String path = filepaths[i];
                String type = "video/" + path.substring(path.lastIndexOf(".") + 1).toLowerCase();
                Map<String, Object> videoMap = new HashMap();
                videoMap.put("title", title);
                videoMap.put("type", type);
                videoMap.put("size", Long.valueOf(size));
                videoMap.put("path", path);
                videoDataList.add(videoMap);
                pathList.add(path);
                exist = false;
            }
            i++;
        }
        return exist;
    }

    public static String[] getAllPaths() {
        String[] paths = null;
        if (pathList.isEmpty()) {
            return null;
        }
        paths = new String[pathList.size()];
        for (int i = 0; i < pathList.size(); i++) {
            paths[i] = (String) pathList.get(i);
        }
        return paths;
    }

    public static int scanSDMedia(String rootpath) {
        int count = 0;
        File[] files = new File(rootpath).listFiles();
        if (files == null) {
            return 0;
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                count += scanSDMedia(file.getPath());
            } else if (getMIMEType(files[i]).equals("video")) {
                String path = file.getAbsolutePath();
                if (!pathList.contains(path)) {
                    String title = file.getName().substring(0, file.getName().lastIndexOf("."));
                    String type = "video/" + path.substring(path.lastIndexOf(".") + 1).toLowerCase();
                    long size = file.length();
                    Map<String, Object> videoMap = new HashMap();
                    videoMap.put("title", title);
                    videoMap.put("type", type);
                    videoMap.put("size", Long.valueOf(size));
                    videoMap.put("path", path);
                    videoDataList.add(videoMap);
                    pathList.add(path);
                    count++;
                }
            }
        }
        return count;
    }

    private static String getMIMEType(File f) {
        String type = "";
        String fName = f.getName();
        String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") || end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
            return "audio";
        }
        if (end.equals("3gp") || end.equals("mp4") || end.equals("rmvb") || end.equals("avi") || end.equals("flv") || end.equals("rm") || end.equals("mkv")) {
            return "video";
        }
        if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg") || end.equals("bmp")) {
            return "image";
        }
        return "*";
    }
}
