package com.example.porteiroeletronico.ui.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.porteiroeletronico.ui.MainActivity;
import com.example.porteiroeletronico.ui.login.LoginActivity;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent activityIntent;

        /*
        * ignore the login activity for now
        if (isLogged()) {
            activityIntent = new Intent(this, MainActivity.class);
        } else {
            activityIntent = new Intent(this, LoginActivity.class);
        }
        */

        activityIntent = new Intent(this, MainActivity.class);

        startActivity(activityIntent);
        finish();
    }

    private boolean isLogged() {
        Bundle extras = getIntent().getExtras();
        return (extras != null);
    }
}