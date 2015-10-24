package com.walkera.wifib.picturebrowser;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryP extends Gallery {
    private Camera mCamera;
    private int mCoveflowCenter;
    private int mMaxRotationAngle;
    private int mMaxZoom;

    public GalleryP(Context context) {
        super(context);
        this.mCamera = new Camera();
        this.mMaxRotationAngle = 60;
        this.mMaxZoom = -120;
        setStaticTransformationsEnabled(true);
    }

    public GalleryP(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCamera = new Camera();
        this.mMaxRotationAngle = 60;
        this.mMaxZoom = -120;
        setStaticTransformationsEnabled(true);
    }

    public GalleryP(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCamera = new Camera();
        this.mMaxRotationAngle = 60;
        this.mMaxZoom = -120;
        setStaticTransformationsEnabled(true);
    }

    public int getMaxRotationAngle() {
        return this.mMaxRotationAngle;
    }

    public void setMaxRotationAngle(int maxRotationAngle) {
        this.mMaxRotationAngle = maxRotationAngle;
    }

    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        this.mMaxZoom = maxZoom;
    }

    private int getCenterOfCoverflow() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    protected boolean getChildStaticTransformation(View child, Transformation tr) {
        int childCenter = getCenterOfView(child);
        int childWidth = child.getWidth();
        tr.clear();
        tr.setTransformationType(Transformation.TYPE_MATRIX);
        if (childCenter == this.mCoveflowCenter) {
            imageBitmapTransform((ImageView) child, tr, 0);
        } else {
            int rotationAngle = (int) ((((float) (this.mCoveflowCenter - childCenter)) / ((float) childWidth)) * ((float) this.mMaxRotationAngle));
            if (Math.abs(rotationAngle) > this.mMaxRotationAngle) {
                rotationAngle = rotationAngle < 0 ? -this.mMaxRotationAngle : this.mMaxRotationAngle;
            }
            imageBitmapTransform((ImageView) child, tr, rotationAngle);
        }
        return true;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void imageBitmapTransform(ImageView child, Transformation tr, int rotationAngle) {
        this.mCamera.save();
        Matrix imageMatrix = tr.getMatrix();
        int imageHeight = child.getLayoutParams().height;
        int imageWidth = child.getLayoutParams().width;
        int rotation = Math.abs(rotationAngle);
        this.mCamera.translate(0.0f, 0.0f, 100.0f);
        if (rotation < this.mMaxRotationAngle) {
            this.mCamera.translate(0.0f, 0.0f, (float) (((double) this.mMaxZoom) + (((double) rotation) * 1.5d)));
        }
        this.mCamera.rotateY((float) rotationAngle);
        this.mCamera.getMatrix(imageMatrix);
        imageMatrix.preTranslate((float) (-(imageWidth / 2)), (float) (-(imageHeight / 2)));
        imageMatrix.postTranslate((float) (imageWidth / 2), (float) (imageHeight / 2));
        this.mCamera.restore();
    }
}
