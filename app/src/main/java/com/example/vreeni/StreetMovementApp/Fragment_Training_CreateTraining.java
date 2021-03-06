package com.example.vreeni.StreetMovementApp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by vreeni on 20/12/2017.
 */

/**
 * Fragment containing two buttons offering the user to choose between a customized workout and creating his/her own
 */
public class Fragment_Training_CreateTraining extends Fragment implements View.OnClickListener {
    private static final String LOG_TAG = "CreateTraining";
    private String activity;
    private String setting;
    private ParkourPark pk;


    public static Fragment_Training_CreateTraining newInstance(String act, String set, ParkourPark spot) {
        final Bundle bundle = new Bundle(); //to pass arguments to the next fragment
        Fragment_Training_CreateTraining fragment = new Fragment_Training_CreateTraining();
        bundle.putString("Activity", act);
        bundle.putString("Setting", set);
        bundle.putParcelable("TrainingLocation", spot);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            activity = getArguments().getString("Activity");
            setting = getArguments().getString("Setting");
            pk = getArguments().getParcelable("TrainingLocation");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_training, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnPredefWorkout = (Button) view.findViewById(R.id.btn_get_predef_workout);
        btnPredefWorkout.setOnClickListener(this);
        Button btnCreateYourOwnWorkout = (Button) view.findViewById(R.id.btn_create_your_own_workout);
        btnCreateYourOwnWorkout.setOnClickListener(this);

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        //information on the desired training so far
        Log.d(LOG_TAG, "training information: " + activity + ", " + setting);

        if (v.getId() == R.id.btn_get_predef_workout) {
//            fragment = new Fragment_Training_Level();

//        else if (v.getId() == R.id.btn_create_your_own_workout) {
            //OR IF CASE = OUTDOORS =>
            Fragment_Training_Level lvl = Fragment_Training_Level.newInstance(activity, setting, pk);
            ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, lvl, "LvlFragment")
                    .addToBackStack("LvlFragment")
                    .commit();
        }
        if (v.getId() == R.id.btn_create_your_own_workout) {

        }
    }

}



