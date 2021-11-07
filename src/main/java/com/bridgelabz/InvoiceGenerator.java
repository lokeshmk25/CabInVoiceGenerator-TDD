package com.bridgelabz;

public class InvoiceGenerator {
    private static final double MIN_COST_PER_KM = 10.0;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare= distance*MIN_COST_PER_KM + time * COST_PER_MIN;
        if(totalFare<MINIMUM_FARE)
            return MINIMUM_FARE;
        else
            return totalFare;
    }
}
