package org.example;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppPropertiesTest {

    @Test
    public void testGetInstance() throws IOException {
        var appProperties = AppProperties.getInstance();
        assertNotNull(appProperties, "appProperties must not be null");
    }

    @Test
    public void testGetResourceByKey(){
        String actualName = AppProperties.getResourceByKey(AppProperties.coffeeNameKey);
        float actualBaconRollPrice = Float.parseFloat(AppProperties.getResourceByKey(AppProperties.baconRollPriceKey));
        String actualAppTitle = AppProperties.getResourceByKey(AppProperties.appTitleKey);

        assertEquals(TestData.expectedCoffeeName, actualName);
        assertEquals(TestData.expectedBaconRollPriceDigit, actualBaconRollPrice);
        assertEquals(TestData.expectedAppTitle, actualAppTitle);
    }

    @Test
    public void testPropertyCorrectValue() throws IOException {

        assertEquals(TestData.expectedCurrencyType, AppProperties.getResourceByKey(AppProperties.currencyTypeKey));
        assertEquals(TestData.expectedCoffeeName, AppProperties.getResourceByKey(AppProperties.coffeeNameKey));

        assertEquals(TestData.expectedSmallCoffeePriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.smallCoffeePriceKey)));
        assertEquals(TestData.expectedSmallCoffeeSize, AppProperties.getResourceByKey(AppProperties.smallCoffeeSizeKey));

        assertEquals(TestData.expectedMediumCoffeePriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.mediumCoffeePriceKey)));
        assertEquals(TestData.expectedMediumCoffeeSize, AppProperties.getResourceByKey(AppProperties.mediumCoffeeSizeKey));

        assertEquals(TestData.expectedLargeCoffeePriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.largeCoffeePriceKey)));
        assertEquals(TestData.expectedLargeCoffeeSize, AppProperties.getResourceByKey(AppProperties.largeCoffeeSizeKey));

        assertEquals(TestData.expectedOrangeJuiceName, AppProperties.getResourceByKey(AppProperties.orangeJuiceNameKey));
        assertEquals(TestData.expectedOrangeJuicePriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.orangeJuicePriceKey)));
        assertEquals(TestData.expectedOrangeJuiceSize, AppProperties.getResourceByKey(AppProperties.orangeJuiceSizeKey));


        assertEquals(TestData.expectedBaconRollName, AppProperties.getResourceByKey(AppProperties.baconRollNameKey));
        assertEquals(TestData.expectedBaconRollPriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.baconRollPriceKey)));

        assertEquals(TestData.expectedExtraMilkName, AppProperties.getResourceByKey(AppProperties.extraMilkNameKey));
        assertEquals(TestData.expectedExtraMilkPriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.extraMilkPriceKey)));
        assertEquals(TestData.expectedFoamedMilkName, AppProperties.getResourceByKey(AppProperties.foamedMilkNameKey));
        assertEquals(TestData.expectedFoamedMilkPriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.foamedMilkPriceKey)));
        assertEquals(TestData.expectedSpecialRoastCoffeeName, AppProperties.getResourceByKey(AppProperties.specialRoastCoffeeNameKey));
        assertEquals(TestData.expectedSpecialRoastCoffeePriceDigit, Float.parseFloat(AppProperties.getResourceByKey(AppProperties.specialRoastCoffeePriceKey)));
    }
}
