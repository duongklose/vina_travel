package com.example.vinatravel.data.model.ticket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticket implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nameTransportationCompany")
    @Expose
    private String nameTransportationCompany;
    @SerializedName("licensePlate")
    @Expose
    private String licensePlate;
    @SerializedName("book_date")
    @Expose
    private String bookDate;
    @SerializedName("defaultStartLocation")
    @Expose
    private String defaultStartLocation;
    @SerializedName("defaultEndLocation")
    @Expose
    private String defaultEndLocation;
    @SerializedName("startLocation")
    @Expose
    private String startLocation;
    @SerializedName("endLocation")
    @Expose
    private String endLocation;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("d")
    @Expose
    private String date;
    @SerializedName("price")
    @Expose
    private int price;

    public Ticket(int id, String nameTransportationCompany, String licensePlate, String bookDate, String defaultStartLocation, String defaultEndLocation, String startLocation, String endLocation, String startTime, String endTime, String date, int price) {
        this.id = id;
        this.nameTransportationCompany = nameTransportationCompany;
        this.licensePlate = licensePlate;
        this.bookDate = bookDate;
        this.defaultStartLocation = defaultStartLocation;
        this.defaultEndLocation = defaultEndLocation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTransportationCompany() {
        return nameTransportationCompany;
    }

    public void setNameTransportationCompany(String nameTransportationCompany) {
        this.nameTransportationCompany = nameTransportationCompany;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDefaultStartLocation() {
        return defaultStartLocation;
    }

    public void setDefaultStartLocation(String defaultStartLocation) {
        this.defaultStartLocation = defaultStartLocation;
    }

    public String getDefaultEndLocation() {
        return defaultEndLocation;
    }

    public void setDefaultEndLocation(String defaultEndLocation) {
        this.defaultEndLocation = defaultEndLocation;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
