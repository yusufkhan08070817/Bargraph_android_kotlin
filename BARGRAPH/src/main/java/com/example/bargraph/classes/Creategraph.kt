package com.example.bargraph.classes


import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bargraph.R

class Creategraph(val context: Context, view: ViewGroup,data: IntArray, width: Float = 10f, color: Int,Graph_background:Boolean) {
    private val relativeLayout = RelativeLayout(context)
    private val recyclerView = RecyclerView(context)
    private val imageView = ImageView(context)

    init {
        // Set layout parameters for RelativeLayout
        val relativeLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        relativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        relativeLayout.layoutParams = relativeLayoutParams

        // Set layout parameters for RecyclerView
        val recyclerViewParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        recyclerViewParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        recyclerView.layoutParams = recyclerViewParams

        // Set layout parameters for ImageView
        val imageViewParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        imageViewParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        imageView.layoutParams = imageViewParams

        // Set your image resource here
        imageView.setImageResource(R.drawable.pngegg)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP

        // Set alpha for the image (adjust opacity)
        imageView.imageAlpha = 128 // Example: set alpha to half opacity
        relativeLayout.addView(imageView)
        relativeLayout.addView(recyclerView)

        view.addView(relativeLayout)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = GraphAdopter(data, color, width)
        imageView.visibility= if (Graph_background)View.VISIBLE else View.GONE

    }


}
