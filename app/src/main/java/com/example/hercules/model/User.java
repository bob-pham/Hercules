package com.example.hercules.model;


import com.example.hercules.model.admin_overhead.Account;
import com.example.hercules.model.admin_overhead.Goal;
import com.example.hercules.model.admin_overhead.Stats;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Account account;
    private Goal goal;
    private Stats userStats;
    private Set<SkinsOwned> skins;
    private SkinsOwned currentSkin;

    public User(String id, String pw, String name, String birthDayString) {
        account = new Account(id, pw, name, birthDayString);
        skins = new HashSet<>();
        this.userStats = new Stats();
        skins.add(SkinsOwned.DEFAULT);
        currentSkin = SkinsOwned.DEFAULT;
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

    public Set<SkinsOwned> getSkins() {
        return skins;
    }

    public void setSkins(Set<SkinsOwned> skins) {
        this.skins = skins;
    }

    public void addSkin(SkinsOwned skin) {
        this.skins.add(skin);
    }

    public void setCurrentSkin(SkinsOwned skin) {
        currentSkin = skin;
    }

    public boolean ownSkin(SkinsOwned skin) {
        return this.skins.contains(skin);
    }

    public SkinsOwned getCurrentAvatar() {
        return currentSkin;
    }
}
