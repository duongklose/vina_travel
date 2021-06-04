package com.example.vinatravel.ui.home.manage_ticket.old_ticket;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.ticket.Ticket;
import com.example.vinatravel.ui.home.manage_ticket.TicketAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OldTicketFragment extends Fragment implements OldTicketContract.View{
    RecyclerView recyclerView;
    OldTicketContract.Presenter presenter;
    ArrayList<Ticket> ticketArrayList;
    private SharedPreferences dataAccountStorage;
    TextView tvNoOldTicket;


    public OldTicketFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_old_ticket, container, false);
        initPresenter();
        recyclerView = view.findViewById(R.id.rcy_old_ticket);
        tvNoOldTicket = view.findViewById(R.id.tv_no_old_ticket);
        ticketArrayList = new ArrayList<>();

        dataAccountStorage = this.getActivity().getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        int idUser =  dataAccountStorage.getInt("id", 0);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = formatter.format(date);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        presenter.getOldTicket(idUser, d);

        return view;
    }

    private void initPresenter(){
        presenter = new OldTicketPresenter(this);
    }

    @Override
    public void receiveOldTickets(ArrayList<Ticket> tickets) {
        for (int i=0; i<tickets.size();i++){
            String startTime = tickets.get(i).getStartTime().substring(11,16);
            String endTime = tickets.get(i).getEndTime().substring(11,16);
            String date = tickets.get(i).getDate().substring(0,10);
            String d = date.substring(8) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
            ticketArrayList.add(new Ticket(tickets.get(i).getId(), tickets.get(i).getNameTransportationCompany(), tickets.get(i).getLicensePlate(), tickets.get(i).getBookDate(), tickets.get(i).getDefaultStartLocation(), tickets.get(i).getDefaultEndLocation(), tickets.get(i).getStartLocation(), tickets.get(i).getEndLocation(), startTime, endTime, d, tickets.get(i).getPrice()));
        }
        if(tickets.size()>0){
            TicketAdapter ticketAdapter = new TicketAdapter(ticketArrayList, getContext());
            recyclerView.setAdapter(ticketAdapter);
        }else{
            tvNoOldTicket.setText("Không có chuyến nào");
        }
    }
}
