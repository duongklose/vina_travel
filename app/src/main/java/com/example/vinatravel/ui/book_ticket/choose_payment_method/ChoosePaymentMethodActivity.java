package com.example.vinatravel.ui.book_ticket.choose_payment_method;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.book_ticket.choose_departure_location.ChooseDepartureLocationActivity;
import com.example.vinatravel.ui.home.MainActivity;
import com.example.vinatravel.ui.login.LoginActivity;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.concurrent.TimeUnit;

public class ChoosePaymentMethodActivity extends AppCompatActivity implements ChoosePaymentMethodContract.View{
    MaterialToolbar toolbar;
//    AutoCompleteTextView bank;
    Button btnBookTicket;
    TextView tvPrice;
    ChoosePaymentMethodContract.Presenter presenter;
    private SharedPreferences dataAccountStorage;
    int idTrip, price, idStartLocation, idEndLocation, idUser;
    int []arrayIdSeat;
    String chosenSeat, departureLocation, arrivalLocation, detailDepartureLocation, detailArrivalLocation, paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_payment_method_screen);
        toolbar = findViewById(R.id.topAppBarChoosePaymentMethod);
        tvPrice = findViewById(R.id.tv_price_payment_method);
//        bank = findViewById(R.id.bank);
        btnBookTicket = findViewById(R.id.pay_btn);
        SharedPreferences dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        idUser = dataAccountStorage.getInt("id", 0);
        initPresenter();
        receiveData();
        paymentMethod="Tiền mặt";
        tvPrice.setText(String.valueOf(price));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChoosePaymentMethodActivity.this, "Đặt vé thành công", Toast.LENGTH_SHORT).show();
                Log.d("AAAA", arrayIdSeat[0] + "");
                int i = 0;
                while (arrayIdSeat[i] > 0){
                    Log.d("AAAA", arrayIdSeat[i] + "");
                    presenter.addTicket(idTrip, idUser, arrayIdSeat[i], detailDepartureLocation, detailArrivalLocation);
                    i++;
                }
//                for(int i=0 ; i < arrayIdSeat.length ; i++){
//                    Log.d("AAAA", arrayIdSeat[i] + "");
////                    presenter.addTicket(idTrip, idUser, arrayIdSeat[i], detailDepartureLocation, detailArrivalLocation);
//                }
                bookTicketSuccess();
            }
        });

        //dropdown menu - bank
//        String []bank = getResources().getStringArray(R.array.list_bank);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getParent(), R.layout.province_item, bank);
//
//        //make default value
//        bank.setText(arrayAdapter.getItem(0).toString(), false);
//        bank.setAdapter(arrayAdapter);
    }

    private void initPresenter(){
        presenter = new ChoosePaymentMethodPresenter(this);
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
            detailArrivalLocation = intent.getStringExtra("detailArrivalLocation");
        }
    }

    @Override
    public void receiveIdDepartureLocation(int idDepartureLocation) {
        idStartLocation =idDepartureLocation;
        presenter.getIdArrivalLocation(arrivalLocation);
    }

    @Override
    public void receiveIdArrivalLocation(int idArrivalLocation) {
//        idEndLocation = idArrivalLocation;
//        dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
//        int idUser =  dataAccountStorage.getInt("id", 0);
//        presenter.addTicket(idTrip, idUser, idStartLocation, idEndLocation, paymentMethod, price, detailDepartureLocation, detailArrivalLocation);
    }

    @Override
    public void bookTicketSuccess() {
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void completeBookTicket(int idTicket) {
        int i =0;
        while (arrayIdSeat[i]!= 0){
            int idSeat = arrayIdSeat[i];
            presenter.comleteBookTicket(idSeat, idTrip, idTicket);
            i++;
        }
        bookTicketSuccess();
    }


}