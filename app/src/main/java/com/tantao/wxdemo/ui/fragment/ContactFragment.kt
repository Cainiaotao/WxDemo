package com.tantao.wxdemo.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration
import com.oushangfeng.pinnedsectionitemdecoration.callback.OnHeaderClickListener
import com.tantao.wxdemo.R
import com.tantao.wxdemo.bean.ContactHeaderEntity
import com.tantao.wxdemo.bean.ContactSection
import com.tantao.wxdemo.bean.ContactUser
import com.tantao.wxdemo.bean.MobileEntiy
import com.tantao.wxdemo.presenter.contract.main.ContactContract
import com.tantao.wxdemo.presenter.main.ContactPresenter
import com.tantao.wxdemo.ui.adapter.BaseHeaderAdapter
import com.tantao.wxdemo.ui.adapter.ContactAdapter
import com.tantao.wxdemo.ui.adapter.ContactListAdapter
import com.tantao.wxdemo.ui.base.BaseFragment
import com.tantao.wxdemo.util.ContactHelper
import com.tantao.wxdemo.util.DataServer
import com.tantao.wxdemo.util.PinyinUtils
import com.tantao.wxdemo.util.StringUtils
import java.util.*
import kotlin.Comparator

/**
 * <p>文件描述：通讯录<p>
 * <p>作者：tantao<p>
 * <p>创建时间：2019/3/21<p>
 *
 */
class ContactFragment: BaseFragment<ContactContract.IView, ContactPresenter>(), ContactContract.IView {

    private var headerAdapter:ContactListAdapter?=null
    private var dataList = ArrayList<ContactHeaderEntity<MobileEntiy>>()
    private var headerClickListener: OnHeaderClickListener?=null

    private var mAdapter:ContactAdapter?=null
    private var recycler:RecyclerView?=null
    private var mData = ArrayList<ContactSection>()


    override fun setContentView(): Int = R.layout.fragment_contact

    override fun createPresenter(): ContactPresenter = ContactPresenter(this)

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler)
    }

    override fun initData() {
        super.initData()
        //initListView()
        //loadData()

        initHeaderListView()
        loadHeaderData()
    }

    override fun initListener() {
        super.initListener()
    }

    private fun initListView(){
        recycler?.layoutManager = LinearLayoutManager(activity!!)
        mAdapter = ContactAdapter(R.layout.item_contact_child,R.layout.item_contact_header,mData)
        val view:View = layoutInflater.inflate(R.layout.include_contact_header_view, recycler?.parent as ViewGroup, false)
        mAdapter?.addHeaderView(view)
        recycler?.adapter = mAdapter
    }

    private fun loadData(){
        val phones = ContactHelper.getInstance().getAllContacts(activity!!)
        if (phones!=null && phones.size>0){
            phones.forEach {
                mData.add(ContactSection(ContactUser(0L,it.name,"")))
            }
        }
        //mData.addAll(DataServer.getSampleData())
        mAdapter?.notifyDataSetChanged()
    }


    private fun initHeaderListView(){
        recycler?.layoutManager = LinearLayoutManager(activity!!)
        headerAdapter = ContactListAdapter(dataList)
        val view:View = layoutInflater.inflate(R.layout.include_contact_header_view, recycler?.parent as ViewGroup, false)
        headerAdapter?.addHeaderView(view)
        headerClickListener = object:OnHeaderClickListener{
            override fun onHeaderLongClick(view: View?, id: Int, position: Int) {
                showToast(activity!!,"$position")
            }

            override fun onHeaderClick(view: View?, id: Int, position: Int) {
                showToast(activity!!,"$position")
            }
        }
        recycler?.addItemDecoration(
            PinnedHeaderItemDecoration.Builder(BaseHeaderAdapter.TYPE_HEADER)
                .setDividerId(R.color.color_f3f4f8).enableDivider(true)
                .setHeaderClickListener(headerClickListener).create())
        recycler?.adapter = headerAdapter
    }

    private fun loadHeaderData(){
        val phones = ContactHelper.getInstance().getAllContacts(activity!!)
        if (phones!=null && phones.size>0){
            val reslut = ArrayList<MobileEntiy>()
            phones.forEach {
                reslut.add(MobileEntiy(it.phone,it.name,PinyinUtils.getSurnamePinyin(it.name).toUpperCase(),PinyinUtils.getSurnameFirstLetter(it.name)))
            }
            //按字母排序
            reslut.sortWith(Comparator sort@{ obj1, obj2 ->
                return@sort obj1.pinyin.compareTo(obj2.pinyin)
            })
            val upper = arrayListOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
            upper.forEach { headerItem ->
                val groups = ArrayList<MobileEntiy>()
                reslut.forEach {
                    if (headerItem == it.header){
                        groups.add(it)
                    }
                }
                if (groups.size>0){
                    dataList.add(ContactHeaderEntity<MobileEntiy>(BaseHeaderAdapter.TYPE_HEADER,null,headerItem))
                    groups.forEach { phoneItem->
                        dataList.add(ContactHeaderEntity(BaseHeaderAdapter.TYPE_DATA,phoneItem,headerItem))
                    }
                }
            }
            headerAdapter?.notifyDataSetChanged()
        }
    }
}