package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryImplTests {

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        CategoryImpl category = new CategoryImpl("Shampoos");
        Assertions.assertEquals("Shampoos", category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        CategoryImpl category = new CategoryImpl("Shampoos");
        Assertions.assertNotNull(category.getProducts());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        String name = "S";
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl(name));
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        CategoryImpl category = new CategoryImpl("Shampoos");
        ProductImpl product = new ProductImpl("Shampoo", "Nivea", 10, GenderType.WOMEN);
        category.addProduct(product);
        Assertions.assertEquals( 1, category.getProducts().size());
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        CategoryImpl category = new CategoryImpl("Shampoos");
        ProductImpl product = new ProductImpl("Shampoo", "Nivea", 10, GenderType.WOMEN);
        category.addProduct(product);
        Assertions.assertEquals( 1, category.getProducts().size());
        category.removeProduct(product);
        Assertions.assertEquals( 0, category.getProducts().size());
    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {
        CategoryImpl category = new CategoryImpl("Shampoos");
        ProductImpl product = new ProductImpl("Shampoo", "Nivea", 10, GenderType.WOMEN);
        ProductImpl product1 = new ProductImpl("Shampoo", "Nivea", 10, GenderType.MEN);
        category.addProduct(product);
        Assertions.assertEquals(1, category.getProducts().size());
        category.removeProduct(product1);
        Assertions.assertEquals(1, category.getProducts().size());
        }
}
