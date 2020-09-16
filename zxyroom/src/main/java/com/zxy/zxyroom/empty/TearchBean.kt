package com.zxy.zxyroom.empty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by zxy on 2020/9/15 19:57
 * ******************************************
 * * Tearcher表
 * ******************************************
 */
@Entity(tableName = "Tearcher")
data class TearchBean(
    @PrimaryKey(autoGenerate = true)//Id
    var tearcherId: Long? = null,
    @ColumnInfo(name = "t_name")//姓名
    var tearchName: String? = null,
    @ColumnInfo(name = "t_year") //教学年限
    var teachYear: Int? = null
)