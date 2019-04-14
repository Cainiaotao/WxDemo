package com.tantao.wxdemo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.contract.main.MeContract
import com.tantao.wxdemo.presenter.main.MePresenter
import com.tantao.wxdemo.ui.activity.me.MyInfoActivity
import com.tantao.wxdemo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * <p>文件描述：Mey 页面<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class MeFragment:BaseFragment<MeContract.IView,MePresenter>()
        ,MeContract.IView, View.OnClickListener {


    override fun createPresenter(): MePresenter  = MePresenter(this)

    override fun setContentView(): Int  = R.layout.fragment_me

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
    }

    override fun initData() {
        super.initData()
    }

    override fun initListener() {
        super.initListener()
        item_play.setOnClickListener(this)
        item_collect.setOnClickListener(this)
        item_album.setOnClickListener(this)
        item_card.setOnClickListener(this)
        item_expression.setOnClickListener(this)
        item_homePage.setOnClickListener(this)
        item_set.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.item_play->{}
            R.id.item_collect->{}
            R.id.item_album->{}
            R.id.item_card->{}
            R.id.item_expression->{}
            R.id.item_homePage->jumpToActivity(Intent(activity!!,MyInfoActivity::class.java))
            R.id.item_set->{}
        }
    }

}