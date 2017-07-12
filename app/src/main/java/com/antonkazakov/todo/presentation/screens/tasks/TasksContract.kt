package com.antonkazakov.todo.presentation.screens.tasks

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.presentation.base.BaseView

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */

interface ITasksView : BaseView {

    fun showTasks(tasks: List<Task>)

}

interface ITasksPresenter {

    fun getTasks()

}