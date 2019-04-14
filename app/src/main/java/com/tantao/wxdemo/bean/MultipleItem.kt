package com.tantao.wxdemo.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/4/5
 *
 */
class MultipleItem :MultiItemEntity {

    companion object {
        const val ITEM_TEXT:Int = 1
        const val ITEM_IMG_TEXT:Int = 2
        const val ITEM_VIDEO:Int = 3
        const val ITEM_AUDIO:Int = 4
        const val ITEM_ADV:Int = 5
    }

    private var itemType:Int = 0

    private var content:String = "文本"
    private var pictures = ArrayList<String>() //图片
    private var videoUrl:String = ""//视频
    private var audioUrl:String = ""//语音



    //纯文本
    constructor(itemType: Int, content: String) {
        this.itemType = itemType
        this.content = content
    }

    //图片+文本
    constructor(itemType: Int, content: String, pictures: ArrayList<String>) {
        this.itemType = itemType
        this.content = content
        this.pictures = pictures
    }

    //视频+文本
    constructor(itemType: Int, content: String, videoUrl: String, audioUrl: String) {
        this.itemType = itemType
        this.content = content
        this.videoUrl = videoUrl
        this.audioUrl = audioUrl
    }


    override fun getItemType(): Int {
        return itemType
    }
}