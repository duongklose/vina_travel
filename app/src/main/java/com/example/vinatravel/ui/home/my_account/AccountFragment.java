package com.example.vinatravel.ui.home.my_account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.change_password.ChangePasswordActivity;
import com.example.vinatravel.ui.edit_info_user.EditInfoUserActivity;
import com.example.vinatravel.ui.home.MainActivity;
import com.example.vinatravel.ui.login.LoginActivity;

public class AccountFragment extends Fragment implements AccountContract.View{

    private TextView tvName;
    private ImageButton imgbtnEdit;
    private ConstraintLayout ctlSettings;
    private ConstraintLayout ctlHelp;
    private ConstraintLayout ctlRate;
    private ConstraintLayout ctlLogout;
    private ConstraintLayout ctlChangePassword;
    private String name;
    private int id;
    private AccountContract.Presenter presenter;

    public AccountFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        tvName = view.findViewById(R.id.tv_name);
        imgbtnEdit = view.findViewById(R.id.imgbtn_edit);
        ctlChangePassword = view.findViewById(R.id.changePassword);
        ctlSettings = view.findViewById(R.id.settings);
        ctlHelp = view.findViewById(R.id.help);
        ctlRate = view.findViewById(R.id.rate);
        ctlLogout = view.findViewById(R.id.logout);

        SharedPreferences dataAccountStorage = getContext().getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        name = dataAccountStorage.getString("name", null);
        id = dataAccountStorage.getInt("id", 0);
        tvName.setText(name);
        initPresenter();

        ctlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        imgbtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditInfoUserActivity.class);
                startActivity(intent);
            }
        });

        ctlChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void initPresenter(){
        presenter = new AccountPresenter(this);
    }
}