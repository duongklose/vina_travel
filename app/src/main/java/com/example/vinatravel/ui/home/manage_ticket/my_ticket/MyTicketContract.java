package com.example.vinatravel.ui.home.manage_ticket.my_ticket;

import com.example.vinatravel.data.model.ticket.Ticket;

import java.util.ArrayList;

public interface MyTicketContract {
    interface View{
        void receiveMyTickets(ArrayList<Ticket> tickets);
    }

    interface Presenter{
        void getMyTicket(int idUser, String d);
    }
}
