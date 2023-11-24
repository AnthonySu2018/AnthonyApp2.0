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
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl("https://m.igbacenter.com/activity/saishi/type_id/186.html")
        }
    },modifier = Modifier.fillMaxWidth())
}