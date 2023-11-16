package com.example.khomaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.khomaster.fragment.Fragment_User;
import com.example.khomaster.fragment.Fragment_giohang;
import com.example.khomaster.fragment.Fragment_hoadon;
import com.example.khomaster.fragment.Fragment_thongbao;
import com.example.khomaster.fragment.Fragment_thongke;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Layout extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId() == R.id.thongke){
                    fragment = new Fragment_thongke();
                } else if (item.getItemId() == R.id.hoadon) {
                    fragment = new Fragment_hoadon();
                } else if (item.getItemId() == R.id.giohang) {
                    fragment = new Fragment_giohang();
                } else if (item.getItemId() == R.id.thongbao) {
                    fragment = new Fragment_thongbao();
                }else if (item.getItemId() == R.id.user) {
                    fragment = new Fragment_User();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit();
                return true;
            }
        });
    }
}