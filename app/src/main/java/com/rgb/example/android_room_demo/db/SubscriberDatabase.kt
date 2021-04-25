package com.rgb.example.android_room_demo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDao : SubscriberDao

    companion object {
        @Volatile
        private var Instance : SubscriberDatabase? = null

        fun getInstance(context: Context) : SubscriberDatabase {
            synchronized(this) {
                var ins : SubscriberDatabase? = Instance
                if (ins == null) {
                    ins = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriber_database"
                    ).build()
                }
                return ins
            }
        }
    }
}