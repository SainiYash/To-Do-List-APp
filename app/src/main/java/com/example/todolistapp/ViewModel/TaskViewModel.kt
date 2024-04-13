package com.example.todolistapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.DataBase.TaskDataBase
import com.example.todolistapp.DataBase.TaskEntry
import com.example.todolistapp.Repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application):AndroidViewModel(application){

    private val taskDao = TaskDataBase.getDatabase(application).taskDao
    private val repository: TaskRepository
    val getAllTask : LiveData<List<TaskEntry>>

    init {
        repository = TaskRepository(taskDao)
        getAllTask = repository.getAllTask()
    }

    fun insert(taskEntry: TaskEntry)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(taskEntry)
        }
    }

    fun update(taskEntry: TaskEntry)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(taskEntry)
        }
    }

    fun delete(taskEntry: TaskEntry)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(taskEntry)
        }
    }

    fun deleteAll()
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }




}