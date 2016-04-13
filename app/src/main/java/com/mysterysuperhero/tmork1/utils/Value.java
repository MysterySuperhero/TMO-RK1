package com.mysterysuperhero.tmork1.utils;

/**
 * Created by dmitri on 13.04.16.
 */
public class Value {
    String value;
    boolean state;
    int id;

    public Value(String value, boolean state, int id) {
        this.value = value;
        this.state = state;
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public boolean getState() {
        return this.state;
    }

    public int getId() {
        return this.id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
