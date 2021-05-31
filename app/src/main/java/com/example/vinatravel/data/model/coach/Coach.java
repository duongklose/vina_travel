package com.example.vinatravel.data.model.coach;

import com.example.vinatravel.data.model.transportation_company.TransportationCompany;

public class Coach {
    private int id;
    private TransportationCompany transportationCompany;
    private int numOfSeats;
    private String licensePlate;
    private String type;

    public Coach(int id, TransportationCompany transportationCompany, int numOfSeats, String licensePlate, String type) {
        this.id = id;
        this.transportationCompany = transportationCompany;
        this.numOfSeats = numOfSeats;
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransportationCompany getTransportationCompany() {
        return transportationCompany;
    }

    public void setTransportationCompany(TransportationCompany transportationCompany) {
        this.transportationCompany = transportationCompany;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
