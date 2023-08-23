package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Constants;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;
import exceptions.InvalidNameLengthException;
import exceptions.InvalidUserInputException;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category, Constants {
    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidUserInputException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException("Category name", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format(
                    "#Category: %s%n" +
                    " #No product in this category",
                    name);
        }

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("#Category: %s%n", name));

        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(String.format(" ===%n"));
        }

        return strBuilder.toString();
    }
}
