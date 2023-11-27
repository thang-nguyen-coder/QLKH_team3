package com.example.khomaster.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khomaster.database.DbHelper;
import com.example.khomaster.model.LoaiSanPham;

import java.util.ArrayList;

public class LoaiSanPhamDAO {
    private DbHelper dbHelper;
    public LoaiSanPhamDAO(Context context){
        dbHelper = new DbHelper(context);
    }
    // hàm get danh sách loại sản phẩm
    public ArrayList<LoaiSanPham> getDSLoaiSP (){
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LoaiSanPham", null);
        if(cursor.getCount() > 0){
            // di chuyển con trỏ lên đầu ds
            cursor.moveToFirst();
            do {
                list.add(new LoaiSanPham(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
