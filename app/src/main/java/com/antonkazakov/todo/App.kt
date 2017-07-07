package com.antonkazakov.todo

import android.app.Application
import com.antonkazakov.todo.data.DaggerAppComponent
import com.antonkazakov.todo.data.di.AppComponent
import com.antonkazakov.todo.data.di.AppModule

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
class App : Application() {

    val appComponent : AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
    }
}