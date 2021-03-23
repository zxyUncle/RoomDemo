package com.zxy.zxyroom.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zxy.zxyroom.empty.StudentBean
import com.zxy.zxyroom.empty.TearchBean
import com.zxy.zxyroom.tools.Applications

/**
 * Created by zxy on 2020/9/15 20:10
 * ******************************************
 * *
 * ******************************************
 */
var roomDao: AppDataBase = AppDataBase.instance()

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
                        ).addMigrations(object : Migration(1, 1) {
                            override fun migrate(database: SupportSQLiteDatabase) {
//                                database.execSQL("ALTER TABLE user ADD age INTEGER Default 0 not null ")
                            }

                        }).allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return appDataBase
        }
    }


}