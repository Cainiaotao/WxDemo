package com.tantao.wxdemo.presenter.main


import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.main.ContactContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class ContactPresenter(mView: ContactContract.IView): BasePresenter<ContactContract.IView>(),ContactContract.Presenter {
    val view:ContactContract.IView = mView

}