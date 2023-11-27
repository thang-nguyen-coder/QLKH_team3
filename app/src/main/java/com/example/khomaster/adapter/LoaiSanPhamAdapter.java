package com.example.khomaster.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khomaster.R;
import com.example.khomaster.dao.LoaiSanPhamDAO;
import com.example.khomaster.model.LoaiSanPham;

import java.util.ArrayList;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiSanPham> list;
    private LoaiSanPhamDAO loaiSanPhamDAO;

    public LoaiSanPhamAdapter(Context context, ArrayList<LoaiSanPham> list, LoaiSanPhamDAO loaiSanPhamDAO) {
        this.context = context;
        this.list = list;
        this.loaiSanPhamDAO = loaiSanPhamDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaisanpham, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSanPhamAdapter.ViewHolder holder, int position) {
        holder.tvLSP.setText(list.get(position).getTenloaisp());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvLSP;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLSP = itemView.findViewById(R.id.tvTenLSP);
        }
    }
}
