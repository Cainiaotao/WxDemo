package com.tantao.wxdemo.ui.activity.discover

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tantao.wxdemo.R
import com.tantao.wxdemo.bean.MomentsEntity
import com.tantao.wxdemo.presenter.contract.discover.MomentsContract
import com.tantao.wxdemo.presenter.discover.MomentsPresenter
import com.tantao.wxdemo.ui.adapter.recycler.MomentListAdapter
import com.tantao.wxdemo.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_friend_circle.*
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.tantao.wxdemo.ui.widget.flexible.OnReadyPullListener


class FriendCircleActivity: BaseActivity<MomentsContract.IView, MomentsPresenter>()
        ,MomentsContract.IView, OnReadyPullListener,
        BaseQuickAdapter.RequestLoadMoreListener {



    private var manager:LinearLayoutManager?=null
    private var mAdapter:MomentListAdapter?=null
    private var mData = ArrayList<MomentsEntity>()


    override fun setContentView(): Int = R.layout.activity_friend_circle

    override fun createPresenter(): MomentsPresenter = MomentsPresenter(this)

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
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
        mAdapter = MomentListAdapter(mData,this)
        val header: View = LayoutInflater.from(this).inflate(R.layout.item_moment_header, null)
        val imgHeader:ImageView = header.findViewById(R.id.img_header)
        mAdapter?.addHeaderView(header)
        manager = LinearLayoutManager(this)
        recycler.layoutManager = manager!!
        recycler.adapter = mAdapter
        //mAdapter?.setOnLoadMoreListener(this)

        flexible.setReadyListener(this)
        flexible.setHeader(imgHeader)
    }

    override fun isReady(): Boolean {
        return manager!!.findFirstCompletelyVisibleItemPosition() == 0
    }


    private fun loadData(){
       val  imgs = ArrayList<String>()
        imgs.add("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")
        imgs.add("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")
        imgs.add("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")
        imgs.add("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))

        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 1", arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 2",
            arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 3",
            arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 4",
            arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 5",
            arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_IMAGE_WORD,"item 6",
            arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))



        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 1", arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 2",
                arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 3",
                arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 4",
                arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 5",
                arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))
        mData.add(MomentsEntity(MomentsEntity.ITEM_TEXT,"item 0", null))
        mData.add(MomentsEntity(MomentsEntity.ITEM_ASS_IMAGE,"item 6",
                arrayListOf("http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg",
                        "http://img4.imgtn.bdimg.com/it/u=2259376396,2250852130&fm=26&gp=0.jpg")))

        mAdapter?.notifyDataSetChanged()
    }

    override fun onLoadMoreRequested() {

    }
}