package com.trootechdemo.roomdb.database

import android.content.Context
import com.trootechdemo.roomdb.database.AppDatabase
import androidx.room.Room
import com.trootechdemo.roomdb.database.DatabaseClient
import kotlin.jvm.Synchronized

class DatabaseClient private constructor(private val mCtx: Context) {
    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //MyUserDetails is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyUserDetails").build()
    }

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }
}