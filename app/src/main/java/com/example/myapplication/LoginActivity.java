package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.UserApi;
import com.example.myapplication.models.UserLoginRequestDto;
import com.example.myapplication.models.UserLoginResponseDto;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUser();

       TextView forgotpassward = findViewById(R.id.forgotpassword);
        forgotpassward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to_forgotpasswardactivity();
            }
        });

    }
    private void loginUser() {

        TextView emailInput = findViewById(R.id.emailtv);
        TextView passwordInput = findViewById(R.id.passwordtv);
        MaterialButton loginBtn = findViewById(R.id.login_btn);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        loginBtn.setOnClickListener(view -> {
            String emailId = String.valueOf(emailInput.getText());
            String password = String.valueOf(passwordInput.getText());


            UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
            userLoginRequestDto.setEmailId(emailId);
            userLoginRequestDto.setPassword(password);

            userApi.userLogin(userLoginRequestDto)
                    .enqueue(new Callback<Response<UserLoginResponseDto>>() {
                        @Override
                        public void onResponse(Call<Response<UserLoginResponseDto>> call, Response<Response<UserLoginResponseDto>> response) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            System.out.println("you have login");

                        }

                        @Override
                        public void onFailure(Call<Response<UserLoginResponseDto>> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, "Error occured");
                            System.out.println("starts here");

                            System.out.println(t.getMessage());
                            System.out.println("ended here");


                        }
                    });
        });

    }

    private void to_forgotpasswardactivity () {
        Intent intent = new Intent(this, forgotPassward.class);
        startActivity(intent);
    }
}



