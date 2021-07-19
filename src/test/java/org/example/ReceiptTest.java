package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReceiptTest {

    @BeforeEach
    void tearDown() {
        Receipt.resetItemPriceCalculators();
    }

    @Test
    void testAddToReceipt(){
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE,2);
        Receipt.addToReceipt(MenuItemNumber.BACON_ROLL,2);
        var actualList = Receipt.getItemPriceCalculators();
        var actualCoffee = actualList.get(0);
        var actualBaconRoll = actualList.get(1);
        assertNotNull(actualList);
        assertNotNull(actualCoffee);
        assertNotNull(actualBaconRoll);
        assertEquals(2, actualList.size());
    }

    @Test
    void testCalculatePrice(){
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE,1);
        Receipt.addToReceipt(MenuItemNumber.BACON_ROLL,1);
        var calculatePrice = Receipt.calculatePrice(new BonusCard());
        assertEquals(TestData.expectedSmallCoffeePriceDigit+
                    TestData.expectedBaconRollPriceDigit, calculatePrice);
    }

}
