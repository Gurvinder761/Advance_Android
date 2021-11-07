package com.labtest1.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate():Date?{
    val dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    return dateFormatter.parse(this)
}