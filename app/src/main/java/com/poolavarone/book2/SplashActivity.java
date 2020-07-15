package com.poolavarone.book2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeScroll;
import androidx.transition.Explode;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.internal.TextScale;

public class SplashActivity extends AppCompatActivity {
    private static final String LOGIN = "login";
    boolean islogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ViewGroup loginactivity = findViewById(R.id.root_splash);
        final RelativeLayout relativeLayout = findViewById(R.id.linearlayout_logo_splash);
        getData();
        if (islogin) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }

    }

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN, MODE_PRIVATE);
        islogin = sharedPreferences.getBoolean("ISLOGIN", false);
    }
}
