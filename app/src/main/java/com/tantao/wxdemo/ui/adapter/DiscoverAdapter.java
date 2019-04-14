package com.tantao.wxdemo.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tantao.wxdemo.R;
import com.tantao.wxdemo.bean.MultipleItem;

import java.util.List;

/**
 * @author：tantao
 * @date：2019/4/5
 */
public class DiscoverAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DiscoverAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.ITEM_TEXT, R.layout.item_discover_text);
        addItemType(MultipleItem.ITEM_IMG_TEXT, R.layout.item_discover_image);
        addItemType(MultipleItem.ITEM_VIDEO, R.layout.item_discover_video);
        addItemType(MultipleItem.ITEM_AUDIO, R.layout.item_discover_audio);
        addItemType(MultipleItem.ITEM_ADV, R.layout.item_discover_adv);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()){
            case MultipleItem.ITEM_TEXT:
                break;
            case MultipleItem.ITEM_IMG_TEXT:
                break;
            case MultipleItem.ITEM_VIDEO:
                break;
            case MultipleItem.ITEM_AUDIO:
                break;
            case MultipleItem.ITEM_ADV:
                break;
            default:
                break;
        }
    }


}
