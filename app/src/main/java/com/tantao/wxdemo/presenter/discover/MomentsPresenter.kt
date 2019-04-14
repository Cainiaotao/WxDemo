package com.tantao.wxdemo.presenter.discover

import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.contract.discover.MomentsContract

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/4/14
 *
 */
class MomentsPresenter(mView:MomentsContract.IView): BasePresenter<MomentsContract.IView>(),MomentsContract.Presenter {
    val view:MomentsContract.IView = mView

}