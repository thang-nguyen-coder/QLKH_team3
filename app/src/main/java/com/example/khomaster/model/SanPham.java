package com.example.khomaster.model;

public class SanPham {
    private int MaSP;
    private String TenSP;
    private int Soluong;
    private int Soluukho;
    private int Gia;
    private int Maloai;
    private String Ngaynhap;
    private int MaNCC;
    private String imgSP;

    public SanPham(int maSP, String tenSP, int soluong, int soluukho, int gia, int maloai, String ngaynhap, int maNCC, String imgSP) {
        MaSP = maSP;
        TenSP = tenSP;
        Soluong = soluong;
        Soluukho = soluukho;
        Gia = gia;
        Maloai = maloai;
        Ngaynhap = ngaynhap;
        MaNCC = maNCC;
        this.imgSP = imgSP;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }

    public int getSoluukho() {
        return Soluukho;
    }

    public void setSoluukho(int soluukho) {
        Soluukho = soluukho;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getMaloai() {
        return Maloai;
    }

    public void setMaloai(int maloai) {
        Maloai = maloai;
    }

    public String getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        Ngaynhap = ngaynhap;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int maNCC) {
        MaNCC = maNCC;
    }

    public String getImgSP() {
        return imgSP;
    }

    public void setImgSP(String imgSP) {
        this.imgSP = imgSP;
    }
}
