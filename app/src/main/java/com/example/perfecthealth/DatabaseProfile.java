package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseProfile extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="persDetails.db";
    public static final String TABLE_NAME="persDetails.db";
    public static final String COLUMN_1="fName";
    public static final String COLUMN_2="lNamae";
    public static final String COLUMN_3="gender";
    public static final String COLUMN_4="age";

    public DatabaseProfile( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creating the database table
        sqLiteDatabase.execSQL("CREATE TABLE userProfile(fname TEXT PRIMARY KEY,lName TEXT,gender TEXT,age TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Dropping the table if it exits
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long addpersDetails(String fName,String lName,String gender,String age)
    {
        //Storing in the database
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fName",fName);
        contentValues.put("lName",lName);
        contentValues.put("gender",gender);
        contentValues.put("age",age);

        long res = db.insert("persDetails",null,contentValues);
        db.close();
        return  res;

    }
}
