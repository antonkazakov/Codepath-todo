package com.antonkazakov.todo.presentation.screens.addtask

import com.antonkazakov.todo.data.repository.ITasksRepository
import com.antonkazakov.todo.presentation.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
@Module
class AddTaskModule(val addTaskView: IAddTaskView) {

    @Provides
    @ActivityScope
    fun provideAddTaskPresenter(tasksRepository: ITasksRepository): IAddTaskPresenter {
        return AddTaskPresenter(addTaskView, tasksRepository)
    }

}