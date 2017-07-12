package com.antonkazakov.todo.presentation.screens.task

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.presentation.base.BaseView

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */
interface ITaskView : BaseView {

    fun showTask(task: Task)

}

interface ITaskPresenter {

    fun getTask(id: Long)

}
