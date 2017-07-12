package com.antonkazakov.todo.presentation.screens.task

import com.antonkazakov.todo.presentation.di.ActivityScope
import dagger.Subcomponent

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(TaskModule::class))
interface TaskComponent {

    fun inject(taskActivity: TaskActivity)

}