package com.antonkazakov.todo.presentation.screens.addtask

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.repository.ITasksRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.anko.coroutines.experimental.bg
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * @author Anton Kazakov
 * *
 * @date 12.07.17.
 */
class AddTaskPresenterTest {

    @Mock
    lateinit var tasksRepository: ITasksRepository

    @Mock
    lateinit var addTaskView: IAddTaskView

    lateinit var addTaskPresenter: IAddTaskPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        addTaskPresenter = AddTaskPresenter(addTaskView, tasksRepository)
    }

    @Test
    fun addTaskSuccess() {
        `when`(tasksRepository.insertTask(any<Task>())).thenReturn(true)
        runBlocking {
            addTask(Task(title = "", description = ""))
        }
        verify(addTaskView, times(1)).taskAdded(any<Task>())
    }

    @Test
    fun addTaskFailure() {
        `when`(tasksRepository.insertTask(any<Task>())).thenReturn(false)
        runBlocking {
            addTask(Task(title = "", description = ""))
        }
        verify(addTaskView, times(1)).showError()
    }


    suspend fun addTask(task: Task) {
        async(CommonPool) {
            val data: Deferred<Boolean> = bg {
                tasksRepository.insertTask(task)
            }
            if (data.await()) {
                addTaskView.taskAdded(task)
            }
        }
    }

    private fun <T> any(): T {
        return null as T
    }


}