package com.trootechdemo.roomdb.model

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "userdetails")
class UserDetailsRoom : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "u_name")
    var user_name: String? = null

    @ColumnInfo(name = "u_email")
    var user_email: String? = null

    @ColumnInfo(name = "u_phone")
    var user_phone: String? = null
}