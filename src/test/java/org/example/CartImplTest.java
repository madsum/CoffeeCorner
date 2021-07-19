package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartImplTest {

    @Test
    void testCheckFreeExtra(){
        var extraMilk = Menu.getExtraMilk();
        var smallCoffee = Menu.getSmallCoffee();
        var baconRoll = Menu.getBaconRoll();
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.BACON_ROLL, 1);
        Receipt.addToReceipt(MenuItemNumber.EXTRA_MILK, 1);
        float expectedTotal = TestData.expectedSmallCoffeePriceDigit+
                              TestData.expectedBaconRollPriceDigit;
        float actualTotal = Receipt.calculatePrice(1);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void testCheckFreeDrink(){
        var smallCoffee = Menu.getSmallCoffee();
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        float expectedTotal = 0;
        float actualTotal = Receipt.calculatePrice(4);
        assertEquals(expectedTotal, actualTotal);
    }

}
