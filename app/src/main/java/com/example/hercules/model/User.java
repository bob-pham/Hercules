package com.example.hercules.model;


public class User {
    private Account account;
    private Goal goal;
    private Admin admin;
    private double currentRewardsRemaining;
    private double totalRewardsGained;


    public User(String id, String pw, String name, String birthDayString, String goalName, Goal goal) {
        account = new Account(id, pw, name, birthDayString);
        this.goal = goal;
    }

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
    }

}
