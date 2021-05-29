package com.example.vinatravel.ui.home;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.vinatravel.R;
import com.example.vinatravel.ui.home.manage_ticket.TicketFragment;
import com.example.vinatravel.ui.home.my_account.AccountFragment;
import com.example.vinatravel.ui.home.notification.NotificationFragment;
import com.example.vinatravel.ui.home.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements MainContract.View{
    ActionBar toolbar;
    private MainContract.Presenter presenter;
    private SharedPreferences dataAccountStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        toolbar = getSupportActionBar();
        dataAccountStorage = getSharedPreferences("ACCOUNT_STORAGE", Context.MODE_PRIVATE);
        initPresenter();
        receiveData();

//        Load fragment mặc định
        loadFragment(new SearchFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new SearchFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_manage_ticket:
                    fragment = new TicketFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notification:
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void initPresenter(){
        presenter = new MainPresenter(this);
    }

    private void receiveData(){
        Bundle receive = getIntent().getExtras();
        if (receive != null) {
            String id = receive.getString("id");
            String phone = receive.getString("phone");
            String name = receive.getString("name");
            dataAccountStorage.edit().putString("phone", phone).apply();
            dataAccountStorage.edit().putString("id", id).apply();
            dataAccountStorage.edit().putString("name", name).apply();
//            presenter.getInfo(token, id);
        }
    }
}