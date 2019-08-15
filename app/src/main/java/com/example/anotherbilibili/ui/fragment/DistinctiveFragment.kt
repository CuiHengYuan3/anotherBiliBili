package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment

class DistinctiveFragment: baseFragment() {
    companion object {
        fun getInstance(): DistinctiveFragment {
            val fragment = DistinctiveFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun initView() {
    }

    override fun lazyLoad() {
    }
    override fun getLayoutId(): Int = R.layout.fragment_distiinctive

}