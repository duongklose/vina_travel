package com.example.vinatravel.ui.complete_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.vinatravel.R;

public class CompleteRegisterActivity extends AppCompatActivity {

    private SharedPreferences dataAccountStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_register);
        Log.v("AAA", "create form ");
//        getDataAccount();
    }

//    private void getDataAccount() {
//        Bundle receive = getIntent().getExtras();
//        if (receive != null) {
//            String id = receive.getString("idUser");
//
////            dataAccountStorage.edit().putString(getString(R.string.key_token), token).apply();
//            dataAccountStorage.edit().putString("userId", id).apply();
////            dataAccountStorage.edit().putString(getString(R.string.key_avatar), avatarLink).apply();
////            presenter.getInfo(token, id);
//        }
//    }
}