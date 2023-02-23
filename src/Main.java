import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        ArrayList<Drink> drinkMenu = new ArrayList<>();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        //Drink menu
        System.out.println("We are in the middle of creating the drink menu. We currently have three types of drinks " +
                "the menu but we need to decide on pricing.");
        Thread.sleep(750);

        //Water Drink
        System.out.println("We are deciding on the price for our bottled water. Here is the description: ");
        water.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the water bottle? (Input a numerical number taken " +
                "to 2 decimal places)");
        Thread.sleep(750);
        String waterPriceText = input.nextLine();

        double waterPrice = Double.parseDouble(waterPriceText);
        water.setPrice(waterPrice);

        //Soda Drink
        System.out.println("We are deciding on the price for our bottle of soda. Here is the description: ");
        soda.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the soda bottle? (Input a numerical number taken " +
                "to 2 decimal places)");
        Thread.sleep(750);
        String sodaPriceText = input.nextLine();

        double sodaPrice = Double.parseDouble(sodaPriceText);
        soda.setPrice(sodaPrice);


        //Milk Drink
        System.out.println("We are deciding on the price for our bottle of milk. Here is the description: ");
        milk.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the milk bottle? (Input a numerical number taken " +
                "to 2 decimal places)");
        Thread.sleep(750);
        String milkPriceText = input.nextLine();

        double milkPrice = Double.parseDouble(milkPriceText);
        milk.setPrice(milkPrice);




        //cupcake menu
        System.out.println("We currently have three cupcakes on the menu but we need to decide on pricing.");
        Thread.sleep(750);


        //Generic Cupcake
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description: ");
        cupcake.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        Thread.sleep(750);

        String priceText = input.nextLine();

        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);


        //Red velvet cupcake
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description: ");
        redVelvet.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        Thread.sleep(750);

        String redPriceText = input.nextLine();

        double redPrice = Double.parseDouble(redPriceText);
        redVelvet.setPrice(redPrice);


        //Chocolate cupcake
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description: ");
        chocolate.type();
        Thread.sleep(750);

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        Thread.sleep(750);

        String chocoPriceText = input.nextLine();

        double chocoPrice = Double.parseDouble(chocoPriceText);
        chocolate.setPrice(chocoPrice);

        //Add cupcakes to cupcake menu
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        //Add Drinks to drink menu
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);

//        System.out.println(drinkMenu);
//        System.out.println(cupcakeMenu);
    }
}

    class Cupcake {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean type() {
            System.out.println("A basic, generic cupcake, with vanilla frosting");
            return true;
        }

        @Override
        public String toString() {
            return "Cupcake with price: $" + price;
        }
    }


    class RedVelvet extends Cupcake {
        public boolean type() {
            System.out.println("A red velvet flavored cupcake, with cream cheese frosting");
            return true;
        }

        @Override
        public String toString() {
            return "Red velvet with price: $" + price;
        }
    }

    class Chocolate extends Cupcake {
        public boolean type() {
            System.out.println("A chocolate flavored cupcake, with chocolate frosting");
            return true;
        }

        @Override
        public String toString() {
            return "Chocolate with price: $" + price;
        }
    }

    class Drink {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean type() {
            System.out.println("A bottle of water");
            return true;
        }

        @Override
        public String toString() {
            return "Water bottle: $" + price;
        }
    }

    class Soda extends Drink {
        public boolean type() {
            System.out.println("A bottle of soda");
            return true;
        }

        @Override
        public String toString() {
            return "Soda bottle: $" + price;
        }
    }

    class Milk extends Drink {
        @Override
        public boolean type() {
            System.out.println("A bottle of milk");
            return true;
        }

        @Override
        public String toString() {
            return "Milk bottle: $" + price;
        }
    }
