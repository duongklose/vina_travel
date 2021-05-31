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
        api.listTrip(startProvince, endProvince, time).enqueue(new Callback<BaseTripResponse>() {
            @Override
            public void onResponse(Call<BaseTripResponse> call, Response<BaseTripResponse> response) {
                Log.v("AAA", "onResponse");
                if (response.isSuccessful()) {
                    Log.v("AAA", "code "+response.body().getCode());
//                    List<Trip> trips = new ArrayList<>();
//                    for (int i = 0; i < response.body().getData().size(); i++) {
//                        trips.add(new Trip(tham số) );
//                    }
                    int size = response.body().getData().size();
//                    for (int i = 0; i<size;i++){
//                        trips.add(response.body().getTrips()[0]);
//                    }
                    ArrayList<Trip> trips = new ArrayList<>();
                    for(int i=0; i<size;i++){
                        trips.add(response.body().getData().get(i));
                    }

//                    for(int i = 0;i<response.body())
//                            User user = new User(
//                                    response.body().getUserModel().getId(),
//                                    response.body().getUserModel().getUsername(),
//                                    response.body().getUserModel().getPass(),
//                                    response.body().getUserModel().getName(),
//                                    response.body().getUserModel().getPhone(),
//                                    response.body().getUserModel().getEmail(),
//                                    response.body().getUserModel().getRole()
//                            );
                    view.sendTrips(trips, size);
                }
            }

            @Override
            public void onFailure(Call<BaseTripResponse> call, Throwable t) {

            }
        });
    }
}
