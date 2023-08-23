package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleImpl implements Vehicle, Printable {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.10;
    public static final double PRICE_MAX_VALUE = 2.50;
    public static final String VEHICLE_PASSENGER_ERROR =
            String.format("A vehicle with less than %s passengers or more than %s passengers cannot exist!",
                    PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final String VEHICLE_PRICE_ERROR =
            String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
                    PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType type;
    private int id;

    public VehicleImpl(int id, int passengerCapacity, double pricePerKilometer, VehicleType type) {
      setId(id);
      setPassengerCapacity(passengerCapacity);
      setPricePerKilometer(pricePerKilometer);
      setType(type);
    }

    protected void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

     void validatePassengerCapacity (int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(VEHICLE_PASSENGER_ERROR);
        }
    }

    protected void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    void validatePricePerKilometer (double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(VEHICLE_PRICE_ERROR);
        }
    }

    protected void setType(VehicleType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type can not be null.");
        }
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public VehicleType getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        String className = String.format("%s", getClass().getSimpleName().replace("Impl", ""));
        return String.format("%s ----\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s", className, passengerCapacity, pricePerKilometer, type);
    }
}