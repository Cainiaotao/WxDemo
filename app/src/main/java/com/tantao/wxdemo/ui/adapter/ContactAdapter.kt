package com.tantao.wxdemo.ui.adapter


import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tantao.wxdemo.R
import com.tantao.wxdemo.bean.ContactSection

/**
 * @author：tantao
 * @date：2019/4/4
 */
class ContactAdapter(layoutResId: Int, sectionHeadResId: Int, data: List<ContactSection>)
    : BaseSectionQuickAdapter<ContactSection, BaseViewHolder>(layoutResId, sectionHeadResId, data) {


    override fun convertHead(helper: BaseViewHolder, item: ContactSection) {
        helper.setText(R.id.tv_header,item.header)
    }

    override fun convert(helper: BaseViewHolder, item: ContactSection) {
        helper.setText(R.id.tv_name,item.t.name)
    }
}
