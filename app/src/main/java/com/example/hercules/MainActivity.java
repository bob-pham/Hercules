package com.example.hercules;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hercules.model.Admin;
import com.example.hercules.model.User;
import com.example.hercules.view.ClosetFragment;
import com.example.hercules.view.HomeFragment;
import com.example.hercules.view.QuestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static User user;
    private BottomNavigationView bottomNavigationView;
    private Admin admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        admin = new Admin();
        //for testing
        user = admin.createUser("chicken", "pizza", "coke", "2000-09-09", Admin.GoalTypes.CARDIO.toString());
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
//                    Intent intent = new Intent(getApplicationContext(), QuestsActivity.class);
//                    startActivity(intent);

                fragment = new QuestsFragment();
                break;
//                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        return true;
    };
}