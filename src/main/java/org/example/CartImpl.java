package org.example;

public class CartImpl implements Cart {

    private String currency = AppProperties.getResourceByKey(AppProperties.currencyTypeKey);
    private BonusCard bonusCard = new BonusCard();
    private boolean onlyOneFreeExtra = false;
    private float itemTotal = 0f;

    public float printReceiptAndCalculation(MenuItem menuItem, boolean isFreeExtra, int purchaseCount) {
        if(checkFreeDrink(menuItem, purchaseCount)){
            return itemTotal;
        }
        return checkFreeExtra(menuItem, isFreeExtra);
    }

    public float checkFreeExtra(MenuItem menuItem, boolean isFreeExtra){
        itemTotal = menuItem.getPrice() * menuItem.getQuantity();
        // give 1 free extra when beverage and a snack in the same order
        if (menuItem.getPrice() < 1.0 && isFreeExtra && !onlyOneFreeExtra) {
            onlyOneFreeExtra = true;
            System.out.println("1 "+ menuItem.getName()+ " is for free 0 "+currency);
            if(menuItem.getQuantity() > 1){
                menuItem.setQuantity(menuItem.getQuantity() - 1);
                printItem(menuItem);
                return itemTotal;
            }else {
                return 0;
            }
        } else {
            printItem(menuItem);
            return itemTotal;
        }
    }

    public boolean checkFreeDrink(MenuItem menuItem, int purchaseCount ){
        boolean isFreeDrink = false;
        // give free drink on every 5th purchase
        if(purchaseCount >= 4){
            if(menuItem.getName().compareToIgnoreCase(AppProperties.getResourceByKey(
                    AppProperties.coffeeNameKey)) == 0 || menuItem.getName().compareToIgnoreCase(AppProperties.getResourceByKey(
                    AppProperties.orangeJuiceNameKey)) == 0){
                System.out.println("For every 5th purchase, you get a free drink.");
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
        float totalItem = menuItem.getPrice() * menuItem.getQuantity();
        System.out.println(
                menuItem.getQuantity() + " " +
                        menuItem.getName() + " " +
                        menuItem.getSize() + " per item costs " +
                        menuItem.getPrice() + " " +
                        currency + " = " +
                        + totalItem);
    }
}

