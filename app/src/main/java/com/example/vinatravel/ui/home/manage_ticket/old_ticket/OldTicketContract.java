package com.example.vinatravel.ui.home.manage_ticket.old_ticket;

import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

public interface OldTicketContract {
    interface View{
        void receiveOldTickets(ArrayList<Ticket> tickets);
    }

    interface Presenter{
        void getOldTicket(int idUser, String d);
    }
}
