package com.example.anotherbilibili.network

object SchedulerUtils {


    fun <T> ioToMain(): IoToMainScheduler<T> {
        return IoToMainScheduler<T>()
    }

    fun <T> newThreadToMain(): NewThreadToMainScheduler<T> {
        return NewThreadToMainScheduler<T>()
    }

}