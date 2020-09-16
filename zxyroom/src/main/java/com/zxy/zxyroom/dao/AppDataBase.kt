package com.zxy.zxyroom.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zxy.zxyroom.empty.StudentBean
import com.zxy.zxyroom.empty.TearchBean

/**
 * Created by zxy on 2020/9/15 20:10
 * ******************************************
 * *
 * ******************************************
 */

@Database(entities = [StudentBean::class, TearchBean::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    abstract fun teacherDao(): TeacherDao

    companion object {
        var dbName = "User.db"
        @Volatile
        private var instance: AppDataBase? = null

        fun instance(mContext: Context): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            mContext,
                            AppDataBase::class.java,
                            dbName
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return instance!!
        }
    }


}