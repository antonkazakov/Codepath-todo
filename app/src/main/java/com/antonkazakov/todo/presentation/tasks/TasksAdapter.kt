package com.antonkazakov.todo.presentation.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.antonkazakov.todo.R
import com.antonkazakov.todo.data.beans.Task

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */

class TasksAdapter(val clickListener: TasksListClickListener) : RecyclerView.Adapter<TasksAdapter.TasksVH>() {

    var tasks: MutableList<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TasksVH {
        return TasksVH(LayoutInflater.from(parent?.context).inflate(R.layout.tasks_item, parent, false))
    }

    override fun onBindViewHolder(holder: TasksVH?, position: Int) {
        holder?.tvTitle?.text = tasks[position].title
        holder?.itemView?.setOnClickListener { clickListener.onClick(position.toLong()) }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun insertData(tasks1: List<Task>) {
        val tempSize = tasks.size
        tasks.addAll(tasks1)
        notifyItemRangeInserted(tempSize - 1, tasks1.size)
    }

    fun insertSingleItem(task: Task, position: Int) {
        tasks.add(position, task)
        notifyItemInserted(position)
    }

    class TasksVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tvTitle by lazy { itemView?.findViewById(R.id.task_title) as TextView }
    }

    interface TasksListClickListener {

        fun onClick(id: Long)

    }

}