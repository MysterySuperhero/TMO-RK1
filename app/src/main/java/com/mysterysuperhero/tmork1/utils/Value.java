package com.mysterysuperhero.tmork1.utils;

import java.util.HashSet;

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

//    public HashSet<String> getRequirements() {
//        return this.requirements;
//    }
//
//    public void setRequirements(HashSet<String> requirements) {
//        this.requirements = requirements;
//    }
//
//    public void addRequirement(String requirement) {
//        this.requirements.add(requirement);
//    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    // PARAMS
    public static final String N = "n";
    public static final String LAMBDA = "lambda";
    public static final String MU = "mu";
    public static final String ALPHA = "alpha";
    public static final String K = "k";

    // VALUES
    public static String P = "P(k, α)";
    public static String R = "R(n, α)";
    public static String P_K_CHANNELS_OCCUP = "Вероятность занятия k каналов";
    public static String AVERAGE_COUNT_OCCUP_CHANNELS = "Среднее число занятых каналов";
    public static String P_REQUEST_SERVICE = "Вероятность обслуживания заявки";
    public static String P_OCCUP_CHANNEL = "Вероятность занятости канала";
    public static String P_FULL_OCCUP_SYS = "Вероятность полной загрузки СМО";
    public static String AVER_OCCUP_CHANNEL_TIME = "Среднее время занятости канала";
    public static String AVER_PLAIN_CHANNEL_TIME = "Среднее время простоя канала";
    public static String AVER_TIME_FULL_OCCUP_SYS = "Среднее время полной загрузки системы";
    public static String AVER_NOT_FULL_OCCUP_SYS = "Среднее время неполной загрузки системы";
    public static String AVER_PLAIN_TIME_SYS = "Среднее время простоя СМО";
    public static String AVER_TIME_STAY_REQUEST = "Среднее время пребывания заявки в СМО";

}