package com.example.anotherbilibili

import android.app.Application
import android.content.Context
import cn.leancloud.AVOSCloud
//import cn.leancloud.AVOSCloud
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import kotlin.properties.Delegates


class MyApplication : Application() {
    private val refWatcher: RefWatcher? = null





    companion object {
        var context: Context by Delegates.notNull()
            private set

        fun getRefWatcher(context: Context): RefWatcher? {
            val myApplication = context.applicationContext as MyApplication
            return myApplication.refWatcher
        }



    }

    override fun onCreate() {
        super.onCreate()
       AVOSCloud.initialize(this, "dnyX07w8Lu6SS6rse2XfF260-gzGzoHsz", "1yL7jvICd7mUDQz44QDJk1II")
        context = applicationContext
        setupLeakCanary()

    }

    private fun setupLeakCanary(): RefWatcher {
        return if (LeakCanary.isInAnalyzerProcess(this)) {
            RefWatcher.DISABLED
        } else LeakCanary.install(this)
    }


}