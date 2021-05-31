package com.example.vinatravel.ui.book_ticket.choose_seat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.book_ticket.ChooseDepartureLocation;
import com.example.vinatravel.ui.book_ticket.SeatFragment;
import com.example.vinatravel.ui.book_ticket.choose_coach.ChooseCoachContract;
import com.google.android.material.appbar.MaterialToolbar;

public class ChooseSeatActivity extends AppCompatActivity implements ChooseSeatContract.View {
    MaterialToolbar toolbar;
    Button btnContinue;
    TextView tvSeat, tvPrice;
    ChooseSeatContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_seat_screen);
        tvSeat = findViewById(R.id.tv_seats);
        tvPrice = findViewById(R.id.tv_price);
        toolbar = findViewById(R.id.topAppBarChooseSeat);
        btnContinue = findViewById(R.id.continue_btn);
        toolbar.setTitle("Chọn ghế");
        initPresenter();

        Intent intent = getIntent();
        int name = intent.getIntExtra("idTrip", 0);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new SeatFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ChooseDepartureLocation.class);
                startActivity(intent1);
            }
        });
    }

    private void initPresenter(){
        presenter = new ChooseSeatPresenter(this);
    }
}