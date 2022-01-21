package com.example.vinatravel.data.model.trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Trip {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("typename")
    @Expose
    private String typename;
    @SerializedName("departure_time")
    @Expose
    private String departureTime;
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;
    @SerializedName("startLocation")
    @Expose
    private String startLocation;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("endLocation")
    @Expose
    private String endLocation;
    @SerializedName("rate_point")
    @Expose
    private double ratePoint;

    public Trip(int id, String name, String typename, String departureTime, String arrivalTime, String startLocation, int price, String endLocation, double ratePoint) {
        this.id = id;
        this.name = name;
        this.typename = typename;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.startLocation = startLocation;
        this.price = price;
        this.endLocation = endLocation;
        this.ratePoint = ratePoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(float ratePoint) {
        this.ratePoint = ratePoint;
    }
}
