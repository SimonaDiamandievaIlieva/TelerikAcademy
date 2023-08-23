package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateProductCommandTests {

    private Command command;
    private ProductRepositoryImpl productRepository;

    private List<String> parameters = new ArrayList<>();
    @BeforeEach
    public void before () {
        this.productRepository = new ProductRepositoryImpl();
        this.command = new CreateProductCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewProductToRepository_When_ValidParameters() {
        String name = "TestProd";
        String brand = "Nivea";
        String price = "10.5";
        String gender = "WOMEN";
        parameters.add(name);
        parameters.add(brand);
        parameters.add(price);
        parameters.add(gender);
        Assertions.assertEquals("Product with name TestProd was created!", command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateProductName() {
        String name = "TestProd";
        String brand = "Nivea";
        String price = "10.5";
        String gender = "WOMEN";
        parameters.add(name);
        parameters.add(brand);
        parameters.add(price);
        parameters.add(gender);
        command.execute(parameters);
        Assertions.assertThrows(DuplicateEntityException.class, () -> command.execute(parameters));
    }
    @Test
    public void tryParseDouble_Should_ThrowException_When_InvalidPrice(){
        String name = "TestProd";
        String brand = "Nivea";
        String price = "ten";
        String gender = "WOMEN";
        parameters.add(name);
        parameters.add(brand);
        parameters.add(price);
        parameters.add(gender);
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }

    @Test
    public void tryParseDouble_Should_ThrowException_When_InvalidGender(){
        String name = "TestProd";
        String brand = "Nivea";
        String price = "10";
        String gender = "boy";
        parameters.add(name);
        parameters.add(brand);
        parameters.add(price);
        parameters.add(gender);
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(parameters));
    }

}
