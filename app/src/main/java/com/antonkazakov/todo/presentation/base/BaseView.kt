package com.antonkazakov.todo.presentation.base

/**
 * @author Anton Kazakov
 * @date 08.07.17.
 */
interface BaseView {

    fun showError()

    fun showCriticalError()

    fun showLoading(isLoading: Boolean)

}