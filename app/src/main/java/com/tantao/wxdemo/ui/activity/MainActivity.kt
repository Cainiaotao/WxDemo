package com.tantao.wxdemo.ui.activity

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View
import com.tantao.wxdemo.R
import com.tantao.wxdemo.presenter.MainPresenter
import com.tantao.wxdemo.presenter.contract.MainContract
import com.tantao.wxdemo.ui.base.BaseActivity
import com.tantao.wxdemo.ui.fragment.ChatFragment
import com.tantao.wxdemo.ui.fragment.ContactFragment
import com.tantao.wxdemo.ui.fragment.DiscoverFragment
import com.tantao.wxdemo.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.IView,MainPresenter>(),MainContract.IView{

    private var chatFragment:ChatFragment?=null
    private var contactFragment:ContactFragment?=null
    private var discoverFragment:DiscoverFragment?=null
    private var meFragment:MeFragment?=null
    private var currentShowFragment: Fragment? = null

    override fun createPresenter(): MainPresenter = MainPresenter(this)
    override fun setContentView(): Int  = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }

    override fun initData() {
        super.initData()
        selectTabPage(ChatFragment::class.java.name)
    }

    override fun initListener() {
        super.initListener()
        navigation_chat.setOnClickListener { selectTabPage(ChatFragment::class.java.name) }
        navigation_contact.setOnClickListener { selectTabPage(ContactFragment::class.java.name) }
        navigation_discover.setOnClickListener { selectTabPage(DiscoverFragment::class.java.name) }
        navigation_me.setOnClickListener { selectTabPage(MeFragment::class.java.name) }
    }

    private fun changeStatusBarColor(mColor:Int){
        setStatusBarColor(ContextCompat.getColor(this,mColor))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun addFragment(fragment: Fragment){
        if (currentShowFragment != null)
            supportFragmentManager.beginTransaction().hide(currentShowFragment!!).commitAllowingStateLoss()
        if (supportFragmentManager.findFragmentByTag(fragment.javaClass.name) != null)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.name).commitAllowingStateLoss()
        else
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, fragment.javaClass.name).commitAllowingStateLoss()
        currentShowFragment = fragment
    }

    private fun showFragment(fragment: Fragment){
        if (currentShowFragment!=null){
            supportFragmentManager.beginTransaction().hide(currentShowFragment!!).commitAllowingStateLoss()
        }
        if (fragment.isDetached){
            supportFragmentManager.beginTransaction().attach(fragment).commitAllowingStateLoss()
        }else{
            supportFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss()
        }
        currentShowFragment = fragment
    }

    private fun selectTabPage(name:String){
        when(name){
            ChatFragment::class.java.name->{
                if (chatFragment==null){
                    chatFragment = ChatFragment()
                    addFragment(chatFragment!!)
                }else{
                    if (chatFragment!!.isAdded){
                        showFragment(chatFragment!!)
                    }else{
                        addFragment(chatFragment!!)
                    }
                }
            }
            ContactFragment::class.java.name->{
                if (contactFragment==null){
                    contactFragment = ContactFragment()
                    addFragment(contactFragment!!)
                }else{
                    if (contactFragment!!.isAdded){
                        showFragment(contactFragment!!)
                    }else{
                        addFragment(contactFragment!!)
                    }
                }
            }
            DiscoverFragment::class.java.name->{
                if (discoverFragment==null){
                    discoverFragment = DiscoverFragment()
                    addFragment(discoverFragment!!)
                }else{
                    if (discoverFragment!!.isAdded){
                        showFragment(discoverFragment!!)
                    }else{
                        addFragment(discoverFragment!!)
                    }
                }
            }
            MeFragment::class.java.name->{
                if (meFragment==null){
                    meFragment = MeFragment()
                    addFragment(meFragment!!)
                }else{
                    if (meFragment!!.isAdded){
                        showFragment(meFragment!!)
                    }else{
                        addFragment(meFragment!!)
                    }
                }
            }
        }
        selectedState(name)
    }

    private fun selectedState(name:String){
        img_chat.setBackgroundResource(R.mipmap.message_normal)
        img_contact.setBackgroundResource(R.mipmap.contacts_normal)
        img_discover.setBackgroundResource(R.mipmap.discovery_normal)
        img_me.setBackgroundResource(R.mipmap.me_normal)
        tv_chat.setTextColor(ContextCompat.getColor(this,R.color.color_black))
        tv_contact.setTextColor(ContextCompat.getColor(this,R.color.color_black))
        tv_discover.setTextColor(ContextCompat.getColor(this,R.color.color_black))
        tv_me.setTextColor(ContextCompat.getColor(this,R.color.color_black))
        when(name){
            ChatFragment::class.java.name->{
                changeStatusBarColor(R.color.color_white)
                img_chat.setBackgroundResource(R.mipmap.message_press)
                tv_chat.setTextColor(ContextCompat.getColor(this,R.color.color_00ff00))
            }
            ContactFragment::class.java.name->{
                changeStatusBarColor(R.color.color_f3f4f8)
                img_contact.setBackgroundResource(R.mipmap.contacts_press)
                tv_contact.setTextColor(ContextCompat.getColor(this,R.color.color_00ff00))
            }
            DiscoverFragment::class.java.name->{
                changeStatusBarColor(R.color.color_white)
                img_discover.setBackgroundResource(R.mipmap.discovery_press)
                tv_discover.setTextColor(ContextCompat.getColor(this,R.color.color_00ff00))
            }
            MeFragment::class.java.name->{
                changeStatusBarColor(R.color.color_white)
                img_me.setBackgroundResource(R.mipmap.me_press)
                tv_me.setTextColor(ContextCompat.getColor(this,R.color.color_00ff00))
            }
        }
    }
}
