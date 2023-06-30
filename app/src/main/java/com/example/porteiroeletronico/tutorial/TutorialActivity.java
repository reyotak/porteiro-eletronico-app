package com.example.porteiroeletronico.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.porteiroeletronico.login.ui.LoginActivity;
import com.example.porteiroeletronico.main.MainActivity;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent activityIntent;



        if (isLogged()) {
            activityIntent = new Intent(this, MainActivity.class);
        } else {
            activityIntent = new Intent(this, LoginActivity.class);
        }

        startActivity(activityIntent);
        finish();
    }

    private boolean isLogged() {
        Bundle extras = getIntent().getExtras();
        return (extras != null);
    }
}