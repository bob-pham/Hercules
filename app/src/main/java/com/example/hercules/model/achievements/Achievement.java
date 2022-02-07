package com.example.hercules.model.achievements;

import java.util.Observable;
import java.util.Observer;

public abstract class Achievement extends Observable implements Observer {

    protected String name;
    protected String description;
    protected int experience;
    protected int required;
    protected int tasksCompleted;

    public Achievement(String name, String description, int experience) {
        this.name = name;
        this.description = description;
        this.experience = experience;
        this.tasksCompleted = 0;
    }

    public Achievement(String name, String description) {
        this.name = name;
        this.description = description;
        this.tasksCompleted = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    protected void incrementCompleted() {
        this.tasksCompleted++;
        if (this.tasksCompleted >= this.required) {
            setChanged();
            notifyObservers();
        }
    }
}
