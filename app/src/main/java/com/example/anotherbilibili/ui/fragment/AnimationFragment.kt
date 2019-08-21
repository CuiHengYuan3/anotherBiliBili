package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.contract.AnimatorContract
import com.example.anotherbilibili.mvp.presenter.AnimationPresenter
import com.example.anotherbilibili.mvp.presenter.CatalogPresenter
import com.example.anotherbilibili.ui.adapter.AnimationAdapter
import com.example.anotherbilibili.ui.adapter.CatalogAdapter
import kotlinx.android.synthetic.main.fragment_animation.*

class AnimationFragment : baseFragment(), AnimatorContract.view {


    companion object {
        fun getInstance(): AnimationFragment {
            val fragment = AnimationFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    var animationAdapter: AnimationAdapter? = null
    val mPresenter by lazy {
        AnimationPresenter()
    }
    val gridLayoutManager by lazy {
        GridLayoutManager(MyApplication.context, 2)
    }

    override fun getLayoutId(): Int = R.layout.fragment_animation

    override fun initView() {
        mPresenter.bindView(this)
    }

    override fun lazyLoad() {
        mPresenter.requestAnimationData()
    }

    override fun setCatalogDetalData(animationList: MutableList<AnimationBean.Result.RecommendCn.Recommend>) {

        animationAdapter = activity?.let {
            AnimationAdapter(
                it,
                animationList as ArrayList<AnimationBean.Result.RecommendCn.Recommend>,
                R.layout.item_animation
            )
        }
        re_animtion.adapter = animationAdapter
        re_animtion.layoutManager = gridLayoutManager

    }


    override fun showIsLoading() {

    }

    override fun removeLoading() {

    }


}