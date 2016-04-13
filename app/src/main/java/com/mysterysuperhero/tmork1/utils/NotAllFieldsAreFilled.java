package com.mysterysuperhero.tmork1.utils;

/**
 * Created by dmitri on 13.04.16.
 */
public class NotAllFieldsAreFilled extends Exception {
    //Parameterless Constructor
    public NotAllFieldsAreFilled() {}

    //Constructor that accepts a message
    public NotAllFieldsAreFilled(String message)
    {
        super(message);
    }
}
