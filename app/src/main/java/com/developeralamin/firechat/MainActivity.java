package com.developeralamin.firechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.OneSignal;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;

    DrawerLayout drawlayout;
    NavigationView navigationView;

    ActionBarDrawerToggle toggle;

    private static final String ONESIGNAL_APP_ID = "f50ebbca-b286-4fc0-a63e-5363ce91a438";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        drawlayout = findViewById(R.id.drawlayout);
        navigationView = findViewById(R.id.navigationView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.fram_layout);

       toggle = new ActionBarDrawerToggle(MainActivity.this, drawlayout, R.string.open, R.string.close);
        drawlayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.rateus:
                        Toast.makeText(MainActivity.this, "Rate us", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.share:
                        Toasty.success(MainActivity.this, "Success!", Toast.LENGTH_SHORT, true).show();
                        break;

                    case R.id.developer:
                        Toasty.info(MainActivity.this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
                        break;

                }

                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (toggle.onOptionsItemSelected(item)){
            return true;
        }


        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                FirebaseAuth auth;
                auth = FirebaseAuth.getInstance();
                auth.signOut();

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }


}