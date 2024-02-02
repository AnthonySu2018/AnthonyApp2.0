package com.sioux.anthony.androidapp.livetv



import android.content.Intent
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.focusable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

import androidx.navigation.NavHostController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import com.sioux.anthony.androidapp.SecondActivity3

@Composable
fun LiveTV(navController: NavHostController) {

    var room by remember  { mutableStateOf("LargeClass") }
    var url  by remember  { mutableStateOf("http://10.19.50.101:8080/stream.mp4") }



    Column(){
            Column(Modifier.weight(1F)){


                Column(Modifier.weight(1F)){
                    Text(text="大教室")
                    LiveCamera("http://10.19.50.101:8080/stream.mp4")
                }
                Column(Modifier.weight(1F)){
                    Text(text="多功能厅")
                    LiveCamera("http://10.19.50.102:8080/stream.mp4")
                }
                Column(Modifier.weight(1F)){
                    Text(text="中教室")
                    LiveCamera("http://10.19.50.103:8080/stream.mp4")
                }

            }
            Text(text="请选择想要观看的空间并点击全屏")
            Row(
                Modifier.align(Alignment.CenterHorizontally)
            ){
                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    url = "http://10.19.50.101:8080/stream.mp4"
                    room = "LargeClass"
                    Log.i("button", "LargeClass")

                }) {
                    Text(text ="大教室")
                }
                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    url = "http://10.19.50.102:8080/stream.mp4"
                    room = "MultiFunctionHall"
                    Log.i("button", "MultiFunctionHall")



                }) {
                    Text(text ="多功能厅")
                }
                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    url = "http://10.19.50.103:8080/stream.mp4"
                    room = "MiddleClass"
                    Log.i("button", "MiddleClass")

                }

                ) {
                    Text(text ="中教室")
                }
                Spacer(Modifier.padding(10.dp))
                ToSecond(url)
            }

    }



}

@Composable
fun ToSecond(url:String){
    val mContext = LocalContext.current

    Button(onClick = {

        mContext.startActivity(Intent(mContext, SecondActivity3::class.java).apply{
            putExtra("url",url)

        })
    }) {
        Text(text ="全屏")

    }
}



