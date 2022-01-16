package com.example.hercules.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.MainActivity;
import com.example.hercules.R;
import com.example.hercules.model.Goal;
import com.example.hercules.model.Quest;
import com.example.hercules.model.User;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public QuestsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestsFragment newInstance(String param1, String param2) {
        QuestsFragment fragment = new QuestsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



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
        User user = MainActivity.user;
        View view = inflater.inflate(R.layout.fragment_quests, container, false);
        Goal goal = user.getGoal();
        TableLayout tableLayout = null;
        try {
            tableLayout = (TableLayout) view.findViewById(R.id.questTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Quest> questsTodo = goal.getQuestsTodo();
        for (Quest quest: questsTodo) {
            TableRow tableRow = new TableRow(getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);
            TextView name = new TextView(getContext());
            TextView description = new TextView(getContext());
            TextView points = new TextView(getContext());
            name.setText(quest.getName());
            description.setText(quest.getDescription());
            points.setText(String.valueOf(quest.getPoints()));
            tableRow.addView(name);
            tableRow.addView(description);
            tableRow.addView(points);
            tableLayout.addView(tableRow);
        }


        return view;
    }
}