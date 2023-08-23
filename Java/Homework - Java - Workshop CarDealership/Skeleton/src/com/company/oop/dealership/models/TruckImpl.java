package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;


public class TruckImpl extends VehicleBase implements Truck {

    private int weightCapacity;
    private final int wheels = 8;
    private VehicleType type;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setWeightCapacity(weightCapacity);
        setType(VehicleType.TRUCK);
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    private void setType(VehicleType type) {
        if (type == null) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        this.type = type;
    }

    private void setWeightCapacity(int weightCapacity) {
        validateWeightCapacity(weightCapacity);
        this.weightCapacity = weightCapacity;
    }

    void validateWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(
                weightCapacity,
                WEIGHT_CAP_MIN,
                WEIGHT_CAP_MAX,
                WEIGHT_CAP_ERR);
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Weight Capacity: %dt\n" +
                "%s", super.toString(), getWeightCapacity(), printComment());
    }
}
