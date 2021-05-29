package com.example.vinatravel.ui.register;

public interface RegisterContract {
    interface View{
        void redirectLogin();
        void showError();
    }
    interface Presenter{
        void register(String phone, String pass, String name);
    }
}
