package com.example.vinatravel.ui.edit_info_user;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.user.BaseUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditInfoUserPresenter implements EditInfoUserContract.Presenter{

    private EditInfoUserContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);


    public EditInfoUserPresenter(EditInfoUserContract.View view) {
        this.view = view;
    }

    public void updateInfo(int idUser, String phone, String name){
        api.updateInfo(idUser, phone, name).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                if (response.isSuccessful()) {
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            int idUser = response.body().getUserModel().getId();
                            view.redirectLogin();
//                            view.updateSuccess();
                            break;
                        case ResponseCode.UNKNOWN_ERROR:
                            view.showError();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseUserResponse> call, Throwable t) {

            }
        });
    }
}
