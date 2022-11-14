package com.zxy.zxyroom.database

import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zxy.zxyroom.tools.Applications

/**
 * Created by zsf on 2021/12/17 16:46
 * ******************************************
 * *
 * ******************************************
 */
object DBCommon {
    var dbName = "common.db"

    @Volatile
    lateinit var commonDataBase: CommonDataBase

    init {
        instance()
    }
    private fun instance(): CommonDataBase {
        if (!::commonDataBase.isInitialized) {
            synchronized(CommonDataBase::class.java) {
                if (!::commonDataBase.isInitialized) {
                    commonDataBase = Room.databaseBuilder(
                        Applications.context(),
                        CommonDataBase::class.java,
                        dbName
                    ).addMigrations(object : Migration(1, 1) {
                        override fun migrate(database: SupportSQLiteDatabase) {
//                                database.execSQL("ALTER TABLE user ADD age INTEGER Default 0 not null ")
                        }

                    })
                      .allowMainThreadQueries()//支持主线程访问数据库
                        .build()
                }
            }
        }
        return commonDataBase
    }
}