package com.example.vinatravel.ui.book_ticket.choose_seat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vinatravel.data.model.seat.Seat;
import com.example.vinatravel.data.model.seat.SeatResponse;

import java.util.ArrayList;
import java.util.List;

public interface ChooseSeatContract {
    interface View{

        void sendBookedSeats(ArrayList<SeatResponse> seatResponses, int size);
        void sendSeats(List<Seat> seats1, List<Seat> seats2, boolean isOneFloor);
    }

    interface Presenter{

        void getBookedSeats(int idTrip);

        void getSeats(int idTrip);

        boolean isOneFloor(int idTrip);
    }
}
