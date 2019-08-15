package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseFragmentAdapter
import com.example.anotherbilibili.base.baseFragment
import kotlinx.android.synthetic.main.fragment_home.*


open class HomeFragment: baseFragment() {
//真正的推荐页面
private var fragmentList: MutableList<Fragment>? = null
    private val titles = arrayListOf("直播", "推荐","追番","假的推荐")

    companion object {
        fun getInstance(): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun initView() {
setUpToolBar(toolbar)

        fragmentList = ArrayList()

        val fragment1 = LiveFragment.getInstance()
        val fragment2 = CommondFragment.getInstance()
        val fragment3 =AnimationFragment.getInstance()
        val fragment4 = FakeCommondFragment.getInstance()

        fragmentList?.apply {

            add(fragment1)
            add(fragment2)
            add(fragment3)
            add(fragment4)

        }
        vp_home.adapter= BaseFragmentAdapter(childFragmentManager,fragmentList!!,titles)
        tab_layout.setupWithViewPager(vp_home)

    }

    override fun lazyLoad() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_home


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        when (id) {
            R.id.action_game_center -> {

            }
            R.id.action_download -> {

            }
            R.id.action_search -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }

    protected fun setUpToolBar(toolBar: Toolbar) {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolBar)
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }

}