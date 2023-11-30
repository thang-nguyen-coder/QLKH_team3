package com.example.khomaster.adapter;

import static android.app.Activity.RESULT_OK;
import static androidx.core.app.ActivityCompat.startActivityForResult;

import static com.example.khomaster.fragment.Fragment_hanghoa.PICK_IMAGE_REQUEST;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khomaster.R;
import com.example.khomaster.dao.LoaiSanPhamDAO;
import com.example.khomaster.model.LoaiSanPham;
import com.example.khomaster.screens.SanPhamActivity;

import java.util.ArrayList;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiSanPham> list;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private Uri selectedImageUri;
    public static final int PICK_IMAGE_REQUEST = 1;

    public LoaiSanPhamAdapter(Context context, ArrayList<LoaiSanPham> list, LoaiSanPhamDAO loaiSanPhamDAO) {
        this.context = context;
        this.list = list;
        this.loaiSanPhamDAO = loaiSanPhamDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaisanpham, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSanPhamAdapter.ViewHolder holder, int position) {
        holder.tvLSP.setText(list.get(position).getTenloaisp());
        holder.imgLSP.setImageURI(Uri.parse(list.get(position).getImgLSP()));
        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("LoaiSanPhamAdapter", "onLongClick");
                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn sửa hay xóa ?");
                builder.setNeutralButton("Hủy", null);
                builder.setNegativeButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("onclick", "Sửa");
                        showDialogEdit(list.get(holder.getAdapterPosition()));
                    }
                });
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("onclick", "Xóa");
                        AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
                        builder.setTitle("Thông báo");
                        builder.setMessage("Xác nhận xóa ?");
                        builder.setNegativeButton("Không", null);
                        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int check = loaiSanPhamDAO.deleteLoaiSP(list.get(holder.getAdapterPosition()).getMaloai());
                                switch (check) {
                                    case -1:
                                        Toast.makeText(context, "Xóa không thành công ", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 0:
                                        Toast.makeText(context, "Bạn cần xóa các sản phẩm trong thể loại sản phẩm này trước", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                                        loadData();
                                        break;
                                }
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });
        holder.item.setOnClickListener(v -> {
            Intent intent = new Intent(context, SanPhamActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView item;
        TextView tvLSP;
        ImageView imgLSP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLSP = itemView.findViewById(R.id.tvTenLSP);
            imgLSP = itemView.findViewById(R.id.imgLoaiSanPham);
            item = itemView.findViewById(R.id.itemLoaiSP);
        }
    }

    public void showDialogEdit(LoaiSanPham loaiSanPham) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_updatelsp, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.show();

        TextView tvTitle = view.findViewById(R.id.tvTitleLSP);
        EditText edtTenLoai = view.findViewById(R.id.edtSaveLSP);
        ImageView imgLSP = view.findViewById(R.id.ivLoaiSP);
        Button btnSave = view.findViewById(R.id.btnSave);
        Button btnHuy = view.findViewById(R.id.btnHuy);

        tvTitle.setText("Cập nhật lại tên sản phẩm");
        btnSave.setText("Cập nhật");
        edtTenLoai.setText(loaiSanPham.getTenloaisp());
        imgLSP.setImageURI(Uri.parse(loaiSanPham.getImgLSP()));

        btnHuy.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        btnSave.setOnClickListener(v -> {
            String name = edtTenLoai.getText().toString();

//            if (name.equals("")) {
//                Toast.makeText(context, "Chưa nhập tên mới", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            LoaiSanPham loaiSpUpdate = new LoaiSanPham(loaiSanPham.getMaloai(), loaiSanPham.getMaNCC(), name, );
//            boolean check = loaiSanPhamDAO.editLoaiSP(loaiSpUpdate);
//            if (check) {
//                Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
//                loadData();
//                alertDialog.dismiss();
//            } else {
//                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
//            }
        });
    }

    private void loadData() {
        list.clear();
        list = loaiSanPhamDAO.getDSLoaiSP();
        notifyDataSetChanged();
    }
}
