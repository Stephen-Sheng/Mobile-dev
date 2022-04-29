package com.example.mobile_dev

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_dev.databinding.FragmentEmployeeDetailBinding
import com.example.mobile_dev.databinding.FragmentEmployeeDetailContentBinding
import com.example.mobile_dev.databinding.FragmentTaskBinding

class EmployeeTaskDetailRecyclerViewAdapter (
    private val values: List<ViewModel.TaskObj.TaskItem>,
    private val onClickRecycler: () -> Unit
) : RecyclerView.Adapter<EmployeeTaskDetailRecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            FragmentEmployeeDetailContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.btnView.text = item.content

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentEmployeeDetailContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val btnView: Button = binding.employeeTaskDetail
        init {
            btnView.setOnClickListener {
                Log.d("DEBUG",values[absoluteAdapterPosition].toString())
                onClickRecycler()
            }
        }


        override fun toString(): String {
            return super.toString() + " '" + btnView.text + "'"
        }
    }

}