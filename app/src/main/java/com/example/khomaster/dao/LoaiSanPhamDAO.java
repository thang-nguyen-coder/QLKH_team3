package com.example.khomaster.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.example.khomaster.database.DbHelper;
import com.example.khomaster.model.LoaiSanPham;

import java.util.ArrayList;

public class LoaiSanPhamDAO {
    private DbHelper dbHelper;

    public LoaiSanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    // hàm get danh sách loại sản phẩm
    public ArrayList<LoaiSanPham> getDSLoaiSP() {
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LoaiSanPham", null);
        if (cursor.getCount() > 0) {
            // di chuyển con trỏ lên đầu ds
            cursor.moveToFirst();
            do {
                list.add(new LoaiSanPham(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean addLoaiSP(String name, String imgLSP) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Tenloaisp", name);
        values.put("imgLSP", imgLSP);
        long check = sqLiteDatabase.insert("LoaiSanPham", null, values);
        return check != -1;
    }
    public boolean editLoaiSP (LoaiSanPham loaiSanPham){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Tenloaisp", loaiSanPham.getTenloaisp());
        values.put("imgLSP", loaiSanPham.getImgLSP());
        int check =sqLiteDatabase.update("LoaiSanPham", values, "Maloai = ?", new String[]{String.valueOf(loaiSanPham.getMaloai())});
        return check != 0;
    }
    public int deleteLoaiSP (int MaLoai){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LoaiSanPham where MaLoai =?", new String[]{String.valueOf(MaLoai)});
        if (cursor.getCount() > 0) {
            int check = sqLiteDatabase.delete("LoaiSanPham", "Maloai = ?", new String[]{String.valueOf(MaLoai)});
            if (check == 0){
                return -1;
            }else {
                return 1;
            }
        }else {
            return 0;
        }
    }
}
