package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseFragmentAdapter
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.event.DrawerEvent
import com.example.anotherbilibili.event.ShowLoadingEvent
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


open class HomeFragment : baseFragment() {
    //真正的推荐页面
    private var fragmentList: MutableList<Fragment>? = null
    private val titles = arrayListOf("直播", "推荐", "追番")
    override fun getLayoutId(): Int = R.layout.fragment_home

    companion object {
        fun getInstance(): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun initView() {


        fragmentList = ArrayList()

        val fragment1 = LiveFragment.getInstance()
        val fragment2 = CommondFragment.getInstance()
        val fragment3 = AnimationFragment.getInstance()

        fragmentList?.apply {

            add(fragment1)
            add(fragment2)
            add(fragment3)
        }
        vp_home.adapter = BaseFragmentAdapter(fragmentManager!!, fragmentList!!, titles)
        tab_layout.setupWithViewPager(vp_home)
        vp_home.currentItem = 1
    }

    override fun lazyLoad() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun setLoading(showLoadingEvent: ShowLoadingEvent) {
        if (showLoadingEvent.isShowLoading) {
            im_loading.visibility = View.VISIBLE
        } else {
            im_loading.visibility = View.GONE

        }
    }


}