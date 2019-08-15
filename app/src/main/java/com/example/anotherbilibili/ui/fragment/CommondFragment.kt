package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment

class CommondFragment: baseFragment() {
    companion object {
        fun getInstance(): CommondFragment {
            val fragment = CommondFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
    }

    override fun lazyLoad() {
    }
    override fun getLayoutId(): Int = R.layout.fragment_commond

}