package com.example.hercules.model.road_maps;

import com.example.hercules.model.Admin;
import com.example.hercules.model.Quest;

import java.util.List;

public class WeightLossRoadMap extends RoadMap {

    public WeightLossRoadMap() {
        super(Admin.GoalTypes.WEIGHT_LOSS.toString());
    }

    @Override
    public List<Quest> createQuests() {
        return null;
    }
}
