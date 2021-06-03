package com.example.vinatravel.ui.book_ticket.choose_departure_location;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.book_ticket.choose_arrival_location.ChooseArrivalLocationActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

public class ChooseDepartureLocationActivity extends AppCompatActivity implements ChooseDepartureLocationContract.View{
    MaterialToolbar toolbar;
    Button btnContinue;
    int idTrip, price;
    int []arrayIdSeat;
    String chosenSeat, departureLocation, arrivalLocation;
    ChooseDepartureLocationContract.Presenter presenter;
    RadioButton rbtn;
    TextInputLayout detailLocation;
    TextView tvChosenSeats, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_departure_location_screen);
        arrayIdSeat = new int[40];
        receiveData();
        toolbar = findViewById(R.id.topAppBarChooseDepartureLocation);
        btnContinue = findViewById(R.id.continue_btn_departure_location);
        rbtn = findViewById(R.id.rbtn_departure_location);
        detailLocation = findViewById(R.id.til_detail_departureLocation);
        tvChosenSeats = findViewById(R.id.tv_seats_departure_location);
        tvPrice = findViewById(R.id.tv_price_departure_location);
        tvChosenSeats.setText(chosenSeat);
        tvPrice.setText(String.valueOf(price));
        initPresenter();

        rbtn.setText(departureLocation);

//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new DepartureLocationFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ChooseArrivalLocationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idTrip", idTrip);
                bundle.putInt("price", price);
                bundle.putString("departureLocation", departureLocation);
                bundle.putString("arrivalLocation", arrivalLocation);
                bundle.putString("chosenSeat", chosenSeat);
                bundle.putIntArray("arrayIdChosenSeats", arrayIdSeat);
                bundle.putString("detailDepartureLocation", detailLocation.getEditText().getText().toString().trim());
                intent1.putExtras(bundle);
                startActivity(intent1, bundle);
                startActivity(intent1);
            }
        });
    }

    private void initPresenter(){
        presenter = new ChooseDepartureLocationPresenter(this);
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
        }
    }
}