package com.tantao.wxdemo.presenter.main


import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.main.DiscoverContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/23
 *
 */
class DiscoverPresenter(mView: DiscoverContract.IView): BasePresenter<DiscoverContract.IView>(),DiscoverContract.Presenter {
    val view:DiscoverContract.IView = mView

}