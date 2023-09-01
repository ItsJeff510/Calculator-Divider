import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        int input = 0;
        HashMap<String, Double> people = new HashMap<>();
        HashMap<String, Double> amountToRecieve = new HashMap<>();
        HashMap<String, Double> amountToSend = new HashMap<>();
        String name;
        double value = 0.0;
        double money = -1.0;
        double total = 0.0;
        Scanner obj = new Scanner(System.in);
        while (input != 6) {
            System.out.println();
            printMenu();

            System.out.print("Enter in your option: ");
            input = Integer.parseInt(obj.nextLine());
            System.out.println();

            switch (input) {
                case 1 -> { // Case one takes care of adding one person with their paid values
                    System.out.print("Enter the name of the person: ");
                    name = obj.nextLine();
                    while (money != 0) {
                        System.out.print("Enter paid value (enter 0 when done): ");
                        money = Double.parseDouble(obj.nextLine());
                        value += money;
                        System.out.print("Current Total: $");
                        System.out.printf("%.2f\n", value);
                    }
                    people.put(name, value);
                    money = -1.0;
                    value = 0.0;
                }
                case 2 -> { // Case two takes all the people and values and displays them
                    for (String i : people.keySet()) {
                        System.out.printf("%s :", i);
                        System.out.printf(" $%.2f\n", people.get(i));
                    }
                }
                case 3 -> { // Case three takes the total and divides it evenly
                    for (Double i : people.values()) {
                        total += i;

                        System.out.print("\nThe total is: $");
                        System.out.printf("%.3f", total);
                    }
                    total /= people.size();
                    System.out.println();
                }
                case 4 -> { // Case 4 Takes care of giving everyone's proper pay value
                    if(total != 0) {
                        for (String i : people.keySet()) {
                            System.out.printf("\n%s", i);

                            if (people.get(i) - total < 0) {
                                System.out.print(" owes ");
                                System.out.printf("%.2f", Math.abs(people.get(i) - total));
                                amountToSend.put(i, Math.abs(people.get(i) - total));
                            } else {
                                System.out.print(" is owed ");
                                System.out.printf("%.2f", Math.abs(people.get(i) - total));
                                amountToRecieve.put(i, Math.abs(people.get(i) - total));
                            }
                        }
                    } else {
                        System.out.println("This method cannot be done, try dividing equally first.");
                    }
                    total = 0.0;
                    System.out.println();
                }
                case 5 -> { // Case 5 is meant to show who owes what to who
                    for (String i : amountToSend.keySet()) {
                        System.out.printf("\n%s owes %.2f", i, amountToSend.get(i) / amountToRecieve.size());
                    }
                    for (String i : amountToRecieve.keySet()) {
                        System.out.printf("\n%s is owed %.2f", i, amountToRecieve.get(i) / amountToSend.size());
                    }

                    amountToSend.clear();
                    amountToRecieve.clear();
                }
                case 6 -> { // Is an end statement meant to stop the While-loop
                    System.out.println("Thank you for using, Exiting!");
                }


                default -> System.out.println("\nThat is not an option, please try again!\n");
            }
        }
    }

    public static void printMenu() {
        System.out.printf("\n*****************************" +
                          "\n*            Menu           *" +
                          "\n*                           *" +
                          "\n* 1) Add new person         *" +
                          "\n* 2) List all people/values *" +
                          "\n* 3) Divide Equally         *" +
                          "\n* 4) Show who is owed       *" +
                          "\n* 5) Show who owes who      *" +
                          "\n* 6) Exit                   *" +
                          "\n*****************************\n");
    }
}

// Calculator divider project
/*
1) need a method to store all values based on who paid
    This method has been done utilizing a Hashmap to store both the name
    paired with value of amount paid

2) need to divide all numbers equally between people
    One method to do this can be by equally dividing everyones paid amount
    into equal amounts and pair them by such but gives off a huge complicated
    code. Another way to tackle this could be to get the total amount needed
    to be paid and subtracting it to find those who paid most. Dividing their
    amount by those who still owe and distribute as such.

3) need a method to update any new values given

Starting with just creating a method to store both a name and their value

*/