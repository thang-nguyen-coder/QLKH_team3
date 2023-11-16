package com.example.khomaster.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.khomaster.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Fragment_thongke extends Fragment {
//    BottomNavigationView bottomNav;
    public Fragment_thongke() {
        //
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thongke, container, false);
//        bottomNav = view.findViewById(R.id.bottomNav);
//
//        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment;
//                if (item.getItemId() == R.id.thongke){
//                    fragment = new Fragment_thongke();
//                } else if (item.getItemId() == R.id.hoadon) {
//                    fragment = new Fragment_hoadon();
//                } else if (item.getItemId() == R.id.giohang) {
//                    fragment = new Fragment_giohang();
//                } else if (item.getItemId() == R.id.thongbao) {
//                    fragment = new Fragment_thongbao();
//                }else if (item.getItemId() == R.id.user) {
//                    fragment = new Fragment_User();
//                }
////                getSupportFragmentManager()
//                return true;
//            }
//        });


        return view;
    }
}