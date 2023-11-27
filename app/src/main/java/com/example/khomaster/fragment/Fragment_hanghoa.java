package com.example.khomaster.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.khomaster.R;
import com.example.khomaster.adapter.LoaiSanPhamAdapter;
import com.example.khomaster.dao.LoaiSanPhamDAO;
import com.example.khomaster.model.LoaiSanPham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_hanghoa extends Fragment {
    private ImageView imgSreach;
    private EditText edtSreach;
    private FloatingActionButton btnAddLSP;
    private RecyclerView rcyLSP;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private ArrayList<LoaiSanPham> list;
    public Fragment_hanghoa() {
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanghoa, container, false);
        imgSreach = view.findViewById(R.id.imgSreachHangHoa);
        edtSreach = view.findViewById(R.id.edtSreachHangHoa);
        btnAddLSP = view.findViewById(R.id.btnAddLoaiSP);
        rcyLSP = view.findViewById(R.id.rcyHangHoa);
        imgSreach.setOnClickListener(v -> {
            onFindItem(view);
        });
        loadData();
        return view;
    }
    public void onFindItem (View view){
        edtSreach.setVisibility(view.VISIBLE);
    }
    public void loadData(){
        loaiSanPhamDAO = new LoaiSanPhamDAO(getContext());
        list = loaiSanPhamDAO.getDSLoaiSP();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcyLSP.setLayoutManager(manager);
        LoaiSanPhamAdapter adapter = new LoaiSanPhamAdapter(getContext(), list, loaiSanPhamDAO);
        rcyLSP.setAdapter(adapter);
    }
}