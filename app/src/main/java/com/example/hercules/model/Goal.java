package com.example.hercules.model;

import com.example.hercules.model.road_maps.BulkUpRoadMap;
import com.example.hercules.model.road_maps.CardioRoadMap;
import com.example.hercules.model.road_maps.DietRoadMap;
import com.example.hercules.model.road_maps.WeightTrainingRoadMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Goal {

    private String name;

    private List<Quest> questsTodo;

    public Goal(String name) {
        this.name = name;
        questsTodo = new ArrayList<>();
    }

    public Goal(String name, List<Quest> questsTodo) {
        this.name = name;
        this.questsTodo = questsTodo;
    }

    public List<Quest> getQuestsTodo() {
        return questsTodo;
    }

    public void setQuestionsToDo(List<Quest> quests) {
        this.questsTodo = quests;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(questsTodo, goal.questsTodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questsTodo);
    }
}
