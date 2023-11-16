package com.example.khomaster.model;

public class User {
    private int MaTK;
    private String HoTen, MatKhau, Email, Sdt;

    public User() {
    }

    public User(int maTK, String hoTen, String matKhau, String email, String sdt) {
        MaTK = maTK;
        HoTen = hoTen;
        MatKhau = matKhau;
        Email = email;
        Sdt = sdt;
    }

    public User(int maTK, String hoTen, String matKhau) {
        MaTK = maTK;
        HoTen = hoTen;
        MatKhau = matKhau;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
