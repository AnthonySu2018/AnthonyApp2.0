package com.sioux.anthony.androidapp.homepage

import android.util.Log
import com.google.common.base.Ascii
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.IOError
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress



fun sendUDP(remoteHost:String,remotePort:Int,action:String){
    Log.d("button", "函数被调用")
    val socket = DatagramSocket()

    val remoteIP = InetAddress.getByName(remoteHost)

    val outputData: ByteArray = action.toByteArray()

    val stringBuilder = StringBuilder()
    for(i in outputData.indices){stringBuilder.append(outputData[i])}
    Log.d("button", stringBuilder.toString())







    try {

        runBlocking {
            launch(Dispatchers.IO) {
                val outputPacket = DatagramPacket(outputData, outputData.size, remoteIP, remotePort)

                socket.send(outputPacket)
                Log.d("button", "数据已发送")


            }


        }




    } catch (_:IOException){
    }finally{
        socket.close();
    }


/*

    val ipObject= InetAddress.getByName(remoteHost)
    Log.d("button", ipObject.hostAddress)

    Log.d("button", remotePort.toString())

    val bytes = action.toByteArray()

    val stringBuilder = StringBuilder()
    for(i in bytes.indices){stringBuilder.append(bytes[i])}
    Log.d("button", stringBuilder.toString())
*/






}