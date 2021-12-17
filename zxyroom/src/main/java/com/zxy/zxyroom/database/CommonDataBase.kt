package com.zxy.zxyroom.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zxy.zxyroom.dao.StudentDao
import com.zxy.zxyroom.dao.TeacherDao
import com.zxy.zxyroom.empty.StudentBean
import com.zxy.zxyroom.empty.TearchBean
import com.zxy.zxyroom.tools.Applications

/**
 * Created by zxy on 2020/9/15 20:10
 * ******************************************
 * *
 * ******************************************
 */
var commonDataBase: CommonDataBase = DBCommon.commonDataBase

@Database(entities = [StudentBean::class, TearchBean::class], version = 1)
abstract class CommonDataBase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
}