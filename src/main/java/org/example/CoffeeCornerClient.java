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

    //

    /**
     * Application entry point. It loops until the user wants to exit the app.
     */
    public void startApp() {
        while (UserInputManager.appContinue) {
            Menu.displayMenu();
            while (UserInputManager.handleInput()) {
                int itemNumber = UserInputManager.getInputNumber();
                ConsolePrinter.printText("Same item how many: ");
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
            ConsolePrinter.printReceiptHeader();
            float totalPrice = Receipt.calculatePrice(bonusCard);
            if (totalPrice == 0) {
                System.exit(0);
            }
            ConsolePrinter.printReceiptFooter(totalPrice);
            bonusCard.addPurchaseCount(1);
            Receipt.resetItemPriceCalculators();
            ConsolePrinter.printContinue();
            UserInputManager.handleInput();
        }
        ConsolePrinter.printThanks();
        bonusCard.resetPurchaseCounter();
        UserInputManager.closeScanner();
    }

}

