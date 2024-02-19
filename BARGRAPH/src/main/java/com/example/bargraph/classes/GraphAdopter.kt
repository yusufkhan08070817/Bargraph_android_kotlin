package com.example.bargraph.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.bargraph.R

class GraphAdopter(val graphdata: IntArray,val Color: Int,val width:Float):RecyclerView.Adapter<GraphAdopter.Graphview>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Graphview {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.graphlayout,parent,false)
        return Graphview(lay)
    }

    override fun getItemCount(): Int {
        return graphdata.size
    }

    override fun onBindViewHolder(holder: Graphview, position: Int) {
        val current=graphdata[position]
        holder.seek.setRectangleProperties(current.toFloat(),Color )
        holder.seek.setgraphwidth(width)

    }
    class Graphview(view: View):RecyclerView.ViewHolder(view)
    {
        val seek=view.findViewById<CustomView>(R.id.bar)

    }

}