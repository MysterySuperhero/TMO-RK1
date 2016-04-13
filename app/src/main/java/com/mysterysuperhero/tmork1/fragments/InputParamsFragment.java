package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mysterysuperhero.tmork1.MainActivity;
import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.adapters.ValuesAdapter;
import com.mysterysuperhero.tmork1.utils.Value;
import com.mysterysuperhero.tmork1.utils.ValuesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputParamsFragment extends Fragment {

    private HashSet<String> reqs;
    private EditText nEditTextView;
    private EditText kEditTextView;
    private EditText alphaEditTextView;
    private EditText muEditTextView;
    private EditText lambdaEditTextView;


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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Ввод параметров");

        nEditTextView = (EditText) getView().findViewById(R.id.n_param_edit);
        kEditTextView = (EditText) getView().findViewById(R.id.k_param_edit);
        alphaEditTextView= (EditText) getView().findViewById(R.id.alpha_param_edit);
        lambdaEditTextView = (EditText) getView().findViewById(R.id.lambda_param_edit);
        muEditTextView = (EditText) getView().findViewById(R.id.mu_param_edit);
    }

    @Override
    public void onStart() {
        super.onStart();

        for (String requirement : reqs) {
            switch (requirement) {
                case Value.N:
                    nEditTextView.setVisibility(View.VISIBLE);
                    break;
                case Value.K:
                    kEditTextView.setVisibility(View.VISIBLE);
                    break;
                case Value.ALPHA:
                    alphaEditTextView.findViewById(R.id.alpha_param_edit).setVisibility(View.VISIBLE);
                    break;
                case Value.LAMBDA:
                    lambdaEditTextView.findViewById(R.id.lambda_param_edit).setVisibility(View.VISIBLE);
                    break;
                case Value.MU:
                    muEditTextView.findViewById(R.id.mu_param_edit).setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        nEditTextView.setVisibility(View.GONE);
        kEditTextView.setVisibility(View.GONE);
        alphaEditTextView.setVisibility(View.GONE);
        lambdaEditTextView.setVisibility(View.GONE);
        muEditTextView.setVisibility(View.GONE);

        reqs.clear();
    }

    @Subscribe
    public void onValuesEvent(ValuesEvent valuesEvent) {
        reqs = valuesEvent.requirements;
    }
}
