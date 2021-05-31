package com.example.vinatravel.ui.book_ticket.choose_coach;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.transportation_company.TransportationCompany;
import com.example.vinatravel.data.model.trip.Trip;
import com.example.vinatravel.ui.book_ticket.TripAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class ChooseCoachActivity extends Activity implements ChooseCoachContract.View{
    RecyclerView recyclerView;
    MaterialToolbar toolbar;
    ChooseCoachContract.Presenter presenter;
    String startLocation, endLocation, date;
    ArrayList<Trip> tripList;
    int sizeTripList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_coach_screen);
        presenter = new ChooseCoachPresenter(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("info");
        if (bundle != null){
            startLocation = bundle.getString("startLocation");
            endLocation = bundle.getString("endLocation");
            date = bundle.getString("date");
        }

        //init view
        toolbar = findViewById(R.id.topAppBarChooseCoach);
        toolbar.setTitle(startLocation + " - " + endLocation);
        presenter.getTrip(1, 28, "2021-05-24");

//        recyclerView = findViewById(R.id.recyclerview_choose_coach);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
//        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
//        dividerItemDecoration.setDrawable(drawable);
//        recyclerView.addItemDecoration(dividerItemDecoration);

//        ArrayList<Trip> tripArrayList = new ArrayList<>();
//        for (int i = 0; i<sizeTripList; i++){
//            tripArrayList.add(tripList.get(i));
//        }
//        tripArrayList.add(new TransportationCompany(R.drawable.mailinh, "Mai Linh"));
//        tripArrayList.add(new TransportationCompany(R.drawable.hoanglong, "Hoàng Long"));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        TripAdapter tripAdapter = new TripAdapter(tripList, getApplicationContext());
//        recyclerView.setAdapter(tripAdapter);
    }

    public void sendTrips(ArrayList<Trip> trips, int size){
        for (int i=0;i<size;i++){
            tripList.add(trips.get(i));
        }
        sizeTripList = size;
        Log.v("AAA", ""+tripList.size());
    }
}
