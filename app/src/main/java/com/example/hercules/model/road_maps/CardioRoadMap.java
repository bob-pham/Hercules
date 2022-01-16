package com.example.hercules.model.road_maps;

import com.example.hercules.model.Admin;
import com.example.hercules.model.Quest;

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
//        Quest start
//        QuestLine questLine = new QuestLine("START", false);
        Quest firstQuest = new Quest("Warm up!", 100, false);
        firstQuest.setDescription("Jog 10 min");
//        questLine.addQuest(firstQuest);
        Quest secondQuest = new Quest("Main quest!", 150, false);
        secondQuest.setDescription("Dash 3 minutes");
//        questLine.addQuest(secondQuest);
        Quest thirdQuest = new Quest("Final quest!", 300, false);
        thirdQuest.setDescription("Repeat!");
//        questLine.addQuest(thirdQuest);

        List<Quest> quests = new ArrayList<>();
        quests.add(firstQuest);
        quests.add(secondQuest);
        quests.add(thirdQuest);
        return quests;

    }








}
