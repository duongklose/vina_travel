package com.example.vinatravel.ui.book_ticket.choose_coach;

import android.util.Log;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.trip.BaseTripResponse;
import com.example.vinatravel.data.model.trip.Trip;
import com.example.vinatravel.data.model.user.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseCoachPresenter implements ChooseCoachContract.Presenter{
    private ChooseCoachContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public ChooseCoachPresenter(ChooseCoachContract.View view) {
        this.view = view;
    }

    public void getTrip(int startProvince, int endProvince, String time){
        Trip t = new Trip(1, "Name", "TypeName", "2012123123123/01/2022", "21123123123123/01/2022", "BX My Dinh", 200000, "Thanh Hoa", 5);
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(t);
        view.sendTrips(trips, 1);
//        api.listTrip(startProvince, endProvince, time).enqueue(new Callback<BaseTripResponse>() {
//            @Override
//            public void onResponse(Call<BaseTripResponse> call, Response<BaseTripResponse> response) {
//                if (response.isSuccessful()) {
//                    int size = response.body().getData().size();
//                    ArrayList<Trip> trips = new ArrayList<>();
//                    for(int i=0; i<size;i++){
//                        trips.add(response.body().getData().get(i));
//                    }
//                    view.sendTrips(trips, size);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseTripResponse> call, Throwable t) {
//
//            }
//        });
    }
}
