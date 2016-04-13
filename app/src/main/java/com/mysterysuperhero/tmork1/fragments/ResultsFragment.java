package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.adapters.ResultsAdapter;
import com.mysterysuperhero.tmork1.utils.Functions;
import com.mysterysuperhero.tmork1.utils.InputEvent;
import com.mysterysuperhero.tmork1.utils.Value;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;


public class ResultsFragment extends Fragment {

    private ArrayList<Value> values;

    private HashMap<String, Double> params;

    private RecyclerView resultsView;

    private ResultsAdapter adapter;

    public ResultsFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Результаты");

        resultsView = (RecyclerView) getView().findViewById(R.id.results_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        assert resultsView != null;
        resultsView.setLayoutManager(layoutManager);

        adapter = new ResultsAdapter(getResults());

        //Apply this adapter to the RecyclerView
        resultsView.setAdapter(adapter);
    }

    private ArrayList<String> getResults() {
        ArrayList<String> res = new ArrayList<>();
        for (Value value : values) {
            switch (value.getValue()) {
                case Value.P:
                    res.add(String.valueOf(
                            Value.P + ": " + Functions.PKAlpha(params.get(Value.K).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.R:
                    res.add(String.valueOf(
                            Value.R + ": " + Functions.RNAlpha(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.P_K_CHANNELS_OCCUP:
                    res.add(String.valueOf(
                            Value.P_K_CHANNELS_OCCUP + ": " + Functions.PKOccupChannels(
                                    params.get(Value.K).longValue(),
                                    params.get(Value.N).longValue(),
                                    params.get(Value.ALPHA))
                    ));
                    break;
                case Value.AVERAGE_COUNT_OCCUP_CHANNELS:
                    res.add(String.valueOf(
                            Value.AVERAGE_COUNT_OCCUP_CHANNELS + ": " + Functions.AverageCountOccupChannels(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.P_REQUEST_SERVICE:
                    res.add(String.valueOf(
                            Value.P_REQUEST_SERVICE + ": " + Functions.PServiceRequest(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.P_OCCUP_CHANNEL:
                    res.add(String.valueOf(
                            Value.P_OCCUP_CHANNEL + ": " + Functions.POccupChannel(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.P_FULL_OCCUP_SYS:
                    res.add(String.valueOf(
                            Value.P_FULL_OCCUP_SYS + ": " + Functions.PFullOccupSys(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.AVER_OCCUP_CHANNEL_TIME:
                    res.add(String.valueOf(
                            Value.AVER_OCCUP_CHANNEL_TIME + ": " + Functions.AverTimeOccupChannel(params.get(Value.MU))
                    ));
                    break;
                case Value.AVER_PLAIN_CHANNEL_TIME:
                    res.add(String.valueOf(
                            Value.AVER_PLAIN_CHANNEL_TIME + ": " + Functions.AverTimePlainChannel(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.AVER_TIME_FULL_OCCUP_SYS:
                    res.add(String.valueOf(
                            Value.AVER_TIME_FULL_OCCUP_SYS + ": " + Functions.AverTimeFullOccupSys(params.get(Value.N).longValue(), params.get(Value.MU))
                    ));
                    break;
                case Value.AVER_NOT_FULL_OCCUP_SYS:
                    res.add(String.valueOf(
                            Value.AVER_NOT_FULL_OCCUP_SYS + ": " + Functions.AverTimeNotFullOccupSys(params.get(Value.N).longValue(), params.get(Value.ALPHA))
                    ));
                    break;
                case Value.AVER_PLAIN_TIME_SYS:
                    res.add(String.valueOf(
                            Value.AVER_PLAIN_TIME_SYS + ": " + Functions.AverTimePlainSys(params.get(Value.LAMBDA))
                    ));
                    break;
                case Value.AVER_TIME_STAY_REQUEST:
                    res.add(String.valueOf(
                            Value.AVER_TIME_STAY_REQUEST + ": " + Functions.AverTimeRequestInSys(
                                    params.get(Value.N).longValue(),
                                    params.get(Value.ALPHA), params.get(Value.LAMBDA)
                            )
                    ));
                    break;
            }
        }
        return res;
    }

    @Subscribe
    public void onInputEvent(InputEvent inputEvent) {
        this.values = inputEvent.values;
        this.params = inputEvent.params;
    }

}
