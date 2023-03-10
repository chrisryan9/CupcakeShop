import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);

        String placeOrder = input.nextLine();

        ArrayList<Object> order = new ArrayList<>();

        if (placeOrder.equalsIgnoreCase("Y")) {

            order.add(LocalDate.now());
            order.add(LocalTime.now());

            System.out.println("Here is the menu");

            System.out.println("CUPCAKES: ");

            int itemNumber = 0;

            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;

                System.out.println(itemNumber + ".");

                cupcakeMenu.get(i).type();

                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());
                System.out.println();
            }

            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;

                System.out.println(itemNumber + ".");

                drinkMenu.get(i).type();

                System.out.println("Price: $" + drinkMenu.get(i).getPrice());
                System.out.println();
            }

        } else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;

        while (ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to " +
                    "order");

            int orderChoice = input.nextInt();

            input.nextLine();

            if (orderChoice == 1) {
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");

            } else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");

            } else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");

            } else if (orderChoice == 4) {
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");

            } else if (orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");

            } else if (orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");

            } else {
                System.out.println("Sorry, we don't seem to have that on the menu");
            }

            System.out.println("Would you like to continue ordering? (Y or N)");

            String continueOrder = input.nextLine();

            if (!continueOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }

        double orderTotal = 0.0;
        for (Object item : order) {
            if (item instanceof Cupcake) {
                orderTotal += ((Cupcake) item).getPrice();

            } else if (item instanceof Drink) {
                orderTotal += ((Drink) item).getPrice();
            }
        }

        System.out.println("\nOrder summary: ");
        System.out.println();

        for (Object item : order) {
            if (item instanceof Cupcake) {
                System.out.println(((Cupcake) item).type());
                System.out.println("Price: $" + ((Cupcake) item).getPrice());

            } else if (item instanceof Drink) {
                System.out.println(((Drink) item).type());
                System.out.println("Price: $" + ((Drink) item).getPrice());

            }
        }

        System.out.println("\nTotal: $" + orderTotal);

        new CreateFile();
        new WriteToFile(order);

    }


    class CreateFile {
        public CreateFile() {

            try {
                File salesData = new File("salesData.txt");

                if (salesData.createNewFile()) {
                    System.out.println("File created: " + salesData.getName());
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.out.println("An error occurred");
            }
        }
    }


    class WriteToFile {
        public WriteToFile(ArrayList<Object> order) {
            try {
                FileWriter fileWriter = new FileWriter("salesData.txt", true);
                PrintWriter salesWriter = new PrintWriter(fileWriter);

                for (int i = 0; i < order.size(); i++) {
                    salesWriter.println(order.get(i));
                }

                salesWriter.close();
                System.out.println("Successfully wrote to the file");

            } catch (IOException e) {
                System.out.println("An error occurred");
            }
        }
    }


}