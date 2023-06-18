package com.trootechdemo.roomdb.database

import androidx.room.Database
import com.trootechdemo.roomdb.model.UserDetailsRoom
import androidx.room.RoomDatabase
import com.trootechdemo.roomdb.dao.UserRoomDao

@Database(entities = [UserDetailsRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): UserRoomDao?
}