package com.example.vinatravel.ui.book_ticket.choose_coach;

import com.example.vinatravel.data.model.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public interface ChooseCoachContract {
    interface View{

        void sendTrips(ArrayList<Trip> trips, int size);
    }

    interface Presenter{

        void getTrip(int idStartProvince, int idEndProvince, String time);
    }
}
