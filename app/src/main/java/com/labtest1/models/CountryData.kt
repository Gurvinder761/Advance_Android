package com.labtest1.models

class CountryData : ArrayList<CountryDataItem>()

data class CountryDataItem(
    val code: String,
    val name: String
)