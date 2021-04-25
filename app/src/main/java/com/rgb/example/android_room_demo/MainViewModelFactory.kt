package com.rgb.example.android_room_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rgb.example.android_room_demo.db.SubscriberRepository

class MainViewModelFactory(private val subscriberRepository: SubscriberRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(subscriberRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}