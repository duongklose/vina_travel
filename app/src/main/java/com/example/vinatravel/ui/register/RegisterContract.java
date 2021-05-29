package com.example.vinatravel.ui.register;

public interface RegisterContract {
    interface View{
        void completeRegisterForm(int idUser);
        void showError();
    }
    interface Presenter{
        void register(String phone, String pass);
    }
}
