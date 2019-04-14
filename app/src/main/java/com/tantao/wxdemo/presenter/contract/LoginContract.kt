package com.tantao.wxdemo.presenter.contract

import com.tantao.wxdemo.presenter.view.BaseView

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/22
 *
 */
interface LoginContract {
    interface IView: BaseView {
        fun onLogin()
    }
    interface IModel{

    }

    interface Presenter{
        fun contract()
    }
}