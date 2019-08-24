package com.example.anotherbilibili.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.event.ShowLoadingEvent
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.InformationData
import com.example.anotherbilibili.mvp.contract.AnimatorContract
import com.example.anotherbilibili.mvp.presenter.AnimationPresenter
import com.example.anotherbilibili.mvp.presenter.CatalogPresenter
import com.example.anotherbilibili.ui.adapter.AnimationAdapter
import com.example.anotherbilibili.ui.adapter.CatalogAdapter
import com.example.anotherbilibili.ui.adapter.InformationAdapter
import kotlinx.android.synthetic.main.fragment_animation.*
import org.greenrobot.eventbus.EventBus

@SuppressLint("WrongConstant")


/**
 *
 * 追番fragment
 */
class AnimationFragment : baseFragment(), AnimatorContract.view {


    companion object {
        fun getInstance(): AnimationFragment {
            val fragment = AnimationFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    var informationAdapter: InformationAdapter? = null
    var animationAdapter: AnimationAdapter? = null
    val mPresenter by lazy {
        AnimationPresenter()
    }
    val gridLayoutManager by lazy {
        GridLayoutManager(MyApplication.context, 2)
    }
    val linearLayoutManager by lazy {
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    override fun getLayoutId(): Int = R.layout.fragment_animation

    override fun initView() {
        mPresenter.bindView(this)
    }

    override fun lazyLoad() {
        mPresenter.requestAnimationData()
        mPresenter.requestInformationData()
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

    override fun setInformationData(informationData: InformationData) {

        informationAdapter = activity?.let {
            InformationAdapter(
                it,
                informationData.result as ArrayList<InformationData.Result>,
                R.layout.item_information
            )
        }
        re_infor.adapter = informationAdapter
        re_infor.layoutManager = linearLayoutManager

    }


    override fun showIsLoading() {
        tv_state.visibility= View.GONE

        EventBus.getDefault().post(ShowLoadingEvent(true))

    }

    override fun removeLoading() {
        tv_state.visibility= View.VISIBLE

        EventBus.getDefault().post(ShowLoadingEvent(false))

    }


}