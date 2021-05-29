package com.example.vinatravel.ui.change_password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.login.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

public class ChangePasswordActivity extends AppCompatActivity implements ChangePasswordContract.View{
    private ChangePasswordContract.Presenter presenter;
    TextInputLayout tilOldPass;
    TextInputLayout tilNewPass;
    TextInputLayout tilRePass;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        tilOldPass = findViewById(R.id.til_old_pass);
        tilNewPass = findViewById(R.id.til_new_pass);
        tilRePass = findViewById(R.id.til_repass);
        btnUpdate = findViewById(R.id.update_pass_btn);
        initPresenter();
        SharedPreferences dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        int id = dataAccountStorage.getInt("id", 0);
        String p = dataAccountStorage.getString("pass", null);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = tilOldPass.getEditText().getText().toString().trim();
                String newPass = tilNewPass.getEditText().getText().toString().trim();
                String rePass = tilRePass.getEditText().getText().toString().trim();

                if( oldPass.equals("") || newPass.equals("") || rePass.equals("")){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT);
                }else if(!newPass.equals(rePass)){
                    Toast.makeText(getApplicationContext(), "Mật khẩu mới chưa khớp", Toast.LENGTH_SHORT);
                }else if(!oldPass.equals(p)){
                    Toast.makeText(getApplicationContext(), "Sai mật khẩu", Toast.LENGTH_SHORT);
                }else{
                    presenter.changePass(id, newPass);
                }
            }
        });

    }

    private void initPresenter(){
        presenter = new ChangePasswordPresenter(this);
    }

    @Override
    public void redirectLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Lỗi server!", Toast.LENGTH_LONG);
    }
}