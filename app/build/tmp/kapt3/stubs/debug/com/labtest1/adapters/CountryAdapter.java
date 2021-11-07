package com.labtest1.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/labtest1/adapters/CountryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/labtest1/adapters/CountryAdapter$ViewHolder;", "()V", "clickListener", "Lkotlin/Function1;", "Lcom/labtest1/models/CountryDataItem;", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function1;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "collection", "getCollection$app_debug", "()Ljava/util/List;", "setCollection$app_debug", "(Ljava/util/List;)V", "collection$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class CountryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.labtest1.adapters.CountryAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.labtest1.models.CountryDataItem, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty collection$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.labtest1.models.CountryDataItem, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.labtest1.models.CountryDataItem, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.labtest1.models.CountryDataItem> getCollection$app_debug() {
        return null;
    }
    
    public final void setCollection$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<com.labtest1.models.CountryDataItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.labtest1.adapters.CountryAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.labtest1.adapters.CountryAdapter.ViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public CountryAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006\u000b"}, d2 = {"Lcom/labtest1/adapters/CountryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "locationData", "Lcom/labtest1/models/CountryDataItem;", "clickListener", "Lkotlin/Function1;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.labtest1.models.CountryDataItem locationData, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.labtest1.models.CountryDataItem, kotlin.Unit> clickListener) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}