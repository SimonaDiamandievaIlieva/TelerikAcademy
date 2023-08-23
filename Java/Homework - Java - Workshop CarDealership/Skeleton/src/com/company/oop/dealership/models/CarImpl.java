package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {
    private int seats;
    private final int wheels = 4;
    private VehicleType type;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price);
        setCarSeats(seats);
        setType(VehicleType.CAR);
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    private void setCarSeats(int seats) {
        validateCarSeats(seats);
        this.seats = seats;
    }

    void validateCarSeats(int seats) {
        ValidationHelpers.validateIntRange(
                seats,
                CAR_SEATS_MIN,
                CAR_SEATS_MAX,
                CAR_SEATS_ERR);
    }

    private void setType(VehicleType type) {
        if (type == null) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Seats: %d\n" +
                "%s", super.toString(), getSeats(), printComment());
    }
}
