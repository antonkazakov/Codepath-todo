package com.antonkazakov.todo.presentation.tasks

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
class TasksPresenter(val tasksRepository: TasksRepository, val tasksView: ITasksView) : ITasksPresenter {

    override fun getTasks() {
        async(CommonPool) {
            for (i in 1..10) {
                val task = Task(title = "test$i", description = "desc$i")
                tasksRepository.insertTask(task)
            }
            val data: Deferred<List<Task>?> = bg {
                tasksRepository.getTasks()
            }
            data.await()?.let { tasksView.showTasks(it) }
        }
    }

}