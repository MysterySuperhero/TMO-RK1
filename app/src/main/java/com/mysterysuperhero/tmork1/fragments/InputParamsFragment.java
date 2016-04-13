package com.mysterysuperhero.tmork1.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mysterysuperhero.tmork1.MainActivity;
import com.mysterysuperhero.tmork1.R;
import com.mysterysuperhero.tmork1.utils.NotAllFieldsAreFilled;
import com.mysterysuperhero.tmork1.utils.Value;
import com.mysterysuperhero.tmork1.utils.ValuesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputParamsFragment extends Fragment {

    private HashSet<String> reqs;
    private ArrayList<Value> values;
    private HashMap<String, Double> params;

    private EditText nEditTextView;
    private EditText kEditTextView;
    private EditText alphaEditTextView;
    private EditText muEditTextView;
    private EditText lambdaEditTextView;
    private ArrayList<EditText> visibleEdits = new ArrayList<>();

    private Button nextButton;

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

        nextButton = (Button) getView().findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    for (EditText edit : visibleEdits) {
                        if (edit.getText().toString().isEmpty()) {
                            throw new NotAllFieldsAreFilled("Введите все параметры!");
                        }
                    }
                } catch (NotAllFieldsAreFilled notAllFieldsAreFilled) {
                    Toast.makeText(getActivity(), notAllFieldsAreFilled.getMessage(), Toast.LENGTH_LONG).show();
                    notAllFieldsAreFilled.printStackTrace();
                    return;
                }

                params = new HashMap<>();
                for (EditText edit : visibleEdits) {
                    params.put(edit.getTag().toString(), Double.valueOf(edit.getText().toString()));
                }

                ((MainActivity) getActivity()).switchFragmetns("Results");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        visibleEdits.clear();

        for (String requirement : reqs) {
            switch (requirement) {
                case Value.N:
                    nEditTextView.setVisibility(View.VISIBLE);
                    visibleEdits.add(nEditTextView);
                    break;
                case Value.K:
                    kEditTextView.setVisibility(View.VISIBLE);
                    visibleEdits.add(kEditTextView);
                    break;
                case Value.ALPHA:
                    alphaEditTextView.findViewById(R.id.alpha_param_edit).setVisibility(View.VISIBLE);
                    visibleEdits.add(alphaEditTextView);
                    break;
                case Value.LAMBDA:
                    lambdaEditTextView.findViewById(R.id.lambda_param_edit).setVisibility(View.VISIBLE);
                    visibleEdits.add(lambdaEditTextView);
                    break;
                case Value.MU:
                    muEditTextView.findViewById(R.id.mu_param_edit).setVisibility(View.VISIBLE);
                    visibleEdits.add(muEditTextView);
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

    public HashMap<String, Double> getParams() {
        return this.params;
    }

    public ArrayList<Value> getValues() {
        return this.values;
    }

    @Subscribe
    public void onValuesEvent(ValuesEvent valuesEvent) {
        this.values = valuesEvent.values;
        this.reqs = valuesEvent.requirements;
    }
}
