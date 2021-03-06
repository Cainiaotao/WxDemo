package com.tantao.wxdemo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.oushangfeng.pinnedsectionitemdecoration.utils.FullSpanUtil;

import java.util.List;

/**
 * @author: tantao
 * @date: 2019/4/13
 * @desc: 带粘性标签的适配器
 */
public abstract class BaseHeaderAdapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, BaseViewHolder>{

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_DATA = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BaseHeaderAdapter(List<T> data) {
        super(data);
        addItemTypes();
    }

    protected abstract void addItemTypes();

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        FullSpanUtil.onAttachedToRecyclerView(recyclerView, this, TYPE_HEADER);
    }

    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        FullSpanUtil.onViewAttachedToWindow(holder, this, TYPE_HEADER);
    }
}
