package com.labtest1.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.labtest1.database.converters.Converters;
import com.labtest1.database.entities.LocationData;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataDAO_Impl implements DataDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocationData> __insertionAdapterOfLocationData;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<LocationData> __deletionAdapterOfLocationData;

  private final EntityDeletionOrUpdateAdapter<LocationData> __updateAdapterOfLocationData;

  public DataDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocationData = new EntityInsertionAdapter<LocationData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LocationData` (`uid`,`name`,`gender`,`latitude`,`longitude`,`dob`,`image`,`country`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationData value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getGender() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGender());
        }
        stmt.bindDouble(4, value.getLatitude());
        stmt.bindDouble(5, value.getLongitude());
        final Long _tmp;
        _tmp = __converters.LocalDateTimeToTimestamp(value.getDob());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        if (value.getImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCountry());
        }
      }
    };
    this.__deletionAdapterOfLocationData = new EntityDeletionOrUpdateAdapter<LocationData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LocationData` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationData value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
      }
    };
    this.__updateAdapterOfLocationData = new EntityDeletionOrUpdateAdapter<LocationData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LocationData` SET `uid` = ?,`name` = ?,`gender` = ?,`latitude` = ?,`longitude` = ?,`dob` = ?,`image` = ?,`country` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationData value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getGender() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGender());
        }
        stmt.bindDouble(4, value.getLatitude());
        stmt.bindDouble(5, value.getLongitude());
        final Long _tmp;
        _tmp = __converters.LocalDateTimeToTimestamp(value.getDob());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        if (value.getImage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImage());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCountry());
        }
        if (value.getUid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUid());
        }
      }
    };
  }

  @Override
  public Object addData(final LocationData[] locationData, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocationData.insert(locationData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final LocationData locationData, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLocationData.handle(locationData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateData(final LocationData[] locationData, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLocationData.handleMultiple(locationData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllEntries(final Continuation<? super List<LocationData>> p0) {
    final String _sql = "SELECT * FROM locationdata";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<LocationData>>() {
      @Override
      public List<LocationData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "dob");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final List<LocationData> _result = new ArrayList<LocationData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocationData _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final Date _tmpDob;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDob)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDob);
            }
            _tmpDob = __converters.fromTimestamp(_tmp);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            _item = new LocationData(_tmpUid,_tmpName,_tmpGender,_tmpLatitude,_tmpLongitude,_tmpDob,_tmpImage,_tmpCountry);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getEntryByID(final String dataID, final Continuation<? super LocationData> p1) {
    final String _sql = "SELECT * FROM locationdata WHERE locationdata.uid = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dataID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dataID);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<LocationData>() {
      @Override
      public LocationData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "dob");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final LocationData _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final Date _tmpDob;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDob)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDob);
            }
            _tmpDob = __converters.fromTimestamp(_tmp);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            _result = new LocationData(_tmpUid,_tmpName,_tmpGender,_tmpLatitude,_tmpLongitude,_tmpDob,_tmpImage,_tmpCountry);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  @Override
  public Object getEntriesByName(final String name,
      final Continuation<? super List<LocationData>> p1) {
    final String _sql = "SELECT * FROM locationdata WHERE locationdata.name LIKE '%' || (?) || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<List<LocationData>>() {
      @Override
      public List<LocationData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "dob");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final List<LocationData> _result = new ArrayList<LocationData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LocationData _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final Date _tmpDob;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDob)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDob);
            }
            _tmpDob = __converters.fromTimestamp(_tmp);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            _item = new LocationData(_tmpUid,_tmpName,_tmpGender,_tmpLatitude,_tmpLongitude,_tmpDob,_tmpImage,_tmpCountry);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
