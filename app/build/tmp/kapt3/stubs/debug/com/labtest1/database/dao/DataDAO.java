package com.labtest1.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/labtest1/database/dao/DataDAO;", "", "addData", "", "locationData", "", "Lcom/labtest1/database/entities/LocationData;", "([Lcom/labtest1/database/entities/LocationData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "(Lcom/labtest1/database/entities/LocationData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEntries", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntriesByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntryByID", "dataID", "updateData", "app_debug"})
public abstract interface DataDAO {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM locationdata")
    public abstract java.lang.Object getAllEntries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.labtest1.database.entities.LocationData>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM locationdata WHERE locationdata.uid = (:dataID)")
    public abstract java.lang.Object getEntryByID(@org.jetbrains.annotations.NotNull()
    java.lang.String dataID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.labtest1.database.entities.LocationData> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM locationdata WHERE locationdata.name LIKE \'%\' || (:name) || \'%\'")
    public abstract java.lang.Object getEntriesByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.labtest1.database.entities.LocationData>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object addData(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData[] locationData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData locationData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateData(@org.jetbrains.annotations.NotNull()
    com.labtest1.database.entities.LocationData[] locationData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}