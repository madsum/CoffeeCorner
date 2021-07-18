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
        String actualBaconRollPrice = AppProperties.getResourceByKey(AppProperties.baconRollPriceKey);
        String actualAppTitle = AppProperties.getResourceByKey(AppProperties.appTitleKey);

        assertEquals(TestData.expectedCoffeeName, actualName);
        assertEquals(TestData.expectedBaconRollPrice, actualBaconRollPrice);
        assertEquals(TestData.expectedAppTitle, actualAppTitle);
    }

    @Test
    public void testPropertyCorrectValue() throws IOException {

        assertEquals(TestData.expectedCurrencyType, AppProperties.getResourceByKey(AppProperties.currencyTypeKey));
        assertEquals(TestData.expectedCoffeeName, AppProperties.getResourceByKey(AppProperties.coffeeNameKey));

        assertEquals(TestData.expectedSmallCoffeePrice, AppProperties.getResourceByKey(AppProperties.smallCoffeePriceKey));
        assertEquals(TestData.expectedSmallCoffeeSize, AppProperties.getResourceByKey(AppProperties.smallCoffeeSizeKey));

        assertEquals(TestData.expectedMediumCoffeePrice, AppProperties.getResourceByKey(AppProperties.mediumCoffeePriceKey));
        assertEquals(TestData.expectedMediumCoffeeSize, AppProperties.getResourceByKey(AppProperties.mediumCoffeeSizeKey));

        assertEquals(TestData.expectedLargeCoffeePrice, AppProperties.getResourceByKey(AppProperties.largeCoffeePriceKey));
        assertEquals(TestData.expectedLargeCoffeeSize, AppProperties.getResourceByKey(AppProperties.largeCoffeeSizeKey));

        assertEquals(TestData.expectedOrangeJuiceName, AppProperties.getResourceByKey(AppProperties.orangeJuiceNameKey));
        assertEquals(TestData.expectedOrangeJuicePrice, AppProperties.getResourceByKey(AppProperties.orangeJuicePriceKey));
        assertEquals(TestData.expectedOrangeJuiceSize, AppProperties.getResourceByKey(AppProperties.orangeJuiceSizeKey));


        assertEquals(TestData.expectedBaconRollName, AppProperties.getResourceByKey(AppProperties.baconRollNameKey));
        assertEquals(TestData.expectedBaconRollPrice, AppProperties.getResourceByKey(AppProperties.baconRollPriceKey));

        assertEquals(TestData.expectedExtraMilkName, AppProperties.getResourceByKey(AppProperties.extraMilkNameKey));
        assertEquals(TestData.expectedExtraMilkPrice, AppProperties.getResourceByKey(AppProperties.extraMilkPriceKey));
        assertEquals(TestData.expectedFoamedMilkName, AppProperties.getResourceByKey(AppProperties.foamedMilkNameKey));
        assertEquals(TestData.expectedFoamedMilkPrice, AppProperties.getResourceByKey(AppProperties.foamedMilkPriceKey));
        assertEquals(TestData.expectedSpecialRoastCoffeeName, AppProperties.getResourceByKey(AppProperties.specialRoastCoffeeNameKey));
        assertEquals(TestData.expectedSpecialRoastCoffeePrice, AppProperties.getResourceByKey(AppProperties.specialRoastCoffeePriceKey));
    }
}
