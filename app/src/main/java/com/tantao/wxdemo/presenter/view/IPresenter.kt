package com.tantao.wxdemo.presenter.view

/**
 * @deprecated：IPresenter
 * @author：tantao
 * @date：2019/3/22
 *
 */
interface IPresenter {
    fun attachView(view: BaseView)
    fun detachView()
}