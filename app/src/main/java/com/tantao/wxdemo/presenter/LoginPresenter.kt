package com.tantao.wxdemo.presenter

import com.tantao.wxdemo.presenter.contract.LoginContract


/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/22
 *
 */
class LoginPresenter(mView:LoginContract.IView): BasePresenter<LoginContract.IView>(),LoginContract.Presenter{

    var view :LoginContract.IView? = mView

    override fun contract() {

    }

    fun onLogin(){
        view?.onLogin()
    }
}