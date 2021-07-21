package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePrinterTest {

    @Test
    void testPrintReceiptHeader(){
        ConsolePrinter.printReceiptHeader();

        var or =          new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.orangeJuiceNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.orangeJuicePriceKey)))
                .size(AppProperties.getResourceByKey(AppProperties.orangeJuiceSizeKey))
                .quantity(1)
                .itemNumber(MenuItemNumber.ORANGE_JUICE)
                .build();
        var sm =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.smallCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.smallCoffeeSizeKey))
                .itemNumber(MenuItemNumber.SMALL_COFFEE)
                .build();



        var mc =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.mediumCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.mediumCoffeeSizeKey))
                .itemNumber(MenuItemNumber.MEDIUM_COFFEE)
                .build();

        var lc =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.largeCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.largeCoffeeSizeKey))
                .itemNumber(MenuItemNumber.LARGE_COFFEE)
                .build();


        var br =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.baconRollNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.baconRollPriceKey)))
                .quantity(1)
                .size("")
                .itemNumber(MenuItemNumber.BACON_ROLL)
                .build();

        var em =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.extraMilkNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.extraMilkPriceKey)))
                .quantity(1)
                .size("")
                .itemNumber(MenuItemNumber.EXTRA_MILK)
                .build();

        var fm =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.foamedMilkNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.foamedMilkPriceKey)))
                .quantity(1)
                .size("")
                .itemNumber(MenuItemNumber.FOAMED_MILK)
                .build();

        var sr =  new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.specialRoastCoffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.specialRoastCoffeePriceKey)))
                .quantity(1)
                .size("")
                .itemNumber(MenuItemNumber.SPECIAL_ROAST_COFFEE)
                .build();

        ConsolePrinter.printReceiptItem(sm);
        ConsolePrinter.printReceiptItem(mc);
        ConsolePrinter.printReceiptItem(lc);
        ConsolePrinter.printReceiptItem(or);
        ConsolePrinter.printReceiptItem(br);
        ConsolePrinter.printReceiptItem(em);
        ConsolePrinter.printReceiptItem(fm);
        ConsolePrinter.printReceiptItem(sr);
        ConsolePrinter.printReceiptFooter(100.50f);
        ConsolePrinter.printContinue();
        ConsolePrinter.printThanks();

    }

}
