package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Login.db";
    public static final String TABLE_NAME ="userDetails";
    public static final String COLUMN_1 ="ID";
    public static final String COLUMN_2 ="username";
    public static final String COLUMN_3 ="password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE userDetails (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long adduserdetails(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long res = db.insert("userDetails",null,contentValues);
        db.close();
        return res;
    }
    public boolean checkUser(String username, String password){
        String[] columns = {COLUMN_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COLUMN_2 + "=?" + "and" + COLUMN_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }
}
