package com.antonkazakov.todo.data.repository

import com.antonkazakov.todo.data.beans.Task
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.parseSingle
import org.jetbrains.anko.db.select
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
                    .whereArgs("(id = {id}", "id" to id)
                    .exec { parseSingle(classParser<Task>()) }
        }
    }


}