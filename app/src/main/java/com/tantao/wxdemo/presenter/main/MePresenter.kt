package com.tantao.wxdemo.presenter.main


import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.main.MeContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class MePresenter(mView: MeContract.IView): BasePresenter<MeContract.IView>(),MeContract.Presenter {
    val view:MeContract.IView = mView

}