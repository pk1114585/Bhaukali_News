package com.pk.bhaukalinews.db

import androidx.room.TypeConverter
import com.pk.bhaukalinews.model.Source

class Converter {
    @TypeConverter
    fun fromsource(source: Source): String{
        return source.name

    }
    @TypeConverter
    fun tosource(name:String): Source {
        return Source(name,name)
    }
}