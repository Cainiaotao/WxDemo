package com.tantao.wxdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author：tantao
 * @date：2019/4/13
 */
public class ContactHeaderEntity<T> implements MultiItemEntity {

    private final int itemType;

    private T data;

    private String pinnedHeaderName;

    public ContactHeaderEntity(int itemType, T data, String pinnedHeaderName) {
        this.itemType = itemType;
        this.data = data;
        this.pinnedHeaderName = pinnedHeaderName;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPinnedHeaderName() {
        return pinnedHeaderName;
    }

    public void setPinnedHeaderName(String pinnedHeaderName) {
        this.pinnedHeaderName = pinnedHeaderName;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
