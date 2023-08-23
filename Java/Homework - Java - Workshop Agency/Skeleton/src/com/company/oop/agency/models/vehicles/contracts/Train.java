package com.company.oop.agency.models.vehicles.contracts;

public interface Train extends Vehicle {

     int PASSENGER_TRAIN_MIN_VALUE = 30;
     int PASSENGER_TRAIN_MAX_VALUE = 150;
     int CARTS_MIN_VALUE = 1;
     int CARTS_MAX_VALUE = 15;
     String TRAIN_PASSENGER_ERROR = String.format("A train cannot have less than %s passengers or more " +
             "than %s passengers.", PASSENGER_TRAIN_MIN_VALUE, PASSENGER_TRAIN_MAX_VALUE);
     String TRAIN_CARTS_ERROR = String.format("A train cannot have less than %s cart or more than %s carts."
             , CARTS_MIN_VALUE, CARTS_MAX_VALUE);

    int getCarts();

}