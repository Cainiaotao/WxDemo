package com.tantao.wxdemo.ui.base

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.view.BaseView
import com.tantao.wxdemo.util.ActivityManager
import org.greenrobot.eventbus.EventBus
import qiu.niorgai.StatusBarCompat

@Suppress("unchecked")
abstract class BaseActivity<V:BaseView,P:BasePresenter<V>>: AppCompatActivity(),BaseView{

    private var navigationBarColor: Int = R.color.color_white //状态栏背景色

    protected var mPresenter:P?=null

    @LayoutRes
    protected abstract fun setContentView(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeSetContentView()
        setContentView(this.setContentView())
        ActivityManager.getInstance().addActivity(this)
        initPresenter()
        initView(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, navigationBarColor)
        }
        initData()
        initListener()
    }
    private fun initPresenter(){
        mPresenter = createPresenter()
        if (mPresenter!=null){
            mPresenter?.attachView(this)
        }
    }

    override fun providerContext(): Context {
        return this
    }

    protected abstract fun createPresenter(): P
    open fun beforeSetContentView(){}
    open fun initView(savedInstanceState: Bundle?){}
    open fun initData(){}
    open fun initListener(){}

    //透明状态栏 导致布局不被软键盘往上推
    fun setStatusBarTranslucent(){
        StatusBarCompat.translucentStatusBar(this,true)
    }

    //设置状态栏背景颜色
    fun setStatusBarColor(@ColorInt color: Int){
        StatusBarCompat.setStatusBarColor(this,color)
    }

    protected fun setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun jumpToActivity(intent:Intent){
        startActivity(intent)
    }

    fun showToast(context: Context,string: String){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show()
    }

    /**
     * use Event Bus add lib
     */
    fun isEventBusRegisted(subscribe:Object):Boolean{
        return EventBus.getDefault().isRegistered(subscribe)
    }

    fun registerEventBus(subscribe: Context){
        EventBus.getDefault().register(subscribe)
    }

    fun unRegisterEventBus(subscribe: Context){
        EventBus.getDefault().unregister(subscribe)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter!=null){
            mPresenter?.detachView()
            mPresenter = null
        }
        ActivityManager.getInstance().finishActivity(this)
    }

}