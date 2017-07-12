package com.antonkazakov.todo.presentation.screens.task

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.antonkazakov.todo.R

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
    }

    companion object {
        fun createExplicitIntent(context: Context, taskId: Long): Intent {
            return Intent(context, TaskActivity::class.java).putExtra("id", taskId)
        }
    }

}
