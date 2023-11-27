package com.example.khomaster.screens;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khomaster.R;
import com.example.khomaster.dao.ThuKhoDAO;

public class EditUserActivity extends AppCompatActivity {
    private AlertDialog alertDialog;
    private LinearLayout itemDMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        itemDMK = findViewById(R.id.itemDoiMK);
        itemDMK.setOnClickListener(v -> {
            showDialogDoiMk();
        });
    }

    private void showDialogDoiMk() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_doimk, null);
        TextView tvOldpass = view.findViewById(R.id.edtOldPasswd);
        TextView tvNewpass = view.findViewById(R.id.edtNewPasswd);
        TextView tvRepass = view.findViewById(R.id.edtRePasswd);
        Button btnLuu = view.findViewById(R.id.btnLuuDoiMk);
        Button btnHuy = view.findViewById(R.id.btnHuyDoiMk);
        builder.setView(view);
        btnHuy.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
        btnLuu.setOnClickListener(v -> {
            String old =tvOldpass.getText().toString();
            String new_ = tvNewpass.getText().toString();
            String re_ = tvRepass.getText().toString();
            if (new_.equals(re_) && !new_.equals(old)) {
                SharedPreferences sharedPreferences = getSharedPreferences("dataUser", this.MODE_PRIVATE);
                String user = sharedPreferences.getString("HoTen", "");
                //update
                ThuKhoDAO thuKhoDAO = new ThuKhoDAO(this);
                boolean check = thuKhoDAO.DoiMk(user, old, new_);
                if(check){
                    Toast.makeText(this, "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Mật khẩu mới phải khác mật khẩu cũ và nhập lại mật khẩu phải trùng khớp", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.show();
    }
}