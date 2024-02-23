package com.example.bargraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.bargraph.classes.Creategraph
import com.example.bargraph.classes.graphdata

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val relativeid:RelativeLayout=findViewById(R.id.relativeid)
        val data=ArrayList<graphdata>()
        for (i in 0 until 10)
            data.add(graphdata(50*i,"hello$i"))
        val graph= Creategraph(this,relativeid,data,40f,getColor(R.color.black),false,true,getColor(R.color.avid))

    }
}