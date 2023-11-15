package com.example.khomaster.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    static final String dbname = "KhoHang";

    static final int dbVersion = 1;

    public DbHelper(@Nullable Context context) {
        super(context, dbname, null, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Bảng Thủ Kho
        String Thukho = "Create table ThuKho("+
                "MaTK text primary key," +
                "HoTen text not null," +
                "MatKhau text not null," +
                "Email text not null," +
                "Sdt Integer not null)";
        sqLiteDatabase.execSQL(Thukho);

        //Bảng Khách hàng
        String Khachhang = "Create table KhachHang(" +
                "MaKH Integer primary key autoincrement," +
                "Hoten text not null," +
                "Sdt Integer not null," +
                "Email text not null," +
                "Dchi text not null)";
        sqLiteDatabase.execSQL(Khachhang);

        //Bảng Nhà cung cấp
        String Nhacungcap = "Create table NhaCungCap(" +
                "MaNCC Integer primary key autoincrement," +
                "Hoten text not null," +
                "Sdt Integer not null," +
                "Dchi text not null," +
                "Email text not null)";
        sqLiteDatabase.execSQL(Nhacungcap);

        //Bảng Loai sản phẩm
        String Loaisanpham = "Create table LoaiSanPham(" +
                "Maloai Integer primary key autoincrement," +
                "MaNCC Integer references NhaCungCap(MaNCC)," +
                "Tenloaisp text not null)";
        sqLiteDatabase.execSQL(Loaisanpham);

        //Bảng Sản phẩm
        String Sanpham = "Create table SanPham(" +
                "MaSP Integer primary key autoincrement," +
                "TenSP text not null," +
                "Soluong Integer not null," +
                "Soluukho Integer not null," +
                "Gia Integer not null," +
                "Maloai Integer references LoaiSanPham(Maloai)," +
                "Ngaynhap Integer not null," +
                "Ngayxuat Integer not null," +
                "MaNCC Integer references NhaCungCap(MaNCC))";
        sqLiteDatabase.execSQL(Sanpham);

        //Bảng Phiếu nhập kho
        String Phieunhapkho = "Create table PhieuNhapKho(" +
                "MaNk Integer primary key autoincrement," +
                "TenSP text references SanPham(TenSP)," +
                "MaSP Integer references SanPham(MaSP)," +
                "MaTK text references ThuKho(MaTK)," +
                "MaNCC Integer references NhaCungCap(MaNCC)," +
                "Ngaynhap Integer not null," +
                "Slnhap Integer not null)";
        sqLiteDatabase.execSQL(Phieunhapkho);

        //Bảng Hàng tồn kho
        String Hangtonkho = "Create table HangTonKho(" +
                "MaHTK Integer primary key autoincrement," +
                "MaSP Interger references SanPham(MaSP)," +
                "SlTon Integer not null)";
        sqLiteDatabase.execSQL(Hangtonkho);

        //Bảng Phiếu xuất kho
        String Phieuxuatkho = "Create table PhieuXuatKho(" +
                "MaXK Integer primary key autoincrement," +
                "TenSP Interger references SanPham(TenSP)," +
                "MaSP Interger references SanPham(MaSP)," +
                "Ngaynhap Integer not null," +
                "Ngayxuat Integer not null," +
                "Slxuat Integer not null," +
                "MaKH Integer references KhachHang(MaKH)," +
                "MaTK text references ThuKho(MaTK))";
        sqLiteDatabase.execSQL(Phieuxuatkho);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ThuKho");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KhachHang");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NhaCungCap");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LoaiSanPham");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SanPham");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PhieuNhapKho");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HangTonKho");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PhieuXuatKho");
        }

    }
}
