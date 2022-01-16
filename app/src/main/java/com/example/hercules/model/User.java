package com.example.hercules.model;


import java.util.ArrayList;
import java.util.List;

public class User extends Stats {
    private Account account;
    private Goal goal;
    private Stats userStats;

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
        userStats = new Stats();
    }

    public void addQuest(Quest quest) {
        goal.addQuest(quest);
    }

    public void removeQuest(Quest quest) {
        goal.removeQuest(quest);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getID() {
        return  account.getUserID();
    }

    public String getPW() {
        return account.getUserPW();
    }

    public Stats getUserStats() {
        return userStats;
    }

    public void setUserStats(Stats userStats) {
        this.userStats = userStats;
    }

}
