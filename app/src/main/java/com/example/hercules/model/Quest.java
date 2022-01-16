package com.example.hercules.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class Quest extends Observable {

    protected String name;
    protected String description;
    protected int points;
    protected Status progress;
    protected boolean collaborative;
    protected PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public Quest(String name, int points, boolean collaborative) {
        this.name = name;
        this.points = points;
        this.collaborative = collaborative;
        this.progress = Status.NOT_STARTED;
    }

    public int getCount() {
        return 1;
    }

    public enum Status {
        NOT_STARTED,
        COMPLETED,
        IN_PROGRESS,
        FAILED
    }

    public enum Update {
        STATUS
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
        Status old = this.progress;
        this.progress = progress;
        changeSupport.firePropertyChange(Update.STATUS.toString(),old, progress);
    }

    @Override
    public String toString() {
        return name + ": " + description + ", points: "  + points;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }



}
