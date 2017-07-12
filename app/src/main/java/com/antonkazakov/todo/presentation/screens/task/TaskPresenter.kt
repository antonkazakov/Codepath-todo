package com.antonkazakov.todo.presentation.screens.task

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.repository.TasksRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */
class TaskPresenter(val taskView: ITaskView, val tasksRepository: TasksRepository) : ITaskPresenter {

    override fun getTask(id: Long) {
        async(CommonPool) {
            val data: Deferred<Task?> = bg {
                tasksRepository.getTaskById(id)
            }
            data.await()?.let { taskView.showTask(it) }
        }
    }

}