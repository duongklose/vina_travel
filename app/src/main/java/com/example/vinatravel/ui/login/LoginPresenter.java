package com.example.vinatravel.ui.login;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
import com.example.vinatravel.data.model.trip.BaseTripResponse;
import com.example.vinatravel.data.model.trip.Trip;
import com.example.vinatravel.data.model.user.BaseUserResponse;
import com.example.vinatravel.data.model.user.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private List<User> userList;
    private User mUser;
    private ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    public void getUserByPhone(String phone){
        api.getUserbyPhone(phone).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                if(response.isSuccessful()){
                    User user = response.body().getUserModel();
                    Log.d("AAA", user.getId() + "");
                    Log.d("AAA", user.getPhone());
                    view.nextHome(user);
                }
            }

            @Override
            public void onFailure(Call<BaseUserResponse> call, Throwable t) {

            }
        });
    }


    @Override
    public void handleLogin(String phone, String pass) {
        userList = new ArrayList<>();
        api.login(phone, pass).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                Log.v("AAA", "onResponseLogin");
                if (response.isSuccessful()) {
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            User user = new User(
                                    response.body().getUserModel().getId(),
                                    response.body().getUserModel().getName(),
                                    response.body().getUserModel().getPhone()
                            );
                            view.nextHome(user);
                            break;
                        case ResponseCode.USER_IS_NOT_INVALID:
                            view.showError();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseUserResponse> call, Throwable t) {
                Log.v("AAA", "onFailureLogin");
            }
        });
    }

    @Override
    public void checkInputPhoneEmail(String phoneEmail) {

    }

    @Override
    public void checkInputPassword(String password, String phone) {

    }
}
