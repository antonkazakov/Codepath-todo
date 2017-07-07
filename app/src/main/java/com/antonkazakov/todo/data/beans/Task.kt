package com.antonkazakov.todo.data.beans

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */

data class Task(val id: Long,
                val title: String,
                val description: String,
                val createdAt: Long,
                val endsAt: Long)