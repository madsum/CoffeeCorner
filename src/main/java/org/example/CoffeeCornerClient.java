package org.example;


import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class CoffeeCornerClient {

    public BonusCard bonusCard;

    public static void main(String[] args){
        CoffeeCornerClient client = new CoffeeCornerClient();
        client.startApp();
    }

    public CoffeeCornerClient() {
        bonusCard = new BonusCard();
    }

    public void startApp() {
        while (UserInputManager.appContinue) {
            Menu.displayMenu();
            while (UserInputManager.handleInput()) {
                int itemNumber = UserInputManager.getInputNumber();
                System.out.printf("Same item how many: ");
                UserInputManager.handleInput();
                int howMany = UserInputManager.getInputNumber();
                if(howMany == 0){
                    JOptionPane.showMessageDialog(null,
                            "0 is not allowed you must select at least 1 or more times. Try again.", "Invalid user input", ERROR_MESSAGE);
                    System.exit(-1);
                }
                if(itemNumber < 1 || itemNumber > 8 ){
                    JOptionPane.showMessageDialog(null,
                            itemNumber+" menu number must be between 1 and 8. Try again.", "Invalid user input", ERROR_MESSAGE);
                    System.exit(-1);
                }

                MenuItemNumber menuItemNumber = MenuItemNumber.values()[itemNumber-1];
                Receipt.addToReceipt(menuItemNumber, howMany);
                Menu.displayMenu();
            }
            System.out.println("\n\n \t\t\t PAYMENT RECEIPT \n");
            float totalPrice = Receipt.calculatePrice(bonusCard.getPurchaseCounter());
            if (totalPrice == 0) {
                System.exit(0);
            }
            System.out.println("----------------------------------------------");
            System.out.println("TOTAL PRICE                            : " + totalPrice);
            System.out.println("Please pay " + totalPrice + " " +
                    AppProperties.getResourceByKey(AppProperties.currencyTypeKey) +
                    " Thanks!");
            bonusCard.addPurchaseCount(1);
            Receipt.resetItemPriceCalculators();
            System.out.println("If you want to continue more orders enter [enter], or q for quite: ");
            UserInputManager.handleInput();
        }
        System.out.println("THANKS FOR YOUR ORDERS. SEE YOU SOON :)\n");
        bonusCard.resetPurchaseCounter();
        UserInputManager.closeScanner();
    }

}

