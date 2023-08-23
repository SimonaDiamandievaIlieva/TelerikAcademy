package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.GenderType;
import exceptions.InvalidFormatExceptions;
import exceptions.InvalidNameExistingException;
import exceptions.InvalidParametersCountExceptions;
import exceptions.InvalidUserInputException;

import java.util.List;

public class CreateProductCommand implements Command {

    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    public static final int PARAMETERS_LENGTH = 4;

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) throws InvalidUserInputException {
        if (parameters.size() != PARAMETERS_LENGTH) {
            throw new InvalidParametersCountExceptions("CreateProduct", PARAMETERS_LENGTH);
        }
        double price;
        try {
            price = Double.parseDouble(parameters.get(2));
        }
        catch (NumberFormatException e) {
            throw new InvalidFormatExceptions("Third parameter should be price (real number).");
        }
        GenderType gender;
        try {
            gender = GenderType.valueOf(parameters.get(3).toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new InvalidFormatExceptions("Forth parameter should be one of Men, Women or Unisex.");
        }

        String name = parameters.get(0);
        String brand = parameters.get(1);

        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, GenderType gender)
            throws InvalidUserInputException{
        if (productRepository.productExist(name)) {
            throw new InvalidNameExistingException("Product", name);
        }

        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }
}
