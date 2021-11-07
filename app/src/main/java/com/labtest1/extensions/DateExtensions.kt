package com.labtest1.extensions

import java.text.SimpleDateFormat
import java.util.*


fun Date.toReadableFormat(): String {
    val dateFormat = SimpleDateFormat("dd-Mm-yyyy", Locale.getDefault())
    return dateFormat.format(this)
}
