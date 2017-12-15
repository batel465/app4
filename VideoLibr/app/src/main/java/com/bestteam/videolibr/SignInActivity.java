package com.bestteam.videolibr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity
{
    private EditText uName, Pass;
    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        uName = findViewById(R.id.txtUserName);
        Pass = findViewById(R.id.txtPass);
        signInBtn = findViewById(R.id.btnSignIn2);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(/*(uName.getText().toString().equals(adminUser.getUserName()) &&
                        Pass.getText().toString().equals(adminUser.getPassWord()))
                        ||*/ usersVector.checkAndgetCurrentIndx(new User(uName.getText().toString(),Pass.getText().toString(),0)))
                {
                    Toast.makeText(SignInActivity.this,"You are In!", Toast.LENGTH_SHORT).show();

                    Intent bMenu = new Intent(SignInActivity.this,MenuActivity.class);
                    startActivity(bMenu);
                    finish();
                }
                else
                {
                    Toast.makeText(SignInActivity.this,"Wrong user/pass, please try again!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
