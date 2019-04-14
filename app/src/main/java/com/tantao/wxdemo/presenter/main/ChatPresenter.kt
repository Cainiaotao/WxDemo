package com.tantao.wxdemo.presenter.main


import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.main.ChatContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class ChatPresenter(mView:ChatContract.IView): BasePresenter<ChatContract.IView>(),ChatContract.Presenter {
    val view:ChatContract.IView = mView

}