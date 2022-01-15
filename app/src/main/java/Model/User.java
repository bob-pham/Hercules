package Model;


import android.os.Build;

import androidx.annotation.RequiresApi;

public class User {
    private Account account;
    private Goal goal;
    private double currentRewardsRemaining;
    private double totalRewardsGained;


    public User(String id, String pw, String name, String birthDayString, String goalName) {
        account = new Account(id, pw, name, birthDayString);
        goal.getGoal(Goal.GoalTypes.valueOf(goalName));
    }

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
    }





}
