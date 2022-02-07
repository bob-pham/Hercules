package com.example.hercules.model.road_maps;


import com.example.hercules.model.Quest;
import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Goal;

import java.util.List;

public abstract class RoadMap {
    private List<Quest> defaultQuests = createQuests();
    protected String name;

    public RoadMap(String name) {
        this.name = name;
    }

    public Goal getGoal(User user) {
        Goal goal = new Goal(name, user, createQuests());
        return goal;
    }

    public void addQuest(Quest q) {
        defaultQuests.add(q);
    }

    public boolean removeQuest(Quest q) {
        return defaultQuests.remove(q);
    }

    public String getName() {
        return name;
    }

    public abstract List<Quest> createQuests();

}
