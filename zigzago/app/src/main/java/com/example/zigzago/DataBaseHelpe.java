package com.example.zigzago;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelpe extends SQLiteOpenHelper {

     SQLiteDatabase customerdatabase1;
public static  String mail;
    int spin;
    public static  String f1;
    public static  String f2;
    public static Cursor login_cursor;

    public DataBaseHelpe(Context context) {
        super(context,"Customer11.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table customerdet (email TEXT primary key , username TEXT,pass TEXT,phone TEXT ,pin INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists customerdet");
        onCreate(db);


    }
    public void createNewCustomer(Customer c){
        customerdatabase1=this.getWritableDatabase();
        ContentValues  row = new ContentValues();
        row.put("email",c.getCust_mail());
        row.put("username",c.getCust_UserName());
        row.put("pass",c.getCust_password());
        row.put("phone",c.getCustomerPhone());
        row.put("pin",c.getPin());

 customerdatabase1.insert("customerdet",null,row);

customerdatabase1.close();

    }
    public  boolean isloginvalid(String uname1,String password1){
        String[] columns = { "email","phone","username"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username"+ "=?" + " and " +"pass" + "=?";
        String[] selectionArgs = { uname1, password1 };
        Cursor cursor = db.query("customerdet",columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.moveToFirst();
        login_cursor=cursor;
       // cursor.close();
        //db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }

    public boolean valid_mail_and_pass (String uname1,String password1){
        String[] columns = { "email"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username"+ "=?" ;
        String[] selectionArgs = { uname1};
        Cursor cursor = db.query("customerdet",columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;

    }
    public boolean send_pin (String mail , SQLiteDatabase sql){
        boolean flag =true;
        String[] columns = { "username","pass","phone","pin" };
        String selection ="email"+" LIKE ?";
        String[] selectionArgs = { mail};
        Cursor cursor = sql.query("customerdet",columns,selection,selectionArgs,null,null,null);

        if (cursor.getCount()>0) {
            this.mail = mail;
            cursor.moveToFirst();
            f1 = cursor.getString(0);
            f2 = cursor.getString(2);
           forget2.Pinn= cursor.getString(3);
            flag=true;
        }
        else
                flag=false;
        return flag;


    }
    public void resetpassword(String New_Pass,SQLiteDatabase sql){
ContentValues cn = new ContentValues();
Customer c2=new Customer();
        //customerdatabase1.close();
        cn.put("email",mail);
        cn.put("username",f1);
        cn.put("pass",New_Pass);
        cn.put("phone",f2);
        cn.put("pin",c2.getPin());
        String selection ="email"+" LIKE ?";
        String[] selectionArgs = {mail};
      sql.update("customerdet",cn,selection,selectionArgs);

    }
public  void Delete_account(){
    String selection ="username"+" LIKE ?";
    String[] selectionArgs = { login_cursor.getString(2)};
    customerdatabase1=this.getReadableDatabase();
    customerdatabase1.delete("customerdet",selection,selectionArgs);
}
    public  boolean Unique_username(String uname1){
        String[] columns = { "email","phone","username"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "username"+ "=?" ;
        String[] selectionArgs = { uname1};
        Cursor cursor = db.query("customerdet",columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.moveToFirst();
        

        if(count>0)
            return  false;
        else
            return  true;
    }
}


