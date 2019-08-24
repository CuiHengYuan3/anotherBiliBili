package com.example.anotherbilibili.network

import com.example.anotherbilibili.base.BaseScheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * rvjava的io线程到主线程的调度器
 */

class IoToMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())
