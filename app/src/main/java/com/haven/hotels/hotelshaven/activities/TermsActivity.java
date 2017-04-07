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

public class TermsActivity extends AppCompatActivity {
    private TextView cookiePolicy;
    private ImageView cookieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        cookiePolicy = (TextView) findViewById(R.id.cookieView);
        cookieImage = (ImageView) findViewById(R.id.cookieImageView);

        cookiePolicy.setText(getResources().getText(R.string.cookie));

    }

}
