package com.labtest1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.labtest1.database.AppDatabase
import com.labtest1.database.entities.LocationData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    val appDatabase: AppDatabase = AppDatabase.getInstance(application.applicationContext)


    /**
     * get user by id
     */
    fun getDataByID(userID: String): MutableLiveData<LocationData?> {
        val dataLiveData = MutableLiveData<LocationData?>()
        viewModelScope.launch(Dispatchers.IO) {
            val user = appDatabase.dataDao().getEntryByID(userID)
            viewModelScope.launch(Dispatchers.Main) { dataLiveData.value = user }
        }
        return dataLiveData
    }

    /**
     * get user by id
     */
    fun getAllDataByName(name: String): MutableLiveData<List<LocationData>?> {
        val dataLiveData = MutableLiveData<List<LocationData>?>()
        viewModelScope.launch(Dispatchers.IO) {
            val user = appDatabase.dataDao().getEntriesByName(name)
            viewModelScope.launch(Dispatchers.Main) { dataLiveData.value = user }
        }
        return dataLiveData
    }

    /**
     * get all users
     */
    fun getAllEntries(): MutableLiveData<List<LocationData>?> {
        val dataLiveData = MutableLiveData<List<LocationData>?>()
        viewModelScope.launch(Dispatchers.IO) {
            val user = appDatabase.dataDao().getAllEntries()
            viewModelScope.launch(Dispatchers.Main) { dataLiveData.value = user }
        }
        return dataLiveData
    }

    /**
     * add user to database
     */
    fun addEntry(locationData: LocationData): MutableLiveData<Boolean?> {
        val successLiveData = MutableLiveData<Boolean?>()
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.dataDao().addData(locationData)
            viewModelScope.launch(Dispatchers.Main) { successLiveData.value = true }
        }
        return successLiveData
    }

    /**
     * delete user from database
     */
    fun deleteEntry(locationData: LocationData): MutableLiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean>()
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.dataDao().delete(locationData)
            viewModelScope.launch(Dispatchers.Main) { mutableLiveData.value = true }
        }
        return mutableLiveData
    }

    /**
     * delete user from database
     */
    fun updateEntry(locationData: LocationData): MutableLiveData<Boolean> {
        val mutableLiveData = MutableLiveData<Boolean>()
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.dataDao().updateData(locationData)
            viewModelScope.launch(Dispatchers.Main) { mutableLiveData.value = true }
        }
        return mutableLiveData
    }

}