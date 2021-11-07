package com.labtest1.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity
data class LocationData(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
    @ColumnInfo(name = "dob") val dob: Date,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "country") val country: String
) : Parcelable