package com.example.khomaster.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khomaster.database.DbHelper;

import java.sql.SQLData;

public class ThuKhoDAO {

    DbHelper dbHelper;
    SharedPreferences sharedPreferences;

    public ThuKhoDAO(Context context) {
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences("dataUser", Context.MODE_PRIVATE);
    }

    public boolean checkLogin(String HoTen, String MatKhau) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ThuKho WHERE HoTen = ? AND MatKhau = ? ", new String[]{HoTen, MatKhau});
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("HoTen", cursor.getString(1));
            editor.apply();
        }

        return cursor.getCount() > 0;
    }

    public boolean Register(String HoTen, String MatKhau, String Email, String Sdt) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen", HoTen);
        values.put("MatKhau", MatKhau);
        values.put("Email", Email);
        values.put("Sdt", Sdt);
        long check = db.insert("ThuKho", null, values);
        return check != 1;
    }

    public boolean DoiMk(String userName, String oldPassword, String newPassword) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from ThuKho where HoTen = ? and MatKhau = ?", new String[]{userName, oldPassword});
        if (cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put("MatKhau", newPassword);
            long check =sqLiteDatabase.update("ThuKho", values, "HoTen = ?", new String[]{userName});
            return check != -1;
        }
        return false;
    }

}
