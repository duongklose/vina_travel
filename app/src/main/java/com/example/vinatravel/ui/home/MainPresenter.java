package com.example.vinatravel.ui.home;

public class MainPresenter implements MainContract.Presenter{

    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


}
