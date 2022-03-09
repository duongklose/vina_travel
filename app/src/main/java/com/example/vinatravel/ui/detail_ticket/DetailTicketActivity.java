package com.example.vinatravel.ui.detail_ticket;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.seat.SeatResponse;
import com.example.vinatravel.data.model.ticket.Ticket;
import com.example.vinatravel.ui.book_ticket.choose_seat.ChooseSeatActivity;
import com.example.vinatravel.ui.home.MainActivity;
import com.example.vinatravel.ui.login.LoginActivity;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class DetailTicketActivity extends Activity implements DetailTicketContract.View{
    DetailTicketContract.Presenter presenter;
    MaterialToolbar toolbar;
    TextView tvID, tvNameTransportationCompany, tvLicensePlate, tvSeats, tvBookDate, tvDefaultStartLocation, tvDefaultEndLocation, tvStartLocation, tvEndLocation, tvStartTime, tvEndTime, tvPrice;
    Button btnFollow, btnCancel;
    Ticket ticket;
    String typeTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ticket);
        initView();
        initPresenter();
        receiveData();
//        presenter.getSeatsByTicket(ticket.getId());
    }

    private void initPresenter(){
        presenter = new DetailTicketPresenter(this);
    }
    private void initView(){
        toolbar = findViewById(R.id.topAppBarDetailTicket);
        tvID = findViewById(R.id.tv_id_ticket);
        tvNameTransportationCompany = findViewById(R.id.tv_transportation_company_ticket);
        tvLicensePlate = findViewById(R.id.tv_license_plate_ticket);
        tvSeats = findViewById(R.id.tv_seats_ticket);
        tvBookDate = findViewById(R.id.tv_book_date_ticket);
        tvStartLocation = findViewById(R.id.tv_start_location_ticket);
        tvEndLocation = findViewById(R.id.tv_end_location_ticket);
        tvStartTime = findViewById(R.id.tv_start_time_ticket);
        tvEndTime = findViewById(R.id.tv_end_time_ticket);
        tvPrice = findViewById(R.id.tv_price_ticket);
        btnCancel = findViewById(R.id.cancel_ticket_btn);

//        setData();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //create dialog
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(DetailTicketActivity.this);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("Hủy vé");
        builder.setMessage("Bạn chắc chắn hủy vé?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.cancelTicket(ticket.getId());
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void receiveData(){
        Intent intent = getIntent();
        ticket = (Ticket) intent.getSerializableExtra("ticket");
        typeTicket = intent.getStringExtra("typeTicket");

        tvID.setText(String.valueOf(ticket.getId()));
        tvNameTransportationCompany.setText(ticket.getName());
        tvLicensePlate.setText(ticket.getLicensePlate());
        tvSeats.setText(ticket.getSeat());
        String bDate = ticket.getBookDate().substring(8,10) + "/" + ticket.getBookDate().substring(5,7) + "/" + ticket.getBookDate().substring(0,4);
        tvBookDate.setText(bDate);
        tvStartLocation.setText(ticket.getStartLocation());
        tvEndLocation.setText(ticket.getEndLocation());

        String date = ticket.getStartTime().substring(0,10);
        String d = date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        tvStartTime.setText(ticket.getStartTime().substring(11,16) + " " + d);

        date = ticket.getEndTime().substring(0,10);
        d = date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        tvEndTime.setText(ticket.getEndTime().substring(11,16) + " " + d);

        tvPrice.setText(String.valueOf(ticket.getPrice()));
    }

    private void setData(){

    }
    @Override
    public void receiveSeats(ArrayList<SeatResponse> listSeats) {
        String seats="";
        for (int i=0; i<listSeats.size(); i++){
            seats = seats + listSeats.get(i).getName() + " ";
        }

        tvID.setText(String.valueOf(ticket.getId()));
        tvNameTransportationCompany.setText(ticket.getName());
        tvLicensePlate.setText(ticket.getLicensePlate());
        tvSeats.setText(seats);
        String bDate = ticket.getBookDate().substring(8) + "/" + ticket.getBookDate().substring(5,7) + "/" + ticket.getBookDate().substring(0,4);
        tvBookDate.setText(bDate);
        tvDefaultStartLocation.setText(ticket.getStartLocation());
        tvDefaultEndLocation.setText(ticket.getEndLocation());
        tvStartLocation.setText(ticket.getStartLocation());
        tvEndLocation.setText(ticket.getEndLocation());

        String date = ticket.getStartTime().substring(0,10);
        String d = date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        tvStartTime.setText(ticket.getStartTime().substring(11,16) + " " + d);

        date = ticket.getEndTime().substring(0,10);
        d = date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        tvEndTime.setText(ticket.getEndTime().substring(11,16) + " " + d);

        tvPrice.setText(String.valueOf(ticket.getPrice()));
    }

    @Override
    public void cancelTicketSuccess() {
        Toast.makeText(this, "Hủy vé thành công", Toast.LENGTH_LONG);
        SharedPreferences dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        String name = dataAccountStorage.getString("name", null);
        int id = dataAccountStorage.getInt("id", 0);
        String phone = dataAccountStorage.getString("phone", null);
        Intent intent = new Intent(this, MainActivity.class);
        Bundle responseData = new Bundle();
        responseData.putInt("id", id);
        responseData.putString("phone", phone);
        responseData.putString("name", name);
        intent.putExtras(responseData);
        startActivity(intent, responseData);
    }
}