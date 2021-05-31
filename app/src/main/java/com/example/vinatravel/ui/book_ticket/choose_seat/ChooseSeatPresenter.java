package com.example.vinatravel.ui.book_ticket.choose_seat;

import android.util.Log;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.seat.BaseSeatResponse;
import com.example.vinatravel.data.model.seat.SeatResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseSeatPresenter implements ChooseSeatContract.Presenter{

    private ChooseSeatContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public ChooseSeatPresenter(ChooseSeatContract.View view) {
        this.view = view;
    }

    public void getBookedSeats(int idTrip){
        api.getBookedSeats(idTrip).enqueue(new Callback<BaseSeatResponse>() {
            @Override
            public void onResponse(Call<BaseSeatResponse> call, Response<BaseSeatResponse> response) {
                Log.v("AAA", "onresponse");
                if(response.isSuccessful()){
                    Log.v("AAA", "code "+response.body().getCode());
                    if(response.body().getCode().equals("1000")){
                        int size = response.body().getData().size();
                        Log.v("AAA", "size "+size);
                        ArrayList<SeatResponse> seatResponses = new ArrayList<>();
                        for(int i=0; i<size;i++){
                            seatResponses.add(response.body().getData().get(i));
                        }
                        Log.v("AAA", "sizeSeatresponse "+seatResponses.size());
                        view.sendBookedSeats(seatResponses, size);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseSeatResponse> call, Throwable t) {

            }

        });
    }
}
