package com.zxy.zxyroom.dao

import androidx.room.Dao
import androidx.room.Query
import com.zxy.zxyroom.empty.TearchBean

/**
 * Created by zxy on 2020/9/15 20:07
 * ******************************************
 * *
 * ******************************************
 */
@Dao
interface TeacherDao : BaseDao<TearchBean> {

    @Query("select * from Tearcher")
    fun queryAll(): MutableList<TearchBean>

    @Query("select * from Tearcher where tearcherId = :tearcherId")
    fun queryId(tearcherId: Int): TearchBean

    @Query("select * from Tearcher order by tearcherId desc ")
    fun queryOrderByDesc(): MutableList<TearchBean>

    @Query("delete from Tearcher")
    fun deleteAll():Int

}