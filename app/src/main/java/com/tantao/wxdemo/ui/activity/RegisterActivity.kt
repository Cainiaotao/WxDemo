package com.tantao.wxdemo.ui.activity

import android.os.Bundle
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.RegisterPresenter
import com.tantao.wxdemo.presenter.contract.RegisterContract
import com.tantao.wxdemo.ui.base.BaseActivity
import com.tantao.wxdemo.ui.widget.VerifyCodeView
import kotlinx.android.synthetic.main.activity_register.*

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/22
 *
 */
class RegisterActivity:BaseActivity<RegisterContract.IView,RegisterPresenter>(),RegisterContract.IView, VerifyCodeView.InputCompleteListener {

    override fun setContentView(): Int = R.layout.activity_register

    override fun createPresenter(): RegisterPresenter  = RegisterPresenter(this)

    override fun onRegisterResult() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }


    override fun initData() {
        super.initData()

        et_verify.setCompleteListener(this)
    }


    override fun onComplete(string: String) {
       showToast(this,string)
    }

    override fun invalidContent() {

    }
}