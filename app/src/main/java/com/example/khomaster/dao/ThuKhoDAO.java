package com.example.khomaster.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khomaster.database.DbHelper;

import java.sql.SQLData;

public class ThuKhoDAO {

    DbHelper dbHelper;

    public ThuKhoDAO(Context context){
        dbHelper =new DbHelper(context);
    }

    public boolean checkLogin(String HoTen, String MatKhau){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ThuKho WHERE HoTen = ? AND MatKhau = ? ", new String[]{HoTen,MatKhau});
        if (cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean Register (String HoTen, String MatKhau, String Email, String Sdt){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen", HoTen);
        values.put("MatKhau", MatKhau);
        values.put("Email", Email);
        values.put("Sdt", Sdt);
        long check = db.insert("ThuKho", null, values);
        return  check != 1;
    }

}
