package com.example.vinatravel.ui.home.my_account;

public class AccountPresenter implements AccountContract.Presenter{

    private AccountContract.View view;

    public AccountPresenter(AccountContract.View view) {
        this.view = view;
    }

}
