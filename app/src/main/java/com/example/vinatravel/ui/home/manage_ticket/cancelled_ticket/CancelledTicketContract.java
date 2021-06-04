package com.example.vinatravel.ui.home.manage_ticket.cancelled_ticket;

import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

public interface CancelledTicketContract {
    interface View{
        void receiveCancelledTicket(ArrayList<Ticket> tickets);
    }

    interface Presenter{
        void getCancelledTicket(int idUser);
    }
}
