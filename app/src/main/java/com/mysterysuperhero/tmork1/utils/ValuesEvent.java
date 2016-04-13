package com.mysterysuperhero.tmork1.utils;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dmitri on 13.04.16.
 */
public class ValuesEvent {

    public ArrayList<Value> values;
    public HashSet<String> requirements;

    public ValuesEvent(ArrayList<Value> values) {
        this.values = new ArrayList<>();
        this.requirements = new HashSet<>();

        Requirements req = new Requirements();

        for (Value value: values) {
            if (value.getState()) {
                this.values.add(value);
                requirements.addAll(req.requirements.get(value.getValue()));
            }
        }
        Log.d("ValuesEvent constructor", "Finised");
    }

}
