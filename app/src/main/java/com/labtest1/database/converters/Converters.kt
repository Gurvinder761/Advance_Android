package com.labtest1.database.converters

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let {
            Date(value)
        }
    }

    @TypeConverter
    fun LocalDateTimeToTimestamp(date: Date?): Long? {
        return date?.time
    }
}