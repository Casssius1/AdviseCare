package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.UserApi;
import com.example.myapplication.models.PatientSignUpReqDto;
import com.example.myapplication.models.PatientSignUpResponseDto;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Create_Account extends AppCompatActivity {
TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
         intializeComponents();


        Login=findViewById(R.id.login_text_view_btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginscreen();
            }
        });

   }
   //login method
   private void loginscreen(){
       Intent intent = new Intent(this, LoginActivity.class);
       startActivity(intent);
   }
    private void intializeComponents(){

        TextView emailInput = findViewById(R.id.email_edit_text);
        TextView passwordInput = findViewById(R.id.password_edit_text);
        TextView confirmPasswordInput = findViewById(R.id.confirm_password_edit_text);
        MaterialButton createAccount = findViewById(R.id.create_account_btn);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        createAccount.setOnClickListener(view ->{
            String emailId = String.valueOf(emailInput.getText());
            String password = String.valueOf(passwordInput.getText());
            String confirmPassword = String.valueOf(confirmPasswordInput.getText());

            PatientSignUpReqDto signUpReqDto = new PatientSignUpReqDto();
            signUpReqDto.setEmailId(emailId);
            signUpReqDto.setPassword(password);
            signUpReqDto.setConfirmPassword(confirmPassword);

            userApi.userSignup(signUpReqDto)
                    .enqueue(new Callback<Response<PatientSignUpResponseDto>>() {
                        @Override
                        public void onResponse(Call<Response<PatientSignUpResponseDto>> call, Response<Response<PatientSignUpResponseDto>> response) {
                            Intent intent = new Intent(Create_Account.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Response<PatientSignUpResponseDto>> call, Throwable t) {
                            Toast.makeText(Create_Account.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            Logger.getLogger(Create_Account.class.getName()).log(Level.SEVERE, "Error occured");

                        }
                    });
        });




    }
}