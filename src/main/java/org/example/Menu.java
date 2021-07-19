package org.example;

public class Menu {
    private static MenuItem smallCoffee;
    private static MenuItem mediumCoffee;
    private static MenuItem largeCoffee;
    private static MenuItem orangeJuice;
    private static MenuItem baconRoll;
    private static MenuItem extraMilk;
    private static MenuItem foamedMilk;
    private static MenuItem specialRoastCoffee;

    private Menu(Builder builder){
        smallCoffee = builder.smallCoffee;
        mediumCoffee = builder.mediumCoffee;
        largeCoffee = builder.largeCoffee;
        orangeJuice = builder.orangeJuice;
        baconRoll = builder.baconRoll;
        extraMilk = builder.extraMilk;
        foamedMilk = builder.foamedMilk;
        specialRoastCoffee = builder.specialRoastCoffee;
    }

    public static class Builder{
        private MenuItem smallCoffee;
        private MenuItem mediumCoffee;
        private MenuItem largeCoffee;
        private MenuItem orangeJuice;
        private MenuItem baconRoll;
        private MenuItem extraMilk;
        private MenuItem foamedMilk;
        private MenuItem specialRoastCoffee;

        public Builder smallCoffee(MenuItem smallCoffee){
            this.smallCoffee = smallCoffee;
            return this;
        }

        public Builder mediumCoffee(MenuItem mediumCoffee){
            this.mediumCoffee = mediumCoffee;
            return this;
        }

        public Builder largeCoffee(MenuItem largeCoffee){
            this.largeCoffee = largeCoffee;
            return this;
        }

        public Builder orangeJuice(MenuItem orangeJuice){
            this.orangeJuice = orangeJuice;
            return this;
        }

        public Builder baconRoll(MenuItem baconRoll){
            this.baconRoll = baconRoll;
            return this;
        }

        public Builder extraMilk(MenuItem extraMilk){
            this.extraMilk = extraMilk;
            return this;
        }

        public Builder foamedMilk(MenuItem foamedMilk){
            this.foamedMilk = foamedMilk;
            return this;
        }

        public Builder specialRoastCoffee(MenuItem specialRoastCoffee){
            this.specialRoastCoffee = specialRoastCoffee;
            return this;
        }

        public Menu build(){
            return new Menu(this);
        }
    }

