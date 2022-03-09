package com.example.vinatravel.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.user.User;
import com.example.vinatravel.ui.home.MainActivity;
import com.example.vinatravel.ui.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener{

    private TextInputLayout tilPhone;
    private TextInputLayout tilOTP;
    Button btnLogin;
    TextInputEditText editPhone;
    private LoginContract.Presenter presenter;
    private AppCompatTextView txtGetOTP, textTime;
    private String verificationId;
    TextInputEditText editOtp;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilPhone = findViewById(R.id.til_phone_login);
        tilOTP = findViewById(R.id.til_pass);
        btnLogin = findViewById(R.id.login_btn);
        txtGetOTP = findViewById(R.id.txtGetOtp);
        textTime = findViewById(R.id.text_time_count);
        editPhone = findViewById(R.id.editPhoneLogin);
        editOtp = findViewById(R.id.editOTP);
        initPresenter();
        txtGetOTP.setTextColor(Color.RED);
        Log.d("AAA", "create1");

        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            String otp = tilOTP.getEditText().getText().toString().trim();
            if (otp == null || otp.isEmpty() || otp.length() != 6)
                Toast.makeText(LoginActivity.this, "OTP chưa xác thực", Toast.LENGTH_SHORT).show();
            else{
                String phone = tilPhone.getEditText().getText().toString().trim();
                Log.d("AAA", phone);
                presenter.getUserByPhone(phone);
//                verifyCode(otp);
            }
        });

        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editPhone.getText().toString().isEmpty()) {
                    txtGetOTP.setVisibility(View.INVISIBLE);
                }
                else  {
                    txtGetOTP.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtGetOTP.setOnClickListener(view -> {
            String phone = "+84" + tilPhone.getEditText().getText().toString().trim();
            sendVerificationCode(phone);
            Timer.start();
        });
//        btnLogin.setOnClickListener(view -> nextHome(new User(1,"duongnd","123456","Duong Nguyen","0123456789","duong@gmail.com","2")));
    }

    CountDownTimer Timer = new CountDownTimer(60000, 1000) {
        int time = 60;

        public void onTick(long millisUntilFinished) {
            textTime.setText(time-- + "s");
            txtGetOTP.setTextColor(Color.GRAY);
            txtGetOTP.setEnabled(false);
        }

        public void onFinish() {
            textTime.setText("Vui lòng thử lại!!!");
            txtGetOTP.setTextColor(Color.RED);
            txtGetOTP.setEnabled(true);
            time = 60;
        }
    };

    public void initPresenter(){
        presenter = new LoginPresenter(this);
    }


    @Override
    public void showPhoneError(int msgResId) {

    }

    @Override
    public void showPasswordError(int msgResId) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void nextHome(User account) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle responseData = new Bundle();
        responseData.putInt("id", account.getId());
        responseData.putString("phone", account.getPhone());
        responseData.putString("name", account.getName());
        intent.putExtras(responseData);
        startActivity(intent, responseData);
    }

        //    Hàm xác thực mã code
        private void signInWithCredential(PhoneAuthCredential credential) {
            auth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String phone = tilPhone.getEditText().getText().toString().trim();
                                Log.d("AAA", phone);
                                presenter.getUserByPhone(phone);
//                                Toast.makeText(LoginActivity.this, "Xác thực thành công!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Lỗi xác thực", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

        //    Hàm gửi code đến sđt,
        private void sendVerificationCode(String number) {
            // this method is used for getting
            // OTP on user phone number.
            PhoneAuthOptions options =
                    PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber(number)            // Phone number to verify
                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                            .setActivity(this)                 // Activity (for callback binding)
                            .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }

        private PhoneAuthProvider.OnVerificationStateChangedCallbacks
                mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId = s;
            }

            // this method is called when user
            // receive OTP from Firebase.
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                // below line is used for getting OTP code
                // which is sent in phone auth credentials.
                final String code = phoneAuthCredential.getSmsCode();

                // checking if the code
                // is null or not.
                if (code != null) {
                    // if the code is not null then
                    // we are setting that code to
                    // our OTP edittext field.
                    editOtp.setText(code);

                    // after setting this code
                    // to OTP edittext field we
                    // are calling our verifycode method.
                    verifyCode(code);
                }
            }

            // this method is called when firebase doesn't
            // sends our OTP code due to any error or issue.
            @Override
            public void onVerificationFailed(FirebaseException e) {
                // displaying error message with firebase exception.
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        // hàm xác thực
        private void verifyCode(String code) {
            // below line is used for getting getting
            // credentials from our verification id and code.
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

            // after getting credential we are
            // calling sign in method.
            signInWithCredential(credential);
        }

    @Override
    public void onClick(View view) {

    }
}