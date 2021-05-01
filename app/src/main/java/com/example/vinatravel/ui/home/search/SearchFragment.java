package com.example.vinatravel.ui.home.search;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.example.vinatravel.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SearchFragment extends Fragment {

    AutoCompleteTextView startLocation, endLocation;
    TextView calendar;
    Button searchBtn;

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

        //dropdown menu - province
        String []province = {"Hà Nội", "TP.Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ"};
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
        builder.setTitleText("SELECT A DATE");
        final MaterialDatePicker materialDatePicker = builder.build();

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getFragmentManager(), "DATA_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                calendar.setText(materialDatePicker.getHeaderText());
            }
        });
        return view;
    }
}