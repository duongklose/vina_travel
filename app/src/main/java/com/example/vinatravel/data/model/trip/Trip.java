package com.example.vinatravel.data.model.trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Trip {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_transportation")
    @Expose
    private int idTransportation;
    @SerializedName("id_coach")
    @Expose
    private int idCoach;
    @SerializedName("departure_time")
    @Expose
    private String departureTime;
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;
    @SerializedName("departure_location")
    @Expose
    private int departureLocation;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("arrival_location")
    @Expose
    private int arrivalLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransportation() {
        return idTransportation;
    }

    public void setIdTransportation(int idTransportation) {
        this.idTransportation = idTransportation;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(int departureLocation) {
        this.departureLocation = departureLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(int arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }
}
