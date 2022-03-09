package com.example.vinatravel.data.model.seat;

public class SeatResponse {
    private int id;
    private String name;
    private int state;
    private int floor;

    public SeatResponse(int id, String name, int state, int floor) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.floor = floor;
    }

    public Seat mapToSeat(){
        return new Seat(id,name,state,floor);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public SeatResponse(int id, String name) {
        this.id = id;
        this.name = name;
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
}
