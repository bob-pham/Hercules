package com.example.hercules.model.road_maps;

import com.example.hercules.model.admin_overhead.Admin;
import com.example.hercules.model.Quest;
import com.example.hercules.model.QuestLine;

import java.util.ArrayList;
import java.util.List;

public class CardioRoadMap extends RoadMap {

    public CardioRoadMap() {
        super(Admin.GoalTypes.CARDIO.toString());
    }

    @Override
    public List<Quest> createQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(createFirstQuest());
        return quests;
    }


    public Quest createFirstQuest() {
        QuestLine questLine = new QuestLine("START", false);
        questLine.addQuest(new Quest("gently run  for 5 minutes!", 100, false));
        questLine.addQuest(new Quest("Dash for 50 seconds!", 50, false));
        questLine.addQuest(new Quest("Repeat!", 150, false));
        return questLine;
    }








}
