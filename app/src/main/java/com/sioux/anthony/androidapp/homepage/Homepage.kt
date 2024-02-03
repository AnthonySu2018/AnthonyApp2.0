package com.sioux.anthony.androidapp.homepage

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun Homepage(navController: NavHostController) {
    HomePageView()
}


@Composable
fun HomePageView() {

    //val prefaceIp by remember { mutableStateOf("") }

    Column(){
        Column(Modifier.weight(1F)){
                Text(text = "序厅LED大屏", fontSize = 30.sp)
                Row(){
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = {
                        Log.i("button", "序厅视频1button被点击")
                        sendUDP(remoteHost = "172.18.0.33", remotePort = 50505, action = "172.18.0.33K0101END")
                    }) { Text(text = "视频1") }

                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "序厅停止button被点击") }) { Text(text = "停止") }
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "序厅停止button被点击") }) { Text(text = "拍照模式") }
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "序厅停止button被点击") }) { Text(text = "拍照灯关闭") }
                }
        }


        Column(Modifier.weight(1F)){
                Text(text = "历史墙投影仪", fontSize = 30.sp)
                Row(){
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "历史墙投影仪视频1button被点击") }) { Text(text = "视频1") }
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "历史墙投影仪停止button被点击") }) { Text(text = "停止") }
                }
            }


        Column(Modifier.weight(1F)){
                Text(text = "IntelVision", fontSize = 30.sp)
                Row(){
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "IntelVision视频1button被点击") }) { Text(text = "视频1") }
                    Spacer(Modifier.padding(1.dp))
                    Button(onClick = { Log.i("button", "IntelVision停止button被点击") }) { Text(text = "停止") }
                }
        }

    }




}
