package com.example.vinatravel.data.model.seat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseSeatResponse {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private List<SeatResponse> data;

    public BaseSeatResponse(String code, List<SeatResponse> data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SeatResponse> getData() {
        return data;
    }

    public void setData(List<SeatResponse> data) {
        this.data = data;
    }
}
