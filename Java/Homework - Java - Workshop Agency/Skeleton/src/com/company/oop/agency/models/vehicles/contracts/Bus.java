package com.company.oop.agency.models.vehicles.contracts;

public interface Bus extends Vehicle {
    int PASSENGER_BUS_MIN_VALUE = 10;
    int PASSENGER_BUS_MAX_VALUE = 50;
    String PASSENGER_BUS_ERROR = String.format("A bus cannot have less than %s passengers or " +
            "more than %s passengers.", PASSENGER_BUS_MIN_VALUE, PASSENGER_BUS_MAX_VALUE);

}