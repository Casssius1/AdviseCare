package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class chat extends AppCompatActivity {
    Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        button = findViewById(R.id.button_send);
        //final EditText editText_mobile = findViewById(R.id.edit_mobile_no);
        final EditText editText_msg = findViewById(R.id.edit_message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //So you can get the edittext value
                //String mobileNumber = editText_mobile.getText().toString();
                String message = editText_msg.getText().toString();
                boolean installed = appInstalledOrNot("com.whatsapp");
                if (installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"256757373832"+ "&text="+message));
                    startActivity(intent);
                }else {
                    Toast.makeText(chat.this, "Whats app not installed on your device", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Create method appInstalledOrNot
    private boolean appInstalledOrNot(String url){
        PackageManager packageManager =getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}
