package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.utils.ValuesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputParamsFragment extends Fragment {

    public InputParamsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onStart();
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_params, container, false);
    }

    @Subscribe
    public void onValuesEvent(ValuesEvent valuesEvent) {
        Log.d("OMG", "!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
