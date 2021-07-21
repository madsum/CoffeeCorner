package org.example;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *  This class is a wrapper for all console printing in formatted text. It has all static methods for console print.
 */
public class ConsolePrinter {

    private static String currency = AppProperties.getResourceByKey(AppProperties.currencyTypeKey);

    public static void printReceiptHeader(){
        System.out.printf("\n%40s",AppProperties.getResourceByKey(AppProperties.appTitleKey));
        System.out.printf("\n%35s\n",AppProperties.getResourceByKey(AppProperties.paymentReceipt));
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void printReceiptFooter(float totalPrice){
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("TOTAL PRICE  : %55.2f\n", totalPrice);
        System.out.println("Please pay " + totalPrice + " " +
                AppProperties.getResourceByKey(AppProperties.currencyTypeKey) +
                " Thanks!");
    }

    public static void printContinue(){
        System.out.println("If you want to continue more orders enter [enter], or q for quite: ");
    }

    public static void printThanks(){
        System.out.println("THANKS FOR YOUR ORDERS. SEE YOU SOON :)\n");
    }

    public static void printMenuHeader(){
        System.out.println(AppProperties.getResourceByKey(AppProperties.appTitleKey)+" MENU");
    }

    public static void printMenuItem(MenuItem menuItem ){
        System.out.println(menuItem.getMenuItemNumber().getValue()+". "+menuItem.getName()+" "+
                menuItem.getSize());
        System.out.printf("Price: %2.2f %s \n", menuItem.getPrice(), currency);
    }

    public static void printText(String string){
        System.out.println(string);
    }

    /**
     * It prints the payment receipt all texts are aligned according to their various length
     * @param menuItem
     */
    public static void printReceiptItem(MenuItem menuItem){
        float totalItem = menuItem.getPrice() * menuItem.getQuantity();
        switch (menuItem.getMenuItemNumber()){
            case SMALL_COFFEE -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + " per item costs " +
                                menuItem.getPrice() + " " +
                                currency );
                System.out.printf(" %25.6s  %2.2f\n","=",totalItem);
            }
            case MEDIUM_COFFEE -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + " per item costs " +
                                menuItem.getPrice() + " " +
                                currency);
                System.out.printf(" %24s  %2.2f\n","=",totalItem);
            }
            case LARGE_COFFEE -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + " per item costs " +
                                menuItem.getPrice() + " " +
                                currency);
                System.out.printf(" %25s  %2.2f\n","=",totalItem);
            }
            case ORANGE_JUICE -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + " per item costs " +
                                menuItem.getPrice() + " " +
                                currency );
                System.out.printf(" %s  %2.2f\n","=",totalItem);
            }
            case BACON_ROLL, EXTRA_MILK -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + "per item costs " +
                                menuItem.getPrice() + " " +
                                currency);
                System.out.printf(" %27s  %2.2f\n","=",totalItem);
            }
            case FOAMED_MILK -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + "per item costs " +
                                menuItem.getPrice() + " " +
                                currency);
                System.out.printf(" %26s  %2.2f\n","=",totalItem);
            }
            case SPECIAL_ROAST_COFFEE -> {
                System.out.printf(
                        menuItem.getQuantity() + " " +
                                menuItem.getName() + " " +
                                menuItem.getSize() + "per item costs " +
                                menuItem.getPrice() + " " +
                                currency);
                System.out.printf(" %17s  %2.2f\n","=",totalItem);
            }
            default ->  {
                JOptionPane.showMessageDialog(null,
                        menuItem.getMenuItemNumber()+" invalid menu item formatting", "Invalid menu formatting", ERROR_MESSAGE);
                System.exit(-1);
            }
        }
    }
}
