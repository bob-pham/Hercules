package com.example.hercules.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.R;
import com.example.hercules.model.SkinsOwned;
import com.example.hercules.model.User;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ClosetFragment#newInstance} factory method to
// * create an instance of this fragment.
// */

public class ClosetFragment extends Fragment {

    private User user;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static SkinsOwned avatar;
//    private int currentSkinInt;
    private SkinsOwned currentSkin;
    private Button prev;
    private Button next;
    private Button select;
    private ImageView skin;
    private ImageView coin;
    private ImageView check;
    private TextView gold;
    private TextView price;
    private TextView skinName;



    private static ClosetFragment instance;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    public ClosetFragment() {
//        // Required empty public constructor
//    }

    private ClosetFragment(User user) {
        this.user = user;
    }

    public static ClosetFragment getInstance(User user) {
        if (instance == null || !instance.user.equals(user)) {
            instance = new ClosetFragment(user);
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
//     * @return A new instance of fragment ClosetFragment.
//     */
////    // TODO: Rename and change types and number of parameters
//    public static ClosetFragment newInstance(String param1, String param2) {
//        ClosetFragment fragment = new ClosetFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//        // testing change
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
        currentSkin = user.getCurrentAvatar();
        View view = inflater.inflate(R.layout.fragment_closet, container, false);

        skin = view.findViewById(R.id.shown_avatar);
        coin = view.findViewById(R.id.price_coin);
        gold = view.findViewById(R.id.user_gold);
        price = view.findViewById(R.id.armor_price);
        skinName = view.findViewById(R.id.skin_name);
        prev = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);
        select = view.findViewById(R.id.select);
        check = view.findViewById(R.id.selected_check);

        gold.setText("$" + String.valueOf(user.getUserStats().getGold()));

        if (currentSkin.equals(avatar)) {
            check.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
        }

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSkin = currentSkin.prev();
                if (checkOwnSkin()) {
                    coin.setVisibility(View.INVISIBLE);
                    price.setVisibility(View.INVISIBLE);
                    select.setText("Select");
                } else {
                    coin.setVisibility(View.VISIBLE);
                    price.setVisibility(View.VISIBLE);
                    setPrice(price);
                    select.setText("Purchase");
                }
                changePic();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSkin = currentSkin.next();
                if (checkOwnSkin()) {
                    coin.setVisibility(View.INVISIBLE);
                    price.setVisibility(View.INVISIBLE);
                    select.setText("Select");
                } else {
                    coin.setVisibility(View.VISIBLE);
                    price.setVisibility(View.VISIBLE);
                    setPrice(price);
                    select.setText("Purchase");
                }
                changePic();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkOwnSkin()) {
                    user.setCurrentSkin(currentSkin);
                    avatar = currentSkin;
                    check.setVisibility(View.VISIBLE);
                } else {
                    attemptPurchaseSkin();
                }
            }
        });
        changePic();
        return view;
    }

    private void attemptPurchaseSkin() {
        switch (currentSkin) {
            case RED:
                try {
                    user.getUserStats().purchase(7);
                    user.addSkin(SkinsOwned.RED);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case PURPLE:
                try {
                    user.getUserStats().purchase(20);
                    user.addSkin(SkinsOwned.PURPLE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case TURTLE:
                try {
                    user.getUserStats().purchase(100);
                    user.addSkin(SkinsOwned.TURTLE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case WIZARD:
                try {
                    user.getUserStats().purchase(200);
                    user.addSkin(SkinsOwned.WIZARD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case EMERALD:
                try {
                    user.getUserStats().purchase(1250);
                    user.addSkin(SkinsOwned.EMERALD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case FIRE:
                try {
                    user.getUserStats().purchase(3500);
                    user.addSkin(SkinsOwned.FIRE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case GOD:
                try {
                    user.getUserStats().purchase(5000);
                    user.addSkin(SkinsOwned.GOD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
        }
    }

    private void updateBought() {
        gold.setText("$" + String.valueOf(user.getUserStats().getGold()));
        select.setText("Select");
        coin.setVisibility(View.INVISIBLE);
        price.setVisibility(View.INVISIBLE);
    }

    private boolean checkOwnSkin() {
        switch (currentSkin) {
            case DEFAULT:
                return user.ownSkin(SkinsOwned.DEFAULT);
            case RED:
                return user.ownSkin(SkinsOwned.RED);
            case PURPLE:
                return user.ownSkin(SkinsOwned.PURPLE);
            case TURTLE:
                return user.ownSkin(SkinsOwned.TURTLE);
            case WIZARD:
                return user.ownSkin(SkinsOwned.WIZARD);
            case EMERALD:
                return user.ownSkin(SkinsOwned.EMERALD);
            case FIRE:
                return user.ownSkin(SkinsOwned.FIRE);
            case GOD:
                return user.ownSkin(SkinsOwned.GOD);
        }
        throw new RuntimeException("There doesn't exist such a skin");
    }

    private void setPrice(TextView price) {
        switch (currentSkin) {
            case RED:
                price.setText("$7");
                break;
            case PURPLE:
                price.setText("$20");
                break;
            case TURTLE:
                price.setText("$100");
                break;
            case WIZARD:
                price.setText("$200");
                break;
            case EMERALD:
                price.setText("$1250");
                break;
            case FIRE:
                price.setText("$3500");
                break;
            case GOD:
                price.setText("$5000");
                break;
            default:
                break;
        }
    }

    private void changePic() {
        switch (currentSkin) {
            case DEFAULT:
                skin.setImageResource(R.drawable.defaultavatar);
                skinName.setText("Default");
                break;
            case RED:
                skin.setImageResource(R.drawable.redarmor);
                skinName.setText("Red Armor");
                break;
            case PURPLE:
                skin.setImageResource(R.drawable.purplearmor);
                skinName.setText("Purple Armor");
                break;
            case TURTLE:
                skin.setImageResource(R.drawable.turtlearmor);
                skinName.setText("Turtle Armor");
                break;
            case WIZARD:
                skin.setImageResource(R.drawable.wizardarmor);
                skinName.setText("Wizard Armor");
                break;
            case EMERALD:
                skin.setImageResource(R.drawable.emeraldarmor);
                skinName.setText("Emerald Armor");
                break;
            case FIRE:
                skin.setImageResource(R.drawable.firearmor);
                skinName.setText("Fire Armor");
                break;
            case GOD:
                skin.setImageResource(R.drawable.godarmor);
                skinName.setText("God Armor");
                break;
        }

        if (currentSkin.equals(avatar)) {
            check.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
        }
    }
}