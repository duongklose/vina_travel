package com.example.vinatravel.ui.home.manage_ticket.old_ticket;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.ticket.BaseTicketResponse;
import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OldTicketPresenter implements OldTicketContract.Presenter{
    private OldTicketContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public OldTicketPresenter(OldTicketContract.View view) {
        this.view = view;
    }

    @Override
    public void getOldTicket(int idUser) {
        api.getOldTicket(idUser).enqueue(new Callback<BaseTicketResponse>() {
            @Override
            public void onResponse(Call<BaseTicketResponse> call, Response<BaseTicketResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getCode().equals("1000")){
                        ArrayList<Ticket> tickets = new ArrayList<>();
                        for(int i=0; i<response.body().getData().size();i++){
                            tickets.add(response.body().getData().get(i));
                        }
                        view.receiveOldTickets(tickets);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseTicketResponse> call, Throwable t) {

            }
        });
    }
}
