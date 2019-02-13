package com.example.ayak1.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static  final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = (Button) findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptscanButton();
            }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptscanButton() {
        Intent scanIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(scanIntent);
        if(scanIntent.resolveActivity(getPackageManager()) != null){

            startActivityForResult(scanIntent,REQUEST_IMAGE_CAPTURE);

        }
    }


    protected void onActivityResulte(int requestCode, int resulteCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resulteCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            setContentView(R.layout.activity_main);

            ImageView mImageView = new ImageView(getApplicationContext());

            Button scanButton = new Button(this);
            mImageView = (ImageView) findViewById(R.id.imageView1);
            scanButton = (Button) findViewById(R.id.scanButton);
            //mImageView.setImageResource(R.drawable.android3d);

        }

    }
}
