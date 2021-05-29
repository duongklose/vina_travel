package com.example.vinatravel.ui.edit_info_user;

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

public class EditInfoUserActivity extends AppCompatActivity implements EditInfoUserContract.View{

    private EditInfoUserContract.Presenter presenter;
    TextInputLayout tilNewPhone;
    TextInputLayout tilNewName;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_user);
        tilNewName = findViewById(R.id.til_name_edit);
        tilNewPhone = findViewById(R.id.til_phone_edit);
        btnUpdate = findViewById(R.id.update_btn);
        SharedPreferences dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        int id = dataAccountStorage.getInt("id", 0);
        initPresenter();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = tilNewName.getEditText().getText().toString().trim();
                String newPhone = tilNewPhone.getEditText().getText().toString().trim();
                Log.v("AAA", "name"+newName);
                Log.v("AAA", "phone"+newPhone);
                presenter.updateInfo(id, newPhone, newName);
            }
        });

    }

    public void initPresenter(){
        presenter = new EditInfoUserPresenter(this);
    }

    public void redirectLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void showError(){
        Toast.makeText(this, "Lỗi server!", Toast.LENGTH_LONG);
    }
    public void updateSuccess(){
        Toast.makeText(this, "Cập nhật thành công.", Toast.LENGTH_LONG);
    }
}