package com.ddona.adpater.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.ddona.adpater.R

class SmileView : View {
    private val centerFace = PointF()
    private val centerEye1 = PointF()
    private val centerEye2 = PointF()
    private val centerMouth2 = PointF()
    private var faceRadius = 50
    private var eyeRadius = 50f

    private val facePaint = Paint()
    private val eyePaint = Paint()
    private val mouthRect = RectF()
    private var faceColor = Color.RED

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val style = context.obtainStyledAttributes(attrs, R.styleable.SmileView)
        faceColor = style.getColor(
            R.styleable.SmileView_doanpt_smile_face_color,
            Color.RED
        )
        faceRadius = style.getDimensionPixelSize(
            R.styleable.SmileView_doanpt_smile_face_radius,
            50
        )
        init()
        style.recycle()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    fun init() {
        facePaint.color = faceColor
        facePaint.style = Paint.Style.FILL

        eyePaint.color = Color.BLUE
        eyePaint.style = Paint.Style.STROKE
        eyePaint.strokeWidth = 30f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val wMode = MeasureSpec.getMode(widthMeasureSpec)
        val hMode = MeasureSpec.getMode(heightMeasureSpec)
        val hSize = MeasureSpec.getSize(heightMeasureSpec)
        val wSize = MeasureSpec.getSize(widthMeasureSpec)
//        var desiredWidth = 100
//        val desiredHeight = 100
//        if (wMode == MeasureSpec.EXACTLY) {
//            desiredWidth = wSize
//        } else if (wMode == MeasureSpec.AT_MOST) {
//            desiredWidth = wSize
//        } else {
//            desiredWidth = 0
//        }
        val size = Math.min(wSize, hSize)
        setMeasuredDimension(size, size)
    }

    private var radius = 50f
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        faceRadius = width / 2
        eyeRadius = width / 8f

        centerFace.set(width / 2f, height / 2f)
        centerEye1.set(centerFace.x - eyeRadius, centerFace.y - eyeRadius)
        centerEye2.set(centerFace.x + eyeRadius, centerFace.y - eyeRadius)
        // draw eyes
        radius = Math.min(width, height) / 2f
        // draw mouth
        val mouthInset: Float = radius / 3f
//        mouthRect.set(
//            mouthInset, mouthInset, radius * 2 - mouthInset,
//            radius * 2 - mouthInset
//        )
        mouthRect.set(
            mouthInset, mouthInset, radius * 2 - mouthInset,
            radius * 2 - mouthInset
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(centerFace.x, centerFace.y, faceRadius.toFloat(), facePaint)
        canvas?.drawCircle(centerEye1.x - 100, centerEye1.y, eyeRadius, eyePaint)
        canvas?.drawCircle(centerEye2.x + 100, centerEye2.y, eyeRadius, eyePaint)
//        canvas?.drawRect(mouthRect, eyePaint)
        canvas?.drawArc(mouthRect, 45f, 90f, false, eyePaint)
    }
}