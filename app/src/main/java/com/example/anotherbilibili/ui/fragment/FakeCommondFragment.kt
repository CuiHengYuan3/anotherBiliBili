package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment

class FakeCommondFragment: baseFragment() {
    companion object {
        fun getInstance(): FakeCommondFragment {
            val fragment = FakeCommondFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
    }

    override fun lazyLoad() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_fake_recommend

}










