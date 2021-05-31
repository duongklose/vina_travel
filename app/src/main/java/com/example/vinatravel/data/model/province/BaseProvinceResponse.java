package com.example.vinatravel.data.model.province;

import com.example.vinatravel.data.model.user.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseProvinceResponse {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private List<Province> provinceList;

}
