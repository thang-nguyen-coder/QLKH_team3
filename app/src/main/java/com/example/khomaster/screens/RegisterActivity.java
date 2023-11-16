package com.example.khomaster.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khomaster.R;
import com.example.khomaster.dao.ThuKhoDAO;

public class RegisterActivity extends AppCompatActivity {

    private ThuKhoDAO thuKhoDAO;
    EditText edtName, edtPass, edtEmail, edtNumber, edtnlPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        edtnlPass = findViewById(R.id.edtnlPass);
        edtEmail = findViewById(R.id.edtEmail);
        edtNumber = findViewById(R.id.edtNumber);
        thuKhoDAO = new ThuKhoDAO(this);

        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvLogin = findViewById(R.id.tvLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String pass = edtPass.getText().toString();
                String nlpass = edtnlPass.getText().toString();
                String email = edtEmail.getText().toString();
                String number = edtNumber.getText().toString();

                if (name.isEmpty() || pass.isEmpty() || nlpass.isEmpty() || email.isEmpty() || number.isEmpty()){
                    if (name.equals("")){
                        Toast.makeText(RegisterActivity.this, "Vui lòng không dể trống Họ tên", Toast.LENGTH_SHORT).show();
                    } else if (pass.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Vui lòng không để trống Mật khẩu", Toast.LENGTH_SHORT).show();
                    } else if (nlpass.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Vui lòng không để Nhập lại mật khẩu trống", Toast.LENGTH_SHORT).show();
                    } else if (!pass.equals(nlpass)) {
                        Toast.makeText(RegisterActivity.this, "Nhập 2 mật khẩu không giống nhau. Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                    } else if (email.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Vui lòng không để Email trống", Toast.LENGTH_SHORT).show();
                    } else if (number.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Vui lòng không để Số điện thoại trống", Toast.LENGTH_SHORT).show();
                    }else {

                    }
                }else {
                    boolean check = thuKhoDAO.Register(name, pass, email, number);
                    if (check){
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                        Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                    }else {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}