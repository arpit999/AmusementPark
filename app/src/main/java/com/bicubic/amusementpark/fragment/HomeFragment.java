package com.bicubic.amusementpark.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.ride.RidesActivity;
import com.bicubic.amusementpark.activity.FoodBeveragesActivity;
import com.bicubic.amusementpark.activity.SelectDateActivity;
import com.bicubic.amusementpark.activity.XochiActivity;
import com.bicubic.amusementpark.adapter.CustomPagerAdapter;
import com.bicubic.amusementpark.utils.ClickableViewPager;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Button bt_next, bt_previous;
    View rootView,bt_book_ticket;
    ClickableViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        FindIDs();

        viewPager.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

//                Toast.makeText(getActivity(), "Position : "+position, Toast.LENGTH_SHORT).show();

                switch (position){

                    case 0:
                        startActivity(new Intent(getActivity(), RidesActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), FoodBeveragesActivity.class));

                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), XochiActivity.class));
                        break;

                    default:

                        break;

                }


            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;

        if (context instanceof Activity) {
            a = (Activity) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_next:

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                break;
            case R.id.bt_previous:

                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);

                break;

            case R.id.bt_book_ticket:

                startActivity(new Intent(getActivity(), SelectDateActivity.class));

                break;
            default:


                break;


        }
    }

    public void FindIDs(){

        viewPager = (ClickableViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(getActivity()));

        bt_next = (Button) rootView.findViewById(R.id.bt_next);
        bt_previous =  (Button) rootView.findViewById(R.id.bt_previous);
        bt_book_ticket = rootView.findViewById(R.id.bt_book_ticket);

       /* MaterialRippleLayout.on(bt_next)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_previous)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();*/

        MaterialRippleLayout.on(bt_book_ticket)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        bt_next.setOnClickListener(this);
        bt_previous.setOnClickListener(this);
        bt_book_ticket.setOnClickListener(this);

    }

}
