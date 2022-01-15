package com.example.hercules.model;


import java.util.ArrayList;
import java.util.List;

public abstract class RoadMap {
    private List<Quest> quests = createQuests();
    protected String name;

    public RoadMap(String name) {
        this.name = name;
    }

    public Goal getGoal() {
        Goal goal = new Goal(name, quests);
        return goal;
    }



    public void addQuest(Quest q) {
        quests.add(q);
    }

    public boolean removeQuest(Quest q) {
        return quests.remove(q);
    }

    public String getName() {
        return name;
    }

    public abstract List<Quest> createQuests();




}
