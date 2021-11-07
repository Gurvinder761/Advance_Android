package com.labtest1.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.labtest1.database.dao.DataDAO;
import com.labtest1.database.dao.DataDAO_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DataDAO _dataDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LocationData` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `gender` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `dob` INTEGER NOT NULL, `image` TEXT NOT NULL, `country` TEXT NOT NULL, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5f3aba04028dcf287ca15244885db29a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LocationData`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLocationData = new HashMap<String, TableInfo.Column>(8);
        _columnsLocationData.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("dob", new TableInfo.Column("dob", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationData.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationData = new TableInfo("LocationData", _columnsLocationData, _foreignKeysLocationData, _indicesLocationData);
        final TableInfo _existingLocationData = TableInfo.read(_db, "LocationData");
        if (! _infoLocationData.equals(_existingLocationData)) {
          return new RoomOpenHelper.ValidationResult(false, "LocationData(com.labtest1.database.entities.LocationData).\n"
                  + " Expected:\n" + _infoLocationData + "\n"
                  + " Found:\n" + _existingLocationData);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5f3aba04028dcf287ca15244885db29a", "00a7c6e325548a3b4663af97534273fd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "LocationData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LocationData`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DataDAO dataDao() {
    if (_dataDAO != null) {
      return _dataDAO;
    } else {
      synchronized(this) {
        if(_dataDAO == null) {
          _dataDAO = new DataDAO_Impl(this);
        }
        return _dataDAO;
      }
    }
  }
}
