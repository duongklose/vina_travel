package com.example.vinatravel.ui.detail_ticket;

import com.example.vinatravel.data.model.seat.SeatResponse;

import java.util.ArrayList;

public interface DetailTicketContract {
    interface View{
        void receiveSeats(ArrayList<SeatResponse> listSeats);
        void cancelTicketSuccess();
    }

    interface Presenter{
        void getSeatsByTicket(int idTicket);
        void cancelTicket(int idTicket);
    }
}
