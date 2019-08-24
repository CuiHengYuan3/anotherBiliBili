package com.example.anotherbilibili.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * ViewPager的基类
 */

class BaseFragmentAdapter(fm: FragmentManager, fragmentList: List<Fragment>, mTitles: List<String>) :
    FragmentPagerAdapter(fm) {

    private var fragmentList: List<Fragment>? = fragmentList
    private var mTitles: List<String>? = mTitles

    init {
        setFragments( fragmentList, mTitles)
    }


    @SuppressLint("CommitTransaction")
    private fun setFragments(fragments: List<Fragment>, mTitles: List<String>) {
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

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {


    }



}
