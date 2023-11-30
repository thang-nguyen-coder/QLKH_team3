package com.example.khomaster.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khomaster.ImagePickerCallback;
import com.example.khomaster.R;
import com.example.khomaster.adapter.LoaiSanPhamAdapter;
import com.example.khomaster.dao.LoaiSanPhamDAO;
import com.example.khomaster.model.LoaiSanPham;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_hanghoa extends Fragment implements ImagePickerCallback {
    private ImageView imgSreach, imgDialogLSP;
    private EditText edtSreach, edtLSP;
    private Button btnAdd, btnHuy;
    private FloatingActionButton btnAddLSP;
    private RecyclerView rcyLSP;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private ArrayList<LoaiSanPham> list;
    private Uri selectedImageUri;
    public static final int PICK_IMAGE_REQUEST = 1;
    private ImagePickerCallback imagePickerCallback;

    public Fragment_hanghoa() {
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanghoa, container, false);
        imgSreach = view.findViewById(R.id.imgSreachHangHoa);
        edtSreach = view.findViewById(R.id.edtSreachHangHoa);
        btnAddLSP = view.findViewById(R.id.btnAddLoaiSP);
        rcyLSP = view.findViewById(R.id.rcyHangHoa);
        imgSreach.setOnClickListener(v -> {
            onFindItem(view);
        });
        btnAddLSP.setOnClickListener(v -> {
            showDialog();
        });
        loadData();
        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_updatelsp, null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.show();

        edtLSP = view.findViewById(R.id.edtSaveLSP);
        imgDialogLSP = view.findViewById(R.id.ivLoaiSP);
        btnAdd = view.findViewById(R.id.btnSave);
        btnHuy = view.findViewById(R.id.btnHuy);

        imgDialogLSP.setOnClickListener(v -> {
            openLibrary();
        });
        btnHuy.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
        btnAdd.setOnClickListener(v -> {
            String name = edtLSP.getText().toString();
            if (selectedImageUri == null && name.isEmpty()) {
                Toast.makeText(getContext(), "Chưa nhập tên của loại sản phẩm hoặc ảnh rỗng", Toast.LENGTH_SHORT).show();
            } else {
                boolean check = loaiSanPhamDAO.addLoaiSP(name, String.valueOf(selectedImageUri));
                if (check) {
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    loadData();
                    alertDialog.dismiss();
                }else{
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void openLibrary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Lưu trữ Uri của ảnh được chọn
            selectedImageUri = data.getData();
            // Hiển thị ảnh trên ImageView
            imgDialogLSP.setImageURI(selectedImageUri);
        }
    }

    public void onFindItem(View view) {
        edtSreach.setVisibility(view.VISIBLE);
    }

    public void loadData() {
        loaiSanPhamDAO = new LoaiSanPhamDAO(getContext());
        list = loaiSanPhamDAO.getDSLoaiSP();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcyLSP.setLayoutManager(manager);
        LoaiSanPhamAdapter adapter = new LoaiSanPhamAdapter(getContext(), list, loaiSanPhamDAO);
        rcyLSP.setAdapter(adapter);
    }
}