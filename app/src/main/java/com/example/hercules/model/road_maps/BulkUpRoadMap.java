package com.example.hercules.model.road_maps;

import com.example.hercules.model.admin_overhead.Admin;
import com.example.hercules.model.Quest;

import java.util.ArrayList;
import java.util.List;

public class BulkUpRoadMap extends RoadMap {

    public BulkUpRoadMap() {
        super(Admin.GoalTypes.BULK_UP.toString());
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
