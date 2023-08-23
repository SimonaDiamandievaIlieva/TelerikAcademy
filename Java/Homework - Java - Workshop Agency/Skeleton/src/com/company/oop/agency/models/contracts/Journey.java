package com.company.oop.agency.models.contracts;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public interface Journey extends Identifiable, Printable {
    int START_LOCATION_MIN_LENGTH = 5;
    int START_LOCATION_MAX_LENGTH = 25;
    int DESTINATION_MIN_LENGTH = 5;
    int DESTINATION_MAX_LENGTH = 25;
    String START_LOCATION_ERROR_MESSAGE =
            String.format("The StartingLocation's length cannot be less than %s or more than %s symbols long."
                    , START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH);
    String DESTINATION_ERROR_MESSAGE =
            String.format("The Destination's length cannot be less than %s or more than %s symbols long."
                    , DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH);
    int DISTANCE_MIN_VALUE = 5;
    int DISTANCE_MAX_VALUE = 5000;
    String DISTANCE_ERROR_MESSAGE =
            String.format("The Distance cannot be less than %s or more than %s kilometers."
                    , DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE);
    int getDistance();

    Vehicle getVehicle();

    String getStartLocation();

    String getDestination();

    double calculateTravelCosts();

}