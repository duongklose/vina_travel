package com.example.vinatravel.ui.book_ticket.choose_seat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.seat.Seat;
import com.example.vinatravel.data.model.seat.SeatResponse;
import com.example.vinatravel.ui.book_ticket.choose_departure_location.ChooseDepartureLocation;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class ChooseSeatActivity extends Activity implements ChooseSeatContract.View {
    MaterialToolbar toolbar;
    Button btnContinue;
    TextView tvSeat, tvPrice;
    ChooseSeatContract.Presenter presenter;
    ToggleButton a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    ToggleButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ToggleButton c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    ToggleButton d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
    String chosenSeat;
    int cost, price, idTrip;
    List<Seat> seats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_seat_screen);
        chosenSeat="";
        cost = 0;
        seats = new ArrayList<>();
        tvSeat = findViewById(R.id.tv_seats);
        tvPrice = findViewById(R.id.tv_price);
        toolbar = findViewById(R.id.topAppBarChooseSeat);
        btnContinue = findViewById(R.id.continue_btn);
        initToggleButton();
        toolbar.setTitle("Chọn ghế");

        Intent intent = getIntent();
        idTrip = intent.getIntExtra("idTrip", 0);
        price = intent.getIntExtra("price", 0);
        initPresenter();
        presenter.getBookedSeats(idTrip);

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new SeatFragment()).addToBackStack(null).commit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cost>0){
                    int []listIdChosenSeat = new int[40];
                    int i=0;
                    String temp = chosenSeat;
                    while (!temp.equals("")){
                        String s1 = temp.substring(0,2);
                        for (int j = 0; j<seats.size();j++){
                            if(seats.get(j).getName().equals(s1)){
                                listIdChosenSeat[i] = seats.get(j).getId();
                                i++;
                                break;
                            }
                        }
                        temp = temp.substring(3);
                    }
                    Intent intent1 = new Intent(getApplicationContext(), ChooseDepartureLocation.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idTrip", idTrip);
                    bundle.putInt("price", cost);
                    bundle.putIntArray("arrayIdChosenSeats", listIdChosenSeat);
                    intent1.putExtras(bundle);
                    startActivity(intent1, bundle);
                }else{
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn chỗ", Toast.LENGTH_LONG);
                }

            }
        });
    }


    private void initPresenter(){
        presenter = new ChooseSeatPresenter(this);
    }

    @Override
    public void sendBookedSeats(ArrayList<SeatResponse> seatResponses, int size) {
        initDefaultSeats();
        for (int i = 0;i<size;i++){
            seats.get(seatResponses.get(i).getId()-1).setState(0);
        }
        eventToggleButton();
    }
    private void initDefaultSeats(){
        seats.add(new Seat(1,"A1", 1));
        seats.add(new Seat(2,"A2", 1));
        seats.add(new Seat(3,"A3", 1));
        seats.add(new Seat(4,"A4", 1));
        seats.add(new Seat(5,"A5", 1));
        seats.add(new Seat(6,"A6", 1));
        seats.add(new Seat(7,"A7", 1));
        seats.add(new Seat(8,"A8", 1));
        seats.add(new Seat(9,"A9", 1));
        seats.add(new Seat(10,"A10", 1));
        seats.add(new Seat(11,"B1", 1));
        seats.add(new Seat(12,"B2", 1));
        seats.add(new Seat(13,"B3", 1));
        seats.add(new Seat(14,"B4", 1));
        seats.add(new Seat(15,"B5", 1));
        seats.add(new Seat(16,"B6", 1));
        seats.add(new Seat(17,"B7", 1));
        seats.add(new Seat(18,"B8", 1));
        seats.add(new Seat(19,"B9", 1));
        seats.add(new Seat(20,"B10", 1));
        seats.add(new Seat(21,"C1", 1));
        seats.add(new Seat(22,"C2", 1));
        seats.add(new Seat(23,"C3", 1));
        seats.add(new Seat(24,"C4", 1));
        seats.add(new Seat(25,"C5", 1));
        seats.add(new Seat(26,"C6", 1));
        seats.add(new Seat(27,"C7", 1));
        seats.add(new Seat(28,"C8", 1));
        seats.add(new Seat(29,"C9", 1));
        seats.add(new Seat(30,"C10", 1));
        seats.add(new Seat(31,"D1", 1));
        seats.add(new Seat(32,"D2", 1));
        seats.add(new Seat(33,"D3", 1));
        seats.add(new Seat(34,"D4", 1));
        seats.add(new Seat(35,"D5", 1));
        seats.add(new Seat(36,"D6", 1));
        seats.add(new Seat(37,"D7", 1));
        seats.add(new Seat(38,"D8", 1));
        seats.add(new Seat(39,"D9", 1));
        seats.add(new Seat(40,"D10", 1));
    }

    private void initToggleButton(){
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);

        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);
        d9 = findViewById(R.id.d9);
        d10 = findViewById(R.id.d10);
    }

    private void eventToggleButton(){
        if(seats.get(0).getState() == 1) {
            a1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A1 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A1 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a1.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(1).getState() == 1) {
            a2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A2 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A2 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a2.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(2).getState() == 1) {
            a3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A3 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A3 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a3.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(3).getState() == 1) {
            a4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A4 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A4 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a4.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(4).getState() == 1) {
            a5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A5 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A5 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a5.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(5).getState() == 1) {
            a6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A6 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A6 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a6.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(6).getState() == 1) {
            a7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A7 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A7 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a7.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(7).getState() == 1) {
            a8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A8 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A8 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a8.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(8).getState() == 1) {
            a9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a9.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A9 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a9.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A9 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a9.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(9).getState() == 1) {
            a10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        a10.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "A10 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        a10.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("A10 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            a10.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }

        if(seats.get(10).getState() == 1) {
            b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B1 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B1 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b1.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(11).getState() == 1) {
            b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B2 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B2 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b2.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(12).getState() == 1) {
            b3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B3 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B3 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b3.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(13).getState() == 1) {
            b4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B4 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B4 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b4.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(14).getState() == 1) {
            b5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B5 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B5 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b5.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(15).getState() == 1) {
            b6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B6 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B6 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b6.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(16).getState() == 1) {
            b7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B7 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B7 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b7.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(17).getState() == 1) {
            b8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B8 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B8 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b8.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(18).getState() == 1) {
            b9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b9.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B9 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b9.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B9 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b9.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(19).getState() == 1) {
            b10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        b10.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "B10 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        b10.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("B10 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            b10.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }

        if(seats.get(20).getState() == 1) {
            c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C1 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C1 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c1.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(21).getState() == 1) {
            c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C2 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C2 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c2.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(22).getState() == 1) {
            c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C3 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C3 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c3.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(23).getState() == 1) {
            c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C4 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C4 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c4.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(24).getState() == 1) {
            c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C5 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C5 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c5.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(25).getState() == 1) {
            c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C6 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C6 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c6.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(26).getState() == 1) {
            c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C7 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C7 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c7.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(27).getState() == 1) {
            c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C8 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C8 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c8.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(28).getState() == 1) {
            c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c9.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C9 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c9.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C9 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c9.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(29).getState() == 1) {
            c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        c10.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "C10 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        c10.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("C10 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            c10.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }

        if(seats.get(30).getState() == 1) {
            d1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D1 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D1 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d1.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(31).getState() == 1) {
            d2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D2 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D2 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d2.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(32).getState() == 1) {
            d3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D3 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D3 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d3.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(33).getState() == 1) {
            d4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D4 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D4 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d4.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(34).getState() == 1) {
            d5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D5 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D5 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d5.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(35).getState() == 1) {
            d6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D6 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D6 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d6.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(36).getState() == 1) {
            d7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D7 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D7 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d7.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(37).getState() == 1) {
            d8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D8 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D8 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d8.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(38).getState() == 1) {
            d9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d9.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D9 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d9.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D9 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d9.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
        if(seats.get(39).getState() == 1) {
            d10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        d10.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked_toggle_button));
                        chosenSeat = chosenSeat + "D10 ";
                        tvSeat.setText(chosenSeat);
                        cost += price;
                        tvPrice.setText(String.valueOf(cost));
                    } else {
                        d10.setBackgroundDrawable(getResources().getDrawable(R.drawable.uncheck_toggle_button));
                        chosenSeat = chosenSeat.replace("D10 ", "");
                        tvSeat.setText(chosenSeat);
                        cost -= price;
                        tvPrice.setText(String.valueOf(cost));
                    }
                }
            });
        }else{
            d10.setBackgroundDrawable(getResources().getDrawable(R.drawable.disable_toggle_button));
        }
    }

}