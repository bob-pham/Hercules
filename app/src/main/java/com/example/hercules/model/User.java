package com.example.hercules.model;


import java.util.ArrayList;
import java.util.List;

public class User {
    private Account account;
    private Goal goal;
    private double currentRewardsRemaining;
    private double totalRewardsGained;
    private List<Quest> quests;

    public User(String id, String pw, String name, String birthDayString, String goalName, List<Quest> quests) {
        account = new Account(id, pw, name, birthDayString);
        goal.getGoal(Goal.GoalTypes.valueOf(goalName));
        this.quests = quests;
    }

    public User(String id, String pw, String name, String birthDayString, String goalName) {
        account = new Account(id, pw, name, birthDayString);
        goal.getGoal(Goal.GoalTypes.valueOf(goalName));
        this.quests = new ArrayList<>();
    }

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
        this.quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void removeQuest(Quest quest) {
        this.quests.remove(quest);
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

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

}
