package com.example.hercules.model;

import com.example.hercules.model.road_maps.BulkUpRoadMap;
import com.example.hercules.model.road_maps.CardioRoadMap;
import com.example.hercules.model.road_maps.DietRoadMap;
import com.example.hercules.model.road_maps.WeightTrainingRoadMap;

public class Admin {

    public enum GoalTypes {
        DIET, BULK_UP, WEIGHT_TRAINING, CARDIO
    }


    private static final RoadMap DietRoadMap = new DietRoadMap();
    private static final RoadMap BULK_UP = new BulkUpRoadMap();
    private static final RoadMap WEIGHT_TRAINING = new WeightTrainingRoadMap();
    private static final RoadMap CARDIO = new CardioRoadMap();



    public Goal getGoal(GoalTypes type) {
        switch (type) {
            case DIET:
                return DietRoadMap.getGoal();
            case BULK_UP:
                return BULK_UP.getGoal();
            case WEIGHT_TRAINING:
                return WEIGHT_TRAINING.getGoal();
            case CARDIO:
                return CARDIO.getGoal();
            default:
                return null;
        }
    }








}
