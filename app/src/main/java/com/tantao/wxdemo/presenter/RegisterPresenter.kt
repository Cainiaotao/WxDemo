package com.tantao.wxdemo.presenter

import com.tantao.wxdemo.presenter.contract.RegisterContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class RegisterPresenter(mView:RegisterContract.IView):BasePresenter<RegisterContract.IView>(),RegisterContract.Presenter {
    val view:RegisterContract.IView = mView

    override fun onRegisterAccount() {

    }
}