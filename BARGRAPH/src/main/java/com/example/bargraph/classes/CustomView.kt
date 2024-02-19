package com.example.bargraph.classes


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView : View {

    private var rectangleHeightPercent: Float = 0f
    private var rectangleWidthPercent: Float = 10f
    private var rectangleColor: Int = 0
    private val rectanglePaint: Paint = Paint()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        rectanglePaint.style = Paint.Style.FILL // Filled rectangle
    }

    fun setRectangleProperties(percent: Float, color: Int) {
        rectangleHeightPercent = percent
        rectangleColor = color
        invalidate()
    }
    fun setgraphwidth(percent: Float)
    {
        rectangleWidthPercent=percent
        invalidate()
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()

        // Calculate the height of the rectangle based on the percentage
        val rectangleHeight = height * rectangleHeightPercent / 100

        // Calculate the top position of the rectangle
        val top = height - rectangleHeight
        val rewedth=width*rectangleWidthPercent/100
        // Define the rectangle bounds
        val rect = RectF(0f, top, rewedth, height)

        // Define the radius for the rounded corners
        val radius = rectangleHeight / 2

        // Set the color
        rectanglePaint.color = rectangleColor

        // Draw the rounded rectangle
        canvas.drawRoundRect(rect, radius, radius, rectanglePaint)

    }

}
