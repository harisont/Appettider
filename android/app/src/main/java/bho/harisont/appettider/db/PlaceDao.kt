package bho.harisont.appettider.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlaceDao {
    @Query("SELECT * FROM place")
    fun selectAll(): List<Place>

    @Query("SELECT * FROM place WHERE name == :name")
    fun selectByName(name: String): List<Place>

    @Insert
    fun insert(place: Place)

    @Delete
    fun delete(place: Place)
}

