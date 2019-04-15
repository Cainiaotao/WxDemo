package com.tantao.wxdemo.app

import android.app.Application
import com.tantao.wxdemo.ui.widget.ninegridview.AssNineGridView
import com.tantao.wxdemo.ui.widget.ninegridview.GlideImageLoader

/**
 * <p>文件描述：<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class APP :Application(){

    override fun onCreate() {
        super.onCreate()
        AssNineGridView.setImageLoader(GlideImageLoader())
    }
}