package com.bicubic.amusementpark.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bicubic.amusementpark.R;

/**
 * Created by admin on 15-Nov-16.
 */

public class VideoViewDialogFragment extends AppCompatDialogFragment{

    // Declare variables
    ProgressDialog pDialog;
    VideoView videoview;
    View rootView;

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dialog_imageview, container, false);

            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        videoview = (VideoView) rootView.findViewById(R.id.videoView);
        // Create a progressbar
        pDialog = new ProgressDialog(getActivity());
        // Set progressbar title
//        pDialog.setTitle("Android Video Streaming Tutorial");
        // Set progressbar message
        pDialog.setMessage("Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        // Show progressbar
        pDialog.show();

        Bundle bundle = getArguments();

        if (bundle != null) {

            try {
                // Start the MediaController
                MediaController mediacontroller = new MediaController(
                        getActivity());
                mediacontroller.setAnchorView(videoview);

                String imageLink = bundle.getString("link","");
                String name = bundle.getString("name","");

                // Get the URL from String VideoURL
//            Uri video = Uri.parse("http://192.168.1.201/botad/uploads/news/1478502322_1651245825.mp4");
//            Uri video = Uri.parse("http://192.168.1.201/botad/uploads/news/1478502619_1731315177.mp4");
                Uri video = Uri.parse(imageLink);
                videoview.setMediaController(mediacontroller);
                videoview.setVideoURI(video);

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
                pDialog.dismiss();
            }

        }
        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and video the video
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                pDialog.dismiss();
                videoview.start();
            }
        });

        MediaPlayer.OnErrorListener vidVwErrorListener = new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {       //if there was an error in trying to play the intro video

                Toast.makeText(getActivity(), "File format not supported", Toast.LENGTH_SHORT).show();

                pDialog.dismiss();

                return true;
            }
        };




        return rootView;
    }





}
