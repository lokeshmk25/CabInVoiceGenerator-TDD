package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * creating class to add rides to the user
 */
public class RideRepository {
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * Purpose - Add rides to the user
     *
     * @param userId - for paticular user
     * @param rides  - array of rides by user
     */
    public void addRides(String userId, Ride[] rides) {
        this.userRides.computeIfAbsent(userId, k -> new ArrayList<>(Arrays.asList(rides)));
    }

    /**
     * @param userId - gets array of rides based on usrid
     * @return no of rides based of userid
     */
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
