package com.example.hercules.model.achievements;

import java.util.Observable;

public class QuestAchievement extends Achievement {

    private static int xp = 10;
    private static int questsNeeded = 1;

    public QuestAchievement(String name, String description, int experience) {
        super(name, description, experience);
        this.required = generateRequired();
        questsNeeded *= 2;
    }

    public QuestAchievement(String name, String description) {
        super(name, description);
        this.experience = generateExperience();
        xp *= 10;
        this.required = generateRequired();
        questsNeeded *= 2;
    }

    private int generateExperience() {
        return (int) Math.floor(Math.random()*((xp)-(xp / 5)+1)+(xp / 5));
    }

    private int generateRequired() {
        return (int) Math.floor(Math.random()*((questsNeeded * 2)-(questsNeeded)+1)+(questsNeeded));
    }

    //Will observe list of quests
    @Override
    public void update(Observable observable, Object o) {
        incrementCompleted();
    }
}
