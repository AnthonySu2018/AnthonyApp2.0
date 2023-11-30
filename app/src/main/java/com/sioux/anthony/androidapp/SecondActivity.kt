package com.sioux.anthony.androidapp


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    var url = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second)


        url = intent.getStringExtra("url").toString()
        if (url != null) {
            Log.d("url",url)
        }



    }
}