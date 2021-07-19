package org.example;

public enum MenuItemNumber {
    SMALL_COFFEE(1),
    MEDIUM_COFFEE(2),
    LARGE_COFFEE(3),
    ORANGE_JUICE(4),
    BACON_ROLL(5),
    EXTRA_MILK(6),
    FOAMED_MILK(7),
    SPECIAL_ROAST_COFFEE(8);

    private final int itemNumber;

    private MenuItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getValue(){
        return itemNumber;
    }
}
