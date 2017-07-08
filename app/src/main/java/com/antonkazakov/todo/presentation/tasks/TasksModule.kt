package com.antonkazakov.todo.presentation.tasks

import com.antonkazakov.todo.data.repository.TasksRepository
import com.antonkazakov.todo.presentation.di.ActivityScope
import com.antonkazakov.todo.presentation.task.ITasksPresenter
import com.antonkazakov.todo.presentation.task.ITasksView
import com.antonkazakov.todo.presentation.task.TasksPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */
@Module
class TasksModule(val view: ITasksView) {

    @ActivityScope
    @Provides
    fun provideTasksPresenter(tasksRepository: TasksRepository): ITasksPresenter {
        return TasksPresenter(tasksRepository, view)
    }

}