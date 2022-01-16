package com.example.hercules.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hercules.MainActivity;
import com.example.hercules.R;
import com.example.hercules.model.Quest;
import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Goal;

import java.util.List;

public class QuestsActivity extends AppCompatActivity {

    private Goal goal;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity = MainActivity.getInstance();
        User user = mainActivity.getUser();
        this.user = user;
        goal = user.getGoal();
        setContentView(R.layout.fragment_quests);
        addTable();
//        TableLayout tableLayout = (TableLayout) findViewById(R.id.questTable);
//        List<Quest> questsTodo = goal.getQuestsTodo();
//        for (Quest quest: questsTodo) {
//            TableRow tableRow = new TableRow(this);
//            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
//            tableRow.setLayoutParams(lp);
//            TextView name = new TextView(this);
////            name.setGravity(Gravity.LEFT);
//            TextView description = new TextView(this);
////            name.setGravity(Gravity.CENTER);
//            TextView points = new TextView(this);
////            points.setGravity(Gravity.RIGHT);
//            name.setText(quest.getName());
//            description.setText(quest.getDescription());
//            points.setText(String.valueOf(quest.getPoints()));
//            tableRow.addView(name);
//            tableRow.addView(description);
//            tableRow.addView(points);
//            tableLayout.addView(tableRow);
        }

    public void addTable() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.quest_table);
        TableRow header = new TableRow(this);

        TextView nameColumn = new TextView(this);
        nameColumn.setText("Name");
        nameColumn.setGravity(Gravity.CENTER);
        nameColumn.setTextColor(Color.BLACK);
        header.addView(nameColumn);
        TextView descriptionColumn = new TextView(this);
        descriptionColumn.setText("Description");
        descriptionColumn.setTextColor(Color.BLACK);
        descriptionColumn.setGravity(Gravity.CENTER);
        header.addView(descriptionColumn);
        TextView pointColumn = new TextView(this);
        pointColumn.setText("Points");
        pointColumn.setTextColor(Color.BLACK);
        pointColumn.setGravity(Gravity.CENTER);
        header.addView(pointColumn);
        TextView checkBoxColumn = new TextView(this);
        checkBoxColumn.setText("DONE");
        checkBoxColumn.setTextColor(Color.BLACK);
        checkBoxColumn.setGravity(Gravity.CENTER);
        header.addView(checkBoxColumn);
        tableLayout.addView(header);
        List<Quest> questsTodo = goal.getQuestsTodo();
        for (Quest quest: questsTodo) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            tableRow.setLayoutParams(lp);
            TextView name = new TextView(this);
            name.setGravity(Gravity.CENTER);
            name.setTextColor(Color.BLACK);
            TextView description = new TextView(this);
            description.setGravity(Gravity.CENTER);
            description.setTextColor(Color.BLACK);
            TextView points = new TextView(this);
            points.setGravity(Gravity.CENTER);
            points.setTextColor(Color.BLACK);

            CheckBox checkBox = new CheckBox(this);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        goal.questDone(quest);
//                        System.out.println(user.getCurrentRewardsRemaining());
                    }
                }
            });

            name.setText(quest.getName());
            description.setText(quest.getDescription());
            points.setText(String.valueOf(quest.getPoints()));
            tableRow.addView(name);
            tableRow.addView(description);
            tableRow.addView(points);
            tableRow.addView(checkBox);
            tableLayout.addView(tableRow);
        }
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

}
