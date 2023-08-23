package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductRepositoryImplTests {

    private ProductRepository productRepository;

    @BeforeEach
    public void before () {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        Assertions.assertNotNull(productRepository.getProducts());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        Assertions.assertNotNull(productRepository.getCategories());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        Assertions.assertNotNull(productRepository.getCategories());
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        Assertions.assertNotNull(productRepository.getProducts());
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        String name = "TestCat";
        productRepository.createCategory(name);
        Assertions.assertTrue(productRepository.categoryExist(name));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        String name = "TestCat";
        productRepository.createCategory(name);
        Assertions.assertFalse(productRepository.categoryExist("name"));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        String name = "TestCat";
        String brand = "Nivea";
        double price = 10.5;
        GenderType gender = GenderType.WOMEN;
        productRepository.createProduct(name, brand, price, gender);
        Assertions.assertTrue(productRepository.productExist(name));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        String name = "TestCat";
        String brand = "Nivea";
        double price = 10.5;
        GenderType gender = GenderType.WOMEN;
        productRepository.createProduct(name, brand, price, gender);
        Assertions.assertFalse(productRepository.productExist("name"));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        String name = "TestCat";
        String brand = "Nivea";
        double price = 10.5;
        GenderType gender = GenderType.WOMEN;
        productRepository.createProduct(name, brand, price, gender);
        Assertions.assertEquals( 1, productRepository.getProducts().size());
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        String name = "TestCat";
        productRepository.createCategory(name);
        Assertions.assertEquals( 1, productRepository.getCategories().size());
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        String name = "TestCat";
        productRepository.createCategory(name);
        Assertions.assertEquals(productRepository.getCategories().get(0), productRepository.findCategoryByName(name));
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        String name = "TestCat";
        productRepository.createCategory(name);
        Assertions.assertThrows(InvalidUserInputException.class,() -> productRepository.findCategoryByName("doesntExist"));
    }

    @Test
    public void findProductByName_Should_ReturnProduct_When_Exists() {
        String name = "TestCat";
        String brand = "Nivea";
        double price = 10.5;
        GenderType gender = GenderType.WOMEN;
        productRepository.createProduct(name, brand, price, gender);
        Assertions.assertEquals(productRepository.getProducts().get(0), productRepository.findProductByName(name));
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        String name = "TestCat";
        String brand = "Nivea";
        double price = 10.5;
        GenderType gender = GenderType.WOMEN;
        productRepository.createProduct(name, brand, price, gender);
        Assertions.assertThrows(InvalidUserInputException.class,() -> productRepository.findProductByName("doesntExist"));
    }

}
