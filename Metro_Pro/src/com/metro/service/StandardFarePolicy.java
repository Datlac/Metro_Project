package com.metro.service;

import com.metro.enums.CustomerType;
import com.metro.interfaces.FarePolicy;

public class StandardFarePolicy implements FarePolicy {

    private static final double BASE_FARE = 10000.0; 
    private static final double PER_STATION_FEE = 2000.0; 
    
    @Override
    public double calculateFare(double stationsCount, CustomerType type) {

        double total = BASE_FARE + (stationsCount * PER_STATION_FEE);


        switch (type) {
            case STUDENT:
                return total * 0.5; 
            case SENIOR:
                return total * 0.7; 
            case CHILD:
                return 0.0;         
            case ADULT:
            default:
                return total;       
        }
    }
}