package com.antonkazakov.todo.data.di

import com.antonkazakov.todo.presentation.screens.addtask.AddTaskComponent
import com.antonkazakov.todo.presentation.screens.addtask.AddTaskModule
import com.antonkazakov.todo.presentation.screens.task.TaskComponent
import com.antonkazakov.todo.presentation.screens.task.TaskModule
import com.antonkazakov.todo.presentation.screens.tasks.TasksComponent
import com.antonkazakov.todo.presentation.screens.tasks.TasksModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun plusTasksComponent(tasksModule: TasksModule): TasksComponent

    fun plusTaskComponent(taskModule: TaskModule): TaskComponent

    fun plusAddTaskComponent(addTaskModule: AddTaskModule): AddTaskComponent

}