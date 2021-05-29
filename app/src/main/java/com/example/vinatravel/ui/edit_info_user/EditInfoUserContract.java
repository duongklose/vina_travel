package com.example.vinatravel.ui.edit_info_user;

public interface EditInfoUserContract {
    interface View{

        void redirectLogin();

        void showError();

        void updateSuccess();
    }

    interface Presenter{

        void updateInfo(int idUser, String newPhone, String newName);
    }
}
