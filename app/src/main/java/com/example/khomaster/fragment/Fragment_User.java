package com.example.khomaster.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.khomaster.R;
import com.example.khomaster.screens.EditUserActivity;
import com.example.khomaster.screens.LoginActivity;

public class Fragment_User extends Fragment {
    private LinearLayout lnLogOut;
    private ImageView itemEditUser;
    public Fragment_User() {
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        itemEditUser = view.findViewById(R.id.itemEditUser);
        lnLogOut = view.findViewById(R.id.itemLogout);
        lnLogOut.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        itemEditUser.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), EditUserActivity.class));
        });
        return view;
    }

}