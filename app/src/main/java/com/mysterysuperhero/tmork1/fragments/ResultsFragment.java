package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.utils.InputEvent;
import com.mysterysuperhero.tmork1.utils.Value;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */

public class ResultsFragment extends Fragment {

    private ArrayList<Value> values;

    private HashMap<String, Double> params;

    public ResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Subscribe
    public void onInputEvent(InputEvent inputEvent) {
        Log.d("OMG", "!!!!!!!!!!!!!!!!!!!!!!!!");
    }

}
