package com.example.hercules;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hercules.model.User;
import com.example.hercules.view.ClosetFragment;
import com.example.hercules.view.HomeFragment;
import com.example.hercules.view.QuestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private User user;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnItemSelectedListener bottomNavMethod = menuItem -> {

        Fragment fragment = null;

        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;

            case R.id.nav_closet:
                fragment = new ClosetFragment();
                break;

            case R.id.nav_quests:
                fragment = new QuestsFragment();

                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        return true;
    };

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//
//
//        }
//        return false;
//    }
}