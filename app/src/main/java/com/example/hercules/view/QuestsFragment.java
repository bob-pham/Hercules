package com.example.hercules.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.MainActivity;
import com.example.hercules.R;
import com.example.hercules.model.Quest;
import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Goal;

import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link QuestsFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class QuestsFragment extends Fragment {

    private MainActivity mainActivity;
    private Goal goal;
    private User user;
    private static QuestsFragment instance;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private QuestsFragment(User user) {
        this.user = user;
    }

    public static QuestsFragment getInstance(User user) {
        if (instance == null || !instance.user.equals(user)) {
            instance = new QuestsFragment(user);
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment QuestsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static QuestsFragment newInstance(String param1, String param2) {
//        QuestsFragment fragment = new QuestsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quests, container, false);
        mainActivity = MainActivity.getInstance();
        User user = mainActivity.getUser();
        this.user = user;
        goal = user.getGoal();
        addTable(view);
        return view;
    }

    public void addTable(View view) {
        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.quest_table);
        TableRow header = new TableRow(getContext());
        TextView nameColumn = new TextView(getContext());
        nameColumn.setText("Name");
        nameColumn.setGravity(Gravity.CENTER);
        nameColumn.setTextColor(Color.WHITE);
        nameColumn.setTypeface(null, Typeface.BOLD);
        nameColumn.setTextSize(16);
        header.addView(nameColumn);
        TextView descriptionColumn = new TextView(getContext());
        descriptionColumn.setText("Description");
        descriptionColumn.setTypeface(null, Typeface.BOLD);
        descriptionColumn.setTextColor(Color.WHITE);
        descriptionColumn.setGravity(Gravity.CENTER);
        descriptionColumn.setTextSize(16);
        header.addView(descriptionColumn);
        TextView goldsColumn = new TextView(getContext());
        goldsColumn.setTypeface(null, Typeface.BOLD);
        goldsColumn.setText("Golds");
        goldsColumn.setTextSize(16);
        goldsColumn.setTextColor(Color.WHITE);
        goldsColumn.setGravity(Gravity.CENTER);
        header.addView(goldsColumn);
        tableLayout.addView(header);
        List<Quest> questsTodo = goal.getQuestsTodo();
        for (Quest quest: questsTodo) {
            TableRow tableRow = new TableRow(getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            tableRow.setLayoutParams(lp);
            TextView name = new TextView(getContext());
            name.setGravity(Gravity.CENTER);
            name.setTextColor(Color.WHITE);
            name.setTypeface(null, Typeface.BOLD);
            name.setTextSize(14);
            TextView description = new TextView(getContext());
            description.setGravity(Gravity.CENTER);
            description.setTextColor(Color.WHITE);
            description.setTextSize(14);
            description.setTypeface(null, Typeface.BOLD);
            TextView golds = new TextView(getContext());
            golds.setGravity(Gravity.CENTER);
            golds.setTextColor(Color.WHITE);
            golds.setTextSize(14);
            golds.setTypeface(null, Typeface.BOLD);
            CheckBox checkBox = new CheckBox(getContext());
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
}