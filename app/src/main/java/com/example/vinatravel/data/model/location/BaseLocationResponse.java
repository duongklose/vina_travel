package com.example.vinatravel.data.model.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseLocationResponse {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("data")
    @Expose
    private List<Location> data;

    public BaseLocationResponse(String code, List<Location> data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Location> getData() {
        return data;
    }

    public void setData(List<Location> data) {
        this.data = data;
    }
}
