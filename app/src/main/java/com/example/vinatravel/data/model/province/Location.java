package com.example.vinatravel.data.model.province;

public class Location {
    private int id;
    private int idProvince;
    private String name;
    private String address;

    public Location(int id, int idProvince, String name, String address) {
        this.id = id;
        this.idProvince = idProvince;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
