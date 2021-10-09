package com.example.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9541367895,'Saurabh',8272.00,'saurabh.02@gmail.com','XXXXXXXXXXXX4321','0038')");
        db.execSQL("insert into user_table values(2345678901,'Omkar',582.67,'omkar.03@gmail.com','XXXXXXXXXXXX2341','0032')");
        db.execSQL("insert into user_table values(3456789012,'Adity',1329.56,'adity.04@gmail.com','XXXXXXXXXXXX3412','0028')");
        db.execSQL("insert into user_table values(4567890123,'Sakshi',1500.01,'sakshi.05@gmail.com','XXXXXXXXXXXX4123','0026')");
        db.execSQL("insert into user_table values(5678901234,'Aniket',2603.48,'aniket.06@gmail.com','XXXXXXXXXXXX2345','0038')");
        db.execSQL("insert into user_table values(6789012345,'Vaibhav',1945.16,'vaibhav.07@gmail.com','XXXXXXXXXXXX3452','0012')");
        db.execSQL("insert into user_table values(7890123456,'Shweta',5936.00,'shweta.08@gmail.com','XXXXXXXXXXXX4523','0032')");
        db.execSQL("insert into user_table values(8901234567,'Pradip',8570.22,'pradip.09@gmail.com','XXXXXXXXXXXX5234','0032')");
        db.execSQL("insert into user_table values(9012345678,'Dinesh',438.46,'dinesh.10@gmail.com','XXXXXXXXXXXX3456','0018')");
        db.execSQL("insert into user_table values(9874521360,'Akash',9273.90,'akash.01@gmail.com','XXXXXXXXXXXX4563','0026')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
