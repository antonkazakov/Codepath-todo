package com.antonkazakov.todo.presentation.screens.addtask

import com.antonkazakov.todo.presentation.di.ActivityScope
import dagger.Subcomponent

/**
 * @author Anton Kazakov
 * @date 12.07.17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(AddTaskModule::class))
interface AddTaskComponent {

    fun inject(addTaskActivity: AddTaskActivity)

}