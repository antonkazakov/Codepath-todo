package com.antonkazakov.todo.presentation.screens.task

import com.antonkazakov.todo.data.repository.TasksRepository
import com.antonkazakov.todo.presentation.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
@Module
class TaskModule(val view: ITaskView) {

    @ActivityScope
    @Provides
    fun provideTaskPresenter(tasksRepository: TasksRepository): ITaskPresenter {
        return TaskPresenter(view, tasksRepository)
    }

}