package com.example.hercules.model.road_maps;

import com.example.hercules.model.Goal;
import com.example.hercules.model.Quest;
import com.example.hercules.model.QuestLine;
import com.example.hercules.model.RoadMap;
import com.example.hercules.model.User;

import java.util.ArrayList;
import java.util.List;

public class CardioRoadMap extends RoadMap {

    public CardioRoadMap() {
        super("CARDIO");
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
