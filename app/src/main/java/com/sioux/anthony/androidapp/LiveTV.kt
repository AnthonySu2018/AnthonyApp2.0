package com.sioux.anthony.androidapp



import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

import androidx.navigation.NavHostController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun LiveTV(navController: NavHostController) {

    var room by remember {
        mutableStateOf("")
    }


    Column(){
        Column(Modifier.weight(1F)){

            if (room == "MultiFunctionHall"){ MultiFunctionHall()}
            else if (room == "LargeClass"){ }
            else if (room == "MiddleClass"){ }
            Text(text = "请选择要观看的空间")
        }
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ){
            Button(onClick = { room = "LargeClass"}) {
                Text(text ="19F大教室")
            }
            Spacer(Modifier.padding(10.dp))
            Button(onClick = { room = "MultiFunctionHall" }) {
                Text(text ="多功能厅")
            }
            Spacer(Modifier.padding(10.dp))
            Button(onClick = { room = "MiddleClass" }) {
                Text(text ="18F中教室")
            }


        }
    }



}




@Composable
fun MultiFunctionHall(){
    val url = "http://10.19.51.168/0.mp4"
    val context = LocalContext.current
    var playWhenReady by remember { mutableStateOf(true)}
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(url))
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            playWhenReady = playWhenReady
            prepare()
            play()
        }
    }
    DisposableEffect(
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = false
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            }
        )
    ) {
        onDispose {
            exoPlayer.release()
        }
    }

}
