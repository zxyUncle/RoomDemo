package com.zxy.zxyroom.empty

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by zsf on 2021/12/17 16:24
 * ******************************************
 * *
 * ******************************************
 */

data class First1WithFirst2Bean(
    @Embedded var first1Bean:First1Bean, //注入
    @Relation(
        parentColumn = "first1ID",//关联键
        entityColumn = "first2ID"//关联键
    )
    val first2s:List<First2Bean>
)