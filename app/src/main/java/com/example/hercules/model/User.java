package com.example.hercules.model;


public class User {
    private Account account;
    private Goal goal;
    private double currentRewardsRemaining;
    private double totalRewardsGained;

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
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

    public double getCurrentRewardsRemaining() {
        return currentRewardsRemaining;
    }

    public void setCurrentRewardsRemaining(double currentRewardsRemaining) {
        this.currentRewardsRemaining = currentRewardsRemaining;
    }

    public double getTotalRewardsGained() {
        return totalRewardsGained;
    }

    public void setTotalRewardsGained(double totalRewardsGained) {
        this.totalRewardsGained = totalRewardsGained;
    }

    public String getID() {
        return  account.getUserID();
    }

    public String getPW() {
        return account.getUserPW();
    }


}
