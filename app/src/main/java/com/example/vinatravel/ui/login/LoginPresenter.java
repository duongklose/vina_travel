package com.example.vinatravel.ui.login;

import android.util.Log;
import android.widget.Toast;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.ResponseCode;
import com.example.vinatravel.api.RetrofitClient;
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



    @Override
    public void handleLogin(String phone, String pass) {
        Log.v("AAA", "handleLogin");
        userList = new ArrayList<>();
//        getListUser(phone, password);
        api.login(phone, pass).enqueue(new Callback<BaseUserResponse>() {
            @Override
            public void onResponse(Call<BaseUserResponse> call, Response<BaseUserResponse> response) {
                Log.v("AAA", "onResponse");
                if (response.isSuccessful()) {
                    Log.v("AAA", String.valueOf(response.body()));
                Log.v("AAA", "response success");
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            Log.v("AAA", "OK");
                            User user = new User(
                                    response.body().getUserModel().getId(),
                                    response.body().getUserModel().getUsername(),
                                    response.body().getUserModel().getPass(),
                                    response.body().getUserModel().getName(),
                                    response.body().getUserModel().getPhone(),
                                    response.body().getUserModel().getEmail(),
                                    response.body().getUserModel().getRole()
                            );
//                            callback.onSuccess(account);
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
                Log.v("AAA", "onFailure");
            }
        });
    }

    @Override
    public void checkInputPhoneEmail(String phoneEmail) {

    }

    @Override
    public void checkInputPassword(String password, String phone) {

    }

    private void getListUser(String phone, String password){
        Log.d("AAA", "get list");
       api.getListUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
                Log.d("AAA", "list  " + userList.size());
                checkLogin(phone, password);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("AAA", "get list fail");
            }
        });
    }
    private void checkLogin(String phone, String password){
        Log.d("AAA", "checkLogin");
        Log.d("AAA", "phone " + phone);
        Log.d("AAA", "pass " + password);
        if(userList == null || userList.isEmpty()){
            Log.d("AAA", "null or empty");
            return;
        }
        boolean result = false;
        for (User u: userList){
            if(phone.equals(u.getPhone()) && password.equals(u.getPass())){
                result = true;
                mUser = u;
                break;
            }
        }
        if(result){
            Log.d("AAA", "success");
            view.nextHome(mUser);
        }else{
            Log.d("AAA", "fail");
//            Toast.makeText( v, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();
        }
    }
}
