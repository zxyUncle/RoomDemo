package com.zxy.zxyroom.empty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Created by zsf on 2021/12/17 16:18
 * ******************************************
 * *
 * ******************************************
 */
@Entity(tableName = "First2Bean")
data class First2Bean(
    @PrimaryKey(autoGenerate = true)//主键
    @ColumnInfo(name = "first2ID")
    var first2ID:Int
)