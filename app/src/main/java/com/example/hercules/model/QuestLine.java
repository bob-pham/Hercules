package com.example.hercules.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class QuestLine extends Quest implements Observer, PropertyChangeListener {

    private List<Quest> quests;
    private double percentDone;

    public QuestLine(String name, boolean collaborative) {
        super(name, 0, collaborative);
        this.percentDone = 0;
        this.quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        quest.addObserver(this);
        this.quests.add(quest);
    }

    public void removeQuest(Quest quest) {
        this.quests.remove(quest);
    }

    public int getEarnedPoints() {
        int pointsEarned = 0;

        for (Quest q : quests) {
            if (q.getProgress() == Status.COMPLETED) {
                pointsEarned += q.getPoints();
            }
        }
        if (this.progress == Status.COMPLETED) {
            return this.points + pointsEarned;
        } else {
            return pointsEarned;
        }
    }

    @Override
    public int getPoints() {
        int points = 0;

        for (Quest q : quests) {
            points += q.getPoints();
        }

        return points + this.points;
    }

    private void calculatePercent() {

        int progress = 0;

        for (Quest q : quests) {
            if (q.getProgress() == Status.COMPLETED || q.getProgress() == Status.FAILED) {
                progress += 2;
            } else if (q.getProgress() == Status.IN_PROGRESS) {
                progress++;
            }
        }

        if (progress / 2 == quests.size()) {
            this.progress = Status.COMPLETED;
            this.percentDone = 100.0;
            changeSupport.firePropertyChange(Update.STATUS.toString(), Status.IN_PROGRESS, Status.COMPLETED);
        } else {
            this.progress = Status.IN_PROGRESS;
            this.percentDone = (double) ((progress / 2) / quests.size())  * 100;
        }
    }

    @Override
    public int getCount() {
        int count = 0;
        for (Quest q: quests) {
            count += q.getCount();
        }
        return count;
    }

    @Override
    public void update(Observable observable, Object o) {
        Update u = (Update) o;
        if (o == Update.STATUS) {
            calculatePercent();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getSource() instanceof  Quest) {
            if (propertyChangeEvent.getNewValue().equals(Status.COMPLETED)) {
                calculatePercent();
            }
        }
    }
}
