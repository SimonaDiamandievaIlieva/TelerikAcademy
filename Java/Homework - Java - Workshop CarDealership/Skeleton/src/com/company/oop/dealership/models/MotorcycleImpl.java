package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {
    private String category;
    private final int wheels = 2;

    private VehicleType type;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setCategory(category);
        setType(VehicleType.MOTORCYCLE);
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    private void setCategory(String category) {
        validateCategory(category);
        this.category = category;
    }

    void validateCategory(String category) {
        ValidationHelpers.validateIntRange(
                category.length(),
                CATEGORY_LEN_MIN,
                CATEGORY_LEN_MAX,
                CATEGORY_LEN_ERR);
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
                "Category: %s\n" +
                "%s", super.toString(), getCategory(), printComment());
    }
}
