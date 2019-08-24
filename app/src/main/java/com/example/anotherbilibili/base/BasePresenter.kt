package com.example.anotherbilibili.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 所有Presenter的基类，里面有view的初始化方法，和解除绑定方法
 * CompositeDisposable() 管理所有Rxjava的disposable
 */


open class BasePresenter<T : IBaseView> : IPresenter<T> {
    var finalView: T? = null

    private var compositeDisposable = CompositeDisposable()

   //初始化view
    override fun bindView(View: T) {
        finalView = View

    }

    //解除绑定，同时把Rxjava的订阅事件切断，在activity销毁的时候调用
    override fun dropView() {
        finalView = null
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    //把订阅事件加入管理
    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


}