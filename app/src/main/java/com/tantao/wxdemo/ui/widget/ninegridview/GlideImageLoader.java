package com.tantao.wxdemo.ui.widget.ninegridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.tantao.wxdemo.ui.widget.ProgressImageView;

/**
 * @author assionhonty
 * Created on 2018/9/19 10:29.
 * Email：assionhonty@126.com
 * Function:
 */
public class GlideImageLoader implements AssNineGridView.ImageLoader{


    @Override
    public void onDisplayImage(Context context, ProgressImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
        imageView.startLoad();
    }

    @Override
    public Bitmap getCacheImage(String url) {
        return null;
    }
}
