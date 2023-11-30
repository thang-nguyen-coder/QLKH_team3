package com.example.khomaster.model;

public class LoaiSanPham {
    private int Maloai;
    private int MaNCC;
    private String Tenloaisp;
    private String imgLSP;

    public LoaiSanPham(int maloai, int maNCC, String tenloaisp, String imgLSP) {
        Maloai = maloai;
        MaNCC = maNCC;
        Tenloaisp = tenloaisp;
        this.imgLSP = imgLSP;
    }


    public int getMaloai() {
        return Maloai;
    }

    public void setMaloai(int maloai) {
        Maloai = maloai;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int maNCC) {
        MaNCC = maNCC;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        Tenloaisp = tenloaisp;
    }

    public String getImgLSP() {
        return imgLSP;
    }

    public void setImgLSP(String imgLSP) {
        this.imgLSP = imgLSP;
    }
}
