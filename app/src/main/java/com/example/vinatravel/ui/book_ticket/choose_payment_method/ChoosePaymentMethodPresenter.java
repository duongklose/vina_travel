package com.example.vinatravel.ui.book_ticket.choose_payment_method;

import android.util.Log;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.BaseResponse;
import com.example.vinatravel.data.model.location.BaseLocationResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChoosePaymentMethodPresenter implements ChoosePaymentMethodContract.Presenter{
    private ChoosePaymentMethodContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public ChoosePaymentMethodPresenter(ChoosePaymentMethodContract.View view) {
        this.view = view;
    }
    @Override
    public void addTicket(int idTrip, int idUser, int idSeat, String detailDepartureLocation, String detailArrivalLocation) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String bookedDate = formatter.format(date);  ;
        api.addTicket(idTrip, idUser, bookedDate, idSeat, detailDepartureLocation, detailArrivalLocation).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()){
                    return;
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getIdLocation(String location) {
        api.getLocationByName(location).enqueue(new Callback<BaseLocationResponse>() {
            @Override
            public void onResponse(Call<BaseLocationResponse> call, Response<BaseLocationResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getCode().equals("1000")){
                        view.receiveIdDepartureLocation(response.body().getData().get(0).getId());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseLocationResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getIdArrivalLocation(String arrivalLocation) {
        api.getLocationByName(arrivalLocation).enqueue(new Callback<BaseLocationResponse>() {
            @Override
            public void onResponse(Call<BaseLocationResponse> call, Response<BaseLocationResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getCode().equals("1000")){
                        view.receiveIdArrivalLocation(response.body().getData().get(0).getId());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseLocationResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void comleteBookTicket(int idSeat, int idTrip, int idTicket) {
        api.completeBookTicket(idSeat, idTrip, idTicket).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode().equals(ResponseCode.OK)){
                        return;
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }

}
