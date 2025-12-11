package com.metro.interfaces;

import com.metro.enums.CustomerType;

public interface FarePolicy {
	double calculateFare(double baseDistance, CustomerType type);
}