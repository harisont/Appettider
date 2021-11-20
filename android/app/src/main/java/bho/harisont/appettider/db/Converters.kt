package bho.harisont.appettider.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun openingTimesToString(openingTimes: Map<Weekday, String>): String {
        return "" // TODO: implement the actual conversion
    }

    @TypeConverter
    fun stringToOpeningTimes(string: String): Map<Weekday, String> {
        return mapOf() // TODO: implement the actual conversion
    }
}