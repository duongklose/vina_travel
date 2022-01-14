package com.example.vinatravel.data.model.seat;

public class SeatResponse {
    private int id;
    private String name;
    private int state;
    private int isGone;

    public SeatResponse(int id, String name, int state, int isGone) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.isGone = isGone;
    }

    public Seat mapToSeat(){
        return new Seat(id,name,state,isGone);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsGone() {
        return isGone;
    }

    public void setIsGone(int isGone) {
        this.isGone = isGone;
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
