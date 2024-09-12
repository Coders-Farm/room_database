package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = UserDatabase.getUserDatabase(this)

        CoroutineScope(Dispatchers.IO).launch {
            database.getUserDao().createUser(User(id = 0, name = "Jhon", jobTitle = "Developer", createdAt = Date(), isActive = 1))
        }

        database.getUserDao().getAllUser().observe(this, Observer {
            Log.e("User","User list ====> $it")
        })

    }
}