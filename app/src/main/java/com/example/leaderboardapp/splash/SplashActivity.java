package com.example.leaderboardapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.example.leaderboardapp.MainActivity;
import com.example.leaderboardapp.R;

import java.util.Map;


public class SplashActivity extends AppCompatActivity {
    SplashViewModel splashViewModel;
    LiveData<Boolean> timer;
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        initSplashViewModel();

    }

    private void initSplashViewModel() {
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashViewModel.sleepThread();
        splashViewModel.mCheck.observe(this, bool ->{
            if(bool == true){
                goToMainActivity();
            }
        });

    }


    private void goToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}