package com.example.khomaster.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.khomaster.R;

public class Fragment_hoadon extends Fragment {
    private EditText edtSreach;
    private ImageView imgSreach;
    public Fragment_hoadon() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hoadon, container, false);
        edtSreach = view.findViewById(R.id.edtSreachHoaDon);
        imgSreach = view.findViewById(R.id.imgSreachHoaDon);
        imgSreach.setOnClickListener(v -> {
            onFindItem(view);
        });
        return view;
    }
    public void onFindItem(View view){
        edtSreach.setVisibility(view.VISIBLE);
    }
}