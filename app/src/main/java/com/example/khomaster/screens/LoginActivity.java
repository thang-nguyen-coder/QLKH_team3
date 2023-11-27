package com.example.khomaster.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khomaster.Layout;
import com.example.khomaster.R;
import com.example.khomaster.dao.ThuKhoDAO;
import com.example.khomaster.fragment.Fragment_thongke;

public class LoginActivity extends AppCompatActivity {

    EditText edtUser, edtPass;

    ThuKhoDAO thuKhoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvRegister = findViewById(R.id.tvRegister);
        thuKhoDAO = new ThuKhoDAO(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    public void login(){
        String user = edtUser.getText().toString();
        String passwd = edtPass.getText().toString();

        if (user.equals("") && passwd.equals("")) {
            Toast.makeText(this, "Chưa nhập tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();

        } else if (user.equals("")) {
            Toast.makeText(this, "Chưa nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
        } else if (passwd.equals("")) {
            Toast.makeText(this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
        } else {
            boolean check = thuKhoDAO.checkLogin(user, passwd);
            if (check) {
                startActivity(new Intent(this, Layout.class));
            } else {
                Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
            }
        }
    }
}