package com.example.bargraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.bargraph.classes.Creategraph

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val relativeid:RelativeLayout=findViewById(R.id.relativeid)
        val data: IntArray = IntArray(10)
        for (i in 0 until 10)
            data[i] = 10 * i
        val graph= Creategraph(this,relativeid,data,40f,getColor(R.color.black),false)

    }
}