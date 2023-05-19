package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {

    public static final int MIN_LENGTH_NAME = 3;
    public static final int MAX_LENGTH_NAME = 10;
    public static final int MIN_LENGTH_BRAND = 2;
    public static final int MAX_LENGTH_BRAND = 10;
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public void setName(String name) {
        if (name.length() < MIN_LENGTH_NAME || name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("Product name’s length must be minimum 3 symbols and maximum 10 symbols.");
        }
        this.name = name;
    }

    public void setBrand(String brand) {
        if (brand.length() < MIN_LENGTH_BRAND || brand.length() > MAX_LENGTH_BRAND) {
            throw new IllegalArgumentException("Brand name’s length must be minimum 2 symbols and maximum 10 symbols.");
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can not be negative.");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String print() {

        return "#" + name + " " + brand + "\n" +
                "#Price: " + price + "\n" +
                "#Gender: " + gender.toString() + "\n===";
    }
    
}
