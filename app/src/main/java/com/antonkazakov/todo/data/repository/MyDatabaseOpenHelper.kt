package com.antonkazakov.todo.data.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */

private val VERSION = 1
private val NAME = "TasksDatabase"

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, NAME, null, VERSION) {

    /**
     * Lazy loading BD instance
     */
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("Tasks", true,
                "id" to INTEGER + PRIMARY_KEY,
                "title" to TEXT,
                "description" to TEXT,
                "created_at" to INTEGER,
                "ends_at" to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("User", true)
    }
}

