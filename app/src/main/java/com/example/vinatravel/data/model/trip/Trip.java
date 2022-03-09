package com.example.vinatravel.data.model.trip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Trip {
    @SerializedName("id")
    private int id;
    @SerializedName("logo")
    private String logo;
    @SerializedName("name")
    private String name;
    @SerializedName("rate_point")
    private double ratePoint;
    @SerializedName("typename")
    private String typename;
    @SerializedName("price")
    private int price;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("start_station")
    private String startStation;
    @SerializedName("end_station")
    private String endStation;

    public Trip(int id, String logo, String name, double ratePoint, String typename, int price, String startTime, String endTime, String startStation, String endStation) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.ratePoint = ratePoint;
        this.typename = typename;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(double ratePoint) {
        this.ratePoint = ratePoint;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}
