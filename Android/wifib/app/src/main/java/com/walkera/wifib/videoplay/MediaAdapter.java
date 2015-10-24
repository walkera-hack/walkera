package com.walkera.wifib.videoplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.walkera.wifib.R;
import java.util.List;
import java.util.Map;

public class MediaAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private TextView mediaNameView;
    private TextView mediaNameViewCache;
    private int resource;
    private Map<String, Object> videoMap;
    private List<Map<String, Object>> videolist;

    public MediaAdapter(Context context, int resource, List<Map<String, Object>> videolist) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.resource = resource;
        this.videolist = videolist;
    }

    public int getCount() {
        return this.videolist.size();
    }

    public Object getItem(int position) {
        return this.videolist.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(this.resource, null);
            this.mediaNameView = (TextView) convertView.findViewById(R.id.mediaName);
            this.mediaNameViewCache = this.mediaNameView;
            convertView.setTag(this.mediaNameViewCache);
        } else {
            this.mediaNameView = (TextView) convertView.getTag();
        }
        this.videoMap = (Map) this.videolist.get(position);
        this.mediaNameView.setText((String) this.videoMap.get("name"));
        return convertView;
    }
}
