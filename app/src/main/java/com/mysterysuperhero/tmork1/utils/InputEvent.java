package com.mysterysuperhero.tmork1.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmitri on 13.04.16.
 */
public class InputEvent {

    public ArrayList<Value> values;
    public HashMap<String, Double> params;


    public InputEvent(ArrayList<Value> values, HashMap<String, Double> params) {
        this.values = values;
        this.params = params;
    }
}
