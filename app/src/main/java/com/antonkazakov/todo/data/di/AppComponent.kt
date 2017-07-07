package com.antonkazakov.todo.data.di

import dagger.Component
import javax.inject.Singleton

/**
 * @author Anton Kazakov
 * @date 07.07.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {


}