package com.zxy.zxyroom.dao

import androidx.room.Dao
import androidx.room.Query
import com.zxy.zxyroom.empty.StudentBean

/**
 * Created by zxy on 2020/9/15 20:06
 * ******************************************
 * *
 * ******************************************
 */
@Dao
interface StudentDao: BaseDao<StudentBean> {

    @Query("select * from Student")
    fun queryAll():MutableList<StudentBean>

    @Query("select * from Student where studentID = :studentID")
    fun queryId(studentID:Int): StudentBean

    @Query("select * from Student order by studentID desc ")
    fun queryOrderByDesc():MutableList<StudentBean>

    @Query("delete from Student")
    fun deleteAll():Int
}