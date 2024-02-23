package com.example.bargraph.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.bargraph.R

class GraphAdopter(val graphdata: ArrayList<graphdata>,val Color: Int,val width:Float,val alternativcolor:Boolean ,val color2:Int):RecyclerView.Adapter<GraphAdopter.Graphview>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Graphview {
        val lay=LayoutInflater.from(parent.context).inflate(R.layout.graphlayout,parent,false)
        return Graphview(lay)
    }

    override fun getItemCount(): Int {
        return graphdata.size
    }

    override fun onBindViewHolder(holder: Graphview, position: Int) {
        val current=graphdata[position]
        holder.seek.setRectangleProperties(current.data.toFloat(),Color )
        holder.seek.setgraphwidth(width)
        holder.text.text=current.datatext
        if (alternativcolor)
        {
            if (position%2==0)
            {
                holder.seek.setRectangleProperties(current.data.toFloat(),Color )
            }else
            {
                holder.seek.setRectangleProperties(current.data.toFloat(),color2 )
            }
        }

    }
    class Graphview(view: View):RecyclerView.ViewHolder(view)
    {
        val seek=view.findViewById<CustomView>(R.id.bar)
        val text:TextView=view.findViewById(R.id.textbar)

    }

}