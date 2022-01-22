package com.example.vinatravel.ui.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinatravel.R;
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

import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, View.OnClickListener {

    TextInputLayout tilPhone;
    TextInputLayout tilPass;
    TextInputLayout tilName, tilOtp;
    TextInputEditText editPhone;
    private AppCompatTextView txtGetOTP, textTime;
    TextInputEditText editOtp;
    Button btnRegister;
    RegisterContract.Presenter presenter;
    FirebaseAuth auth;

    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tilPhone = findViewById(R.id.til_phone_register);
        tilPass = findViewById(R.id.til_pass_register);
        tilName = findViewById(R.id.til_name_register);
        btnRegister = findViewById(R.id.register_btn);
        textTime = findViewById(R.id.text_time_zone);
        txtGetOTP = findViewById(R.id.txtGetOtp);
        editPhone = findViewById(R.id.editPhone);
        tilOtp = findViewById(R.id.til_otp);
        editOtp = findViewById(R.id.editOtp);
        initPresenter();
        txtGetOTP.setTextColor(Color.RED);


        auth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view -> {
            String otp = tilOtp.getEditText().getText().toString().trim();
            if (otp == null || otp.isEmpty() || otp.length() != 6)
                Toast.makeText(RegisterActivity.this, "OTP chưa xác thực", Toast.LENGTH_SHORT).show();
            else
                verifyCode(otp);
        });

        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("xxxxxxxxxxxxxxxxxxxxxx", charSequence.toString());
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


    public void initPresenter() {
        presenter = new RegisterPresenter(this);
    }

    @Override
    public void onClick(android.view.View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.register_btn:
//                String phone = tilPhone.getEditText().getText().toString().trim();
//                String pass = tilPass.getEditText().getText().toString().trim();
//                presenter.register(phone, pass);
//                break;
//        }
    }


    @Override
    public void redirectLogin() {
//        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Tài khoản đã tồn tại", Toast.LENGTH_LONG).show();
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String phone = tilPhone.getEditText().getText().toString().trim();
                            String pass = tilPass.getEditText().getText().toString().trim();
                            String name = tilName.getEditText().getText().toString().trim();
                            presenter.register(phone, pass, name);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

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
            Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    // below method is use to verify code from Firebase.
    private void verifyCode(String code) {
        // below line is used for getting getting
        // credentials from our verification id and code.
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        // after getting credential we are
        // calling sign in method.
        signInWithCredential(credential);
    }
}