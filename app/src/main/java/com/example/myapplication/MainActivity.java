package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ImageButton call;
ImageView breastcancer;
ImageView prostatecancer;
ImageView relief;
ImageView chat;
ImageButton upload;
ImageButton menuBtn;
ImageButton moreBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // menu
        menuBtn = findViewById(R.id.menu_btn);
        menuBtn.setOnClickListener((v)-> showMenu());
        //morebtn
        moreBtn = findViewById(R.id.more_btn);
        moreBtn.setOnClickListener((v)-> showMore());

        // calling relief screen method
        relief=findViewById(R.id.reliefbtn);
        relief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reliefcreen();
            }
        });

        // calling chat screen method
        chat=findViewById(R.id.chatbtn);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatscreen();
            }
        });
        // calling prostatecancer screen method
        prostatecancer=findViewById(R.id.prostatecancerbtn);
        prostatecancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prostatecancerscreen();
            }
        });


        // calling breastcancer screen method method
        breastcancer=findViewById(R.id.breastcancerbtn);
        breastcancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breastcancerscreen();
            }
        });
        // upload screeen
        // calling upload screen method method
        upload=findViewById(R.id.uploadbtn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadscreen();
            }
        });
        // calling phone call method
        call=findViewById(R.id.contact_us);
        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phonecall();
            }
        });
    }


    // method to relief mind
    private void reliefcreen(){
        Intent intent = new Intent(this,Relief.class);
        startActivity(intent);
    }
    // method to take you to chart view
    private void chatscreen(){
        Intent intent = new Intent(this,chat.class);
        startActivity(intent);
    }

    // method to take you to breast cancer screen
    private void breastcancerscreen(){
        Intent intent = new Intent(this,breastCancerActivity.class);
        startActivity(intent);
    }
    // method to take you to breast cancer screen
    private void prostatecancerscreen(){
        Intent intent = new Intent(this,prostateCancerActivity.class);
        startActivity(intent);
    }

    //method to take you to make a phone call
    private void phonecall(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0757373832"));
        startActivity(intent);
    }
    private void uploadscreen(){
        Intent intent = new Intent(this,DoctorsSpace.class);
        startActivity(intent);
    }
    // menu
    void showMenu(){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,menuBtn);
        popupMenu.getMenu().add("About");
        popupMenu.getMenu().add("settings");


        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle() == "settings") {
                    startActivity(new Intent(MainActivity.this,Settings.class));
                    return true;

                }
                if (menuItem.getTitle() == "About") {
                    startActivity(new Intent(MainActivity.this, About.class));
                    return true;
                }
                return false;
            }

        });

    }
    // more
    void showMore(){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,moreBtn);
        popupMenu.getMenu().add("About");
        popupMenu.getMenu().add("settings");


        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle() == "settings") {
                    startActivity(new Intent(MainActivity.this,Settings.class));
                    return true;

                }
                if (menuItem.getTitle() == "About") {
                    startActivity(new Intent(MainActivity.this, About.class));
                    return true;
                }
                return false;
            }

        });

    }
}









