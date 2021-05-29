package com.example.vinatravel.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.user.User;
import com.example.vinatravel.ui.home.MainActivity;
import com.example.vinatravel.ui.register.RegisterActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener{

    private TextInputLayout tilPhone;
    private TextInputLayout tilPass;
    Button btnLogin, btnRegister;
    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilPhone = findViewById(R.id.til_phone);
        tilPass = findViewById(R.id.til_pass);
        btnLogin = findViewById(R.id.login_btn);
        btnRegister = findViewById(R.id.register_form_btn);
        Log.v("AAA", "create");
        initPresenter();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = tilPhone.getEditText().getText().toString().trim();
                String password = tilPass.getEditText().getText().toString().trim();
                presenter.handleLogin(phone, password);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFormRegister();
            }
        });
    }

    public void initPresenter(){
        presenter = new LoginPresenter(this);
    }

    @Override
    public void showPhoneError(int msgResId) {

    }

    @Override
    public void showPasswordError(int msgResId) {

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Sai tài khoản hoặc mật khẩu ", Toast.LENGTH_LONG);
    }

    @Override
    public void nextHome(User account) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle responseData = new Bundle();
        responseData.putInt("id", account.getId());
        responseData.putString("phone", account.getPhone());
        responseData.putString("name", account.getName());
        responseData.putString("pass", account.getPass());
//        responseData.putString(getString(R.string.key_token), account.getToken());
//        responseData.putString(getString(R.string.key_avatar), account.getAvatarLink());
        intent.putExtras(responseData);
        startActivity(intent, responseData);
    }

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.login_btn:
//                String phone = tilPhone.getEditText().getText().toString().trim();
//                String password = tilPass.getEditText().getText().toString().trim();
//                presenter.handleLogin(phone, password);
//                break;
//            case R.id.register_form_btn:
//                Log.v("AAA", "click");
//                showFormRegister();
//                break;
//        }
//    }

    public void showFormRegister(){
        Log.v("AAA", "showForm");
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}