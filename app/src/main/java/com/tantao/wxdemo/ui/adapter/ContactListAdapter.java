package com.tantao.wxdemo.ui.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.tantao.wxdemo.R;
import com.tantao.wxdemo.bean.ContactHeaderEntity;
import com.tantao.wxdemo.bean.MobileEntiy;

import java.util.List;

/**
 * @author：tantao
 * @date：2019/4/13
 */
public class ContactListAdapter  extends  BaseHeaderAdapter<ContactHeaderEntity<MobileEntiy>>{


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ContactListAdapter(List<ContactHeaderEntity<MobileEntiy>> data) {
        super(data);
    }

    @Override
    protected void addItemTypes() {
        addItemType(BaseHeaderAdapter.TYPE_HEADER, R.layout.item_contact_pinned_header);
        addItemType(BaseHeaderAdapter.TYPE_DATA, R.layout.item_contact_child);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactHeaderEntity<MobileEntiy> item) {
        switch (helper.getItemViewType()){
            case BaseHeaderAdapter.TYPE_HEADER:
                helper.setText(R.id.tv_header,item.getPinnedHeaderName());
                break;
            case BaseHeaderAdapter.TYPE_DATA:
                helper.setText(R.id.tv_name,item.getData().getName());
                break;
            default:
                break;
        }
    }
}
