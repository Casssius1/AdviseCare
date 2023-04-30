package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.UserApi;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forgotPassward extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passward);
        forgotPassword();


    }

    private void forgotPassword() {

        TextView emailInput = findViewById(R.id.emailidforgot);
        MaterialButton resetBtn = findViewById(R.id.ResetPasswordBtn);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);


        resetBtn.setOnClickListener(view -> {
            String emailId = String.valueOf(emailInput.getText());

            userApi.userForgotPassword(emailId)
                    .enqueue(new Callback<Response<String>>() {
                        @Override
                        public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
                            Toast.makeText(forgotPassward.this, response.body().message(), Toast.LENGTH_SHORT).show();

                            System.out.println(response.message());
                            System.out.println("you have RESETEDpassword");


                        }

                        @Override
                        public void onFailure(Call<Response<String>> call, Throwable t) {
                            Toast.makeText(forgotPassward.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            Logger.getLogger(forgotPassward.class.getName()).log(Level.SEVERE, "Error occured");

                            System.out.println(t.getMessage());
                            System.out.println("ended here");


                        }
                    });
        });

    }
}