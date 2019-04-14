package com.tantao.wxdemo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.contract.main.DiscoverContract
import com.tantao.wxdemo.presenter.main.DiscoverPresenter
import com.tantao.wxdemo.ui.activity.discover.FriendCircleActivity
import com.tantao.wxdemo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_discover.*

/**
 * <p>文件描述：发现<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class DiscoverFragment:BaseFragment<DiscoverContract.IView,DiscoverPresenter>(),DiscoverContract.IView {


    override fun setContentView(): Int  = R.layout.fragment_discover

    override fun createPresenter(): DiscoverPresenter = DiscoverPresenter(this)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)

    }

    override fun initData() {
        super.initData()

    }

    override fun initListener() {
        super.initListener()
        item_friend.setOnClickListener { onMoments() }
    }

    private fun onMoments(){
        jumpToActivity(Intent(activity!!,FriendCircleActivity::class.java))
    }





}