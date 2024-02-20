package com.example.bargraph.classes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PieChartView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val colors = listOf(
        Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.MAGENTA
    )

    private var data = ArrayList<PieChartData>()

    fun data(data: ArrayList<PieChartData>) {
        this.data = data
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.apply {
            val width = width.toFloat()
            val height = height.toFloat()
            val radius = (width.coerceAtMost(height) / 2) * 0.8f
            val centerX = width / 2
            val centerY = height / 2
            var startAngle = 0f

            val paint = Paint().apply {
                style = Paint.Style.FILL
                color = Color.GRAY // Text color set to black
                textAlign = Paint.Align.LEFT // Text alignment
                textSize = 30f // Text size
            }

            data.forEachIndexed { index, pieChartData ->
                val angle = 360 * (pieChartData.value / data.sumByDouble { it.value.toDouble() }).toFloat()
                val middleAngle = startAngle + angle / 2

                val labelRadius = radius * 0.8f // Adjust position of labels

                // Calculate position for the text label
                val labelX =
                    centerX + labelRadius * kotlin.math.cos(Math.toRadians(middleAngle.toDouble())).toFloat()
                val labelY =
                    centerY + labelRadius * kotlin.math.sin(Math.toRadians(middleAngle.toDouble())).toFloat()

                paint.color = colors[index % colors.size]
                drawArc(
                    centerX - radius,
                    centerY - radius,
                    centerX + radius,
                    centerY + radius,
                    startAngle,
                    angle,
                    true,
                    paint
                )

                // Draw text label
                val label = pieChartData.label // Using labels from PieChartData
                drawText(label, labelX, labelY, paint)

                startAngle += angle
            }
        }
    }
}
