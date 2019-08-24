package com.example.anotherbilibili.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RemovableFab(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    FloatingActionButton(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        var mLastX: Float = 0F
        var mLastY: Float = 0F

        var x = ev?.rawX
        var y = ev?.rawY
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {

            }
            MotionEvent.ACTION_MOVE -> {
                var movedX = x?.minus(mLastX)
                var movedY = y?.minus(mLastY)
                translationX += mLastX
                translationY += mLastY
            }
        }
        if (x != null) {
            mLastX = x
        }
        if (y != null) {
            mLastY = y
        }

        return true
    }


}
