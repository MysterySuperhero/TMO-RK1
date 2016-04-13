package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysterysuperhero.tmork1.MainActivity;
import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.adapters.ValuesAdapter;
import com.mysterysuperhero.tmork1.utils.Value;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValuesFragment extends Fragment {

    private RecyclerView valuesView;

    private ArrayList<Value> data;

    public ValuesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_values, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Выбор значений");

        valuesView = (RecyclerView) getView().findViewById(R.id.values_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        assert valuesView != null;
        valuesView.setLayoutManager(layoutManager);

        final ValuesAdapter adapter = new ValuesAdapter(getActivity());

        //Apply this adapter to the RecyclerView
        valuesView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = adapter.getValues();
                ((MainActivity) getActivity()).switchFragmetns("InputParams");
            }
        });
    }

    public ArrayList<Value> getData() {
        return data;
    }


}
