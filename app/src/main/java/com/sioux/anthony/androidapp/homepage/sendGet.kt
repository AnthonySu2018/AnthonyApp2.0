package com.sioux.anthony.androidapp.homepage

import android.os.Build
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

fun sendGet(remoteHost:String,remotePort:Int,action:String) {

    val urlString = "http://${remoteHost}:${remotePort}/${action}"
    Log.d("button",urlString)
    val url = URL(urlString)

    try {

        runBlocking {
            launch(Dispatchers.IO) {
                with(url.openConnection() as HttpURLConnection) {
                    requestMethod = "GET"  // optional default is GET

                    println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        inputStream.bufferedReader().use {
                            it.lines().forEach { line ->
                                println(line)
                            }
                        }
                    } else {
                        val reader: BufferedReader = inputStream.bufferedReader()
                        var line: String? = reader.readLine()
                        while (line != null) {
                            System.out.println(line)
                            line = reader.readLine()
                        }
                        reader.close()
                    }
                }
            }
        }
    } catch (_: IOException){
        Log.d("button","IOException happen.")
    }finally{
        Log.d("button","finally")
    }
}