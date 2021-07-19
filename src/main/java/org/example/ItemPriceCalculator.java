package org.example;

public interface ItemPriceCalculator {

    float getItemPrice(Cart cart, boolean isFreeExtra, BonusCard bonusCard);
}
