package com.example.vinatravel.ui.book_ticket.choose_seat;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.seat.BaseSeatResponse;
import com.example.vinatravel.data.model.seat.Seat;
import com.example.vinatravel.data.model.seat.SeatResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseSeatPresenter implements ChooseSeatContract.Presenter {
    private static final String TAG = "ChooseSeatPresenter";

    private List<Seat> seats = new ArrayList<>();
    private List<Seat> seats1 = new ArrayList<>();
    private List<Seat> seats2 = new ArrayList<>();


    private ChooseSeatContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public ChooseSeatPresenter(ChooseSeatContract.View view) {
        this.view = view;
    }

    public void getBookedSeats(int idTrip) {
        api.getBookedSeats(idTrip).enqueue(new Callback<BaseSeatResponse>() {
            @Override
            public void onResponse(Call<BaseSeatResponse> call, Response<BaseSeatResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("1000")) {
                        int size = response.body().getData().size();
                        ArrayList<SeatResponse> seatResponses = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            seatResponses.add(response.body().getData().get(i));
                        }
                        view.sendBookedSeats(seatResponses, size);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseSeatResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getSeats(int idTrip) {
//        nên lấy hết các ghế và trạng thái ghế
//        seats.add(new Seat(1,"A1", 2, 1));
//        seats.add(new Seat(2,"A", 0, 1));
//        seats.add(new Seat(3,"B1", 2, 1));
//        seats.add(new Seat(4,"A", 0));
//        seats.add(new Seat(5,"C1", 1));
//        seats.add(new Seat(6,"A3", 1));
//        seats.add(new Seat(7,"A", 0));
//        seats.add(new Seat(8,"B3", 1));
//        seats.add(new Seat(9,"A", 0));
//        seats.add(new Seat(10,"C3", 1));
//        seats.add(new Seat(11,"A5", 1));
//        seats.add(new Seat(12,"A", 0));
//        seats.add(new Seat(13,"B5", 2));
//        seats.add(new Seat(14,"A", 0));
//        seats.add(new Seat(15,"C5", 1));
//        seats.add(new Seat(16,"A7", 1));
//        seats.add(new Seat(17,"A", 0));
//        seats.add(new Seat(18,"B7", 1));
//        seats.add(new Seat(19,"A", 0));
//        seats.add(new Seat(20,"C7", 1));
//        seats.add(new Seat(21,"A9", 1));
//        seats.add(new Seat(22,"A", 0));
//        seats.add(new Seat(23,"B9", 1));
//        seats.add(new Seat(24,"A", 0));
//        seats.add(new Seat(25,"C9", 1));
//        seats.add(new Seat(26,"D1", 1));
//        seats.add(new Seat(27,"D3", 1));
//        seats.add(new Seat(28,"D5", 1));
//        seats.add(new Seat(29,"D7", 1));
//        seats.add(new Seat(30,"D9", 1));
//        seats.add(new Seat(66,"A", 0));
//        seats.add(new Seat(67,"A", 0));
//        seats.add(new Seat(68,"A", 0));
//        seats.add(new Seat(69,"A", 0));
//        seats.add(new Seat(70,"A", 0, 1));
//
//        seats2.add(new Seat(31,"A2", 2,2));
//        seats2.add(new Seat(32,"A", 0,2));
//        seats2.add(new Seat(33,"B2", 1,2));
//        seats2.add(new Seat(34,"A", 0,2));
//        seats2.add(new Seat(35,"C2", 2,2));
//        seats2.add(new Seat(36,"A4", 1,2));
//        seats2.add(new Seat(37,"A", 0,2));
//        seats2.add(new Seat(38,"B4", 1,2));
//        seats2.add(new Seat(39,"A", 0,2));
//        seats2.add(new Seat(40,"C4", 1,2));
//        seats2.add(new Seat(41,"A6", 1,2));
//        seats2.add(new Seat(42,"A", 0,2));
//        seats2.add(new Seat(43,"B6", 1,2));
//        seats2.add(new Seat(44,"A", 0,2));
//        seats2.add(new Seat(45,"C6", 1,2));
//        seats2.add(new Seat(46,"A8", 1,2));
//        seats2.add(new Seat(47,"A", 0,2));
//        seats2.add(new Seat(48,"B8", 1,2));
//        seats2.add(new Seat(49,"A", 0,2));
//        seats2.add(new Seat(50,"C8", 1,2));
//        seats2.add(new Seat(51,"A10", 1,2));
//        seats2.add(new Seat(52,"A", 0,2));
//        seats2.add(new Seat(53,"B10", 1,2));
//        seats2.add(new Seat(54,"A", 0,2));
//        seats2.add(new Seat(55,"C10", 1,2));
//        seats2.add(new Seat(56,"D2", 1,2));
//        seats2.add(new Seat(57,"D4", 1,2));
//        seats2.add(new Seat(58,"D6", 1,2));
//        seats2.add(new Seat(59,"D8", 1,2));
//        seats2.add(new Seat(60,"D10", 1,2));
//        seats2.add(new Seat(61,"A", 0,2));
//        seats2.add(new Seat(62,"A", 0,2));
//        seats2.add(new Seat(63,"A", 0,2));
//        seats2.add(new Seat(64,"A", 0,2));
//        seats2.add(new Seat(65,"A", 0,2));
//
//        view.sendSeats(seats,seats2,seats2.isEmpty());
        api.getBookedSeats(idTrip).enqueue(new Callback<BaseSeatResponse>() {
            @Override
            public void onResponse(Call<BaseSeatResponse> call, Response<BaseSeatResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("1000")) {
                        seats.clear();
                        seats1.clear();
                        seats2.clear();
                        int size = response.body().getData().size();
                        for (int i = 0; i < size; i++) {
                            Seat seat=  response.body().getData().get(i).mapToSeat();
                            if (seat.getFloor() == 2) seats2.add(seat);
                            else seats1.add(seat);
                        }
                        view.sendSeats(seats1,seats2,seats2.isEmpty());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseSeatResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });
    }

    @Override
    public boolean isOneFloor(int idTrip) {
        if(seats.isEmpty()) getSeats(idTrip);
        for (int i=0;i< seats.size(); i++){
            if (seats.get(i).getFloor() == 2) {
                return false;
            }
        }
        return true;
    }
}
