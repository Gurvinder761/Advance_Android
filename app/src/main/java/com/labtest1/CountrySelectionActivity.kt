package com.labtest1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.labtest1.adapters.CountryAdapter
import com.labtest1.database.utils.JsonUtils
import com.labtest1.models.CountryData
import kotlinx.android.synthetic.main.activity_country_selection.*

class CountrySelectionActivity : AppCompatActivity() {

    private val adapter = CountryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_selection)
        setupUI()

    }

    private fun setupUI() {
        recyclerViewCountries.layoutManager = LinearLayoutManager(this)
        recyclerViewCountries.adapter = adapter
        adapter.clickListener = { country ->
            val data = Intent()
            data.putExtra("country", country.name)
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        val countriesJsonString = JsonUtils.getCountriesFromAssets(this)
        Log.d("Countries :: ", countriesJsonString ?: "")
        val jsonResults = Gson().fromJson<CountryData>(countriesJsonString, CountryData::class.java)
        adapter.collection = jsonResults
    }
}