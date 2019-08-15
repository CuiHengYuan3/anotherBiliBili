package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment

class LiveFragment : baseFragment() {

    companion object {
        fun getInstance(): LiveFragment {
            val fragment = LiveFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
    }

    override fun lazyLoad() {
    }

    override fun getLayoutId(): Int =R.layout.fragment_live


}