package com.example.hercules.model.admin_overhead;


import com.example.hercules.model.Quest;

public class User {
    private Account account;
    private Goal goal;
    private double currentRewardsRemaining;
    private double totalRewardsGained;
//    private List<Quest> quests;

//    public User(String id, String pw, String name, String birthDayString, Goal goal, List<Quest> quests) {
//        this.goal = goal;
//        account = new Account(id, pw, name, birthDayString);
//    }
//
//    public User(String id, String pw, String name, String birthDayString, Goal goal) {
//        this.goal = goal;
//        account = new Account(id, pw, name, birthDayString);
////        this.quests = new ArrayList<>();
//    }

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
