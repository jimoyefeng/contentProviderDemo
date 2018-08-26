package com.example.licheng.contentprovidertest

import android.app.ActivityManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.licheng.contentprovidertest.base.TestAppliaction
import kotlinx.android.synthetic.main.activity_test2.*

class TestActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        Log.i("Test", "processName-=-==-=-=-=>" + getName())


        btn.setOnClickListener {


            var value= TestAppliaction.get().getValue()


            Log.i("Test", "Test1-=-==-=-=-=>" + value)


        }



        btn2.setOnClickListener{



            /**
             * 对user表进行操作
             */

            // 设置URI
            val uri_user = Uri.parse("content://cn.scu.myprovider/user")

//            // 插入表中数据
//            val values = ContentValues()
//            values.put("_id", 3)
//            values.put("name", "Iverson")


            // 获取ContentResolver
            val resolver = contentResolver
            // 通过ContentResolver 根据URI 向ContentProvider中插入数据
//            resolver.insert(uri_user, values)

            // 通过ContentResolver 向ContentProvider中查询数据
            val cursor = resolver.query(uri_user, arrayOf("_id", "name"), null, null, null)
            while (cursor!!.moveToNext()) {
                System.out.println("query book:" + cursor.getInt(0) + " " + cursor.getString(1))
                // 将表中数据全部输出
            }
            cursor.close()
            // 关闭游标
        }
    }


    fun getName(): String {

        val pid = android.os.Process.myPid()//获取进程pid


        var processName = ""
        val am = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager//获取系统的ActivityManager服务
        for (appProcess in am.runningAppProcesses) {
//            if (appProcess.pid == pid) {
                processName = appProcess.processName
                break
//            }
        }

        return processName
    }
}
