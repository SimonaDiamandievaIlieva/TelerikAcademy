package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {

    private List<String> ingredients;
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    private void setIngredients(List<String> ingredients) {
        validateIngredients(ingredients);
        this.ingredients = new ArrayList<>(ingredients);
    }

    private void validateIngredients (List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException("Ingredients can not be null.");
        }
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
                " #Ingredients: %s\n" +
                " ===", getIngredients());
    }
    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
