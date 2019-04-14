package com.tantao.wxdemo.bean

import com.chad.library.adapter.base.entity.SectionEntity

/**
 * @author：tantao
 * @date：2019/4/4
 */
class ContactSection : SectionEntity<ContactUser> {

    var isMore:Boolean = false

    constructor(isHeader: Boolean, header: String,isMore:Boolean) : super(isHeader, header){
        this.isMore = isMore
    }

    constructor(contactUser: ContactUser) : super(contactUser)
}
