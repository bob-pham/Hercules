package com.example.hercules.model;

import java.util.Observable;

public class Quest extends Observable {

    protected String name;
    protected String description;
    protected int points;
    protected Status progress;
    protected boolean collaborative;

    public Quest(String name, int points, boolean collaborative) {
        this.name = name;
        this.points = points;
        this.collaborative = collaborative;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Status getProgress() {
        return progress;
    }

    public void setProgress(Status progress) {
        this.progress = progress;
    }
}
