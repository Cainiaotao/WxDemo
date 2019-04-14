package com.tantao.wxdemo.ui.activity.me

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.contract.me.MineInfoContract
import com.tantao.wxdemo.presenter.me.MineInfoPresenter
import com.tantao.wxdemo.ui.adapter.MineAdapter
import com.tantao.wxdemo.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_info.*
import android.view.ViewGroup
import com.tantao.wxdemo.ui.adapter.MyInfoAdapter





/**
 * @deprecated：个人信息
 * @author：tantao
 * @date：2019/3/21
 *
 */
class MyInfoActivity:BaseActivity<MineInfoContract.IView,MineInfoPresenter>(),MineInfoContract.IView {

    private var mAdapter: MineAdapter?=null
    override fun setContentView(): Int  = R.layout.activity_my_info

    override fun createPresenter(): MineInfoPresenter = MineInfoPresenter(this)

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        initList()
    }

    private fun initList(){
        val mlist = ArrayList<String>()
        for (i in 0..30){
            mlist.add("$i")
        }
        mAdapter = MineAdapter(this,mlist)

        val newAdapter = MyInfoAdapter(R.layout.item_mine_view,mlist)
        val view = layoutInflater.inflate(R.layout.item_mine_header, recycler.parent as ViewGroup, false)
        val lm = LinearLayoutManager(this)
        recycler.layoutManager = lm
        recycler.adapter = newAdapter
        newAdapter.addHeaderView(view)
        recycler.setZoomView(view,R.id.img_view,lm)
    }
}