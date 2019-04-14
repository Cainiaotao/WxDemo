package com.tantao.wxdemo.presenter.me


import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.me.MineInfoContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class MineInfoPresenter(mView:MineInfoContract.IView): BasePresenter<MineInfoContract.IView>(),MineInfoContract.Presenter {
    val view:MineInfoContract.IView = mView

}