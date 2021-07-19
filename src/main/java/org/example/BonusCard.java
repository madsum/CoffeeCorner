package org.example;

public class BonusCard {
    private int purchaseCounter;

    public void resetPurchaseCounter(){
        purchaseCounter = 0;
    }

    public int getPurchaseCounter() {
        return purchaseCounter;
    }


    public void addPurchaseCount(int purchaseCounter){
        purchaseCounter += purchaseCounter;
    }
}
