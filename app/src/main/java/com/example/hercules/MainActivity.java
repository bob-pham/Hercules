package com.example.hercules;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Admin;
import com.example.hercules.model.admin_overhead.Stats;
import com.example.hercules.view.ClosetFragment;
import com.example.hercules.view.HomeFragment;
import com.example.hercules.view.QuestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Admin admin;
    public User user; //The current user
    public Boolean lastPage = Boolean.FALSE; // Default home page
    private static HomeFragment homeFragment;
    private static ClosetFragment closetFragment;
    private static QuestsFragment questsFragment;


    private static MainActivity instance;

    private void initializeUser() {
        user = admin.createUser("69420","password","Achilles","2002-01-01", Admin.GoalTypes.CARDIO.toString());
        initializeUserStats(user.getUserStats());
    }

    private void initializeUserStats(Stats s) {
        s.setBench(250);
        s.setCurrentStreak(6);
        s.setLongestStreak(9);
        s.setExperience(80);
        s.setGold(420);
        s.setHeight(183);
        s.setLevel(10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            instance = this;
            setContentView(R.layout.activity_main);
            admin = new Admin();
            initializeUser();
            homeFragment = HomeFragment.getInstance(user);
            closetFragment = ClosetFragment.getInstance(user);
            questsFragment = QuestsFragment.getInstance(user);
            bottomNavigationView = findViewById(R.id.bottomNav);
            bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
            getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment, homeFragment.getTag()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BottomNavigationView.OnItemSelectedListener bottomNavMethod = menuItem -> {

        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment, homeFragment.getTag()).commit();
                lastPage = false;
                break;

            case R.id.nav_closet:
//                closetFragment = ClosetFragment.getInstance(user);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, closetFragment, closetFragment.getTag()).commit();
                lastPage = true;
                break;

            case R.id.nav_quests:
                try {
//                    questsFragment = QuestsFragment.getInstance(user);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, questsFragment, questsFragment.getTag()).commit();
//                    Intent intent = new Intent(getApplicationContext(), QuestsActivity.class);
//                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

        return true;
    };

    public Admin getAdmin() {
        return admin;
    }

    public User getUser() {
        return user;
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public Boolean getLastPage() {
        return lastPage;
    }
}