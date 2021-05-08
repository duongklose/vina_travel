package com.example.vinatravel.ui.book_ticket;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinatravel.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ChooseSeat extends AppCompatActivity {
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_seat_screen);
        toolbar = findViewById(R.id.topAppBarChooseSeat);
        toolbar.setTitle("Chọn ghế");

        Intent intent = getIntent();
        String name = intent.getStringExtra("chooseSeat");
        Log.d("AAA", String.valueOf(name));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new SeatFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}