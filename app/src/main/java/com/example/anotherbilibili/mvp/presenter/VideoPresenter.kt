package com.example.anotherbilibili.mvp.presenter

import android.util.Log
import cn.leancloud.AVObject
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import com.example.anotherbilibili.mvp.contract.VideoConstract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import cn.leancloud.AVQuery
import com.example.anotherbilibili.event.AVobectEvent
import org.greenrobot.eventbus.EventBus
import kotlinx.coroutines.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class VideoPresenter : BasePresenter<VideoConstract.view>(), VideoConstract.presenter {


    override fun loadVideodata(data: ExtractBean) {
        finalView?.showIsLoading()
        finalView?.setVideoData(data)
        finalView?.removeLoading()
    }

    override fun pushToAV(extractBean: ExtractBean) {
        val videoData = AVObject("ExtractBean")
        with(videoData) {
            put("videoName", extractBean.videoName)
            put("videoUrl", extractBean.videoUrl)
            put("autherName", extractBean.autherName)
            put("autherImaeg", extractBean.autherImaeg)
            put("collectNumber", extractBean.collectNumber)
            put("videoPicUrl", extractBean.videoPicUrl)
            put("loveNumber", extractBean.loveNumber)
            put("commendList", extractBean.commendList)
        }

        videoData.saveInBackground().subscribe(object : Observer<AVObject> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(todo: AVObject) {
                // 成功保存之后，执行其他逻辑

                EventBus.getDefault().post(AVobectEvent(todo))//保存后发送事件初始化videoActivity的AVobject


            }

            override fun onError(throwable: Throwable) {
                // 异常处理
            }

            override fun onComplete() {}
        })


    }


    fun getVideoDataFromAV(videoUrl: String) {
        finalView?.showIsLoading()
        val query = AVQuery<AVObject>("ExtractBean")
        query.whereEqualTo("videoUrl", videoUrl)
        query.findInBackground().subscribe(object : Observer<List<AVObject?>> {
            override fun onSubscribe(disposable: Disposable) {
                Log.d("vvvv", "onSubscribe")
            }

            override fun onNext(students: List<AVObject?>) {
                finalView?.removeLoading()
                if (students.isEmpty()) {
                    finalView?.setDefaultData()//没有数据就默认数据
                } else {
                    finalView?.setRefreshedData(students[0])//从AVobject中取出属性
                }

                // students 是包含满足条件的 Student 对象的数组
            }

            override fun onError(throwable: Throwable) {
                Log.d("vvvv", "onError")

            }

            override fun onComplete() {
                Log.d("vvvv", "onComplete")

            }
        })

    }


    override fun reFreshAVdata(data: AVObject?, extractBean: ExtractBean) {

        val query = AVQuery<AVObject>("ExtractBean")
        query.whereEqualTo("videoUrl", extractBean.videoUrl)
        query.findInBackground().subscribe(object : Observer<List<AVObject>> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(students: List<AVObject>) {

                with(students[0]) {
                    put("collectNumber", extractBean.collectNumber)
                    put("videoPicUrl", extractBean.videoPicUrl)
                    put("loveNumber", extractBean.loveNumber)
                    put("commendList", extractBean.commendList)
                }
                students[0].saveInBackground().subscribe(object : Observer<AVObject> {
                    override fun onSubscribe(disposable: Disposable) {
                        Log.d("zzz", "onSubscribe")
                    }

                    override fun onNext(todo: AVObject) {
                        // 成功保存之后，执行其他逻辑
                        Log.d("zzz", "onNextOKKKKKK")
                        //保存后发送事件初始化videoActivity的AVobject

                    }

                    override fun onError(throwable: Throwable) {
                        // 异常处理
                        Log.d("zzz", "onNext")

                    }

                    override fun onComplete() {

                        Log.d("zzz", "onNext")

                    }

                })

                Log.d("zzz", "ok")


            }

            override fun onError(throwable: Throwable) {
                android.util.Log.d("zzz", "error")

            }

            override fun onComplete() {
                android.util.Log.d("zzz", "complet")

            }
        })

    }


}
