package com.trootechdemo.roomdb.dao

import androidx.room.*
import com.trootechdemo.roomdb.model.UserDetailsRoom

@Dao
interface UserRoomDao {
    @get:Query("SELECT * FROM userdetails")
    val all: List<UserDetailsRoom?>?

    @Insert
    fun insert(task: UserDetailsRoom?)

    @Delete
    fun delete(task: UserDetailsRoom?)

    @Update
    fun update(task: UserDetailsRoom?)
}