package com.tantao.wxdemo.presenter.contract

import com.tantao.wxdemo.presenter.view.BaseView

/**
 * @deprecated：注册方法
 * @author：tantao
 * @date：2019/3/23
 *
 */
interface RegisterContract {

    interface IView: BaseView {
        // result callback view
        fun onRegisterResult()
    }
    interface IModel{

    }


    interface Presenter{
        //view use fun
        fun onRegisterAccount()
    }
}