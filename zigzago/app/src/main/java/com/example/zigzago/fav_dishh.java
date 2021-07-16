package com.example.zigzago;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class fav_dishh extends SQLiteOpenHelper {

    SQLiteDatabase favoritedishes;
    public  static  Cursor customer_favorite_dish;
    //    Log_in l1= new Log_in();
    public fav_dishh(Context context) {
        super(context,"favoriteDataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table favorite (username TEXT primary key , fav_dishes TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists favorite");
        onCreate(db);


    }
    public boolean insert_fav_dish(String fav){
        favoritedishes=this.getWritableDatabase();
        ContentValues  row = new ContentValues();
        row.put("username",DataBaseHelpe.login_cursor.getString(2));
        row.put("fav_dishes",fav);

        long result = favoritedishes.insert("favorite",null,row);

        favoritedishes.close();
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean get_fav_dish (){
        String[] columns = { "fav_dishes"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username"+ "=?" ;
        String[] selectionArgs = {DataBaseHelpe.login_cursor.getString(2)};
        Cursor cursor = db.query("favorite",columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.moveToFirst();
        customer_favorite_dish= cursor;
        if(count>0){
            //

            return  true;}
        else {

            return false;
        }
    }
    public void update_fav(String fav){
        favoritedishes=this.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("username",DataBaseHelpe.login_cursor.getString(2));
        row.put("fav_dishes",fav);
        String selection ="username"+" LIKE ?";
        String[] selectionArgs = {DataBaseHelpe.login_cursor.getString(2)};
        favoritedishes.update("favorite",row,selection,selectionArgs);

    }
    public  void f_Delete_account(){
        String selection ="username"+" LIKE ?";
        String[] selectionArgs = { DataBaseHelpe.login_cursor.getString(2)};
        favoritedishes=this.getReadableDatabase();
        favoritedishes.delete("favorite",selection,selectionArgs);
    }
}