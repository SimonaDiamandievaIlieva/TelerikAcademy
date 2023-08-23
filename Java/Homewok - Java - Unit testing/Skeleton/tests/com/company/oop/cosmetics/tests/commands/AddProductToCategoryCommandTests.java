package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.AddProductToCategoryCommand;
import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AddProductToCategoryCommandTests {
    private AddProductToCategoryCommand command;
    private ProductRepositoryImpl productRepository;

    private CreateCategoryCommand commandCategory;
    private CreateProductCommand commandProduct;

    private List<String> parametersCategory = new ArrayList<>();
    private List<String> parametersProduct = new ArrayList<>();
    private List<String> parameters = new ArrayList<>();
    @BeforeEach
    public void before () {
        this.productRepository = new ProductRepositoryImpl();
        this.command = new AddProductToCategoryCommand(productRepository);
        this.commandCategory = new CreateCategoryCommand(productRepository);
        this.commandProduct = new CreateProductCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewProductToCategory_When_ValidParameters() {
        String categoryNameToAdd = "Shampoo";
        String productNameToAdd = "Nivea";
        String brand = "Nivea N";
        String price = "10.5";
        String gender = "WOMEN";
        parametersCategory.add(categoryNameToAdd);
        commandCategory.execute(parametersCategory);

        parametersProduct.add(productNameToAdd);
        parametersProduct.add(brand);
        parametersProduct.add(price);
        parametersProduct.add(gender);
        commandProduct.execute(parametersProduct);

        parameters.add(categoryNameToAdd);
        parameters.add(productNameToAdd);
        Assertions.assertEquals("Product Nivea added to category Shampoo!", command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }
}
