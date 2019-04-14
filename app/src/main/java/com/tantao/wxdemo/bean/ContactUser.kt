package com.tantao.wxdemo.bean

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/4/4
 *
 */
class ContactUser {
    var id:Long = 0L
    var name:String=""
    var avatar:String = ""

    constructor()

    constructor(id: Long, name: String, avatar: String) {
        this.id = id
        this.name = name
        this.avatar = avatar
    }


}