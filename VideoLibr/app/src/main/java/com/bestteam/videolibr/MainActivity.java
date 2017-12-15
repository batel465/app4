package com.bestteam.videolibr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = (Button) findViewById(R.id.btnSignIn);
        signUp = (Button) findViewById(R.id.btnSignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bSignIn = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(bSignIn);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bSignUp = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(bSignUp);
            }
        });
    }
}
