package com.zxy.zxyroom.dao

import androidx.room.*

/**
 * Created by zxy on 2020/9/15 20:05
 * ******************************************
 * *
 * ******************************************
 */
@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: T):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: MutableList<T>):MutableList<Long>

    @Delete
    fun delete(element: T):Int

    @Delete
    fun deleteList(elements: MutableList<T>):Int

    @Delete
    fun deleteSome(vararg elements: T):Int

    @Update
    fun update(element: T):Int

    @Update
    fun updateList(elements: MutableList<T>):Int

}