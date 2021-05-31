package com.example.vinatravel.data.model.trip;

import com.example.vinatravel.data.model.user.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseTripResponse {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private List<Trip> data = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Trip> getData() {
        return data;
    }

    public void setData(List<Trip> data) {
        this.data = data;
    }
}
