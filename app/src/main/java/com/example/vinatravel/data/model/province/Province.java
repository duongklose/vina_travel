package com.example.vinatravel.data.model.province;

import java.util.List;

public class Province {
    private int id;
    private String name;
    private List<Location> locationList;

    public Province(int id, String name, List<Location> locationList) {
        this.id = id;
        this.name = name;
        this.locationList = locationList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
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

    public String getNameDefaultLocation(){
        return locationList.get(0).getName();
    }
}
