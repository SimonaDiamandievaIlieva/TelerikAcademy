package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
         this.hasFreeFood = hasFreeFood;
    }
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getAsString() {
       return String.format( "%s\n" +
         "Has free food: %s\n", super.getAsString(), hasFreeFood);
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
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