package com.zxy.zxyroom.empty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Created by zxy on 2020/9/15 20:01
 * ******************************************
 * * Student表
 * ******************************************
 */
@Entity(tableName = "Student")
data class StudentBean(
    @ColumnInfo(name = "s_studentId")
    var studentId: Long? = null,
    @ColumnInfo(name = "s_studentName")
    var studentName: String? = null,
    @ColumnInfo(name = "s_studentType")
    var studentType: String? = null,

    @Ignore  //忽略这个字段
    var aaaa: String? = null,
    @PrimaryKey(autoGenerate = true)//主键
    @ColumnInfo(name = "s_id")
    var id: Long? = null
) {

}