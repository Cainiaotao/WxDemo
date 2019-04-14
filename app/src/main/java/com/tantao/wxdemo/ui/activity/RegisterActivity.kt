package com.tantao.wxdemo.ui.activity

import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.RegisterPresenter
import com.tantao.wxdemo.presenter.contract.RegisterContract
import com.tantao.wxdemo.ui.base.BaseActivity

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/22
 *
 */
class RegisterActivity:BaseActivity<RegisterContract.IView,RegisterPresenter>(),RegisterContract.IView {

    override fun setContentView(): Int = R.layout.activity_register

    override fun createPresenter(): RegisterPresenter  = RegisterPresenter(this)

    override fun onRegisterResult() {

    }
}