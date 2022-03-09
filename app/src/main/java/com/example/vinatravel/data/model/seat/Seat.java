package com.example.vinatravel.data.model.seat;

import androidx.annotation.Nullable;

public class Seat {
    private int id;
    private String name;
    private int state; // có người ngồi là 1, k ai ngồi là 2

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    private int floor;

    public Seat(int id, String name, int state, int floor) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.floor = floor;
    }

    public Seat(int id, String name, int state) {
        this.id = id;
        this.name = name;
        this.state = state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
