package com.example.vinatravel.ui.book_ticket.choose_coach;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.trip.Trip;
import com.google.android.material.appbar.MaterialToolbar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChooseCoachActivity extends Activity implements ChooseCoachContract.View{
    RecyclerView recyclerView;
    MaterialToolbar toolbar;
    ChooseCoachContract.Presenter presenter;
    String startLocation, endLocation, date;
    int idStartLocation, idEndLocation;
    ArrayList<Trip> tripList;
    TextView chosenDate;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_coach_screen);
        presenter = new ChooseCoachPresenter(this);
        chosenDate = findViewById(R.id.chosen_date);
        tripList = new ArrayList<>();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("info");
        if (bundle != null){
            startLocation = bundle.getString("startLocation");
            endLocation = bundle.getString("endLocation");
            idStartLocation = bundle.getInt("idStartLocation");
            idEndLocation = bundle.getInt("idEndLocation");
            date = bundle.getString("date");
        }
        chosenDate.setText("NGÀY " + date.substring(0,2) + "/" + date.substring(3,5) + "/" + date.substring(6));
        String formatDate = date.substring(6) + "-" + date.substring(3,5) + "-" + date.substring(0,2);

//        Calendar cal = Calendar.getInstance();
//        cal.set(2021, 5, 30);
//        DateFormat formatter = new SimpleDateFormat("EEEE");
//        chosenDate.setText(formatter.format(cal.getTime()));

        //init view
        toolbar = findViewById(R.id.topAppBarChooseCoach);
        toolbar.setTitle(startLocation + " - " + endLocation);

        recyclerView = findViewById(R.id.recyclerview_choose_coach);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        presenter.getTrip(idStartLocation, idEndLocation, formatDate);

        toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void sendTrips(ArrayList<Trip> trips, int size){
        for (int i=0;i<size;i++){
            String startDay = trips.get(i).getDepartureTime().substring(11,16);
            String endDay = trips.get(i).getArrivalTime().substring(11,16);

//            tripList.add(trips.get(i));
            tripList.add(new Trip(trips.get(i).getId(), trips.get(i).getName(), trips.get(i).getTypename(), startDay, endDay, trips.get(i).getStartLocation(), trips.get(i).getPrice(), trips.get(i).getEndLocation(), trips.get(i).getRatePoint()));
        }
        TripAdapter tripAdapter = new TripAdapter(tripList, getApplicationContext());
        recyclerView.setAdapter(tripAdapter);
    }
}
