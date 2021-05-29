package com.example.vinatravel.data.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseUserResponse {

    @SerializedName("code")
    @Expose
    protected String code;

    @SerializedName("data")
    @Expose
    private User userModel;

    @SerializedName("token")
    @Expose
    protected String token;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUserModel() {
        return userModel;
    }

    public void setUserModel(User userModel) {
        this.userModel = userModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
