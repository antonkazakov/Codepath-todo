package com.antonkazakov.todo.data.beans

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */

data class Task(val id: Long = 0,
                var title: String,
                var description: String,
                val createdAt: Long = System.currentTimeMillis(),
                val endsAt: Long = System.currentTimeMillis())