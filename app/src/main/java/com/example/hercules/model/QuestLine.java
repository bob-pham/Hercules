package com.example.hercules.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class QuestLine extends Quest implements Observer {

    private List<Quest> quests;
    private int percentDone;

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



    @Override
    public void update(Observable observable, Object o) {

    }
}
