package com.sms.demo.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "user";
   private static String DataBase_NAME = "Student";
   private static String Col_one = "name";
    String Col_two = "phone";
    String Col_three = "age";

    public SqlHelper(Context context) {
        super(context,DataBase_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists "+ TABLE_NAME + " ( " + Col_one + " text, " + Col_two + " text primary key , " + Col_three + " integer );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insert(ObjectCreator objectCreator){
        ContentValues values = new ContentValues();
        values.put(Col_one,objectCreator.getName_());
        values.put(Col_two,objectCreator.getPhone());
        values.put(Col_three,objectCreator.getAge());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long insert = sqLiteDatabase.insert(TABLE_NAME, null, values);
        if(insert>0){
            return true;
        }else
            return false;
    }


    public Cursor retrive(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "select * from " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }
}
