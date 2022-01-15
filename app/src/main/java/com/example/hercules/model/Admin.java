package com.example.hercules.model;

import com.example.hercules.model.road_maps.BulkUpRoadMap;
import com.example.hercules.model.road_maps.CardioRoadMap;
import com.example.hercules.model.road_maps.DietRoadMap;
import com.example.hercules.model.road_maps.WeightTrainingRoadMap;

import java.util.HashMap;
import java.util.Map;

public class Admin {

    private Map<String, User> userMap;

    public enum GoalTypes {
        DIET, BULK_UP, WEIGHT_TRAINING, CARDIO
    }


    private static final RoadMap DietRoadMap = new DietRoadMap();
    private static final RoadMap BULK_UP = new BulkUpRoadMap();
    private static final RoadMap WEIGHT_TRAINING = new WeightTrainingRoadMap();
    private static final RoadMap CARDIO = new CardioRoadMap();





    public Admin() {
        userMap = new HashMap<>();
    }



    public void createUser(String id, String pw, String name, String birthday, String goalName) {
        Goal goal = getGoal(goalName);
        userMap.put(id, new User(id, pw, name, birthday, goal));
    }

    public boolean loginAttempt(String id, String pw) {
        User user = userMap.get(id);
        if (user == null) {
            return false;
        }
        if (user.getPW().equals(pw)) {
            return true;
        } else {
            return false;
        }
    }



    private Goal getGoal(GoalTypes type) {
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

    public Goal getGoal(String typeName) {
        return getGoal(GoalTypes.valueOf(typeName));
    }










}
