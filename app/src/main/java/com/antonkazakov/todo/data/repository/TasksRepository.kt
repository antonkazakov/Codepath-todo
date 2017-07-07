package com.antonkazakov.todo.data.repository

import com.antonkazakov.todo.data.beans.Task
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import javax.inject.Inject

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
class TasksRepository @Inject constructor(val databaseOpenHelper: MyDatabaseOpenHelper) {

    fun test(): List<Task> {
        return databaseOpenHelper.use {
            select("User", "name")
                    .parseList(classParser<Task>())
        }
    }

}