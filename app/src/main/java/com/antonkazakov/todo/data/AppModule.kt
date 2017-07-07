package com.antonkazakov.todo.data

import android.content.Context
import com.antonkazakov.todo.data.repository.MyDatabaseOpenHelper
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
    fun provideDB(context: Context): MyDatabaseOpenHelper {
        return MyDatabaseOpenHelper.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideContext() : Context{
        return context
    }

}