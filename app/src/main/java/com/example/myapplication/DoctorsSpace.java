package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Api.UserApi;
import com.example.myapplication.models.PostRequestDto;
import com.example.myapplication.models.PostResponseDto;
import com.example.myapplication.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsSpace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_space);





    }
    private void DoctorsPost() {

        TextView editTitle = findViewById(R.id.edit_Title);
        TextView body = findViewById(R.id.edit_body);
        ImageButton upload = findViewById(R.id.upload);


        RetrofitService retrofitService = new RetrofitService();

        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

            upload.setOnClickListener(view -> {
            String edittiltle = String.valueOf(editTitle.getText());
            String Body = String.valueOf(body.getText());


            PostRequestDto postRequestDto = new PostRequestDto();

                postRequestDto.setTitle(edittiltle);
                postRequestDto.setBody(Body);

            ;

            userApi.createPost(postRequestDto)
                    .enqueue(new Callback<Response<PostResponseDto>>() {
                        @Override
                        public void onResponse(Call<Response<PostResponseDto>> call, Response<Response<PostResponseDto>> response) {
                            Toast.makeText(DoctorsSpace.this, "post created" , Toast.LENGTH_SHORT).show();
                            Response<PostResponseDto> postResponseDto = response.body();
                            System.out.println("you have posted");

                        }

                        @Override
                        public void onFailure(Call<Response<PostResponseDto>> call, Throwable t) {
                            Toast.makeText(DoctorsSpace.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            Logger.getLogger(DoctorsSpace.class.getName()).log(Level.SEVERE, "Error occured");
                            System.out.println("starts here");

                            System.out.println(t.getMessage());
                            System.out.println("ended here");


                        }
                    });
        });

    }
    }
