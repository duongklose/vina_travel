package com.example.vinatravel.ui.book_ticket.choose_seat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.seat.Seat;
import com.example.vinatravel.ui.book_ticket.SeatAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeatFragment extends Fragment{
    ArrayList<Seat> seatArrayList;
//    RecyclerView rcvSeat;
//    RecyclerView.LayoutManager layoutManager;
    TextView tvSeats, tvPrice;
    ToggleButton a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    ToggleButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ToggleButton c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    ToggleButton d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
//    SeatAdapter seatAdapter;

    public SeatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        seatArrayList = new ArrayList<>();
//        seatArrayList.add(new Seat("A1", 0));
//        seatArrayList.add(new Seat("B1", 0));
//        seatArrayList.add(new Seat("C1", 0));
//        seatArrayList.add(new Seat("A3", 0));

        View view = inflater.inflate(R.layout.item_40_seats_coach, container, false);
        initView(view);

        a1 = getActivity().findViewById(R.id.a1);
        a1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                } else {
                    a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                }
            }
        });
        eventToggleButton(view);


        return view;
    }

    public void initView(View view){
        tvSeats = getActivity().findViewById(R.id.tv_seats);
        tvPrice = getActivity().findViewById(R.id.tv_price);
//        rcvSeat = view.findViewById(R.id.rcv_40_seats);
//        layoutManager = new GridLayoutManager(getActivity(), 10);
//        rcvSeat.setLayoutManager(layoutManager);
//        seatAdapter = new SeatAdapter(seatArrayList, getActivity());
//        rcvSeat.setAdapter(seatAdapter);
//        rcvSeat.setHasFixedSize(true);

        a1 = getActivity().findViewById(R.id.a1);
        a2 = getActivity().findViewById(R.id.a2);
        a3 = getActivity().findViewById(R.id.a3);
        a4 = getActivity().findViewById(R.id.a4);
        a5 = getActivity().findViewById(R.id.a5);
        a6 = getActivity().findViewById(R.id.a6);
        a7 = getActivity().findViewById(R.id.a7);
        a8 = getActivity().findViewById(R.id.a8);
        a9 = getActivity().findViewById(R.id.a9);
        a10 = getActivity().findViewById(R.id.a10);

        b1 = getActivity().findViewById(R.id.b1);
        b2 = getActivity().findViewById(R.id.b2);
        b3 = getActivity().findViewById(R.id.b3);
        b4 = getActivity().findViewById(R.id.b4);
        b5 = getActivity().findViewById(R.id.b5);
        b6 = getActivity().findViewById(R.id.b6);
        b7 = getActivity().findViewById(R.id.b7);
        b8 = getActivity().findViewById(R.id.b8);
        b9 = getActivity().findViewById(R.id.b9);
        b10 = getActivity().findViewById(R.id.b10);

        c1 = getActivity().findViewById(R.id.c1);
        c2 = getActivity().findViewById(R.id.c2);
        c3 = getActivity().findViewById(R.id.c3);
        c4 = getActivity().findViewById(R.id.c4);
        c5 = getActivity().findViewById(R.id.c5);
        c6 = getActivity().findViewById(R.id.c6);
        c7 = getActivity().findViewById(R.id.c7);
        c8 = getActivity().findViewById(R.id.c8);
        c9 = getActivity().findViewById(R.id.c9);
        c10 = getActivity().findViewById(R.id.c10);

        d1 = getActivity().findViewById(R.id.d1);
        d2 = getActivity().findViewById(R.id.d2);
        d3 = getActivity().findViewById(R.id.d3);
        d4 = getActivity().findViewById(R.id.d4);
        d5 = getActivity().findViewById(R.id.d5);
        d6 = getActivity().findViewById(R.id.d6);
        d7 = getActivity().findViewById(R.id.d7);
        d8 = getActivity().findViewById(R.id.d8);
        d9 = getActivity().findViewById(R.id.d9);
        d10 = getActivity().findViewById(R.id.d10);
    }

    public void eventToggleButton(View view){
//        a1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked)  {
//                    a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
//                } else {
//                    a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
//                }
//            }
//        });
    }

}