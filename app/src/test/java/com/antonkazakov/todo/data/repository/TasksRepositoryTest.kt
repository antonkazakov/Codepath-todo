package com.antonkazakov.todo.data.repository

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.db.MyDatabaseOpenHelper
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * @author Anton Kazakov
 * *
 * @date 12.07.17.
 */
@RunWith(RobolectricTestRunner::class)
@Config()
class TasksRepositoryTest {

    lateinit var dbHelper: MyDatabaseOpenHelper

    lateinit var tasksRepository: ITasksRepository

    val actualList: MutableList<Task> = ArrayList()

    @Before
    fun setUp() {
        dbHelper = MyDatabaseOpenHelper(RuntimeEnvironment.application)
        dbHelper.recreate() // This is just to clear the db
        tasksRepository = TasksRepository(dbHelper)
    }

    @Test
    fun getTasks() {
        insertFakeTasks(IntRange(1, 10))
        Assert.assertNotNull(tasksRepository.getTasks())
        Assert.assertEquals(tasksRepository.getTasks(), actualList)
    }

    @Test
    fun getTaskById() {
        insertFakeTasks(IntRange(1, 1))
        Assert.assertNotNull(tasksRepository.getTaskById(1))
        Assert.assertEquals(tasksRepository.getTaskById(1), actualList[0])
    }

    @Test
    fun insertTask() {

    }

    @Test
    fun updateTask() {

    }

    @After
    fun tearDown() {
        dbHelper.clearDb()
    }


    private fun insertFakeTasks(range: IntRange) {
        for (i in range) {
            var task = Task(title = "FakeTaskTitle$i", description = "FakeTaskDescription$i")
            actualList.add(task)
            tasksRepository.insertTask(task)
        }
    }


}