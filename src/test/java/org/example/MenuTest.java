package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MenuTest {

    @Test
    public void testMakeMenu(){
        var menu =  Menu.makeMenu();
        assertNotNull(menu, "menu must to be null");
    }

    @Test
    public void testMenuContainsSmallCoffeeWithCorrectValues(){
        MenuItem smallCoffee = Menu.getSmallCoffee();
        assertNotNull(smallCoffee, "smallCoffee must to be null");
        assertEquals(TestData.expectedCoffeeName, smallCoffee.getName());
        assertEquals(TestData.expectedSmallCoffeePrice, smallCoffee.getPrice()+"");
        assertEquals(TestData.expectedSmallCoffeeSize, smallCoffee.getSize());
    }

    @Test
    public void testMenuContainsMediumCoffeeWithCorrectValues(){
        MenuItem mediumCoffee = Menu.getSmallCoffee();
        assertNotNull(mediumCoffee, "mediumCoffee must to be null");
        assertEquals(TestData.expectedCoffeeName, mediumCoffee.getName());
        assertEquals(TestData.expectedMediumCoffeePrice, mediumCoffee.getPrice()+"");
        assertEquals(TestData.expectedMediumCoffeePrice, mediumCoffee.getSize());
    }

    @Test
    public void testMenuContainsLargeCoffeeWithCorrectValues(){
        MenuItem largeCoffee = Menu.getLargeCoffee();
        assertNotNull(largeCoffee, "largeCoffee must to be null");
        assertEquals(TestData.expectedCoffeeName, largeCoffee.getName());
        assertEquals(TestData.expectedLargeCoffeePrice, largeCoffee.getPrice()+"");
        assertEquals(TestData.expectedLargeCoffeeSize, largeCoffee.getSize());
    }

    @Test
    public void testMenuContainsBaconRollWithCorrectValues(){
        MenuItem baconRoll = Menu.getBaconRoll();
        assertNotNull(baconRoll, "baconRoll must to be null");
        assertEquals(TestData.expectedBaconRollName, baconRoll.getName());
        assertEquals(TestData.expectedBaconRollPrice, baconRoll.getPrice()+"");
    }

    @Test
    public void testMenuContainsAllExtraWithCorrectValues(){
        MenuItem extraItem = Menu.getExtraMilk();
        assertNotNull(extraItem, "extraItem must to be null");
        assertEquals(TestData.expectedExtraMilkName, extraItem.getName());
        assertEquals(TestData.expectedExtraMilkPrice, extraItem.getPrice()+"");

        MenuItem foamedMilk = Menu.getFoamedMilk();
        assertNotNull(foamedMilk, "foamedMilk must to be null");
        assertEquals(TestData.expectedFoamedMilkName, foamedMilk.getName());
        assertEquals(TestData.expectedFoamedMilkPrice, foamedMilk.getPrice()+"");

        MenuItem specialRoastCoffee = Menu.getSpecialRoastCoffee();
        assertNotNull(specialRoastCoffee, "specialRoastCoffee must to be null");
        assertEquals(TestData.expectedSpecialRoastCoffeeName, specialRoastCoffee.getName());
        assertEquals(TestData.expectedSpecialRoastCoffeePrice, specialRoastCoffee.getPrice()+"");

    }

}
