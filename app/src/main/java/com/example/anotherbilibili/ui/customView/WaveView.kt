package com.example.anotherbilibili.ui.customView


import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.animation.LinearInterpolator


/***
 *
 * 贝塞尔曲线实现的波浪动画，
 * 但是控制点找不到，不会算，只能上网找了一下
 */


open class WaveView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {


    private var mScreenHeight: Int = 0
    private var mScreenWidth: Int = 0
    private var mWavePaint: Paint? = null
    private var mWaveLength: Int = 0
    internal lateinit var mWavePath: Path
    private var mOffset: Int = 0
    private var mWaveCount: Int = 0
    private var mWaveAmplitude: Int = 0
    private var valueAnimator: ValueAnimator? = null

    init {
        init()
    }


    private fun init() {
        mWaveAmplitude = dp2px(13)
        mWaveLength = dp2px(400)
        initPaint()
    }


    private fun initPaint() {
        mWavePath = Path()

        mWavePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mWavePaint!!.color = Color.parseColor("#FF60AF")
        mWavePaint!!.style = Paint.Style.FILL_AND_STROKE
        mWavePaint!!.isAntiAlias = true

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mScreenHeight = h
        mScreenWidth = w

        //加1.5是为了保证屏幕内有两个波，因为有还有一部分是在屏幕外的，屏幕内只是动画的一部分
        mWaveCount = Math.round(mScreenWidth / mWaveLength + 1.5).toInt()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawSinPath(canvas)
    }


    private fun drawSinPath(canvas: Canvas) {
        //每次划线之前要重置，否则还是上一次的配置
        mWavePath.reset()

        mWavePath.moveTo((-mWaveLength + mOffset).toFloat(), mWaveAmplitude.toFloat())



        for (i in 0..mWaveCount) {

            //控制点的坐标话不会算，网上找了一下
            mWavePath.quadTo(
                (-mWaveLength * 3 / 4 + mOffset + i * mWaveLength).toFloat(),
                (-mWaveAmplitude).toFloat(),
                (-mWaveLength / 2 + mOffset + i * mWaveLength).toFloat(),
                mWaveAmplitude.toFloat()
            )

            mWavePath.quadTo(
                (-mWaveLength / 4 + mOffset + i * mWaveLength).toFloat(),
                (3 * mWaveAmplitude).toFloat(),
                (mOffset + i * mWaveLength).toFloat(),
                mWaveAmplitude.toFloat()
            )
        }

        mWavePath.lineTo(width.toFloat(), height.toFloat())
        mWavePath.lineTo(0f, height.toFloat())

//必须要close形成闭环，让背景填充波浪以外的区域
        mWavePath.close()

        canvas.drawPath(mWavePath, mWavePaint!!)
    }


    private fun initAnimation() {
        valueAnimator = ValueAnimator.ofInt(0, mWaveLength)
        valueAnimator!!.duration = 2000
        valueAnimator!!.startDelay = 300
        valueAnimator!!.repeatCount = ValueAnimator.INFINITE
        valueAnimator!!.interpolator = LinearInterpolator()
        valueAnimator!!.addUpdateListener { animation ->
            mOffset = animation.animatedValue as Int //偏移量随动画变化
            invalidate()  //重新绘制
        }
        valueAnimator!!.start()
    }

    fun startAnimation() {
        initAnimation()
    }

    fun stopAnimation() {
        if (valueAnimator != null) {
            valueAnimator!!.cancel()
        }
    }

    fun pauseAnimation() {
        if (valueAnimator != null) {
            valueAnimator!!.pause()
        }
    }

    fun resumeAnimation() {
        if (valueAnimator != null) {
            valueAnimator!!.resume()
        }
    }


    private fun dp2px(dpVal: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal.toFloat(), resources.displayMetrics
        ).toInt()
    }


}

