package com.myapp.kirat.favoritetheitem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 3/13/2018.
 */

public class FavoriteDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "favouritelist.db";
    public static final String TABLE_NAME = "favouritelist_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "DESCRIPTION";
  //  private static final int DATABASE_VERSION = 1;
//    public static final String COL4 = "POSITION";
//    public static final String COL5 = "ADDRESS";
//    public static final String COL6 = "ADDRESSTAGS";


    public FavoriteDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table favouritelist_data " +
                "(id integer primary key AUTOINCREMENT,TITLE text,DESCRIPTION text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1, String item2 ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(String title , String description){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE TITLE= '" + title+"WHERE DESCRIPTION = '"+description+ "' ORDER BY ID DESC ", null);
        return data;
    }

    public boolean checkData(String description ) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String Query = "Select * from " + TABLE_NAME + " where " + COL3 + " = '" + description + "' ORDER BY ID DESC ";
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean deleteDataFromId (String id , String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        return (db.delete(TABLE_NAME, "ID= ? AND TITLE = ?",new String[] {id,title}) == -1 ) ?false:true;
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
    }

}
