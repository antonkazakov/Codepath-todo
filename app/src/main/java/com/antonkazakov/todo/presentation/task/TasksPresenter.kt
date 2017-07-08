package com.antonkazakov.todo.presentation.task

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
class TasksPresenter(val tasksRepository: TasksRepository, val taskView: ITasksView) : ITasksPresenter {

    override fun getTasks() {
        async(CommonPool) {
            for (i in 1..10){
                var task = Task(title = "test$i", description = "desc$i")
                tasksRepository.insertTask(task)
            }
            val data: Deferred<List<Task>?> = bg {
                tasksRepository.getTasks()
            }
            data.await()?.let { taskView.showTasks(it) }
        }
    }

}