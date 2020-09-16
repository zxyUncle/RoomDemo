package com.zxy.zxyroom.empty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by zxy on 2020/9/15 20:01
 * ******************************************
 * * Student表
 * ******************************************
 */
@Entity(tableName = "Student")
data class StudentBean(
    @PrimaryKey(autoGenerate = true)
    var studentId: Long? = null,
    @ColumnInfo(name = "s_name")
    var studentName: String? = null,
    @ColumnInfo(name = "s_type")
    var studentType: String? = null
)