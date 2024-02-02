package com.sioux.anthony.androidapp.homepage

import android.util.Log
import com.google.common.base.Ascii
import kotlinx.coroutines.runBlocking
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress



fun sendUDP(ipAddress:String,port:Int,action:String){

    Log.d("button", "函数被调用")

    val ipObject= InetAddress.getByName(ipAddress)
    Log.d("button", ipObject.hostAddress)

    Log.d("button", port.toString())

    val bytes = action.toByteArray()

    val stringBuilder = StringBuilder()
    for(i in bytes.indices){stringBuilder.append(bytes[i])}
    Log.d("button", stringBuilder.toString())






}