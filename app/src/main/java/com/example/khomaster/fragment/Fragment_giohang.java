package com.example.khomaster.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.khomaster.R;

public class Fragment_giohang extends Fragment {
    private ImageView imgSreach;
    private EditText edtSreach;
    public Fragment_giohang() {
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang, container, false);
        imgSreach = view.findViewById(R.id.imgSreachHangHoa);
        edtSreach = view.findViewById(R.id.edtSreachHangHoa);
        imgSreach.setOnClickListener(v -> {
            onFindItem(view);
        });
        return view;
    }
    public void onFindItem (View view){
        edtSreach.setVisibility(view.VISIBLE);
    }
}