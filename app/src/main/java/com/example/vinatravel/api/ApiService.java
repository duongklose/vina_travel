package com.example.vinatravel.api;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.user.BaseUserResponse;
import com.example.vinatravel.data.model.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

//    Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy:MM:dd HH:mm:ss")
//                .create();
//
//    ApiService apiService = new Retrofit.Builder()
//                                .baseUrl("http://localhost:5000/api/v1/")
//                                .addConverterFactory(GsonConverterFactory.create(gson))
//                                .build()
//                                .create(ApiService.class);

    @GET("users")
    Call<List<User>> getListUser();

    @GET("checkLogin")
    Call<BaseUserResponse> login(@Query("phone") String phone,
                                 @Query("pass") String pass);

    @POST("register")
    Call<BaseUserResponse> register(@Query("phone") String phone,
                                    @Query("pass") String pass,
                                    @Query("name") String name);

    @POST("updateInfo")
    Call<BaseUserResponse> updateInfo(@Query("id") int id,
                                      @Query("phone") String phone,
                                      @Query("name") String name);

    @POST("changePass")
    Call<BaseUserResponse> changePass(@Query("id") int id,
                                      @Query("pass") String pass);
}
