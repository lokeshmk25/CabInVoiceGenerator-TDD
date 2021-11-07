package com.bridgelabz;

public class InvoiceService {
    private static final double MIN_COST_PER_KM = 10.0;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;
    private final RideRepository RideRepository;

    public InvoiceService() {
        this.RideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {

        RideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(RideRepository.getRides(userId));
    }
}
