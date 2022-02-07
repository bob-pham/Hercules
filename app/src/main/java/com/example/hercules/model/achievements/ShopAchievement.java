package com.example.hercules.model.achievements;

import java.util.Observable;

public class ShopAchievement extends Achievement {

    private static int xp = 10;
    private static int shopNeeded = 1;

    public ShopAchievement(String name, String description, int experience) {
        super(name, description, experience);
        this.required = generateRequired();
        shopNeeded *= 2;
    }

    public ShopAchievement(String name, String description) {
        super(name, description);
        this.experience = generateExperience();
        xp *= 10;
        this.required = generateRequired();
        shopNeeded *= 2;
    }

    private int generateExperience() {
        return (int) Math.floor(Math.random()*((xp)-(xp / 5)+1)+(xp / 5));
    }

    private int generateRequired() {
        return (int) Math.floor(Math.random()*((shopNeeded * 2)-(shopNeeded)+1)+(shopNeeded));
    }

    //Will observe list of quests
    @Override
    public void update(Observable observable, Object o) {
        incrementCompleted();
    }
}
