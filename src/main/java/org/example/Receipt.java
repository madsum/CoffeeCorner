package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Receipt {
    private static List<ItemPriceCalculator> itemPriceCalculators = new ArrayList<>();
    private static boolean freeExtraCondition1 = false;
    private static boolean freeExtraCondition2 = false;

    /**
     * This adds menu items to generic list
     * @param itemNumber Enum for menu items
     * @param howMany how many same items
     */
    public static void addToReceipt(MenuItemNumber itemNumber, int howMany){
        switch (itemNumber){
            case SMALL_COFFEE -> {
                freeExtraCondition1 = true;
                var smallCoffee = Menu.getSmallCoffee();
                smallCoffee.setQuantity(howMany);
                itemPriceCalculators.add(smallCoffee);
            }
            case MEDIUM_COFFEE -> {
                freeExtraCondition1 = true;
                var mediumCoffee = Menu.getMediumCoffee();
                mediumCoffee.setQuantity(howMany);
                itemPriceCalculators.add(mediumCoffee);
            }
            case LARGE_COFFEE -> {
                freeExtraCondition1 = true;
                var largeCoffee = Menu.getLargeCoffee();
                largeCoffee.setQuantity(howMany);
                itemPriceCalculators.add(largeCoffee);
            }
            case ORANGE_JUICE -> {
                freeExtraCondition1 = true;
                var orangeJuice = Menu.getOrangeJuice();
                orangeJuice.setQuantity(howMany);
                itemPriceCalculators.add(orangeJuice);
            }
            case BACON_ROLL -> {
                freeExtraCondition2 = true;
                var baconRoll = Menu.getBaconRoll();
                baconRoll.setQuantity(howMany);
                itemPriceCalculators.add(baconRoll);
            }
            case EXTRA_MILK -> {
                var extraMilk = Menu.getExtraMilk();
                extraMilk.setQuantity(howMany);
                itemPriceCalculators.add(extraMilk);
            }
            case FOAMED_MILK -> {
                var foamedMilk = Menu.getFoamedMilk();
                foamedMilk.setQuantity(howMany);
                itemPriceCalculators.add(foamedMilk);
            }
            case SPECIAL_ROAST_COFFEE -> {
                var specialRoastCoffee = Menu.getSpecialRoastCoffee();
                specialRoastCoffee.setQuantity(howMany);
                itemPriceCalculators.add(specialRoastCoffee);
            }
            default ->  {
                JOptionPane.showMessageDialog(null,
                        itemNumber+" invalid menu item. Only number 1 to 8 is allowed", "Invalid user input", ERROR_MESSAGE);
                System.exit(-1);
            }
        }
    }

    public static boolean isFreeExtraCondition1() {
        return freeExtraCondition1;
    }

    public static boolean isFreeExtraCondition2() {
        return freeExtraCondition2;
    }

    public static void resetItemPriceCalculators() {
        Receipt.itemPriceCalculators.clear();
    }

    public static List<ItemPriceCalculator> getItemPriceCalculators() {
        return itemPriceCalculators;
    }

    /**
     * Calculates total price and return the total price
     * @param bonusCard it is required to get the number of purchases and reset the purchase count
     * @return total price
     */
    public static float calculatePrice(BonusCard bonusCard) {
        Cart cart = new CartImpl();
        var wrapper = new Object() {
            float sum = 0f;
            BonusCard wrapperBonusCard = bonusCard;
            boolean freeExtra = false;
        };
        if( Receipt.isFreeExtraCondition1() &&
                Receipt.isFreeExtraCondition2()){
            wrapper.freeExtra = true;
        }

        itemPriceCalculators.forEach( item -> {
            wrapper.sum = wrapper.sum + item.getItemPrice(cart, wrapper.freeExtra, wrapper.wrapperBonusCard);
        });
        return wrapper.sum;
    } 

}
