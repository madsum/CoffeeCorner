package org.example;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *  It manages all your input from the console.
 */
public class UserInputManager {
    private static int inputNumber = 0;
    private static Scanner scanner = null;
    public static boolean appContinue = true;

    public static int getInputNumber() {
        return inputNumber;
    }

    public static boolean handleInput(){
        String input;
        try {
            if(scanner == null){
                scanner = new Scanner(System.in);
            }
            input = scanner.nextLine();
            if(isNumeric(input)){
                inputNumber = Integer.parseInt(input);
            }else{
                if(input.compareToIgnoreCase("q") == 0){
                    appContinue = false;
                } else if(input.compareToIgnoreCase("") == 0){
                    return true;
                }
                else {
                    displayError();
                }
            }
            if(inputNumber < 0 ){
                throw new Exception("Invalid user input");
            }
        }catch (Exception e){
            displayError();
        }
        if(inputNumber == 0){
            return false;
        }
        return true;
    }

    private static boolean isNumeric(String inputStr){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (inputStr == null) {
            return false;
        }
        return pattern.matcher(inputStr).matches();
    }

    private static void displayError(){
        JOptionPane.showMessageDialog(null,
                "Invalid user input. Only number 0 to 8 is allowed", "Invalid user input", ERROR_MESSAGE);
        closeScanner();
        System.exit(-1);
    }

    /**
     * It is a known bug for Scanner that it must close only once per application when it is done.
     */
    public static void closeScanner(){
        if(scanner != null){
            scanner.close();
        }
    }
}
