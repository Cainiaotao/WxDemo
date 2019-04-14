package com.tantao.wxdemo.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tantao.wxdemo.R

/**
 * @deprecated：文件描述
 * @author：tantao
 * @date：2019/3/25
 *
 */
class MineAdapter(var mContext:Context,val data:ArrayList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_HEADER = 100
    private var headerView:View?=null

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return TYPE_HEADER
        }
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER){
            headerView = LayoutInflater.from(parent.context).inflate(R.layout.item_mine_header,parent,false)
            return HeaderView(headerView!!)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mine_view,parent,false)
            return ViewHolder(view)
        }
    }

    override fun getItemCount(): Int =data.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = data[position -1]
            holder.tv_item.text = item

        }
    }

    inner class HeaderView(view: View):RecyclerView.ViewHolder(view){

    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        internal val tv_item:TextView = view.findViewById(R.id.tv_me)
    }

    fun obtainHeaderView():View{
        return headerView!!
    }
}