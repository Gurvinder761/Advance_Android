package com.labtest1;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010\'\u001a\u00020\u0016H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/labtest1/EditPageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "oldLocationData", "Lcom/labtest1/database/entities/LocationData;", "getOldLocationData", "()Lcom/labtest1/database/entities/LocationData;", "setOldLocationData", "(Lcom/labtest1/database/entities/LocationData;)V", "selectedImage", "", "getSelectedImage", "()Ljava/lang/String;", "setSelectedImage", "(Ljava/lang/String;)V", "userViewModel", "Lcom/labtest1/viewmodel/LocationViewModel;", "getUserViewModel", "()Lcom/labtest1/viewmodel/LocationViewModel;", "setUserViewModel", "(Lcom/labtest1/viewmodel/LocationViewModel;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setOldUserData", "setupUI", "app_debug"})
public final class EditPageActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.labtest1.viewmodel.LocationViewModel userViewModel;
    @org.jetbrains.annotations.Nullable()
    private com.labtest1.database.entities.LocationData oldLocationData;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedImage = "";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.labtest1.viewmodel.LocationViewModel getUserViewModel() {
        return null;
    }
    
    public final void setUserViewModel(@org.jetbrains.annotations.NotNull()
    com.labtest1.viewmodel.LocationViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.labtest1.database.entities.LocationData getOldLocationData() {
        return null;
    }
    
    public final void setOldLocationData(@org.jetbrains.annotations.Nullable()
    com.labtest1.database.entities.LocationData p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedImage() {
        return null;
    }
    
    public final void setSelectedImage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setOldUserData() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public EditPageActivity() {
        super();
    }
}