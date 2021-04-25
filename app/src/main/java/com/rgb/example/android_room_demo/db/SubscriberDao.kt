package com.rgb.example.android_room_demo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDao {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Query("DELETE from subscriber_data")
    suspend fun deleteAll()

    // no need of suspend, since return type is livedata - this will be automatically
    // called on background thread by Room
    @Query("select * from subscriber_data")
    fun getAll(): LiveData<List<Subscriber>>

}