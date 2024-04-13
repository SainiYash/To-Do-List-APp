package com.example.todolistapp.Repository

import com.example.todolistapp.DataBase.TaskDao
import com.example.todolistapp.DataBase.TaskEntry

class TaskRepository( val taskDao: TaskDao)
{

    suspend fun insert(taskEntry: TaskEntry){
        taskDao.insert(taskEntry)
    }

    suspend fun update(taskEntry: TaskEntry){
        taskDao.update(taskEntry)
    }

    suspend fun delete(taskEntry: TaskEntry)
    {
        taskDao.delete(taskEntry)
    }

    suspend fun deleteAll()
    {
        taskDao.deleteAll()
    }

    fun getAllTask() = taskDao.getAllTask()




}