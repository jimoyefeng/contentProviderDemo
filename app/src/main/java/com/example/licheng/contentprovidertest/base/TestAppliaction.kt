package com.example.licheng.contentprovidertest.base

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.util.Log

class TestAppliaction : Application() {


    companion object {
        private var instance: TestAppliaction? = null
            get() {
                if (field == null) {
                    field = TestAppliaction()
                }
                return field
            }
        fun get(): TestAppliaction{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }


//
//    companion object {
//        val instance: TestAppliaction by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            TestAppliaction() }
//    }


    var valueme: String = ""

    override fun onCreate() {
        super.onCreate()


        Log.i("Test", "TestAppliaction-=-==-=-=-=>" + getName())
    }


    fun getName(): String {

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



    fun setValue(var1:String){

        valueme=var1

    }

    fun getValue():String{



        return valueme
    }


}
