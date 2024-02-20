package com.example.bargraph.classes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineGraphView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var data = ArrayList<Int>() // Example data
    private var maxDataValue = 0 // Maximum data value
    private var minDataValue = 0 // Minimum data value
    private var lineColor = Color.BLACK // Default line color

    fun setData(maxDataValue: Int, minDataValue: Int, data: ArrayList<Int>, color: Int) {
        this.maxDataValue = maxDataValue
        this.minDataValue = minDataValue
        this.data = data
        this.lineColor = color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.apply {
            val width = width.toFloat()
            val height = height.toFloat()
            val padding = 50f
            val graphWidth = width - (2 * padding)
            val graphHeight = height - (2 * padding)

            val paint = Paint().apply {
                style = Paint.Style.STROKE
                color = Color.BLACK
                strokeWidth = 4f
            }

            // Draw X and Y axis
            drawLine(padding, padding, padding, height - padding, paint)
            drawLine(padding, height - padding, width - padding, height - padding, paint)

            // Draw data points and lines
            paint.color = lineColor
            paint.strokeWidth = 8f

            // Calculate the range of data values
            val maxValue = data.maxOrNull() ?: maxDataValue
            val minValue = data.minOrNull() ?: minDataValue
            val yRange = maxValue - minValue

            val dataPointSpacing = graphWidth / (data.size - 1)
            var startX = padding
            var startY =
                height - padding - ((data[0] - minValue) / yRange.toFloat() * graphHeight)
            for (i in 1 until data.size) {
                val endX = padding + (i * dataPointSpacing)
                val endY =
                    height - padding - ((data[i] - minValue) / yRange.toFloat() * graphHeight)
                drawLine(startX, startY, endX, endY, paint)
                drawCircle(startX, startY, 8f, paint)
                startX = endX
                startY = endY
            }
        }
    }
}
