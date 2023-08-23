package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    private static final int MIN_MILLILITER = 0;
    private static final String MILLILITERS_ERROR = "Milliliters can not be negative number";
    private int milliliters;
    private UsageType type;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType type) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setType(type);
    }

    private void validateMilliliters (int milliliters) {
        if (milliliters < MIN_MILLILITER) {
            throw new IllegalArgumentException(MILLILITERS_ERROR);
        }
    }

    private void setMilliliters(int milliliters) {
        validateMilliliters(milliliters);
        this.milliliters = milliliters;
    }

    private void setType(UsageType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public String getBrand() {
        return brandName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                super.print() +
                " #Milliliters: %d\n" +
                " #Usege: %s\n" +
                " ===", getMilliliters(),getUsage());
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    @Override
    public UsageType getUsage() {
        return type;
    }
}
