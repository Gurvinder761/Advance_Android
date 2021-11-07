package com.labtest1.database.utils

import android.content.Context
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object JsonUtils {
    fun getCountriesFromAssets(context: Context): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = context.getAssets().open("countries.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        Log.e("data", json?:"")
        return json
    }
}