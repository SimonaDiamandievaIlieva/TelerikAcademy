package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        validatePassengerCapacity(passengerCapacity);
    }

    @Override
    void validatePassengerCapacity (int passengerCapacity) {
        super.validatePassengerCapacity(passengerCapacity);
        if (passengerCapacity < PASSENGER_BUS_MIN_VALUE || passengerCapacity > PASSENGER_BUS_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_BUS_ERROR);
        }
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getAsString() {
        return String.format( "%s\n",
               super.getAsString());
    }
    @Override
    public VehicleType getType() {
        return super.getType();
    }

    @Override
    public int getPassengerCapacity() {
        return super.getPassengerCapacity();
    }

    @Override
    public double getPricePerKilometer() {
        return super.getPricePerKilometer();
    }
}