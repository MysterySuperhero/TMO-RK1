package com.mysterysuperhero.tmork1.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmitri on 13.04.16.
 */
public class Requirements {
    public HashMap<String, ArrayList<String>> requirements;

    public Requirements() {
        requirements = new HashMap<>();

        ArrayList<String> paramsPK = new ArrayList<>();
        paramsPK.add(Value.K);
        paramsPK.add(Value.ALPHA);
        requirements.put(Value.P, paramsPK);

        ArrayList<String> paramsRN = new ArrayList<>();
        paramsRN.add(Value.N);
        paramsRN.add(Value.ALPHA);
        requirements.put(Value.R, paramsRN);

        ArrayList<String> paramsPKCO = new ArrayList<>();
        paramsPKCO.addAll(paramsPK);
        paramsPKCO.add(Value.N);
        requirements.put(Value.P_K_CHANNELS_OCCUP, paramsPKCO);

        requirements.put(Value.AVERAGE_COUNT_OCCUP_CHANNELS, paramsRN);

        requirements.put(Value.P_REQUEST_SERVICE, paramsRN);

        requirements.put(Value.P_OCCUP_CHANNEL, paramsRN);

        ArrayList<String> paramsPFOS = new ArrayList<>();
        paramsPFOS.addAll(paramsRN);
        paramsPFOS.add(Value.K);
        requirements.put(Value.P_FULL_OCCUP_SYS, paramsPFOS);

        ArrayList<String> paramsAVPCT = new ArrayList<>();
        paramsAVPCT.add(Value.MU);
        requirements.put(Value.AVER_OCCUP_CHANNEL_TIME, paramsAVPCT);

        requirements.put(Value.AVER_PLAIN_CHANNEL_TIME, paramsRN);

        paramsAVPCT.add(Value.N);
        requirements.put(Value.AVER_TIME_FULL_OCCUP_SYS, paramsAVPCT);

        requirements.put(Value.AVER_NOT_FULL_OCCUP_SYS, paramsPFOS);

        ArrayList<String> paramsAPTS = new ArrayList<>();
        paramsAPTS.add(Value.LAMBDA);
        requirements.put(Value.AVER_PLAIN_TIME_SYS, paramsAPTS);

        paramsAPTS.addAll(paramsRN);
        requirements.put(Value.AVER_TIME_STAY_REQUEST, paramsAPTS);

    }

}
