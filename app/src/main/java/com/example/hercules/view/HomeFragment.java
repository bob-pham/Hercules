package com.example.hercules.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.R;
import com.example.hercules.model.SkinsOwned;
import com.example.hercules.model.User;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class HomeFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvExperienceLevel;
    private TextView tvWelcomeMessage;
    private TextView tvGoldVal;
    private TextView tvLongStreakVal;
    private TextView tvCurrStreakVal;
    private User user;

    private static HomeFragment instance;

//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
////

    private HomeFragment(User user) {
        this.user = user;
    }

    public static HomeFragment getInstance(User user) {
        if (instance == null || !instance.user.equals(user)) {
            instance = new HomeFragment(user);
        }
        return instance;
    }

    public User getUser() {
        return user;
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView avatar = view.findViewById(R.id.personalAvatarView);
        changePic(avatar, user.getCurrentAvatar());
//        avatar.setImageResource(MainActivity.user.getCurrentAvatar());
        tvWelcomeMessage = view.findViewById(R.id.welcomeTextView);
        tvWelcomeMessage.setText("Welcome, " + user.getAccount().getName());

        tvGoldVal = view.findViewById(R.id.tvGoldVal);
        tvGoldVal.setText(Integer.toString(user.getUserStats().getGold()));

        tvExperienceLevel = view.findViewById(R.id.tvExperienceLevel);
        tvExperienceLevel.setText("Level " + user.getUserStats().getLevel() + ":"); // Replace with user level

        tvCurrStreakVal = view.findViewById(R.id.tvCurrStreakVal);
        tvCurrStreakVal.setText(String.valueOf(user.getUserStats().getCurrentStreak()));

        tvLongStreakVal = view.findViewById(R.id.tvLongStreakVal);
        tvLongStreakVal.setText(String.valueOf(user.getUserStats().getLongestStreak()));

        return view;
    }

    private void changePic(ImageView skin, SkinsOwned currentSkin) {
        switch (currentSkin) {
            case DEFAULT:
                skin.setImageResource(R.drawable.defaultavatar);
                break;
            case RED:
                skin.setImageResource(R.drawable.redarmor);
                break;
            case PURPLE:
                skin.setImageResource(R.drawable.purplearmor);
                break;
            case TURTLE:
                skin.setImageResource(R.drawable.turtlearmor);
                break;
            case WIZARD:
                skin.setImageResource(R.drawable.wizardarmor);
                break;
            case EMERALD:
                skin.setImageResource(R.drawable.emeraldarmor);
                break;
            case FIRE:
                skin.setImageResource(R.drawable.firearmor);
                break;
            case GOD:
                skin.setImageResource(R.drawable.godarmor);
                break;
        }
    }
}