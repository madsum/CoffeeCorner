package org.example;

/**
 *  This class checks all discount criteria and prints  menu items for payment receipt
 */
public class CartImpl implements Cart {

    private boolean onlyOneFreeExtra = false;
    private float itemTotal = 0f;

    /**
     * This prints each item added to the Receipt and then calculates the price.
     * @param menuItem Menu item
     * @param isFreeExtra boolean to check is free extra eligible
     * @param bonusCard
     * @return is to check purchase count and recent purchase count if the condition is fulfills.
     */
    public float printReceiptAndCalculation(MenuItem menuItem, boolean isFreeExtra, BonusCard bonusCard) {
        if(checkFreeDrink(menuItem, bonusCard)){
            return itemTotal;
        }
        return checkFreeExtra(menuItem, isFreeExtra);
    }

    /**
     *  Check the possibility for the free extra and return the price accordingly
     * @param menuItem Menu item
     * @param isFreeExtra boolean for free extra
     * @return the item total price for the item
     */
    public float checkFreeExtra(MenuItem menuItem, boolean isFreeExtra){
        itemTotal = menuItem.getPrice() * menuItem.getQuantity();
        // give 1 free extra when beverage and a snack in the same order
        if (menuItem.getPrice() < 1.0 && isFreeExtra && !onlyOneFreeExtra) {
            onlyOneFreeExtra = true;
            ConsolePrinter.printText("1 "+ menuItem.getName()+ " is for free 0 ");
            if(menuItem.getQuantity() > 1){
                menuItem.setQuantity(menuItem.getQuantity() - 1);
                printItem(menuItem);
                itemTotal = menuItem.getPrice() * menuItem.getQuantity();
                return itemTotal;
            }else {
                return 0;
            }
        } else {
            printItem(menuItem);
            return itemTotal;
        }
    }

    /**
     * Check the possibility for the free drink and return the price accordingly
     * @param menuItem
     * @param bonusCard
     * @return
     */
    public boolean checkFreeDrink(MenuItem menuItem, BonusCard bonusCard ){
        boolean isFreeDrink = false;
        // give free drink on every 5th purchase
        if(bonusCard.getPurchaseCounter() >= 4){
            if(menuItem.getName().compareToIgnoreCase(AppProperties.getResourceByKey(
                    AppProperties.coffeeNameKey)) == 0 || menuItem.getName().compareToIgnoreCase(AppProperties.getResourceByKey(
                    AppProperties.orangeJuiceNameKey)) == 0){
                ConsolePrinter.printText("For every 5th purchase, you get a free drink.");
                isFreeDrink = true;
                bonusCard.resetPurchaseCounter();
                if(menuItem.getQuantity() > 1){
                    menuItem.setQuantity(menuItem.getQuantity() - 1);
                    printItem(menuItem);
                    itemTotal = menuItem.getPrice() * menuItem.getQuantity();
                }else {
                    itemTotal = 0;
                }
            }
        }
        return isFreeDrink;
    }

    private void printItem(MenuItem menuItem){
        ConsolePrinter.printReceiptItem(menuItem);
    }
}

