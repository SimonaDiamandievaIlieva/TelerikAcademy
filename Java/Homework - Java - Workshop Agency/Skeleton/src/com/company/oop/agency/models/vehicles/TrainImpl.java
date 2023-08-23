package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        validatePassengerCapacity(passengerCapacity);
        setCarts(carts);
    }
    @Override
    protected void validatePassengerCapacity (int passengerCapacity) {
        super.validatePassengerCapacity(passengerCapacity);
        if (passengerCapacity < PASSENGER_TRAIN_MIN_VALUE || passengerCapacity > PASSENGER_TRAIN_MAX_VALUE) {
            throw new IllegalArgumentException(TRAIN_PASSENGER_ERROR);
        }
    }
    private void validateCarts (int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(TRAIN_CARTS_ERROR);
        }
    }

     private void setCarts(int carts) {
        validateCarts(carts);
        this.carts = carts;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getAsString() {
        return String.format( "%s\n" +
                "Carts amount: %d\n", super.getAsString(), getCarts());
    }
    @Override
    public int getCarts() {
        return carts;
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