package com.tantao.wxdemo.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.tantao.wxdemo.R
import com.tantao.wxdemo.bean.MultipleItem
import com.tantao.wxdemo.presenter.contract.main.DiscoverContract
import com.tantao.wxdemo.presenter.main.DiscoverPresenter
import com.tantao.wxdemo.ui.adapter.DiscoverAdapter
import com.tantao.wxdemo.ui.base.BaseFragment
import com.tantao.wxdemo.util.DataServer

/**
 * <p>文件描述：发现<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class DiscoverFragment:BaseFragment<DiscoverContract.IView,DiscoverPresenter>(),DiscoverContract.IView {

    private var mAdapter: DiscoverAdapter?=null
    private var recycler: RecyclerView?=null
    private var mData = ArrayList<MultipleItem>()

    override fun setContentView(): Int  = R.layout.fragment_discover

    override fun createPresenter(): DiscoverPresenter = DiscoverPresenter(this)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler)
    }

    override fun initData() {
        super.initData()
        initListView()
        loadData()
    }

    override fun initListener() {
        super.initListener()
    }

    private fun initListView(){
        recycler?.layoutManager = LinearLayoutManager(activity!!)
        mAdapter = DiscoverAdapter(mData)
        val view:View = layoutInflater.inflate(R.layout.include_contact_header_view, recycler?.parent as ViewGroup, false)
        mAdapter?.addHeaderView(view)
        recycler?.adapter = mAdapter
    }

    private fun loadData(){
        mData.addAll(DataServer.getDiscoverData())
        mAdapter?.notifyDataSetChanged()
    }
}