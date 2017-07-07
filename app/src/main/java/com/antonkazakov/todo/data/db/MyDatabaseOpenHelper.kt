package com.antonkazakov.todo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "TaskDataBase123", null, 2) {

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
                "_id" to INTEGER + PRIMARY_KEY ,
                "title" to TEXT,
                "description" to TEXT,
                "created_at" to INTEGER,
                "ends_at" to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable("Tasks", true)
        onCreate(db)
    }

}
