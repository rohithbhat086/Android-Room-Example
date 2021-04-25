package com.rgb.example.android_room_demo

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rgb.example.android_room_demo.db.Subscriber
import com.rgb.example.android_room_demo.db.SubscriberRepository
import kotlinx.coroutines.launch

class MainViewModel(private val subscriberRepo: SubscriberRepository) : ViewModel() {

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val deleteOrClearButtonText = MutableLiveData<String>()

    val subscribers = subscriberRepo.subscribers

    init {
        saveOrUpdateButtonText.value = "Save"
        deleteOrClearButtonText.value = "Clear"
    }

    fun saveOrUpdate(){
        Log.i("ROOM_DB", "save called")
        if(!name.value.isNullOrEmpty()){
            viewModelScope.launch {
                subscriberRepo.insertSubscriber(Subscriber(0, name.value!!, email.value!!))
            }
            name.value = ""
            email.value = ""
        }
    }

    fun deleteOrClear(){
        Log.i("ROOM_DB", "delete called")
        viewModelScope.launch {
            subscriberRepo.deleteAll()
        }
    }
}