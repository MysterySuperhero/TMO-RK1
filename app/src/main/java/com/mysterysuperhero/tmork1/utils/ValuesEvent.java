package com.mysterysuperhero.tmork1.utils;


import java.util.ArrayList;

/**
 * Created by dmitri on 13.04.16.
 */
public class ValuesEvent {

    public ArrayList<Value> values;

    public ValuesEvent(ArrayList<Value> values) {
        this.values = new ArrayList<>();
        for (Value value: values) {
            if (value.getState()) {
                this.values.add(value);
            }
        }
    }

}
