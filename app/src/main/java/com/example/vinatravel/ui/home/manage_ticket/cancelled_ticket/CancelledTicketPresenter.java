package com.example.vinatravel.ui.home.manage_ticket.cancelled_ticket;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.ticket.BaseTicketResponse;
import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelledTicketPresenter implements CancelledTicketContract.Presenter{
    private CancelledTicketContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public CancelledTicketPresenter(CancelledTicketContract.View view) {
        this.view = view;
    }

    @Override
    public void getCancelledTicket(int idUser) {
        api.getCancelledTicket(idUser).enqueue(new Callback<BaseTicketResponse>() {
            @Override
            public void onResponse(Call<BaseTicketResponse> call, Response<BaseTicketResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getCode().equals(ResponseCode.OK)){
                        ArrayList<Ticket> tickets = new ArrayList<>();
                        for(int i=0; i<response.body().getData().size();i++){
                            tickets.add(response.body().getData().get(i));
                        }
                        view.receiveCancelledTicket(tickets);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseTicketResponse> call, Throwable t) {

            }
        });
    }
}
