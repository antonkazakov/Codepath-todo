package com.antonkazakov.todo.data.db

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/**
 * @author Anton Kazakov
 * *
 * @date 12.07.17.
 */
@RunWith(RobolectricTestRunner::class)
class MyDatabaseOpenHelperTest {

    lateinit var databaseHelper: MyDatabaseOpenHelper

    @BeforeClass
    fun setUp() {
        databaseHelper = MyDatabaseOpenHelper(RuntimeEnvironment.application)

    }

    @Test
    fun onCreate() {
        //check bd created and not null
        //check table with name tasks exists
    }

    @Test
    fun onUpgrade() {
        //check db version
    }

    @AfterClass
    fun tearDown() {
        databaseHelper.clearDb()
    }

}