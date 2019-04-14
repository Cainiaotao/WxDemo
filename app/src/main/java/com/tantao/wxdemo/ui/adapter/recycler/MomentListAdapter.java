package com.tantao.wxdemo.ui.adapter.recycler;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tantao.wxdemo.R;
import com.tantao.wxdemo.bean.MomentsEntity;

import java.util.List;

/**
 * @author：tantao
 * @date：2019/4/14
 */
public class MomentListAdapter extends BaseMultiItemQuickAdapter<MomentsEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MomentListAdapter(List<MomentsEntity> data) {
        super(data);
        addItemType(MomentsEntity.ITEM_TEXT, R.layout.item_moment_text);
    }

    @Override
    protected void convert(BaseViewHolder helper, MomentsEntity item) {
        switch (helper.getItemViewType()){
            case MomentsEntity.ITEM_TEXT:
                helper.setText(R.id.tv_text,item.getName());
                break;
        }
    }
}
