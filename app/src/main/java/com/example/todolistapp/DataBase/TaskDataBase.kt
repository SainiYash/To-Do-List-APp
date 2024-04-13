package com.example.todolistapp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TaskEntry::class], version = 1, exportSchema = false)
abstract class TaskDataBase : RoomDatabase(){

    abstract val taskDao : TaskDao


    companion object{
        @Volatile
        private var INSTANCE : TaskDataBase? = null
        fun getDatabase(context: Context): TaskDataBase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataBase::class.java,
                        "task_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }




}