package com.tantao.wxdemo.bean

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/4/13
 *
 */
class MobileEntiy {

    var phone:String = ""
    var name:String = ""
    var pinyin:String = ""
    var header:String = ""

    constructor(phone: String, name: String, pinyin: String, header: String) {
        this.phone = phone
        this.name = name
        this.pinyin = pinyin
        this.header = header
    }
}