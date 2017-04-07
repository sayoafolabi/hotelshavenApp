package com.haven.hotels.hotelshaven.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haven.hotels.hotelshaven.R;

public class AboutusActivity extends AppCompatActivity {

    private TextView aboutUs;
    private ImageView aboutUsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        aboutUs = (TextView) findViewById(R.id.textViewAbout);
        aboutUsImage = (ImageView) findViewById(R.id.aboutImageView);

        aboutUs.setText(getResources().getText(R.string.aboutus));


    }

}
