package com.example.vinatravel.ui.book_ticket.choose_seat;

import com.example.vinatravel.data.model.seat.SeatResponse;

import java.util.ArrayList;

public interface ChooseSeatContract {
    interface View{

        void sendBookedSeats(ArrayList<SeatResponse> seatResponses, int size);
    }

    interface Presenter{

        void getBookedSeats(int idTrip);
    }
}
