package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.DragEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseFragmentAdapter
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.event.DrawerEvent
import com.example.anotherbilibili.ui.fragment.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.textColor
import cn.leancloud.AVUser
import kotlinx.android.synthetic.main.activity_nav_header_manin.*
import org.jetbrains.anko.toast


class HomeActivity : baseActivity() {


    private val mIconSelectIds = intArrayOf(
        R.mipmap.ic_category_selected,
        R.mipmap.ic_home_selected,
        R.mipmap.ic_dynamic_selected
    )
    private val mIconUnselectIds = intArrayOf(
        R.mipmap.ic_category_unselected,
        R.mipmap.ic_home_unselected,
        R.mipmap.ic_dynamic_unselected
    )


    private var homeFragment: HomeFragment? = null
    private var catalogFragment: CatalogFragment? = null
    private var distinctiveFragment: DistinctiveFragment? = null
    private var courrentIndex = 2  //第一次进入推荐页面

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initData() {

        val currentUser = AVUser.getCurrentUser()

    if (currentUser!=null)  {


       toast(currentUser.username)
    }

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        ll_home.setOnClickListener {
            changeFragment(2)
        }
        ll_catalog.setOnClickListener {
            changeFragment(1)
        }
        ll_distinct.setOnClickListener {
            changeFragment(3)
        }


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun finalPrepare() {
        changeFragment(courrentIndex)
    }


    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun changeFragment(positon: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        setTextDefault()
        setIconDefault()
        val pinkcolor = Color.parseColor("#fffb7299")
        when {
            positon == 1 -> {
                catalogFragment?.let {
                    transaction.show(it)
                } ?: CatalogFragment.getInstance().let {
                    catalogFragment = it
                    transaction.add(R.id.container, it, "catalogFragment")
                }
                im_catalog.setImageDrawable(getDrawable(mIconSelectIds[0]))
                tv_catalog.setTextColor(pinkcolor)

            }
            positon == 2 -> {
                homeFragment?.let {
                    transaction.show(it)
                } ?: HomeFragment.getInstance().let {
                    homeFragment = it
                    transaction.add(R.id.container, it, "homeFragment")
                }
                im_home.setImageDrawable(getDrawable(mIconSelectIds[1]))
                tv_home.setTextColor(pinkcolor)


            }
            positon == 3 -> {
                distinctiveFragment?.let {
                    transaction.show(it)
                } ?: DistinctiveFragment.getInstance().let {
                    distinctiveFragment = it
                    transaction.add(R.id.container, it, "distinctFragment")
                }
                im_distinct.setImageDrawable(getDrawable(mIconSelectIds[2]))
                tv_distinct.setTextColor(pinkcolor)


            }

        }
        transaction.commit()
        courrentIndex = positon
    }


    private fun hideFragments(transaction: FragmentTransaction) {
        homeFragment?.let { transaction.hide(it) }
        catalogFragment?.let { transaction.hide(it) }
        distinctiveFragment?.let { transaction.hide(it) }
    }


    private fun setTextDefault() {
        with(R.color.text_default) {
            tv_home.textColor = this
            tv_catalog.textColor = this
            tv_distinct.textColor = this
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setIconDefault() {
        im_home.setImageDrawable(getDrawable(mIconUnselectIds[1]))
        im_catalog.setImageDrawable(getDrawable(mIconUnselectIds[0]))
        im_distinct.setImageDrawable(getDrawable(mIconUnselectIds[2]))
    }


    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        if (tab_layout != null) {
            outState.putInt("currTabIndex", courrentIndex)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        if (savedInstanceState != null) {
            courrentIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState, persistentState)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: DrawerEvent) {
        if (dl_main.isDrawerOpen(GravityCompat.START)) {
            dl_main.closeDrawer(GravityCompat.START)
        } else {
            dl_main.openDrawer(GravityCompat.START)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)

    }

    override fun onBackPressed() {
        if (dl_main.isDrawerOpen(GravityCompat.START)) run { dl_main.closeDrawer(GravityCompat.START) }
        else run {
            super.onBackPressed()

        }

    }




}
