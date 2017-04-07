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

public class PrivacyPolicyActivity extends AppCompatActivity {

    private TextView privacy;
    private ImageView privacyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        privacy = (TextView) findViewById(R.id.privacyView);
        privacyImage = (ImageView) findViewById(R.id.privacyImageView);

        privacy.setText(getResources().getText(R.string.privacypolicy));

    }

}
