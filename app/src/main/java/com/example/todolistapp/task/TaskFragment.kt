package com.example.todolistapp.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.ViewModel.TaskViewModel
import com.example.todolistapp.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

    private val viewModel : TaskViewModel by viewModels()
    private lateinit var adapter :TaskAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding  = FragmentTaskBinding.inflate(inflater)

        binding.lifecycleOwner =this
        binding.viewModel = viewModel

        adapter = TaskAdapter()
        viewModel.getAllTask.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        binding.apply {

            binding.recyclerView.adapter = adapter

            floatingActionButton.setOnClickListener{

                findNavController().navigate(R.id.action_taskFragment_to_addFragment)

            }

        }

        // Inflate the layout for this fragment
        return binding.root
    }


}