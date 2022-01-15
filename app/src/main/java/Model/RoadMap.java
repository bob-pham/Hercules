package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class RoadMap {
    private List<Quest> quests = new ArrayList<>();

    public abstract Goal getGoal();
    public void addQuest(Quest q) {
        quests.add(q);
    }


}
