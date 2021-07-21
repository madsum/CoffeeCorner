package org.example;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class AppProperties {

    private static AppProperties instance = null;
    private static Map<String, String> resourceMap = new HashMap<>();
    public static final String currencyTypeKey = "currencyTypeKey";
    public static final String coffeeNameKey = "coffeeNameKey";
    public static final String smallCoffeePriceKey = "smallCoffeePriceKey";
    public static final String smallCoffeeSizeKey = "smallCoffeeSizeKey";
    public static final String mediumCoffeePriceKey = "mediumCoffeePriceKey";
    public static final String mediumCoffeeSizeKey = "mediumCoffeeSizeKey";
    public static final String largeCoffeePriceKey = "largeCoffeePriceKey";
    public static final String largeCoffeeSizeKey = "largeCoffeeSizeKey";
    public static final String orangeJuiceNameKey= "orangeJuiceNameKey";
    public static final String orangeJuicePriceKey= "orangeJuicePriceKey";
    public static final String orangeJuiceSizeKey= "orangeJuiceSizeKey";
    public static final String baconRollNameKey = "baconRollNameKey";
    public static final String baconRollPriceKey = "baconRollPriceKey";
    public static final String extraMilkNameKey= "extraMilkNameKey";
    public static final String extraMilkPriceKey= "extraMilkPriceKey";
    public static final String foamedMilkNameKey= "foamedMilkNameKey";
    public static final String foamedMilkPriceKey= "foamedMilkPriceKey";
    public static final String specialRoastCoffeeNameKey= "specialRoastCoffeeNameKey";
    public static final String specialRoastCoffeePriceKey= "specialRoastCoffeePriceKey";
    public static final String appTitleKey = "appTitleKey";
    public static final String paymentReceipt = "paymentReceipt";


    private AppProperties() {
        ResourceBundle resource = ResourceBundle.getBundle(
                "application", Locale.UK);
        resourceMap = convertResourceToMap(resource);

    }

    public static AppProperties getInstance(){
        if(instance == null){
            instance = new AppProperties();
        }
        return instance;
    }

    private Map<String, String> convertResourceToMap(ResourceBundle resource) {
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            resourceMap.put(key, resource.getString(key));
        }
        return resourceMap;
    }

    public static String getResourceByKey(String key){
        if(instance == null){
            instance = getInstance();
        }
        return resourceMap.get(key);
    }
}
