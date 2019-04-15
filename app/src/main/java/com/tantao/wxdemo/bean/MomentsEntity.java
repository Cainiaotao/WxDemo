package com.tantao.wxdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tantao
 * @date：2019/4/14
 */
public class MomentsEntity implements MultiItemEntity {

    public static final int ITEM_TEXT = 0;
    public static final int ITEM_IMAGE_WORD = 1;
    public static final int ITEM_ASS_IMAGE = 2;

    private int itemType;
    private String name;
    private List<String> images;

    public MomentsEntity(int itemType, String name, List<String> images) {
        this.itemType = itemType;
        this.name = name;
        this.images = images;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
