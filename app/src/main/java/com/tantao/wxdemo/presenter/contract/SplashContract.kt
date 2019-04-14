package com.tantao.wxdemo.presenter.contract

import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.view.BaseView

/**
 * @deprecated：闪屏页
 * @author：tantao
 * @date：2019/3/22
 *
 */
interface SplashContract {
    //View
    interface IView:BaseView{
        fun onShow()
    }

    //model
    interface IModel{
        fun loadData()
    }

    interface Presenter{
        fun contract()
    }

}