package com.example.todolistapp.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntry (

    @PrimaryKey
    var id :Int ,
    var title : String ,
    var priority : Int ,
    var timeStamp : Long


)