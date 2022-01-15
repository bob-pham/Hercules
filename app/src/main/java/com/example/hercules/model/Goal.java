package com.example.hercules.model;

import com.example.hercules.model.road_maps.BulkUpRoadMap;
import com.example.hercules.model.road_maps.CardioRoadMap;
import com.example.hercules.model.road_maps.DietRoadMap;
import com.example.hercules.model.road_maps.WeightTrainingRoadMap;

import java.util.ArrayList;
import java.util.List;


public class Goal {

    List<Quest> questsTodo;
    List<Quest> questsDone = new ArrayList<>();

//    private static final RoadMap DietRoadMap = new DietRoadMap();
//    private static final RoadMap BULK_UP = new BulkUpRoadMap();
//    private static final RoadMap WEIGHT_TRAINING = new WeightTrainingRoadMap();
//    private static final RoadMap CARDIO = new CardioRoadMap();

    public Goal() {
        questsTodo = new ArrayList<>();
    }

    public Goal(List<Quest> questsTodo) {
        this.questsTodo = questsTodo;
    }















}
