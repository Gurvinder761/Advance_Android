package com.labtest1.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00100\nJ\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0006\u0010\u0015\u001a\u00020\u0012J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/labtest1/viewmodel/LocationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appDatabase", "Lcom/labtest1/database/AppDatabase;", "getAppDatabase", "()Lcom/labtest1/database/AppDatabase;", "addEntry", "Landroidx/lifecycle/MutableLiveData;", "", "locationData", "Lcom/labtest1/database/entities/LocationData;", "deleteEntry", "getAllDataByName", "", "name", "", "getAllEntries", "getDataByID", "userID", "updateEntry", "app_debug"})
public final class LocationViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.labtest1.database.AppDatabase appDatabase = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.labtest1.database.AppDatabase getAppDatabase() {
        return null;
    }
    
    /**
     * get user by id
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.labtest1.database.entities.LocationData> getDataByID(@org.jetbrains.annotations.NotNull()
    java.lang.String userID) {
        return null;
    }
    
    /**
     * get user by id
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.labtest1.database.entities.LocationData>> getAllDataByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    /**
     * get all users
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.labtest1.database.entities.LocationData>> getAllEntries() {
        return null;
    }
    
    /**
     * add user to database
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> addEntry(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData locationData) {
        return null;
    }
    
    /**
     * delete user from database
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> deleteEntry(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData locationData) {
        return null;
    }
    
    /**
     * delete user from database
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> updateEntry(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData locationData) {
        return null;
    }
    
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}