package com.sioux.anthony.androidapp.homepage

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun Homepage(navController: NavHostController) {
    Homepageview()
}


@Composable
fun Homepageview() {

    //val prefaceIp by remember { mutableStateOf("") }

    Column(){
        val context = LocalContext.current
        Column(Modifier.weight(1F)){
            Text(text = "Author：Anthony, Date:2024-02-04, Version:1.0.0", fontSize = 10.sp)
            Text(text = "序厅LED大屏", fontSize = 20.sp)
            Row(){

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "序厅 视频1 button被点击")
                    sendUDP(remoteHost = "172.18.0.33", remotePort = 50505, action = "172.18.0.33K0101END")
                    Toast.makeText(context,"序厅 视频1 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "视频") }


                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "序厅 停止 button被点击")
                    sendUDP(remoteHost = "172.18.0.33", remotePort = 50505, action = "172.18.0.33STOPPEND")
                    Toast.makeText(context,"序厅 停止 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "停止") }

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "序厅 拍照模式 button被点击")
                    sendUDP(remoteHost = "172.18.0.33", remotePort = 50505, action = "172.18.0.33B0601END")
                    Toast.makeText(context,"序厅 拍照模式 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "拍照") }

            }
        }


        Column(Modifier.weight(1F)){
            Text(text = "历史墙投影仪", fontSize = 20.sp)
            Row(){

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "历史墙投影仪 视频 button被点击")
                    sendUDP(remoteHost = "172.18.0.11", remotePort = 50505, action = "172.18.0.11K0101END")
                    Toast.makeText(context,"历史墙投影仪 视频 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "视频") }

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "历史墙投影仪 停止 button被点击")
                    sendUDP(remoteHost = "172.18.0.11", remotePort = 50505, action = "172.18.0.11STOPPEND")
                    Toast.makeText(context,"历史墙投影仪 停止 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "停止") }


            }
        }


        Column(Modifier.weight(1F)){
            Text(text = "IntelVision", fontSize = 20.sp)
            Row(){

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "IntelVision 视频 button被点击")
                    sendUDP(remoteHost = "172.18.0.34", remotePort = 50505, action = "172.18.0.34K0101K0101END")
                    Toast.makeText(context,"IntelVision 视频 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "视频") }

                Spacer(Modifier.padding(1.dp))
                Button(onClick = {
                    Log.i("button", "IntelVision 视频 button被点击")
                    sendUDP(remoteHost = "172.18.0.34", remotePort = 50505, action = "172.18.0.34STOPPEND")
                    Toast.makeText(context,"IntelVision 视频 button被点击",Toast.LENGTH_SHORT).show()
                }) { Text(text = "停止") }



            }
        }

    }




}
