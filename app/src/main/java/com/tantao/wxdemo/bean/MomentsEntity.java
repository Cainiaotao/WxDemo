package com.tantao.wxdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author：tantao
 * @date：2019/4/14
 */
public class MomentsEntity implements MultiItemEntity {

    public static final int ITEM_TEXT = 0;

    private int itemType;
    private String name;

    public MomentsEntity(int itemType, String name) {
        this.itemType = itemType;
        this.name = name;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
