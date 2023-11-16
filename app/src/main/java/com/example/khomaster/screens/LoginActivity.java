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

    ThuKhoDAO thuKhoDAO = new ThuKhoDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvRegister = findViewById(R.id.tvRegister);

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
        String pass = edtPass.getText().toString();

        if (user.isEmpty() || pass.isEmpty()){
            if (user.equals("")){
                Toast.makeText(this, "Vui lòng không để trống Tài khoản", Toast.LENGTH_SHORT).show();
            } else if (pass.equals("")) {
                Toast.makeText(this, "Vui lòng không để trống Mật khẩu", Toast.LENGTH_SHORT).show();
            }else {

            }
        }else {
            if (thuKhoDAO.checkLogin(user, pass)){
                Toast.makeText(this, "Login thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, Layout.class);
                intent.putExtra("MaTK", user);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        }
    }
}