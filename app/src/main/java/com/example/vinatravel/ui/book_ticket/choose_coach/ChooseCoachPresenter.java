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
//        Trip t = new Trip(1, "Hoàng Long", "Xe giường nằm", "19/01/2022 08:00:00", "20/01/2022 20:00:00", "Bến xe Mỹ Đình", 800000, "Bến xe Miền Đông", 4.8);
//        Trip t1 = new Trip(2, "Hoàng Long", "Xe giường nằm", "19/01/2022 18:00:00", "21/01/2022 06:00:00", "Bến xe Mỹ Đình", 800000, "Bến xe Miền Đông", 4.8);
//        ArrayList<Trip> trips = new ArrayList<>();
//        trips.add(t);
//        trips.add(t1);
//        view.sendTrips(trips, 2);
//        Log.d("AAAA",startProvince+ "----" + endProvince +"----" + time);
        api.listTrip(startProvince, endProvince, time).enqueue(new Callback<BaseTripResponse>() {
            @Override
            public void onResponse(Call<BaseTripResponse> call, Response<BaseTripResponse> response) {
//                Log.d("AAAA",response.body().getCode());
                if (response.isSuccessful()) {
                    int size = response.body().getData().size();
//                    Log.d("AAA", String.valueOf(size));
                    ArrayList<Trip> trips = new ArrayList<>();
                    for(int i=0; i<size;i++){
                        trips.add(response.body().getData().get(i));
                    }
                    view.sendTrips(trips, size);
                }
            }

            @Override
            public void onFailure(Call<BaseTripResponse> call, Throwable t) {
                Log.d("AAAA",t.getMessage().toString());
            }
        });
    }
}
