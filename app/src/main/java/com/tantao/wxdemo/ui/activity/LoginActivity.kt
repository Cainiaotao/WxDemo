package com.tantao.wxdemo.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.LoginPresenter
import com.tantao.wxdemo.presenter.contract.LoginContract
import com.tantao.wxdemo.ui.activity.me.MyInfoActivity
import com.tantao.wxdemo.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @deprecated：登录
 * @author：tantao
 * @date：2019/3/22
 *
 */
class LoginActivity : BaseActivity<LoginContract.IView,LoginPresenter>(),LoginContract.IView{

    override fun createPresenter(): LoginPresenter = LoginPresenter(this)
    override fun setContentView(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        et_phone.clearFocus()
        setStatusBarColor(ContextCompat.getColor(this,R.color.color_white))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //状态栏字体颜色
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun initData() {
        super.initData()
        //mPresenter?.onLogin()
    }

    override fun initListener() {
        super.initListener()
        img_back.setOnClickListener { finish() }
        et_phone.addTextChangedListener(watcher)
        btn_next.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private val watcher:TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           if (s!=null && !TextUtils.isEmpty(s.toString().trim())){
               btn_next.setBackgroundResource(R.drawable.btn_login_next_no_background)
               btn_next.setTextColor(ContextCompat.getColor(this@LoginActivity,R.color.color_white))
           }else{
               btn_next.setBackgroundResource(R.drawable.btn_login_next_background)
               btn_next.setTextColor(ContextCompat.getColor(this@LoginActivity,R.color.color_f5f5f5))
           }
        }
    }

    override fun onLogin() {
       Log.e("TAG","MVP")
    }

    override fun onDestroy() {
        super.onDestroy()
        et_phone.removeTextChangedListener(watcher)
    }

}