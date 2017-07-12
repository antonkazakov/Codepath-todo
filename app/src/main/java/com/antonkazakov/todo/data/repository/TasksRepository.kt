package com.antonkazakov.todo.data.repository

import com.antonkazakov.todo.data.beans.Task
import com.antonkazakov.todo.data.db.MyDatabaseOpenHelper
import org.jetbrains.anko.db.*
import javax.inject.Inject

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
class TasksRepository @Inject constructor(val databaseOpenHelper: MyDatabaseOpenHelper) : ITasksRepository {

    override fun getTasks(): List<Task>? {
        return databaseOpenHelper.use {
            select("Tasks")
                    .exec { parseList(classParser<Task>()) }
        }
    }

    override fun getTaskById(id: Long): Task? {
        return databaseOpenHelper.use {
            select("Tasks")
                    .whereArgs("(_id = {id})", "id" to id)
                    .exec { parseSingle(classParser<Task>()) }
        }
    }

    override fun insertTask(task: Task) : Boolean{
        databaseOpenHelper.use {
            insert("Tasks",
                    "title" to task.title,
                    "description" to task.description,
                    "created_at" to System.currentTimeMillis(),
                    "ends_at" to System.currentTimeMillis())
        }
        return true
    }

    override fun updateTask(id: Long, task: Task) {
        databaseOpenHelper.use {
            update("Tasks",
                    "title" to task.title,
                    "description" to task.description,
                    "ends_at" to task.endsAt)
                    .whereArgs("_id = {userId}", "userId" to id)
        }
    }



}