    public static Menu makeMenu() {

        smallCoffee = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.smallCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.smallCoffeeSizeKey))
                .build();

        mediumCoffee = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.mediumCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.mediumCoffeeSizeKey))
                .build();
        largeCoffee = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.coffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.largeCoffeePriceKey)))
                .quantity(1)
                .size(AppProperties.getResourceByKey(AppProperties.largeCoffeeSizeKey))
                .build();

        orangeJuice = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.orangeJuiceNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.orangeJuicePriceKey)))
                .size(AppProperties.getResourceByKey(AppProperties.orangeJuiceSizeKey))
                .build();


        baconRoll = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.baconRollNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.baconRollPriceKey)))
                .build();
        extraMilk = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.extraMilkNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.extraMilkPriceKey)))
                .build();
        foamedMilk = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.foamedMilkNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.foamedMilkPriceKey)))
                .build();
        specialRoastCoffee = new MenuItem.Builder()
                .name(AppProperties.getResourceByKey(AppProperties.specialRoastCoffeeNameKey))
                .price(Float.parseFloat(AppProperties.getResourceByKey(AppProperties.specialRoastCoffeePriceKey)))
                .build();

        return new Builder()
                .smallCoffee(smallCoffee)
                .mediumCoffee(mediumCoffee)
                .largeCoffee(largeCoffee)
                .orangeJuice(orangeJuice)
                .baconRoll(baconRoll)
                .extraMilk(extraMilk)
                .foamedMilk(foamedMilk)
                .specialRoastCoffee(specialRoastCoffee)
                .build();
    }

    public static void displayMenu(){
        MenuItem smallCoffee = Menu.getSmallCoffee();
        MenuItem mediumCoffee = Menu.getMediumCoffee();
        MenuItem largeCoffee = Menu.getLargeCoffee();
        MenuItem orangeJuice = Menu.getOrangeJuice();
        MenuItem baconRoll = Menu.getBaconRoll();
        MenuItem extraMilk = Menu.getExtraMilk();
        MenuItem foamedMilk = Menu.getFoamedMilk();
        MenuItem specialRoastCoffee = Menu.getSpecialRoastCoffee();
        String currency = AppProperties.getResourceByKey(AppProperties.currencyTypeKey);
        System.out.println(AppProperties.getResourceByKey(AppProperties.appTitleKey)+" MENU");
        System.out.print(MenuItemNumber.SMALL_COFFEE.getValue()+". "+smallCoffee.getName()+" "+
                smallCoffee.getSize());
        System.out.printf(" Price: %.2f %s \n", smallCoffee.getPrice(), currency);
        System.out.print(MenuItemNumber.MEDIUM_COFFEE.getValue()+". "+mediumCoffee.getName()+" "+
                mediumCoffee.getSize());
        System.out.printf(" Price: %.2f %s \n",mediumCoffee.getPrice(),currency);
        System.out.print(MenuItemNumber.LARGE_COFFEE.getValue()+". "+largeCoffee.getName()+" "+
                largeCoffee.getSize());
        System.out.printf(" Price: %.2f %s \n",largeCoffee.getPrice(),currency);

        System.out.print(MenuItemNumber.ORANGE_JUICE.getValue()+". "+orangeJuice.getName()+" "+
                orangeJuice.getSize());
        System.out.printf(" Price: %.2f %s \n",orangeJuice.getPrice(),currency);

        System.out.print(MenuItemNumber.BACON_ROLL.getValue()+". "+baconRoll.getName());
        System.out.printf(" Price: %.2f %s \n",baconRoll.getPrice(),currency);
        System.out.println("Extras:-");
        System.out.print(MenuItemNumber.EXTRA_MILK.getValue()+". "+extraMilk.getName());
        System.out.printf(" Price: %.2f %s \n",extraMilk.getPrice(),currency);
        System.out.print(MenuItemNumber.FOAMED_MILK.getValue()+". "+foamedMilk.getName());
        System.out.printf(" Price: %.2f %s \n",foamedMilk.getPrice(),currency);
        System.out.print(MenuItemNumber.SPECIAL_ROAST_COFFEE.getValue()+". "+specialRoastCoffee.getName());
        System.out.printf(" Price: %.2f %s \n",specialRoastCoffee.getPrice(),currency);
        System.out.println("Enter 0 (zero) for the payment ");
        System.out.print("Please enter the menu number 0 to 8: ");
    }


    public static MenuItem getSmallCoffee() {
        if(smallCoffee == null){
            makeMenu();
        }
        return smallCoffee;
    }

    public static MenuItem getMediumCoffee() {
        if(mediumCoffee == null){
            makeMenu();
        }
        return mediumCoffee;
    }

    public static MenuItem getLargeCoffee() {
        if(largeCoffee == null){
            makeMenu();
        }
        return largeCoffee;
    }

    public static MenuItem getOrangeJuice() {
        if(orangeJuice == null){
            makeMenu();
        }
        return orangeJuice;
    }

    public static MenuItem getBaconRoll() {
        if(baconRoll == null){
            makeMenu();
        }
        return baconRoll;
    }

    public static MenuItem getExtraMilk() {
        if(extraMilk == null){
            makeMenu();
        }
        return extraMilk;
    }

    public static MenuItem getFoamedMilk() {
        if(foamedMilk == null){
            makeMenu();
        }
        return foamedMilk;
    }

    public static MenuItem getSpecialRoastCoffee() {
        if(specialRoastCoffee == null){
            makeMenu();
        }
        return specialRoastCoffee;
    }


}
