package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare);
    }

    @Test
    void givenLessDistanceandTime_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }

    @Test
    void givenMultipleRides_shouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expctedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expctedInvoiceSummary, summary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturn_InvoiceSummary() {
        String userId = "Lokesh";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 2.0, 1)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 46.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturn_InvoiceSummeryForPremiumRides() {
        String userId = "Loki";
        Ride[] rides = new Ride[]{new Ride(CabRide.PREMIUM, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
                new Ride(CabRide.PREMIUM, 2.0, 5)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 100.0);
        Assertions.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturn_InvoiceSummeryForNormalRides() {
        String userId = "Lokesh";
        Ride[] rides = new Ride[]{new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 1.0, 3),
                new Ride(CabRide.NORMAL, 10, 10)};
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(3, 148);
        Assertions.assertEquals(actualSummary, expectedSummary);
    }
}