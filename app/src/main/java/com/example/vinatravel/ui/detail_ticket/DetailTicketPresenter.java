package com.example.vinatravel.ui.detail_ticket;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.BaseResponse;
import com.example.vinatravel.data.model.seat.BaseSeatResponse;
import com.example.vinatravel.data.model.seat.SeatResponse;
import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTicketPresenter implements DetailTicketContract.Presenter{
    DetailTicketContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public DetailTicketPresenter(DetailTicketContract.View view) {
        this.view = view;
    }


    @Override
    public void getSeatsByTicket(int idTicket) {
        api.getSeatsByTicket(idTicket).enqueue(new Callback<BaseSeatResponse>() {
            @Override
            public void onResponse(Call<BaseSeatResponse> call, Response<BaseSeatResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equals(ResponseCode.OK)){
                        ArrayList<SeatResponse> seats = new ArrayList<>();
                        for(int i=0; i<response.body().getData().size();i++){
                            seats.add(response.body().getData().get(i));
                        }
                        view.receiveSeats(seats);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseSeatResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void cancelTicket(int idTicket) {
        api.cancelTicket(idTicket).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equals(ResponseCode.OK)){
                        view.cancelTicketSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }
}
