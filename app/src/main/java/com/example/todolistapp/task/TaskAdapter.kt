package com.example.todolistapp.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.DataBase.TaskEntry
import com.example.todolistapp.databinding.RowLayoutBinding
import com.example.todolistapp.task.TaskAdapter.*

class TaskAdapter: ListAdapter<TaskEntry, ViewHolder>(TaskDiffCallback){


    companion object TaskDiffCallback:DiffUtil.ItemCallback<TaskEntry>(){
        override fun areItemsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem == newItem



    }




    class ViewHolder(val binding :RowLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
           fun bind(taskEntry: TaskEntry)
           {
               binding.taskentry = taskEntry
               binding.executePendingBindings()
           }
    }





    override fun onCreateViewHolder(parent :ViewGroup , viewType :Int):ViewHolder
    {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }







}



