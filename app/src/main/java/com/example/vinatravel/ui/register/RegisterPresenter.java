package com.example.vinatravel.ui.register;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.user.BaseUserResponse;
import com.example.vinatravel.data.model.user.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter{

    private RegisterContract.View view;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void register(String phone, String pass, String name) {
        api.register(phone, pass, name).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                if (response.isSuccessful()) {
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            int idUser = response.body().getUserModel().getId();
                            view.redirectLogin();
                            break;
                        case ResponseCode.USER_EXISTED:
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
