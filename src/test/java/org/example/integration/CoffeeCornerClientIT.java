package org.example.integration;

import org.example.BonusCard;
import org.example.ConsolePrinter;
import org.example.MenuItemNumber;
import org.example.Receipt;
import org.example.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeCornerClientIT {

    @Test
    void testNormalOrder(){
        BonusCard bonusCard = new BonusCard();
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.ORANGE_JUICE, 1);
        float expectedPrice = TestData.expectedSmallCoffeePriceDigit +
                               TestData.expectedOrangeJuicePriceDigit;
        float actualTotalPrice = Receipt.calculatePrice(bonusCard);
        assertEquals(expectedPrice, actualTotalPrice);
    }

    @Test
    void testFreeExtra(){
        BonusCard bonusCard = new BonusCard();
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.BACON_ROLL, 1);
        Receipt.addToReceipt(MenuItemNumber.EXTRA_MILK, 2);
        float expectedPrice = TestData.expectedSmallCoffeePriceDigit +
                TestData.expectedBaconRollPriceDigit+
                TestData.expectedExtraMilkPriceDigit;
        float actualTotalPrice = Receipt.calculatePrice(bonusCard);
        assertEquals(expectedPrice, actualTotalPrice);
    }

    @Test
    void testSimulatedFreeDrink(){
        BonusCard bonusCard = new BonusCard();
        bonusCard.addPurchaseCount(5);
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        float expectedPrice = 0;
        float actualTotalPrice = Receipt.calculatePrice(bonusCard);
        assertEquals(expectedPrice, actualTotalPrice);
    }

    @Test
    void testAllMenuItemPurchasedOne(){
        // Since all items each, so we expect 1 free extra when beverage and a snack in the same order.
        float expectedTotalPrice = TestData.expectedSmallCoffeePriceDigit +
                              TestData.expectedMediumCoffeePriceDigit +
                              TestData.expectedLargeCoffeePriceDigit +
                              TestData.expectedOrangeJuicePriceDigit +
                              TestData.expectedBaconRollPriceDigit +
                              TestData.expectedFoamedMilkPriceDigit +
                              TestData.expectedSpecialRoastCoffeePriceDigit;
        BonusCard bonusCard = new BonusCard();
        Receipt.addToReceipt(MenuItemNumber.SMALL_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.MEDIUM_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.LARGE_COFFEE, 1);
        Receipt.addToReceipt(MenuItemNumber.ORANGE_JUICE, 1);
        Receipt.addToReceipt(MenuItemNumber.BACON_ROLL, 1);
        Receipt.addToReceipt(MenuItemNumber.EXTRA_MILK, 1);
        Receipt.addToReceipt(MenuItemNumber.FOAMED_MILK, 1);
        Receipt.addToReceipt(MenuItemNumber.SPECIAL_ROAST_COFFEE, 1);
        ConsolePrinter.printReceiptHeader();

        float actualTotalPrice = Receipt.calculatePrice(bonusCard);
        assertEquals(expectedTotalPrice, actualTotalPrice);

        ConsolePrinter.printReceiptFooter(actualTotalPrice);
        ConsolePrinter.printThanks();
    }

}
