package com.tantao.wxdemo.util;

import com.tantao.wxdemo.bean.ContactSection;
import com.tantao.wxdemo.bean.ContactUser;
import com.tantao.wxdemo.bean.MultipleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tantao
 * @date：2019/4/4
 * desc : 测试数据
 */
public class DataServer {

    public static List<ContactSection> getSampleData() {
        List<ContactSection> list = new ArrayList<>();
        list.add(new ContactSection(true, "Section 1", true));
        list.add(new ContactSection(new ContactUser(1, "测试1","url")));
        list.add(new ContactSection(new ContactUser(2, "测试2","url")));
        list.add(new ContactSection(new ContactUser(3, "测试3","url")));
        list.add(new ContactSection(new ContactUser(4, "测试4","url")));
        list.add(new ContactSection(true, "Section 2", false));
        list.add(new ContactSection(new ContactUser(5, "测试5","url")));
        list.add(new ContactSection(new ContactUser(6, "测试6","url")));
        list.add(new ContactSection(new ContactUser(7, "测试7","url")));
        list.add(new ContactSection(true, "Section 3", false));
        list.add(new ContactSection(new ContactUser(8, "测试8","url")));
        list.add(new ContactSection(new ContactUser(9, "测试9","url")));
        list.add(new ContactSection(true, "Section 4", false));
        list.add(new ContactSection(new ContactUser(10, "测试10","url")));
        list.add(new ContactSection(new ContactUser(11, "测试11","url")));
        list.add(new ContactSection(true, "Section 5", false));
        list.add(new ContactSection(new ContactUser(12, "测试12","url")));
        list.add(new ContactSection(new ContactUser(13, "测试13","url")));
        return list;
    }

    public static List<MultipleItem> getDiscoverData(){
        List<MultipleItem> list = new ArrayList<>();
        list.add(new MultipleItem(MultipleItem.ITEM_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_VIDEO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_AUDIO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_ADV, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_VIDEO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_AUDIO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_ADV, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_VIDEO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_AUDIO, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_ADV, ""));
        list.add(new MultipleItem(MultipleItem.ITEM_IMG_TEXT, ""));

        return list;
    }
}
