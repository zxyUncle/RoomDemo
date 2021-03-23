package com.zxy.zxyroom.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zxy.zxyroom.empty.StudentBean
import com.zxy.zxyroom.empty.TearchBean
import com.zxy.zxyroom.tools.Applications

/**
 * Created by zxy on 2020/9/15 20:10
 * ******************************************
 * *
 * ******************************************
 */
var roomDao:AppDataBase = AppDataBase.instance()

@Database(entities = [StudentBean::class, TearchBean::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    abstract fun teacherDao(): TeacherDao

    companion object {
        var dbName = "User.db"
        @Volatile
        private lateinit var appDataBase: AppDataBase

        fun instance(): AppDataBase {
            if (!::appDataBase.isInitialized) {
                synchronized(AppDataBase::class.java) {
                    if (!::appDataBase.isInitialized) {
                        appDataBase = Room.databaseBuilder(
                            Applications.context(),
                            AppDataBase::class.java,
                            dbName
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return appDataBase
        }
    }


}