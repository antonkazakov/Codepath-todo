package com.antonkazakov.todo.presentation.tasks

import com.antonkazakov.todo.presentation.di.ActivityScope
import dagger.Subcomponent

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(TasksModule::class))
interface TasksComponent {

    fun inject(tasksActivity: TasksActivity)

}