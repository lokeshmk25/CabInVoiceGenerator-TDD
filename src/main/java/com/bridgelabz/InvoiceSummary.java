package com.bridgelabz;

/**
 * @author Lokesh
 * Purpose- class Invoice summary is created to obtain noOfrides,totalFare and average fare
 */
public class InvoiceSummary {
    private final int noOfRides;
    private final double totalfare;
    private final double avgfare;


    public InvoiceSummary(int noOfRides, double totalfare) {
        this.noOfRides = noOfRides;
        this.totalfare = totalfare;
        this.avgfare = totalfare / noOfRides;
    }

    /**
     * @param o cecks for object equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides && Double.compare(that.totalfare, totalfare) == 0 && Double.compare(that.avgfare, avgfare) == 0;
    }

}
