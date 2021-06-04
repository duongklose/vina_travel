package com.example.vinatravel.data.model.ticket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseTicketResponse {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private List<Ticket> data;

    public BaseTicketResponse(String code, List<Ticket> data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Ticket> getData() {
        return data;
    }

    public void setData(List<Ticket> data) {
        this.data = data;
    }
}
