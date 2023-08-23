package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    private static final int MIN_PRODUCT_LENGTH = 3;
    private static final int MAX_PRODUCT_LENGTH = 10;
    private static final String PRODUCT_LENGTH_ERROR =
            "Please provide a field with length between " + MIN_PRODUCT_LENGTH + " and " + MAX_PRODUCT_LENGTH + " chars.";
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String BRAND_LENGTH_ERROR =
            "Please provide a field with length between" + MIN_BRAND_LENGTH + " and " + MAX_BRAND_LENGTH + " chars.";
    private static final String PRICE_ERROR = "Price can not be negative.";
    private static final int PRICE_MIN = 0;
    protected String productName;
    protected String brandName;
    protected double price;
    protected GenderType gender;

    public ProductBase(String name, String brand, double price, GenderType gender) {
        setProductsName(name);
        setBrandName(brand);
        setPrice(price);
        setGender(gender);
    }

    private void validateProductsNameLength (String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name can not be null.");
        }
        if (productName.length()< MIN_PRODUCT_LENGTH|| productName.length()> MAX_PRODUCT_LENGTH) {
            throw new IllegalArgumentException(PRODUCT_LENGTH_ERROR);
        }
    }

    private void setProductsName(String productsName) {
        validateProductsNameLength(productsName);
        this.productName = productsName;
    }

    private void validateBrandNameLength (String brandName) {
        if (brandName == null) {
            throw new IllegalArgumentException("Brand name can not be null.");
        }
        if (brandName.length()< MIN_BRAND_LENGTH || brandName.length()> MAX_BRAND_LENGTH) {
            throw new IllegalArgumentException(BRAND_LENGTH_ERROR);
        }
    }

    private void setBrandName(String brandName) {
        validateBrandNameLength(brandName);
        this.brandName = brandName;
    }

    private void validatePrice (double price) {
        if (price < PRICE_MIN) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
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
        return String.format("#%s %s \n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s\n", productName, brandName, price, gender);
    }
}
