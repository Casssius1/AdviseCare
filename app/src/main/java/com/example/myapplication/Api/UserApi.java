package com.example.myapplication.Api;

import com.example.myapplication.models.PatientSignUpReqDto;
import com.example.myapplication.models.PatientSignUpResponseDto;
import com.example.myapplication.models.PostRequestDto;
import com.example.myapplication.models.PostResponseDto;
import com.example.myapplication.models.UserLoginRequestDto;
import com.example.myapplication.models.UserLoginResponseDto;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    @POST("/Doctor/post/create")
    Call<Response<PostResponseDto>> createPost(@Body PostRequestDto postRequestDto);
    @GET("/user/forgot_password")
    Call<Response<String>> userForgotPassword(@Query("emailId") String EmailId);
    @POST("/user/login")
    Call<Response<UserLoginResponseDto>> userLogin(@Body UserLoginRequestDto userLoginReqDto);

    @POST("/patient/signup")
    Call<Response<PatientSignUpResponseDto>> userSignup(@Body PatientSignUpReqDto patientSignUpReqDto);
}