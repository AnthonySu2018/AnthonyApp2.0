package com.sioux.anthony.androidapp.tools

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun shutDownAllDevices() {

    try {
        runBlocking {
            launch(Dispatchers.IO) {

                println("LED屏电箱关电")
                sendUDPHEXStr("172.18.0.6", 5000, "00 00 00 00 00 06 01 05 08 02 FF 00")

                println("机房时序电源关闭。")
                sendTCPHEXStr("172.18.0.71", 40004, "55 01 A5 00 00 A4")
                Thread.sleep(1000)

                println("T1灯光控制全关")
                sendTCPHEXStr("172.18.0.71", 20001, "05 0F 00 00 00 10 02 00 00 D0 E0")
                Thread.sleep(1000)

                println("T2灯光控制全关")
                sendTCPHEXStr("172.18.0.71", 20001, "06 0F 00 00 00 10 02 00 00 C4 10")
                Thread.sleep(1000)

                println("调光控制器1路关")
                sendTCPHEXStr("172.18.0.71", 30003, "01 05 00 01 00 00 9C 0A")
                Thread.sleep(1000)

                println("调光控制器2路关")
                sendTCPHEXStr("172.18.0.71", 30003, "01 05 00 02 00 00 6C 0A")
                Thread.sleep(1000)

                println("调光控制器3路关")
                sendTCPHEXStr("172.18.0.71", 30003, "01 05 00 03 00 00 3D CA")
                Thread.sleep(1000)

                println("调光控制器4路关")
                sendTCPHEXStr("172.18.0.71", 30003, "01 05 00 04 00 00 8C 0B")

                println("序厅LED播放盒关")
                sendUDP("172.18.0.33", 50505, "172.18.0.33STDBYEND")
                Thread.sleep(100)

                println("投影仪关")
                sendTCPHEXStr("172.18.0.73", 8000, "28 50 57 52 20 30 29")
                Thread.sleep(100)

                println("Intel Vision LED 播放盒关")
                sendUDP("172.18.0.34", 50505, "172.18.0.34STDBYEND")
                Thread.sleep(100)

                println("会议解决方案工控屏1关")
                sendTCPHEXStr("172.18.0.61", 8000, "DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("会议解决方案工控屏2关")
                sendTCPHEXStr("172.18.0.62", 8000, "DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("会议解决方案Maxhub关")
                sendTCPHEXStr("172.18.0.62", 8000, "00")
                Thread.sleep(100)

                println("会议解决方案全场智能平板关")
                sendTCPHEXStr("172.18.0.74", 8000, "DD FF 00 07 C1 31 00 00 01 01 F7 BB CC")
                Thread.sleep(100)

                println("智慧教室Maxhub关")
                sendTCPHEXStr("172.18.0.55", 8000, "00")
                Thread.sleep(100)

                println("智慧校园拼接屏关")
                sendTCPHEXStr("172.18.0.69", 20001, "D5 11 11 10 00 AA")
                Thread.sleep(100)

                println("CCG LED播放盒关")
                sendUDP("172.18.0.35", 50505, "172.18.0.35STDBYEND")
                Thread.sleep(100)

                println("汽车 LED播放盒关")
                sendUDP("172.18.0.36", 50505, "172.18.0.36STDBYEND")
                Thread.sleep(100)


                println("XFusion工控屏关")
                sendTCPHEXStr("172.18.0.44",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("芯片产业链工控屏关")
                sendTCPHEXStr("172.18.0.47",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("Motherboard工控屏关")
                sendTCPHEXStr("172.18.0.48",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("显卡工控屏关")
                sendTCPHEXStr("172.18.0.49",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("超能云终端工控屏关")
                sendTCPHEXStr("172.18.0.51",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("会议解决方案工控屏1关")
                sendTCPHEXStr("172.18.0.61",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("会议解决方案工控屏2关")
                sendTCPHEXStr("172.18.0.62",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("闸机工控屏关")
                sendTCPHEXStr("172.18.0.53",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("智慧灯杆工控屏关")
                sendTCPHEXStr("172.18.0.54",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("AI Box工控屏关")
                sendTCPHEXStr("172.18.0.55",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("缺陷检测工控屏关")
                sendTCPHEXStr("172.18.0.56,8000",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("大族激光工控屏关")
                sendTCPHEXStr("172.18.0.57",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("飞拍工控屏关")
                sendTCPHEXStr("172.18.0.58",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("机械臂工控屏关")
                sendTCPHEXStr("172.18.0.59",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)

                println("Green PC工控屏关")
                sendTCPHEXStr("172.18.0.45",8000,"DD FF 00 08 C1 15 00 00 01 AA AA DD BB CC")
                Thread.sleep(100)


            }
        }
            } catch (_: IOException){
        }finally{

        }

}