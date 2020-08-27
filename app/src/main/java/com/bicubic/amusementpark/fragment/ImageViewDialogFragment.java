package com.bicubic.amusementpark.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.utils.TouchImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by admin on 15-Nov-16.
 */

public class ImageViewDialogFragment extends AppCompatDialogFragment{

    String image_link;
    //    Button bt_submit;
    View rootView;
    TouchImageView touchImageView;

//    @Override
//    public void onActivityCreated(Bundle arg0) {
//        super.onActivityCreated(arg0);
//        getDialog().getWindow()
//                .getAttributes().windowAnimations = R.style.DialogAnimation;
//    }

    @Override
    public int getTheme() {
        return R.style.DialogAnimation;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dialog_imageview, container, false);

            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        touchImageView = (TouchImageView)rootView.findViewById(R.id.imageView);

        Bundle bundle = getArguments();
        String imageLink = bundle.getString("link","");
//        String name = bundle.getString("name","");

        Picasso.with(getActivity())
                .load(imageLink)
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.placeholder)
                .into(touchImageView);

//        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();


        return rootView;
    }





}
