package com.example.vinatravel.ui.book_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vinatravel.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ChooseDepartureLocation extends AppCompatActivity {
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_departure_location_screen);
        toolbar = findViewById(R.id.topAppBarChooseDepartureLocation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new DepartureLocationFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
    }
}