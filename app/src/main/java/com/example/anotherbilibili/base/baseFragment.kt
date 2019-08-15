package com.example.anotherbilibili.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anotherbilibili.MyApplication

abstract class baseFragment : Fragment() {
    //所有的fragment都懒加载

    private var isViewCreated = false

    private var hasLoadData = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), null)
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadIfPrepared()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewCreated = true
        initView()
        lazyLoadIfPrepared()

    }

    private fun lazyLoadIfPrepared() {
        if (userVisibleHint && isViewCreated && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun lazyLoad()

    override fun onDestroy() {
        super.onDestroy()
        activity?.let { MyApplication.getRefWatcher(it)?.watch(activity) }
    }


}