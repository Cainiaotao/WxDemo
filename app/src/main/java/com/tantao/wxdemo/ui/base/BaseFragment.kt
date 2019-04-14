package com.tantao.wxdemo.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tantao.wxdemo.presenter.BasePresenter
import com.tantao.wxdemo.presenter.view.BaseView


abstract class BaseFragment<V: BaseView,P: BasePresenter<V>> :Fragment(),BaseView{

    protected var mPresenter:P?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter!=null){
            mPresenter?.attachView(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View =  inflater.inflate(setContentView(),container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view,savedInstanceState)
        initData()
        initListener()
    }

    @LayoutRes
    protected abstract fun setContentView(): Int

    protected abstract fun createPresenter():P

    open fun initView(view: View, savedInstanceState: Bundle?) {}
    open fun initData() {}
    open fun initListener(){}

    fun showToast(context: Context,str:String){
        Toast.makeText(context,str, Toast.LENGTH_SHORT).show()
    }

    override fun providerContext(): Context {
        return activity!!
    }

    fun jumpToActivity(intent: Intent){
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter!=null){
            mPresenter?.detachView()
            mPresenter = null
        }
    }
}