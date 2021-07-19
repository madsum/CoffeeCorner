package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    public void testCoffeeBuildingByBuilder(){

        MenuItem coffee = new MenuItem.Builder()
                .name(TestData.expectedCoffeeName)
                .price(TestData.expectedSmallCoffeePriceDigit)
                .size(TestData.expectedSmallCoffeeSize)
                .quantity(1)
                .build();
        assertNotNull(coffee, "coffee must not be null");
        assertEquals(TestData.expectedSmallCoffeePriceDigit, coffee.getPrice());
        assertEquals(TestData.expectedSmallCoffeeSize, coffee.getSize());
        assertEquals(1, coffee.getQuantity());
    }

}
