package com.example.vinatravel.ui.book_ticket.choose_arrival_location;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.book_ticket.choose_payment_method.ChoosePaymentMethodActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

public class ChooseArrivalLocationActivity extends AppCompatActivity implements ChooseArrivalLocationContract.View{
    MaterialToolbar toolbar;
    Button btnContinue;
    int idTrip, price;
    int []arrayIdSeat;
    String chosenSeat, departureLocation, arrivalLocation, detailDepartureLocation;
    ChooseArrivalLocationContract.Presenter present;
    RadioButton rbtn;
    TextInputLayout detailLocation;
    TextView tvChosenSeats, tvPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_arrival_location_screen);
        toolbar = findViewById(R.id.topAppBarChooseArrivalLocation);
        btnContinue = findViewById(R.id.continue_btn_arrival_location);
        arrayIdSeat = new int[40];
        receiveData();
        rbtn = findViewById(R.id.rbtn_arrival_location);
        detailLocation = findViewById(R.id.til_detail_arrival_location);
        tvChosenSeats = findViewById(R.id.tv_seats_arrival_location);
        tvPrice = findViewById(R.id.tv_price_arrival_location);

        tvChosenSeats.setText(chosenSeat);
        tvPrice.setText(String.valueOf(price));
        rbtn.setText(arrivalLocation);
        initPresenter();

//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content_arrival_location, new ArrivalLocationFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ChoosePaymentMethodActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idTrip", idTrip);
                bundle.putInt("price", price);
                bundle.putString("departureLocation", departureLocation);
                bundle.putString("arrivalLocation", arrivalLocation);
                bundle.putString("chosenSeat", chosenSeat);
                bundle.putIntArray("arrayIdChosenSeats", arrayIdSeat);
                bundle.putString("detailDepartureLocation", detailDepartureLocation);
                bundle.putString("detailArrivalLocation", detailLocation.getEditText().getText().toString().trim());
                intent1.putExtras(bundle);
                startActivity(intent1, bundle);
            }
        });
    }

    private void receiveData(){
        Bundle receive = getIntent().getExtras();
        if (receive != null) {
            Intent intent = getIntent();
            idTrip = intent.getIntExtra("idTrip", 0);
            price = intent.getIntExtra("price", 0);
            departureLocation = intent.getStringExtra("departureLocation");
            arrivalLocation = intent.getStringExtra("arrivalLocation");
            chosenSeat = intent.getStringExtra("chosenSeat");
            arrayIdSeat = intent.getIntArrayExtra("arrayIdChosenSeats");
            detailDepartureLocation = intent.getStringExtra("detailDepartureLocation");
        }
    }
    private void initPresenter(){
        present = new ChooseArrivalLocationPresenter(this);
    }
}