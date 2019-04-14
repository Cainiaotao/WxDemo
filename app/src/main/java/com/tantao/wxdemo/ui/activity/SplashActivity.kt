package com.tantao.wxdemo.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.SplashPresenter
import com.tantao.wxdemo.presenter.contract.SplashContract
import com.tantao.wxdemo.presenter.view.BaseView
import com.tantao.wxdemo.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @deprecated：闪屏
 * @author：tantao
 * @date：2019/3/22
 *
 */
class SplashActivity:BaseActivity<SplashContract.IView,SplashPresenter>(),SplashContract.IView {


    override fun setContentView(): Int = R.layout.activity_splash

    override fun createPresenter(): SplashPresenter  = SplashPresenter(this)

    override fun beforeSetContentView() {
        super.beforeSetContentView()
        //setFullScreen()
        setStatusBarColor(ContextCompat.getColor(this,R.color.color_black))
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }

    override fun initData() {
        super.initData()
        Handler().postDelayed({
            showLoginBtn()
        },3000)
    }

    override fun initListener() {
        super.initListener()
        btn_login.setOnClickListener {
            jumpToActivity(Intent(this@SplashActivity,LoginActivity::class.java))
            finish()
        }
        btn_register.setOnClickListener {
            jumpToActivity(Intent(this@SplashActivity,RegisterActivity::class.java))
            finish()
        }
    }

    private fun showLoginBtn(){
        btn_login.visibility = View.VISIBLE
        btn_register.visibility = View.VISIBLE
    }

    override fun onShow() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}