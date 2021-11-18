package bho.harisont.appettider.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

@Entity
data class Place (
        @PrimaryKey val name: String,
        @ColumnInfo val address: String,
        @ColumnInfo val openingTimes: Map<Weekday, String>,
        @ColumnInfo val notes: String
)