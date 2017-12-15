package com.bestteam.videolibr;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

public class SignUpActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText userName, password, fName, Lname, City, Street, Email;
    private Button signUp, btnUploadByGal, btnCamera;
    public static Uri imageUri;
    public static Bitmap bitmap;
    public static boolean flag = true;
    private String extension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = (EditText) findViewById(R.id.txtUserNameUP);
        password = (EditText) findViewById(R.id.txtPassUP);
        fName = findViewById(R.id.txtFirstName);
        Lname = findViewById(R.id.txtLastName);
        City = findViewById(R.id.txtCity);
        Street = findViewById(R.id.txtStreet);
        Email = findViewById(R.id.txtEmail);
        signUp = (Button) findViewById(R.id.btnSignUp2);
        btnUploadByGal = findViewById(R.id.btnUpLoadPhoto);
        btnCamera = findViewById(R.id.btnUpLoadByCam);

        imageView = findViewById(R.id.ImageViewCam2);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(SignUpActivity.this, "userName or pass is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    usersVector.AddUser(new User(userName.getText().toString(),
                            password.getText().toString(), Email.getText().toString(), fName.getText().toString(),
                            Lname.getText().toString(), City.getText().toString(), Street.getText().toString(),
                            usersVector.index));
                    Toast.makeText(SignUpActivity.this, "You are Registered!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btnUploadByGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            flag = true;
        } else if (requestCode == 1 && resultCode == RESULT_OK) {
            imageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media.DISPLAY_NAME};
            Cursor cursor =
                    getContentResolver().query(imageUri, filePathColumn, null, null, null);
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String filePath = cursor.getString(columnIndex);
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                int fileNameIndex = cursor.getColumnIndex(filePathColumn[1]);
                String fileName = cursor.getString(fileNameIndex);
                // Here we get the extension you want
                extension = fileName.replaceAll("^.*\\.", "");
            }
            if(extension.equals("jpg") || extension.equals("png"))
            {
                imageView.setImageURI(imageUri);
                flag = false;
            }
            else
                Toast.makeText
                        (SignUpActivity.this, "You can Upload only Image!", Toast.LENGTH_SHORT).show();


            cursor.close();

        }

    }
}