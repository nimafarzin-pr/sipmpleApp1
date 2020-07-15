package com.poolavarone.book2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frag;
    BottomNavigationView navbottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        navbottom.setOnNavigationItemSelectedListener(this);
    }

    private void setupView() {
        frag = (FrameLayout) findViewById(R.id.frame_mainactivity);
        navbottom = (BottomNavigationView) findViewById(R.id.nav_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_mainactivity, new HomeFragment()).commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int menueId = item.getItemId();

        switch (menueId) {
            case R.id.home:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_mainactivity, new HomeFragment()).commit();
                break;

            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_mainactivity, new SearchFragment()).commit();

                break;

            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_mainactivity, new PersonFragment()).commit();

                break;
        }

        return true;
    }
}
