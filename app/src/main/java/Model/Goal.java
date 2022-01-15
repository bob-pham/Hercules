package Model;

import java.util.List;

public class Goal {

    public enum GoalTypes {
        DIET, BULK_UP, WEIGHT_TRAINING, CARDIO
    }

    private static final Goal DIET = new Goal();
    private static final Goal BULK_UP = new Goal();
    private static final Goal WEIGHT_TRAINING = new Goal();
    private static final Goal CARDIO = new Goal();

    private List<Quest> questsToDo;
    private List<Quest> questsDone;

    private Goal() {

    }



    public void getGoal(GoalTypes goalTypes) {

    }









}
