package com.walkera.wifib.picturebrowser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.walkera.wifib.R;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<String> list;
    private Context mContext;
    private int mGalleryItemBackground;
    Bitmap oldImage;

    public ImageAdapter(Context c, List<String> list) {
        this.mContext = c;
        this.list = list;
        /*TypedArray typedArray = this.mContext.obtainStyledAttributes(R.styleable.Gallery);
        this.mGalleryItemBackground = typedArray.getResourceId(0, 0);
        typedArray.recycle();*/
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public ImageView createReflectedImages(String filePath) {
        Bitmap originalImage = BitmapFactory.decodeFile(filePath);
        if (originalImage == null) {
            originalImage = this.oldImage;
        } else {
            this.oldImage = originalImage;
        }
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height / 2, width, height / 2, matrix, false);
        Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height / 2) + height, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapWithReflection);
        canvas.drawBitmap(originalImage, 0.0f, 0.0f, null);
        canvas.drawRect(0.0f, (float) height, (float) width, (float) (height + 4), new Paint());
        canvas.drawBitmap(reflectionImage, 0.0f, (float) (height + 4), null);
        Paint paint = new Paint();
        Paint paint2 = paint;
        paint2.setShader(new LinearGradient(0.0f, (float) originalImage.getHeight(), 0.0f, (float) (bitmapWithReflection.getHeight() + 4), 1895825407, 16777215, TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, (float) height, (float) width, (float) (bitmapWithReflection.getHeight() + 4), paint);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageBitmap(bitmapWithReflection);
        imageView.setLayoutParams(new LayoutParams(180, 240));
        imageView.setBackgroundResource(this.mGalleryItemBackground);
        return imageView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return createReflectedImages((String) this.list.get(position));
    }

    public float getScale(boolean focused, int offset) {
        return Math.max(0.0f, 1.0f / ((float) Math.pow(2.0d, (double) Math.abs(offset))));
    }
}
