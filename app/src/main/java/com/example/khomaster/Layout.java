package com.example.khomaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.khomaster.fragment.Fragment_User;
import com.example.khomaster.fragment.Fragment_giohang;
import com.example.khomaster.fragment.Fragment_hoadon;
import com.example.khomaster.fragment.Fragment_thongbao;
import com.example.khomaster.fragment.Fragment_thongke;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import android.content.res.ColorStateList;


public class Layout extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        bottomNav =findViewById(R.id.bottomNav);

//        // Đặt màu mặc định cho tất cả các item (chưa được chọn)
//        ColorStateList defaultColor = ContextCompat.getColorStateList(this, R.color.cam);
//        bottomNav.setItemIconTintList(defaultColor);
//        bottomNav.setItemTextColor(defaultColor);


        bottomNav.setSelectedItemId(R.id.thongke);
        Fragment_thongke frg = new Fragment_thongke();
        relaceFrg(frg);

        
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Fragment();
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
                // Hiển thị fragment
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit();

//                // Đặt màu sắc cho item được chọn
//                ColorStateList selectedColor = ContextCompat.getColorStateList(getApplicationContext(), R.color.cam);
//                bottomNav.setItemIconTintList(selectedColor);
//                bottomNav.setItemTextColor(selectedColor);

//                // Đặt màu sắc cho item được chọn
//                int selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.cam);
//                bottomNav.setItemIconTintList(ColorStateList.valueOf(selectedColor));
//                bottomNav.setItemTextColor(ColorStateList.valueOf(selectedColor));


                // Đặt màu sắc cho item được chọn
                int selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.cam);
                ColorStateList colorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_checked},
                                new int[]{-android.R.attr.state_checked}
                        },
                        new int[]{
                                selectedColor,
                                ContextCompat.getColor(getApplicationContext(), R.color.black)
                        }
                );

                bottomNav.setItemIconTintList(colorStateList);
                bottomNav.setItemTextColor(colorStateList);

                return true;
            }
        });
    }
    public void relaceFrg(Fragment frg){
        FragmentManager fg = getSupportFragmentManager();
        fg.beginTransaction().replace(R.id.frameLayout,frg).commit();
    }
}