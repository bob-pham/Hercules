package com.example.hercules.model.road_maps;

import com.example.hercules.model.Quest;
import com.example.hercules.model.admin_overhead.Admin;

import java.util.ArrayList;
import java.util.List;

public class CardioRoadMap extends RoadMap {

    public CardioRoadMap() {
        super(Admin.GoalTypes.CARDIO.toString());
    }

    @Override
    public List<Quest> createQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.addAll(createFirstQuest());
        return quests;
    }

    public List<Quest> createFirstQuest() {
        Quest firstQuest = new Quest("Warm up!", 100, false);
        firstQuest.setDescription("Jog 10 min");
        Quest secondQuest = new Quest("Main quest!", 150, false);
        secondQuest.setDescription("Dash 3 minutes");
        Quest thirdQuest = new Quest("Final quest!", 300, false);
        thirdQuest.setDescription("Repeat!");

        List<Quest> quests = new ArrayList<>();
        quests.add(firstQuest);
        quests.add(secondQuest);
        quests.add(thirdQuest);
        return quests;

    }








}
