package com.example.anotherbilibili.base

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class baseActivity : AppCompatActivity() {
    companion object {
        var defaultTheme = R.style.AppTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(defaultTheme)
        setContentView(getLayoutId())
        initData()
        initView()
        finalPrepare()

    }

    abstract fun getLayoutId(): Int

    abstract fun initData()//在初始化view之前初始化一些必要的数据

    abstract fun initView()//初始化view，和给view设置数据等等

    abstract fun finalPrepare()//在view的数据都加载了之后,做最后的一些操作

    override fun onDestroy() {
        super.onDestroy()
        MyApplication.getRefWatcher(this)?.watch(this)
    }

}

