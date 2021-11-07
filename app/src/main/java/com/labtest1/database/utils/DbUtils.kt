package com.labtest1.database.utils

import java.util.*

object DbUtils {

    fun generateIDForData(
        title: String,
        subTitle: String,
        latitude: Double,
        longitude: Double,
        dob:String,
        country:String

    ): String {
        val hashID = "${title.replace(" ", "")
            .toLowerCase(Locale.getDefault())}${subTitle.replace(" ", "")
            .toLowerCase(Locale.getDefault())}${latitude}$longitude$dob,$country"
        return UUID.nameUUIDFromBytes(hashID.toByteArray()).mostSignificantBits.toString();

    }
}