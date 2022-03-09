package com.example.vinatravel.ui.home.search;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.book_ticket.choose_coach.ChooseCoachActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SearchFragment extends Fragment implements SearchContract.View{

    AutoCompleteTextView startLocation, endLocation;
    TextView calendar;
    Button searchBtn;
    SearchContract.Presenter presenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        startLocation = view.findViewById(R.id.startLocation);
        endLocation = view.findViewById(R.id.endLocation);
        calendar = view.findViewById(R.id.calendar);
        searchBtn = view.findViewById(R.id.search_btn);
        initPresenter();

        //dropdown menu - province
//        presenter.getListProvince();
        String []province = getResources().getStringArray(R.array.list_province);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.province_item, province);

        //make default value
        startLocation.setText(arrayAdapter.getItem(0).toString(), false);
        endLocation.setText(arrayAdapter.getItem(1).toString(), false);

        startLocation.setAdapter(arrayAdapter);
        endLocation.setAdapter(arrayAdapter);

        //set calendar
        String dateNow = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        calendar.setText(dateNow);

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Chọn ngày");
        final MaterialDatePicker materialDatePicker = builder.build();

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getFragmentManager(), "DATA_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                cal.setTimeInMillis(selection);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                calendar.setText(format.format(cal.getTime()));
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ChooseCoachActivity.class);
                Bundle bundle = new Bundle();
                int idStartLocation=0, idEndLocation=0;
                for(int i=0;i<province.length; i++){
                    if(startLocation.getText().toString().equals(province[i])){
                        idStartLocation = i+1;
                    }
                    if(endLocation.getText().toString().equals(province[i])){
                        idEndLocation = i+1;
                    }
                }
                bundle.putString("startLocation", startLocation.getText().toString());
                bundle.putString("endLocation", endLocation.getText().toString());
                bundle.putInt("idStartLocation", idStartLocation);
                bundle.putInt("idEndLocation", idEndLocation);
                bundle.putString("date",calendar.getText().toString());

                intent.putExtra("info", bundle);
                startActivity(intent, bundle);
            }
        });
        return view;
    }
    private void initPresenter(){
        presenter = new SearchPresenter(this);
    }

}