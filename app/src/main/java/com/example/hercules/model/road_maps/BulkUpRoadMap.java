package com.example.hercules.model.road_maps;

import com.example.hercules.model.Goal;
import com.example.hercules.model.Quest;
import com.example.hercules.model.QuestLine;
import com.example.hercules.model.RoadMap;
import com.example.hercules.model.User;

import java.util.ArrayList;
import java.util.List;

public class BulkUpRoadMap extends RoadMap {

    public BulkUpRoadMap() {
        super("BULK_UP");
    }



    @Override
    public List<Quest> createQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(createTheFirstTask());
        return quests;
    }


    public Quest createTheFirstTask() {
        return null;
    }

}
