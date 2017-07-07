package com.antonkazakov.todo.data.repository

import com.antonkazakov.todo.data.beans.Task

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
interface ITasksRepository {

    /**
     * Get all tasks
     */
    fun getTasks(): List<Task>?

    /**
     * Get task by specific id
     * @id id of the task
     */
    fun getTaskById(id: Long): Task?

    /**
     * Insert new task to DB
     * @task Task to be inserted
     */
    fun insertTask(task: Task)

    /**
     * Update task
     * @task Task to be updated
     */
    fun updateTask(id: Long, task: Task)

}