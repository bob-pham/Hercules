package com.example.hercules.model.admin_overhead;

import com.example.hercules.model.Quest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Goal implements PropertyChangeListener {

    private String name;
    private User user;

    private List<Quest> questsTodo;
    private List<Quest> questsDone;
    private double overallProgress = 0;




    public Goal(String name, User user, List<Quest> questsTodo) {
        this.name = name;
        this.user = user;
        this.questsTodo = questsTodo;
        questsDone = new ArrayList<>();
    }


    public List<Quest> getQuestsTodo() {
        return questsTodo;
    }

    public List<Quest> getQuestsDone() {
        return questsDone;
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

    public void addQuest(Quest quest) {
        questsTodo.add(quest);
    }


    public void removeQuest(Quest quest) {
        questsTodo.remove(quest);
    }

    public int getTotalQuestNumber() {
        return getQuestsDoneCount() + getQuestsToDoCount();
    }



    public int getQuestsDoneCount() {
        return questsDone.size();
//        int count = 0;
//        for (Quest q: questsDone) {
//            count += q.getCount();
//        }
//        return count;
    }

    public int getQuestsToDoCount() {
        return questsTodo.size();
//        int count = 0;
//        for (Quest q: questsTodo) {
//            count += q.getCount();
//        }
//        return count;
    }

    public void goalAchieved() {

    }

    //when a quest is done
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getSource() instanceof Quest) {
            Quest quest = (Quest) propertyChangeEvent.getSource();
            if (propertyChangeEvent.getNewValue().equals(Quest.Status.COMPLETED)){
                questsTodo.remove(quest);
                questsDone.add(quest);
                overallProgress = getQuestsDoneCount() / (double) getTotalQuestNumber();
                if (overallProgress == 100) {
                    goalAchieved();
                }
            }
        }
    }

    public Quest getNextQuest() {
        if (questsTodo.isEmpty()) {
            return null;
        }
        return questsTodo.get(0);
    }
}
