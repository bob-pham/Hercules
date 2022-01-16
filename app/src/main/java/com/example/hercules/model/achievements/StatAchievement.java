package com.example.hercules.model.achievements;

import java.util.Observable;

public class StatAchievement extends Achievement {

    private static int xp = 10;
    private static int statsNeeded = 1;

    public StatAchievement(String name, String description, int experience) {
        super(name, description, experience);
        this.required = generateRequired();
        statsNeeded *= 2;
    }

    public StatAchievement(String name, String description) {
        super(name, description);
        this.experience = generateExperience();
        xp *= 10;
        this.required = generateRequired();
        statsNeeded *= 2;
    }

    private int generateExperience() {
        return (int) Math.floor(Math.random()*((xp)-(xp / 5)+1)+(xp / 5));
    }

    private int generateRequired() {
        return (int) Math.floor(Math.random()*((statsNeeded * 2)-(statsNeeded)+1)+(statsNeeded));
    }

    //Will observe list of quests
    @Override
    public void update(Observable observable, Object o) {
        incrementCompleted();
    }
}
