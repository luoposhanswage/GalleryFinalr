package cn.finalteam.galleryfinal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Desction:
 * Author:pengjianbo
 * Date:2015/12/24 0024 20:14
 */
public class GFImageView extends ImageView {

    private ImageViewListener mImageViewListener;

    public GFImageView(Context context) {
        super(context);
    }

    public GFImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GFImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageViewListener(ImageViewListener imageViewListener) {
        mImageViewListener = imageViewListener;
    }

    public static class ImageViewListener {
        public void onDetach() {
        }

        public void onAttach() {
        }

        public boolean verifyDrawable(Drawable dr) {
            return false;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mImageViewListener.onDetach();
        super.onDetachedFromWindow();
    }

    @Override
    protected void onAttachedToWindow() {
        mImageViewListener.onAttach();
        super.onAttachedToWindow();
    }

    @Override
    protected boolean verifyDrawable(Drawable dr) {
        if (mImageViewListener.verifyDrawable(dr)) {
            return true;
        }
        return super.verifyDrawable(dr);
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        mImageViewListener.onDetach();
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        mImageViewListener.onAttach();
    }

}
