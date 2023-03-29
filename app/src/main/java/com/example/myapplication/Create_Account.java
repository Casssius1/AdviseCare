package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Account extends AppCompatActivity {

    TextView Longin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        Longin=findViewById(R.id.login_text_view_btn);
        Longin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to_main_activity();
            }
        });


    }
    private void to_main_activity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}