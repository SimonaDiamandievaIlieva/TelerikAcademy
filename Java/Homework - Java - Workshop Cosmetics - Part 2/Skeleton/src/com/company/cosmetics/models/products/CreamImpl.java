package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        setScent(scent);
    }

    private void setScent(ScentType scent) {
        this.scent = scent;
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
                " #Scent: %s \n" +
                " ===", getScent());
    }
    @Override
    public ScentType getScent() {
        return scent;
    }
}
