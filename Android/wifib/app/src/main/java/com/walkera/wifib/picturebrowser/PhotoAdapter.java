package com.walkera.wifib.picturebrowser;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.walkera.wifib.R;
import java.util.List;
import java.util.Map;

public class PhotoAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private TextView mediaNameView;
    private TextView mediaNameViewCache;
    private ImageView photoView;
    private List<Map<String, Object>> photolist;
    private int resource;
    private Map<String, Object> videoMap;

    public PhotoAdapter(Context context, int resource, List<Map<String, Object>> photolist) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.resource = resource;
        this.photolist = photolist;
    }

    public int getCount() {
        return this.photolist.size();
    }

    public Object getItem(int position) {
        return this.photolist.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(this.resource, null);
            this.mediaNameView = (TextView) convertView.findViewById(R.id.photoName);
            this.photoView = (ImageView) convertView.findViewById(R.id.photo);
            this.mediaNameViewCache = this.mediaNameView;
            convertView.setTag(this.mediaNameViewCache);
        } else {
            this.mediaNameView = (TextView) convertView.getTag();
        }
        this.videoMap = (Map) this.photolist.get(position);
        this.mediaNameView.setText((String) this.videoMap.get("name"));
        this.photoView.setImageURI(Uri.parse((String) this.videoMap.get("path")));
        return convertView;
    }
}
