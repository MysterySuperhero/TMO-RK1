package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mysterysuperhero.tmork1.MainActivity;
import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.adapters.ValuesAdapter;
import com.mysterysuperhero.tmork1.utils.NoValuesChosen;
import com.mysterysuperhero.tmork1.utils.Value;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValuesFragment extends Fragment {

    private RecyclerView valuesView;

    private ValuesAdapter adapter;

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

        adapter = new ValuesAdapter(getActivity());

        //Apply this adapter to the RecyclerView
        valuesView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = adapter.getValues();
                boolean flag = false;
                for (Value d : data) {
                    if (d.getState()) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    try {
                        throw new NoValuesChosen("Выберите хотя бы одно значение!");
                    } catch (NoValuesChosen noValuesChosen) {
                        noValuesChosen.printStackTrace();
                        Toast.makeText(getActivity(), noValuesChosen.getMessage(), Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                ((MainActivity) getActivity()).switchFragmetns("InputParams");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (data != null)
            adapter.setValues(data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data", data);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            data = (ArrayList<Value>) savedInstanceState.getSerializable("data");
            for (Value d : data) {
                adapter.setValueState(d.getId(), d.getState());
            }
        }
    }

    public ArrayList<Value> getData() {
        return data;
    }


}
