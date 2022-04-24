package com.example.mobile_dev

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.mobile_dev.placeholder.PlaceholderContent.PlaceholderItem
import com.example.mobile_dev.databinding.FragmentProjectBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyProjectListPageRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyProjectListPageRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentProjectBinding.inflate(
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

    inner class ViewHolder(binding: FragmentProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val btnView: Button = binding.itemBtn

        override fun toString(): String {
            return super.toString() + " '" + btnView.text + "'"
        }
    }

}