package com.sioux.anthony.androidapp.tools
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.io.OutputStream
import java.net.Socket

fun sendTCPHEXStr(remoteHost:String,remotePort:Int,action:String){

    println("sendTCPHEXStr函数被调用")

    val actionStr = action.replace(" ","")
    println(actionStr)
    val outputData: ByteArray = hexStringToByteArray(actionStr)

    val socket = Socket(remoteHost, remotePort)


        try {
        runBlocking {
            launch(Dispatchers.IO) {

                val outputStream: OutputStream = socket.getOutputStream()
                    outputStream.write(outputData)
                    outputStream.flush() // 确保数据发送

                println("数据已发送。")
            }
        }
        } catch (_: IOException){
        }finally{
            socket.close()
        }


    }