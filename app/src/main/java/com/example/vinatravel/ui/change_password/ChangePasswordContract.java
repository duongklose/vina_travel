package com.example.vinatravel.ui.change_password;

public interface ChangePasswordContract {
    interface View{
        void redirectLogin();
        void showError();
    }

    interface Presenter{
        void changePass(int id, String pass);
    }
}
