package com.sioux.anthony.androidapp.homepage

import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.text.ClickableText

@Composable
fun PowerUp(navController: NavHostController) {
    PowerUpView()
}

@Composable
fun PowerUpView(){
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .align(Alignment.CenterHorizontally) // 水平居中
            .align(Alignment.CenterVertically) // 垂直居中
    ){
        Button(onClick = {
            Log.i("button", "一键开启所有设备按钮被点击")

            Toast.makeText(context,"一键开启所有设备按钮被点击", Toast.LENGTH_SHORT).show()
        }) { Text(text = "一键开启所有设备",fontSize = 40.sp) }

    }


}