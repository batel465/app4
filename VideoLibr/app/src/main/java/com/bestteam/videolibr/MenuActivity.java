package com.bestteam.videolibr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity
{
    private Button readMe, userDetails, map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        readMe = findViewById(R.id.btnReadMe);
        userDetails = findViewById(R.id.btnUserDetails);
        map = findViewById(R.id.btnMap);

        readMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bReadMe = new Intent(MenuActivity.this,ReadMeActivity.class);
                startActivity(bReadMe);
            }
        });

        userDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bUdetails = new Intent(MenuActivity.this,UserDetailsActivity.class);
                startActivity(bUdetails);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bMap = new Intent(MenuActivity.this,MapsActivity.class);
                startActivity(bMap);
            }
        });
    }
}
