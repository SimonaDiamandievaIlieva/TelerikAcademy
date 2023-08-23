package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.models.contracts.Category;
import exceptions.InvalidParametersCountExceptions;
import exceptions.InvalidUserInputException;

import java.util.List;

public class ShowCategoryCommand implements Command {
    public static final int MAX_PARAMETER = 1;
    private final ProductRepository productRepository;

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) throws InvalidUserInputException {
        if (parameters.size() != MAX_PARAMETER) {
            throw new InvalidParametersCountExceptions("Show category", MAX_PARAMETER);
        }

        String categoryName = parameters.get(0);

        return showCategory(categoryName);
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);

        return category.print();
    }
}
