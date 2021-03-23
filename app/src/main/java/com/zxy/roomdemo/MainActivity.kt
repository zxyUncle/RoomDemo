package com.zxy.roomdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zxy.zxyroom.dao.roomDao
import com.zxy.zxyroom.empty.StudentBean
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by zxy on 2020/9/11 17:56
 * ******************************************
 * * Room
 * ******************************************
 */
class MainActivity : AppCompatActivity() {

    private val studentDao by lazy {
        roomDao.studentDao()
    }
    private val tearcherDao by lazy {
        roomDao.teacherDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInsert.setOnClickListener {
            insertList()
        }
        btnSelectAll.setOnClickListener {
            selectAll()
        }
        btnDeleteAll.setOnClickListener {
            val deleteAll = studentDao.deleteAll()
            Log.e("zxy", deleteAll.toString())
        }
        btnUpdate.setOnClickListener {
            val update = studentDao.update(StudentBean(1, "s1", "大学"))
            Log.e("zxy", update.toString())
        }
    }

    private fun insertList() {
        var sList: MutableList<StudentBean> = mutableListOf<StudentBean>()
        sList.add(StudentBean(1, "s1", "小学"))
        sList.add(StudentBean(2, "s2", "小学"))
        sList.add(StudentBean(3, "s3", "小学"))
        sList.add(StudentBean(4, "s4", "大学"))
        sList.add(StudentBean(5, "s5", "大学"))
        sList.add(StudentBean(6, "s6", "大学"))

        //可以直接把list传进去，也可以一个一个单独添加
        val insertList = studentDao.insertList(sList)
        Log.e("zxy", insertList.size.toString())
    }

    private fun selectAll() {
        var queryAll: MutableList<StudentBean> = studentDao.queryAll()
        for (i in queryAll.indices) {
            Log.e("zxy", queryAll[i].toString())
        }
    }
}
