package com.trootechdemo.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.trootechdemo.model.ConversationData
import java.lang.reflect.Type
import java.util.*

object ConversationDataConverter {

        @TypeConverter
        fun fromString(value: String?): ArrayList<ConversationData> {
            val listType: Type = object : TypeToken<ArrayList<ConversationData?>?>() {}.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun fromArrayList(list: ArrayList<ConversationData?>?): String {
            val gson = Gson()
            return gson.toJson(list)
        }

}