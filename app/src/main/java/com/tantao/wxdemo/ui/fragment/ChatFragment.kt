package com.tantao.wxdemo.ui.fragment

import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.main.ChatPresenter
import com.tantao.wxdemo.presenter.contract.main.ChatContract
import com.tantao.wxdemo.ui.base.BaseFragment

/**
 * <p>文件描述：聊天<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class ChatFragment:BaseFragment<ChatContract.IView, ChatPresenter>(),ChatContract.IView {

    override fun setContentView(): Int = R.layout.fragment_chat

    override fun createPresenter(): ChatPresenter =
        ChatPresenter(this)
}