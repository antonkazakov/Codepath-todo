package com.antonkazakov.todo.data.di

import android.content.Context
import com.antonkazakov.todo.data.db.MyDatabaseOpenHelper
import com.antonkazakov.todo.data.repository.ITasksRepository
import com.antonkazakov.todo.data.repository.TasksRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
@Module
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun provideRepo(myDatabaseOpenHelper: MyDatabaseOpenHelper): ITasksRepository {
        return TasksRepository(myDatabaseOpenHelper)
    }

    @Singleton
    @Provides
    fun provideDB(context: Context): MyDatabaseOpenHelper {
        return MyDatabaseOpenHelper.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

}