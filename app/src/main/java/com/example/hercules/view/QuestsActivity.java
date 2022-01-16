package com.example.hercules.view;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hercules.R;
import com.example.hercules.model.Goal;
import com.example.hercules.model.Quest;

import java.util.List;

public class QuestsActivity extends AppCompatActivity {


    private Goal goal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quests);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.questTable);
        List<Quest> questsTodo = goal.getQuestsTodo();
        for (Quest quest: questsTodo) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);
            TextView name = new TextView(this);
            TextView description = new TextView(this);
            TextView points = new TextView(this);
            name.setText(quest.getName());
            description.setText(quest.getDescription());
            points.setText(String.valueOf(quest.getPoints()));
            tableRow.addView(name);
            tableRow.addView(description);
            tableRow.addView(points);
            tableLayout.addView(tableRow);
        }
    }


    public void setGoal(Goal goal) {
        this.goal = goal;
    }




}
