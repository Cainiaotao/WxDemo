package com.tantao.wxdemo.presenter

import com.tantao.wxdemo.presenter.view.BaseView
import com.tantao.wxdemo.presenter.view.IPresenter
import java.lang.ref.WeakReference

/**
 * @deprecated：BasePresenter
 * @author：tantao
 * @date：2019/3/22
 *
 */


abstract class BasePresenter<T:BaseView>: IPresenter {

    var mView:WeakReference<T>?=null

    override fun attachView(view: BaseView) {
       this.mView = WeakReference(cast(view))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> cast(obj: Any): T {
        return obj as T
    }

    fun isAttach():Boolean{
        return mView!=null
    }

    fun obtainView(): T {
        return mView!!.get()!!
    }

    override fun detachView() {
        mView = null
    }
}