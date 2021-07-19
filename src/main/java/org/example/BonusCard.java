package org.example;

public class BonusCard {
    private static int purchaseCounter;

    public static void resetPurchaseCounter(){
        purchaseCounter = 0;
    }

    public static int getPurchaseCounter() {
        return purchaseCounter;
    }


    public static void addPurchaseCount(){
        purchaseCounter += 1;
    }
}
