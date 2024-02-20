package com.sioux.anthony.androidapp.homepage

import android.util.Log
import android.view.Gravity
import android.widget.Toast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

import androidx.compose.ui.Alignment


@Composable
fun PowerUp(navController: NavHostController) {
    PowerUpView()
}

@Composable
fun PowerUpView(){
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize() // 让Box占据全屏
            .wrapContentSize(Alignment.Center) // 让内容居中
    ){
        Button(onClick = {
            Log.i("button", "一键开启所有设备按钮被点击")

            Toast.makeText(context,"一键开启所有设备按钮被点击", Toast.LENGTH_SHORT).show()
        }) { Text(text = "一键开启所有设备",fontSize = 40.sp) }

    }


}