package com.tantao.wxdemo.ui.adapter.recycler;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.tantao.wxdemo.R;
import com.tantao.wxdemo.bean.MomentsEntity;
import com.tantao.wxdemo.ui.widget.ninegridview.AssNineGridView;
import com.tantao.wxdemo.ui.widget.ninegridview.AssNineGridViewAdapter;

import java.util.List;


public class MomentListAdapter extends BaseMultiItemQuickAdapter<MomentsEntity, BaseViewHolder> {
    private Context mContext;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MomentListAdapter(List<MomentsEntity> data,Context context) {
        super(data);
        mContext = context;
        addItemType(MomentsEntity.ITEM_TEXT, R.layout.item_moment_text);
        addItemType(MomentsEntity.ITEM_IMAGE_WORD,R.layout.item_moment_image_word);
        addItemType(MomentsEntity.ITEM_ASS_IMAGE,R.layout.item_moments_ass_grid);
    }

    @Override
    protected void convert(BaseViewHolder helper, MomentsEntity item) {
        switch (helper.getItemViewType()){
            case MomentsEntity.ITEM_TEXT:
                helper.setText(R.id.tv_text,item.getName());
                break;
            case MomentsEntity.ITEM_IMAGE_WORD:
                NineGridImageView ninView=helper.getView(R.id.nine);
                ninView.setAdapter(new NineGridImageViewAdapter<String>(){
                    @Override
                    protected void onDisplayImage(Context context, ImageView imageView, String imgurl) {
                        Glide.with(context).load(imgurl).into(imageView);
                    }
                });
                if (item.getImages()!=null){
                    ninView.setImagesData(item.getImages());
                }
                break;
            case MomentsEntity.ITEM_ASS_IMAGE:
                AssNineGridView assView = helper.getView(R.id.ass);
                assView.setAdapter(new AssNineGridViewAdapter(mContext,item.getImages()));
                break;
        }
    }

}
