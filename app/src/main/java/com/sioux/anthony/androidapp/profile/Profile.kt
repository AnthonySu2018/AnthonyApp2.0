package com.sioux.anthony.androidapp.profile

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun Profile(navController: NavHostController) {
    Loginpageview()
}



@Composable
fun Loginpageview(){

    Text(text="暂未开发，无需登录")
}