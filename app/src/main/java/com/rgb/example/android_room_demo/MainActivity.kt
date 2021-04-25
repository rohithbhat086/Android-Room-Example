package com.rgb.example.android_room_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rgb.example.android_room_demo.databinding.ActivityMainBinding
import com.rgb.example.android_room_demo.db.SubscriberDatabase
import com.rgb.example.android_room_demo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val subscriberDao = SubscriberDatabase.getInstance(applicationContext).subscriberDao
        val repoistory = SubscriberRepository(subscriberDao)
        val factory = MainViewModelFactory(repoistory)
        mViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        mViewModel.subscribers.observe(this, Observer {
            Log.i("ROOM_DB", "Entries: ${it.toString()}")
        })

        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this
    }
}