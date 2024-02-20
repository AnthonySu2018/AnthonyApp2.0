package com.sioux.anthony.androidapp.pages


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ShutDown(navController: NavHostController) {
    ShutDownView()
}

@Composable
fun ShutDownView(){

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize() // 让Box占据全屏
            .wrapContentSize(Alignment.Center) // 让内容居中
    ){
        Button(onClick = {
            Log.i("button", "一键关闭所有设备按钮被点击")

            Toast.makeText(context,"一键关闭所有设备按钮被点击", Toast.LENGTH_SHORT).show()
        }) { Text(text = "一键关闭所有设备",fontSize = 40.sp) }

    }


}