package com.rgb.example.android_room_demo.db

class SubscriberRepository(private val dao: SubscriberDao) {

    //LiveData
    val subscribers = dao.getAll()

    suspend fun insertSubscriber(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun deleteSubscriber(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun updateSubscriber(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}