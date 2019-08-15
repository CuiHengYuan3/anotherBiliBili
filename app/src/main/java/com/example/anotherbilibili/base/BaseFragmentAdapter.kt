package com.example.anotherbilibili.base

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class BaseFragmentAdapter(fm: FragmentManager, fragmentList: List<Fragment>, mTitles: List<String>) : FragmentPagerAdapter(fm) {

    private var fragmentList: List<Fragment>? = ArrayList()
    private var mTitles: List<String>? = mTitles

    init {
        setFragments(fm, fragmentList, mTitles)
    }

    //刷新fragment
    @SuppressLint("CommitTransaction")
    private fun setFragments(fm: FragmentManager, fragments: List<Fragment>, mTitles: List<String>) {
        this.mTitles = mTitles
        this.fragmentList = fragments
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (null != mTitles) mTitles!![position] else ""
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList!![position]
    }

    override fun getCount(): Int {
        return fragmentList!!.size
    }

}
