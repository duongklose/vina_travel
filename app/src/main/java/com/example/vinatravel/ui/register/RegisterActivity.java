package com.example.vinatravel.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.complete_register.CompleteRegisterActivity;
import com.example.vinatravel.ui.login.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, View.OnClickListener {

    TextInputLayout tilPhone;
    TextInputLayout tilPass;
    TextInputLayout tilName;
    Button btnRegister;
    RegisterContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilPhone = findViewById(R.id.til_phone_register);
        tilPass = findViewById(R.id.til_pass_register);
        tilName = findViewById(R.id.til_name_register);
        btnRegister = findViewById(R.id.register_btn);
        initPresenter();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = tilPhone.getEditText().getText().toString().trim();
                String pass = tilPass.getEditText().getText().toString().trim();
                String name = tilName.getEditText().getText().toString().trim();
                presenter.register(phone, pass, name);
            }
        });
    }

    public void initPresenter(){
        presenter = new RegisterPresenter( this);
    }

    @Override
    public void onClick(android.view.View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.register_btn:
//                String phone = tilPhone.getEditText().getText().toString().trim();
//                String pass = tilPass.getEditText().getText().toString().trim();
//                presenter.register(phone, pass);
//                break;
//        }
    }


    @Override
    public void redirectLogin() {
//        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG);
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Tài khoản đã tồn tại", Toast.LENGTH_LONG);
    }
}