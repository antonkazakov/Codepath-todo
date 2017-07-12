package com.antonkazakov.todo.presentation.screens.addtask

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.repository.ITasksRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
class AddTaskPresenter(val addTaskView: IAddTaskView, val tasksRepository: ITasksRepository) : IAddTaskPresenter {

    override fun addTask(task: Task) {
        async(CommonPool) {
            val data: Deferred<Boolean> = bg {
                tasksRepository.insertTask(task)
            }
            if (data.await()) {
                addTaskView.taskAdded(task)
            }
        }
    }

}