package com.example.vinatravel.ui.change_password;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.user.BaseUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordPresenter implements ChangePasswordContract.Presenter{

    private ChangePasswordContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public ChangePasswordPresenter(ChangePasswordContract.View view) {
        this.view = view;
    }

    @Override
    public void changePass(int id, String pass) {
        api.changePass(id, pass).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                if (response.isSuccessful()) {
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            view.redirectLogin();
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
