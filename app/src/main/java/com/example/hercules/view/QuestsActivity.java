package com.example.hercules.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hercules.MainActivity;
import com.example.hercules.R;
import com.example.hercules.model.Quest;
import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Goal;

import java.util.List;

public class QuestsActivity extends AppCompatActivity {

    private Goal goal;
    private User user;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = MainActivity.getInstance();
        User user = mainActivity.getUser();
        this.user = user;
        goal = user.getGoal();
        setContentView(R.layout.fragment_quests);
        addTable();
        }

    public void addTable() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.quest_table);
        TableRow header = new TableRow(this);
        TextView nameColumn = new TextView(this);
        nameColumn.setText("Name");
        nameColumn.setGravity(Gravity.CENTER);
        nameColumn.setTextColor(Color.WHITE);
        nameColumn.setTypeface(null, Typeface.BOLD);
        nameColumn.setTextSize(16);
        header.addView(nameColumn);
        TextView descriptionColumn = new TextView(this);
        descriptionColumn.setText("Description");
        descriptionColumn.setTypeface(null, Typeface.BOLD);
        descriptionColumn.setTextColor(Color.WHITE);
        descriptionColumn.setGravity(Gravity.CENTER);
        descriptionColumn.setTextSize(16);
        header.addView(descriptionColumn);
        TextView goldsColumn = new TextView(this);
        goldsColumn.setTypeface(null, Typeface.BOLD);
        goldsColumn.setText("Golds");
        goldsColumn.setTextSize(16);
        goldsColumn.setTextColor(Color.WHITE);
        goldsColumn.setGravity(Gravity.CENTER);
        header.addView(goldsColumn);
//        TextView checkBoxColumn = new TextView(this);
//        checkBoxColumn.setText("Done");
//        checkBoxColumn.setTextColor(Color.WHITE);
//        checkBoxColumn.setGravity(Gravity.CENTER);
//        checkBoxColumn.setTextSize(17);
//        header.addView(checkBoxColumn);
        tableLayout.addView(header);
//        tableLayout.setBackgroundColor(Color.RED);
        List<Quest> questsTodo = goal.getQuestsTodo();
        for (Quest quest: questsTodo) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            tableRow.setLayoutParams(lp);
            TextView name = new TextView(this);
            name.setGravity(Gravity.CENTER);
            name.setTextColor(Color.WHITE);
            name.setTypeface(null, Typeface.BOLD);
            name.setTextSize(14);
            TextView description = new TextView(this);
            description.setGravity(Gravity.CENTER);
            description.setTextColor(Color.WHITE);
            description.setTextSize(14);
            description.setTypeface(null, Typeface.BOLD);
            TextView golds = new TextView(this);
            golds.setGravity(Gravity.CENTER);
            golds.setTextColor(Color.WHITE);
            golds.setTextSize(14);
            golds.setTypeface(null, Typeface.BOLD);
            CheckBox checkBox = new CheckBox(this);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        goal.questDone(quest);
                    }
                }
            });

            name.setText(quest.getName());
            description.setText(quest.getDescription());
            golds.setText(String.valueOf(quest.getPoints()));
            tableRow.addView(name);
            tableRow.addView(description);
            tableRow.addView(golds);
            tableRow.addView(checkBox);
            tableRow.setBackgroundColor(Color.TRANSPARENT);
            tableLayout.addView(tableRow);
        }
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Override
    public void onBackPressed() {
        //your method call
        super.onBackPressed();

        Fragment fragment = null;
//        if (mainActivity.getLastPage()) {
//            fragment = new ClosetFragment();
//        } else {
//            fragment = new HomeFragment();
//        }

        mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
