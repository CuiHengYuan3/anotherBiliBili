package com.example.anotherbilibili.base


/**
 * 所有presenter层需要实现的接口
 */


interface IPresenter< in V: IBaseView> {

    fun bindView(mRootView: V)

    fun dropView()

}

