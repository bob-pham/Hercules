package com.example.hercules.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.hercules.MainActivity;
import com.example.hercules.R;
import com.example.hercules.model.SkinsOwned;
import com.example.hercules.model.User;

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
    public static int avatar = 0;
    private int currentSkin = 0;
    private Button prev;
    private Button next;
    private Button select;
    private ImageView skin;
    private ImageView coin;
    private ImageView check;
    private TextView gold;
    private TextView price;
    private TextView skinName;

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
        // testing change
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

        skin = view.findViewById(R.id.shown_avatar);
        coin = view.findViewById(R.id.price_coin);
        gold = view.findViewById(R.id.user_gold);
        price = view.findViewById(R.id.armor_price);
        skinName = view.findViewById(R.id.skin_name);
        prev = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);
        select = view.findViewById(R.id.select);
        check = view.findViewById(R.id.selected_check);

        gold.setText("$" + String.valueOf(MainActivity.user.getUserStats().getGold()));

        if (currentSkin == avatar) {
            check.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
        }

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSkin > 0) {
                    currentSkin--;
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
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSkin < 7) {
                    currentSkin++;
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
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkOwnSkin()) {
                    avatar = currentSkin;
                    check.setVisibility(View.VISIBLE);
                } else {
                    attemptPurchaseSkin();
                }
            }
        });

        return view;
    }

    private void attemptPurchaseSkin() {
        int currentGold = MainActivity.user.getUserStats().getGold();

        switch (currentSkin) {
            case 1:
                try {
                    MainActivity.user.getUserStats().purchase(7);
                    MainActivity.user.addSkin(SkinsOwned.RED);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 2:
                try {
                    MainActivity.user.getUserStats().purchase(20);
                    MainActivity.user.addSkin(SkinsOwned.PURPLE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 3:
                try {
                    MainActivity.user.getUserStats().purchase(100);
                    MainActivity.user.addSkin(SkinsOwned.TURTLE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 4:
                try {
                    MainActivity.user.getUserStats().purchase(200);
                    MainActivity.user.addSkin(SkinsOwned.WIZARD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 5:
                try {
                    MainActivity.user.getUserStats().purchase(1250);
                    MainActivity.user.addSkin(SkinsOwned.EMERALD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 6:
                try {
                    MainActivity.user.getUserStats().purchase(3500);
                    MainActivity.user.addSkin(SkinsOwned.FIRE);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
            case 7:
                try {
                    MainActivity.user.getUserStats().purchase(5000);
                    MainActivity.user.addSkin(SkinsOwned.GOD);
                    updateBought();
                } catch (Exception e) {
                    // Nothing
                }
                break;
        }

    }

    private void updateBought() {
        gold.setText("$" + String.valueOf(MainActivity.user.getUserStats().getGold()));
        select.setText("Select");
        coin.setVisibility(View.INVISIBLE);
        price.setVisibility(View.INVISIBLE);
    }

    private boolean checkOwnSkin() {
        User user = MainActivity.user;
        switch (currentSkin) {
            case 1:
                return user.ownSkin(SkinsOwned.RED);
            case 2:
                return user.ownSkin(SkinsOwned.PURPLE);
            case 3:
                return user.ownSkin(SkinsOwned.TURTLE);
            case 4:
                return user.ownSkin(SkinsOwned.WIZARD);
            case 5:
                return user.ownSkin(SkinsOwned.EMERALD);
            case 6:
                return user.ownSkin(SkinsOwned.FIRE);
            case 7:
                return user.ownSkin(SkinsOwned.GOD);
            default:
                return true;
        }
    }

    private void setPrice(TextView price) {
        switch (currentSkin) {
            case 1:
                price.setText("$7");
                break;
            case 2:
                price.setText("$20");
                break;
            case 3:
                price.setText("$100");
                break;
            case 4:
                price.setText("$200");
                break;
            case 5:
                price.setText("$1250");
                break;
            case 6:
                price.setText("$3500");
                break;
            case 7:
                price.setText("$5000");
                break;
            default:
                break;
        }
    }

    private void changePic() {
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
        if (currentSkin == avatar) {
            check.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
        }
    }
}