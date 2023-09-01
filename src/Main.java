import java.util.*;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        int input = 0;
        HashMap<String, Double> people = new HashMap<>();
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
                        System.out.println(value);
                        System.out.println();
                    }
                    people.put(name, value);
                    money = -1.0;
                    value = 0.0;
                }
                case 2 -> { // Case two takes all the people and values and displays them
                    for (String i : people.keySet()) {
                        System.out.println(i);
                        System.out.println(people.get(i));
                    }
                }
                case 3 -> { // Case three takes the total and divides it evenly
                    for (Double i : people.values()) {
                        total += i;

                        System.out.print("\nThe total is: $");
                        System.out.print(total);
                    }
                    total /= people.size();
                }
                case 4 -> {
                } // Case 4 Takes care of giving everyones proper pay value

                default -> System.out.println("\nThat is not an option, please try again!\n");
            }
        }
    }

    public static void printMenu() {
        System.out.println("*****************************");
        System.out.println("*            Menu           *");
        System.out.println("*                           *");
        System.out.println("* 1) Add new person         *");
        System.out.println("* 2) List all people/values *");
        System.out.println("* 3) Divide Equally         *");
        System.out.println("* 6) Exit                   *");
        System.out.println("*****************************");
    }
}

// Calculator divider project
/*
1) need a method to store all values based on who payed
2) need to divide all numbers equally between people
3) need a method to update any new values given

Starting with just creating a method to store both a name and their value

*/