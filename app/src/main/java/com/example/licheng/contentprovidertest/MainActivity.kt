package com.example.licheng.contentprovidertest

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.i("Test", "processName-=-==-=-=-=>"+getName())



        btn_1.setOnClickListener{



            val intent1=Intent(this@MainActivity,TestActivity1::class.java)
            startActivity(intent1)

        }

        btn_2.setOnClickListener{


            val intent2=Intent(this@MainActivity,TestActivity2::class.java)
            startActivity(intent2)

        }
    }


    fun   getName() :String {

        val pid = android.os.Process.myPid()//获取进程pid
        var processName = ""
        val am = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager//获取系统的ActivityManager服务
        for (appProcess in am.runningAppProcesses) {
            if (appProcess.pid == pid) {
                processName = appProcess.processName
                break
            }
        }

        return processName
    }


}
