package com.example.sith3.textinputlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "test.db";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "user";

    public static final String NAME = "name";

    public static final String EMAIL="email";

    public static final String USERNAME="user_name";

    public static final String PASSWORD="password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+" (NAME TEXT, EMAIL TEXT, PASSWORD TEXT, USERNAME TEXT UNIQUE)";
        sqLiteDatabase.rawQuery(query, null);
    }

    public void insertUser(UserModel userModel) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,userModel.getName());
        contentValues.put(EMAIL,userModel.getEmail());
        contentValues.put(USERNAME,userModel.getUsername());
        contentValues.put(PASSWORD,userModel.getPassword());
        long insert = writableDatabase.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
