package com.sioux.anthony.androidapp.pages


import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sioux.anthony.androidapp.tools.sendTCPHEXStr
import com.sioux.anthony.androidapp.tools.sendUDPHEXStr

@Composable
fun Settings(navController: NavHostController) {
    SettingsView()
}

@Composable
fun SettingsView(){
    SwitchBlock("机房时序电源","sendTCPHEXStr","172.18.0.71",
        40004,"55 01 A4 00 00 A5","55 01 A5 00 00 A4")

}

@Composable
fun SwitchBlock(deviceName:String,methodName:String,remoteHost:String,remotePort:Int,openAction:String,closeAction:String){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth() //
            .wrapContentSize(Alignment.Center) // 让内容居中
    ){
        Text(text = deviceName, fontSize = 20.sp)
        Row(){
            Button(onClick = {
                if(methodName == "sendTCPHEXStr"){
                    sendTCPHEXStr(remoteHost,remotePort,openAction)
                }
                else if(methodName == "sendUDPHEXStr"){
                    sendUDPHEXStr(remoteHost,remotePort,openAction)
                }
                Toast.makeText(context,deviceName+"的开启按钮被点击", Toast.LENGTH_SHORT).show()
            }){
                Text(text="开启")
            }
            Spacer(Modifier.padding(10.dp))
            Button(onClick = {
                if(methodName == "sendTCPHEXStr"){
                    sendTCPHEXStr(remoteHost,remotePort,closeAction)
                }
                else if(methodName == "sendUDPHEXStr"){
                    sendUDPHEXStr(remoteHost,remotePort,closeAction)
                }
                Toast.makeText(context,deviceName+"的关闭按钮被点击", Toast.LENGTH_SHORT).show()
            }){
                Text(text="关闭")
            }
        }
    }

}