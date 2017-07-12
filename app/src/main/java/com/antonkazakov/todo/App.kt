package com.antonkazakov.todo

import android.app.Application
import com.antonkazakov.todo.data.di.AppComponent
import com.antonkazakov.todo.data.di.AppModule
import com.antonkazakov.todo.data.di.DaggerAppComponent

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
class App private constructor() : Application() {

    val appComponent: AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()


    
}