package com.bridgelabz;

/**
 * class is created for calculating invoiceSummary ,add rides,calculating fare
 */
public class InvoiceService {
    private static final double MIN_COST_PER_KM = 10.0;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;
    private final RideRepository RideRepository;

    public InvoiceService() {
        this.RideRepository = new RideRepository();
    }

    /**
     * Purpose- To calculate Fair for Particular Ride
     *
     * @param distance - distance travelled
     * @param time     - Time taken
     * @return totalfare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Purpose - To calculate fair for array of rides
     *
     * @param rides array of rides
     * @return invoice summary
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Purpose - To add Rides to arraulist
     *
     * @param userId - Stores rides of particular user
     * @param rides  - array  of rides
     */
    public void addRides(String userId, Ride[] rides) {
        RideRepository.addRides(userId, rides);
    }

    /**
     * @param userId - Searches invoice summary based on userid
     * @return - Invoicesummary of a user
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(RideRepository.getRides(userId));
    }
}
