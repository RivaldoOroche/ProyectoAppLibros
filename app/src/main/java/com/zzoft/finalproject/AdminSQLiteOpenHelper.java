package com.zzoft.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table tblUser(id integer primary key autoincrement," +
                "nombres text, email text, user text, password text)");
    }

    public boolean verificarLogin(String user, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"user"};
        String selection = "user = ? AND password = ?";
        String[] selectionArgs = {user, password};
        Cursor cursor = db.query("tblUser", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
