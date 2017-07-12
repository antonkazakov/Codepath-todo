package com.antonkazakov.todo.presentation.screens.tasks

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.antonkazakov.todo.App
import com.antonkazakov.todo.R
import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.repository.TasksRepository
import com.antonkazakov.todo.presentation.screens.task.TaskActivity
import javax.inject.Inject

class TasksActivity : AppCompatActivity(), ITasksView, TasksAdapter.TasksListClickListener {

    val tasksAdapter: TasksAdapter = TasksAdapter(this)

    lateinit var recyclerView: RecyclerView

    @Inject lateinit var tasksPresenter: ITasksPresenter

    @Inject lateinit var tasksRepo: TasksRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = tasksAdapter
        (application as App).appComponent.plusTasksComponent(TasksModule(this)).inject(this)
        tasksPresenter.getTasks()
    }

    override fun onClick(id: Long) {
        startActivity(TaskActivity.createExplicitIntent(this, id))
    }

    override fun showError() {

    }

    override fun showCriticalError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading(isLoading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTasks(tasks: List<Task>) {
        tasksAdapter.insertData(tasks)
    }

}
