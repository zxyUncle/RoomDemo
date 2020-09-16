package com.zxy.roomdemo

import android.app.Application
import android.util.Log
import kotlin.properties.Delegates

/**
 * Created by zxy on 2020/9/11 18:12
 * ******************************************
 * *
 * ******************************************
 */
class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
