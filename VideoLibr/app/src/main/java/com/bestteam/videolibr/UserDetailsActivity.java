package com.bestteam.videolibr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView userName,Password,fName,Lname,City,Street,Email;
    private ImageView ImageViewCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        userName = findViewById(R.id.txtvUserName);
        Password = findViewById(R.id.txtvPassword);
        fName = findViewById(R.id.txtvFname);
        Lname = findViewById(R.id.txtvLname);
        City = findViewById(R.id.txtvCity);
        Street = findViewById(R.id.txtvStreet);
        Email = findViewById(R.id.txtvEmail);

        ImageViewCam = findViewById(R.id.ImageViewCam);

        User user = usersVector.getUserAt(usersVector.CurrentIndx);

        userName.setText(user.getUserName());
        Password.setText(user.getPassWord());
        fName.setText(user.getfName());
        Lname.setText(user.getLname());
        City.setText(user.getCity());
        Street.setText(user.getStreet());
        Email.setText(user.getEmail());

        if(SignUpActivity.flag == true)
        {
            ImageViewCam.setImageBitmap(SignUpActivity.bitmap);
        }
        else
        {
            ImageViewCam.setImageURI(SignUpActivity.imageUri);
        }

    }
}
