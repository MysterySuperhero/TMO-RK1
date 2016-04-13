package com.mysterysuperhero.tmork1.utils;

import android.util.Log;

import static java.lang.Math.pow;

/**
 * Created by dmitri on 13.04.16.
 */
public class Functions {

    public static double PKAlpha(long k, double alpha) {
        return pow(alpha, k) / factorial(k) * Math.exp(-alpha);
    }

    public static double RNAlpha(long n, double alpha) {
        double res = 0.0;
        double b = 0.0;
        Log.d("Start calculating", "!");
        for (long i = 0; i <= n; ++i) {
            b = PKAlpha(i, alpha);
            res += b;
        }
        Log.d("Finish calculating", "!");

        return res;
    }

    public static double PKOccupChannels(long k, long n, double alpha) {
        return PKAlpha(k, alpha) / PKAlpha(n, alpha);
    }

    public static double AverageCountOccupChannels(long n, double alpha) {
        return alpha * (RNAlpha(n - 1, alpha) / RNAlpha(n, alpha));
    }

    public static double PServiceRequest(long n, double alpha) {
        return 1 - (PKAlpha(n, alpha) / RNAlpha(n, alpha));
    }

    public static double POccupChannel(long n, double alpha) {
        return AverageCountOccupChannels(n , alpha) / n;
    }

    public static double PFullOccupSys(long n, double alpha) {
        return PKAlpha(n, alpha) / RNAlpha(n, alpha);
    }

    public static double AverTimeOccupChannel(double mu) {
        return 1 / mu;
    }

    public static double AverTimePlainChannel(long n, double alpha) {
        return (1 - POccupChannel(n, alpha)) / POccupChannel(n, alpha);
    }

    public static double AverTimeFullOccupSys(long n, double mu) {
        return 1 / (n * mu);
    }

    public static double AverTimeNotFullOccupSys(long n, double alpha) {
        return (1 - PFullOccupSys(n, alpha)) / PFullOccupSys(n, alpha);
    }

    public static double AverTimePlainSys(double lambda) {
        return 1 / lambda;
    }

    public static double AverTimeRequestInSys(long n, double alpha, double lambda) {
        return AverageCountOccupChannels(n, alpha) / lambda;
    }

    private static long factorial(long param) {
        long res = 1;

        for (long i = 1; i <= param; ++i) {
            res = res * i;
        }

        return res;
    }

}
