package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment


class HomeFragment: baseFragment() {
//真正的推荐页面

    companion object {
        fun getInstance(): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun initView() {


    }

    override fun lazyLoad() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_home


}