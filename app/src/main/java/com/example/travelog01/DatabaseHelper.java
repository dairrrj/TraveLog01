package com.example.travelog01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Diary.db";
    private static final String TABLE_NAME = "diary_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "time";
    private static final String COL_3 = "input_title";
    private static final String COL_4 = "input_text";
    private static final String COL_5 = "weather";
    private static final int DATABASED_VERSION = 1;
    public DatabaseHelper(Context context) {
        // super(context, name, factor, version)
        super(context, DATABASE_NAME, null, DATABASED_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
               // "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
               // "FIRSTNAME TEXT, LASTNAME TEXT, MARKS INTEGER)");
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                 "TIME TEXT, INPUT_TITLE TEXT, INPUT_TEXT TEXT, WEATHER TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // Method to insert a record to the database
    public boolean insertData(String time, String input_title, String input_text, String weather) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,time);
        contentValues.put(COL_3,input_title);
        contentValues.put(COL_4,input_text);
        contentValues.put(COL_5,weather);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    // Method to show all the records
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    // Method to update a record
    public boolean updateData(String ID, String time, String input_title, String input_text, String weather)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,time);
        contentValues.put(COL_3,input_title);
        contentValues.put(COL_4,input_text);
        contentValues.put(COL_5,weather);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {ID});
        return true;
    }
    // Method to delete a record
    public Integer deleteData (String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {ID});
    }
}