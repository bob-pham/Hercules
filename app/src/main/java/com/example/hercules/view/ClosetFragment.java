package com.example.hercules.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClosetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClosetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int currentSkin = 0;
    private Button prev;
    private Button next;
    private Button select;
    public static int avatar = 0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClosetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClosetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClosetFragment newInstance(String param1, String param2) {
        ClosetFragment fragment = new ClosetFragment();
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
        View view = inflater.inflate(R.layout.fragment_closet, container, false);
        ImageView skin = view.findViewById(R.id.shown_avatar);
        TextView skinName = view.findViewById(R.id.skin_name);
        prev = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);
        select = view.findViewById(R.id.select);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSkin > 0) {
                    currentSkin--;
                    changePic(skin, skinName);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSkin < 7) {
                    currentSkin++;
                    changePic(skin, skinName);
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avatar = currentSkin;
            }
        });

        return view;
    }

    private void changePic(ImageView skin, TextView skinName) {
        switch (currentSkin) {
            case 1:
                skin.setImageResource(R.drawable.redarmor);
                skinName.setText("Red Armor");
                break;
            case 2:
                skin.setImageResource(R.drawable.purplearmor);
                skinName.setText("Purple Armor");
                break;
            case 3:
                skin.setImageResource(R.drawable.turtlearmor);
                skinName.setText("Turtle Armor");
                break;
            case 4:
                skin.setImageResource(R.drawable.wizardarmor);
                skinName.setText("Wizard Armor");
                break;
            case 5:
                skin.setImageResource(R.drawable.emeraldarmor);
                skinName.setText("Emerald Armor");
                break;
            case 6:
                skin.setImageResource(R.drawable.firearmor);
                skinName.setText("Fire Armor");
                break;
            case 7:
                skin.setImageResource(R.drawable.godarmor);
                skinName.setText("God Armor");
                break;
            default:
                skin.setImageResource(R.drawable.defaultavatar);
                skinName.setText("Default");
                currentSkin = 0;
                break;
        }
    }
}