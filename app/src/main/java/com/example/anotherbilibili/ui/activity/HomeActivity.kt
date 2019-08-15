package com.example.anotherbilibili.ui.activity

import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseFragmentAdapter
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.ui.fragment.AnimationFragment
import com.example.anotherbilibili.ui.fragment.FakeCommondFragment
import com.example.anotherbilibili.ui.fragment.HomeFragment
import com.example.anotherbilibili.ui.fragment.LiveFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : baseActivity() {


    private var fragmentList: MutableList<Fragment>? = null
    private val titles = arrayListOf("直播", "推荐","追番","假的推荐")

    override fun initData() {
        fragmentList = ArrayList()

        val fragment1 = LiveFragment.getInstance()
        val fragment2 = HomeFragment.getInstance()
        val fragment3 =AnimationFragment.getInstance()
        val fragment4 = FakeCommondFragment.getInstance()

        fragmentList?.apply {

            add(fragment1)
            add(fragment2)
            add(fragment3)
            add(fragment4)

        }

    }

    override fun initView() {
  vp_home.adapter=BaseFragmentAdapter(supportFragmentManager,fragmentList!!,titles)

    }

    override fun finalPrepare() {
    }

    override fun getLayoutId(): Int= R.layout.fragment_home

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
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
}
