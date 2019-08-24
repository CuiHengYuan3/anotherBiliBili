package com.example.anotherbilibili.base

import io.reactivex.*
import org.reactivestreams.Publisher

/**
 * Rxjava调度器的基类，有背压和非背压，但是只用到了非背压
 */

abstract class BaseScheduler<T>(
    val subscribeOnScheduler: Scheduler,
    val observeOnScheduler: Scheduler
) : ObservableTransformer<T, T>, FlowableTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }


}
