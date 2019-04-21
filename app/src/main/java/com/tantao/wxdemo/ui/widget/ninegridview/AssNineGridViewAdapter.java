package com.tantao.wxdemo.ui.widget.ninegridview;

import android.content.Context;
import android.widget.ImageView;
import com.tantao.wxdemo.R;
import com.tantao.wxdemo.ui.widget.ProgressImageView;

import java.io.Serializable;
import java.util.List;

/**
 * @author assionhonty
 * Created on 2018/9/19 8:39.
 * Email：assionhonty@126.com
 * Function:适配器
 */
public class AssNineGridViewAdapter implements Serializable {

    protected Context context;
    private List<String> imageInfo;

    public AssNineGridViewAdapter(Context context, List<String> imageInfo) {
        this.context = context;
        this.imageInfo = imageInfo;
    }

    /**
     * 如果要实现图片点击的逻辑，重写此方法即可
     *
     * @param context      上下文
     * @param angv         九宫格控件
     * @param index        当前点击图片的的索引
     * @param imageInfo    图片地址的数据集合
     */
    public void onImageItemClick(Context context, AssNineGridView angv, int index, List<String> imageInfo) {
    }

    /**
     * 生成ImageView容器的方式，默认使用AssNineGridImageViewWrapper类，即点击图片后，图片会有蒙板效果
     * 如果需要自定义图片展示效果，重写此方法即可
     *
     * @param context 上下文
     * @return 生成的 ImageView
     */
    public ProgressImageView generateImageView(Context context) {
//        AssNineGridViewWrapper imageView = new AssNineGridViewWrapper(context);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageResource(R.drawable.ic_default_color);

        ProgressImageView imageView =new  ProgressImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_default_color);
        return imageView;
    }

    public List<String> getImageInfo() {
        return imageInfo;
    }

    public void setImageInfoList(List<String> imageInfo) {
        this.imageInfo = imageInfo;
    }
}
