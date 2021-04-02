package com.example.testtodo.ui.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtodo.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_task_list.*

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    var items = listOf<TaskListItem>(
        TaskListItem(0, "Task", true,"21.12.21"),
        TaskListItem(1, "Task1", false,"21.12.21"),
        TaskListItem(2, "Task2", true,null)
    )
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task_list, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: TaskListItem) {
            with(item) {
                checkbox.isChecked = isChecked
                tvName.text = name
            }
        }

    }

}
