package com.labtest1.database.dao

import androidx.room.*
import com.labtest1.database.entities.LocationData

@Dao
interface DataDAO {
    @Query("SELECT * FROM locationdata")
    suspend fun getAllEntries(): List<LocationData>?

    @Query("SELECT * FROM locationdata WHERE locationdata.uid = (:dataID)")
    suspend fun getEntryByID(dataID: String): LocationData?

    @Query("SELECT * FROM locationdata WHERE locationdata.name LIKE '%' || (:name) || '%'")
    suspend fun getEntriesByName(name: String): List<LocationData>?

    @Insert
    suspend fun addData(vararg locationData: LocationData)

    @Delete
    suspend fun delete(locationData: LocationData)

    @Update
    suspend fun updateData(vararg locationData: LocationData)
}