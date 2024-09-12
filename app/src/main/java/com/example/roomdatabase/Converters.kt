package com.example.roomdatabase

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromDateToLong(date: Date):Long{
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(date:Long):Date{
        return Date(date)
    }

}