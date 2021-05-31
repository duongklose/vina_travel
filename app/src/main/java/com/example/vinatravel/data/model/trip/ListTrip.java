package com.example.vinatravel.data.model.trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListTrip {
    @SerializedName("data")
    @Expose
    private List<Trip> trips;

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
    public int getSize(){
        return trips.size();
    }
}
