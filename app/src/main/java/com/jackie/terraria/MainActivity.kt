package com.jackie.terraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Foo().i("jackie")
//        view.setOnClickListener(object : OnClickListener{
//            override fun onClick(p0: View?) {
//
//            }
//        })
//
//        view.setOnClickListener {
//
//        }
    }

}