package com.antonkazakov.todo.presentation.screens.addtask

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.presentation.base.BaseView

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
interface IAddTaskView : BaseView {

    fun taskAdded(task: Task)

}

interface IAddTaskPresenter {

    fun addTask(task : Task)

}