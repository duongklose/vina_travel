package com.example.vinatravel.api;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.BaseResponse;
import com.example.vinatravel.data.model.location.BaseLocationResponse;
import com.example.vinatravel.data.model.province.BaseProvinceResponse;
import com.example.vinatravel.data.model.seat.BaseSeatResponse;
import com.example.vinatravel.data.model.ticket.BaseTicketResponse;
import com.example.vinatravel.data.model.trip.BaseTripResponse;
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

    @GET("listProvince")
    Call<BaseProvinceResponse> listProvince();

    @GET("user/getTrips")
    Call<BaseTripResponse> listTrip(@Query("idStartProvince") int startProvince,
                                    @Query("idEndProvince") int endProvince,
                                    @Query("time") String time);

    @GET("/user/getBookedSeats")
    Call<BaseSeatResponse> getBookedSeats(@Query("idTrip") int idTrip);

    @GET("/user/getUserByPhone")
    Call<BaseUserResponse> getUserbyPhone(@Query("phone") String phone);

    @GET("getLocation")
    Call<BaseLocationResponse> getLocationByName(@Query("location") String location);

    @POST("user/addNewTicket")
    Call<BaseResponse> addTicket(@Query("idTrip") int idTrip,
                                 @Query("idUser") int idIUser,
                                 @Query("bookedDate") String bookedDate,
                                 @Query("idSeat") int idSeat,
                                 @Query("detailStartLocation") String detailStartLocation,
                                 @Query("detailEndLocation") String detailEndLocation);

    @POST("completeBookTicket")
    Call<BaseResponse> completeBookTicket(@Query("idSeat") int idSeat,
                                          @Query("idTrip") int idTrip,
                                          @Query("idTicket") int idTicket);

    @GET("user/getMyTicket")
    Call<BaseTicketResponse> getMyTicket(@Query("idUser") int idUser);

    @GET("user/getOldTicket")
    Call<BaseTicketResponse> getOldTicket(@Query("idUser") int idUser);

    @GET("getCancelledTicket")
    Call<BaseTicketResponse> getCancelledTicket(@Query("idUser") int idUser);

    @GET("getSeatsByTicket")
    Call<BaseSeatResponse> getSeatsByTicket(@Query("idTicket") int idTicket);

    @POST("user/cancelTicket")
    Call<BaseResponse> cancelTicket(@Query("idTicket") int idTicket);
}
