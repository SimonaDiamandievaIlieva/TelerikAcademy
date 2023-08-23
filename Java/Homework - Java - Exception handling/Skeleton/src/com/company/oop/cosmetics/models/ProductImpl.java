package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Constants;
import com.company.oop.cosmetics.models.contracts.Product;
import exceptions.InvalidNameLengthException;
import exceptions.InvalidProductPriceException;
import exceptions.InvalidUserInputException;

public class ProductImpl implements Product, Constants {

    public static final int MIN_BRAND_NAME_LENGTH = 2;
    public static final int MIN_PRICE = 0;
    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidUserInputException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException("Product name", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) throws InvalidUserInputException {
        if (brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException("Product brand", MIN_BRAND_NAME_LENGTH, MAX_NAME_LENGTH);
        }
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) throws InvalidUserInputException {
        if (price < MIN_PRICE) {
            throw new InvalidProductPriceException();
        }
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }
}
