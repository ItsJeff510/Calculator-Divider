import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        int input = 0;
        int counter = 0;
        HashMap<String, Double> people = new HashMap<>();
        HashMap<String, Double> amountToRecieve = new HashMap<>();
        HashMap<String, Double> amountToSend = new HashMap<>();
        String name;
        double value = 0.0;
        double money = -1.0;
        double total = 0.0;
        Scanner obj = new Scanner(System.in);

        while (input != 7) {
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
                        System.out.print("\nCurrent Total: $");
                        System.out.printf("%.2f\n", value);
                    }
                    people.put(name, value);
                    money = -1.0;
                    value = 0.0;
                }
                case 2 -> {
                    System.out.print("Enter the name of the person you want to remove: ");
                    name = obj.nextLine();

                    if (people.containsKey(name)) {
                            people.remove(name);
                            System.out.printf("%s has been removed.\n", name);
                            
                            if (!amountToSend.isEmpty() && !amountToRecieve.isEmpty()) {
                                amountToSend.clear();
                                amountToRecieve.clear();
                            }
                    } else {
                        System.out.println("\nThe name was not found, please try another name or be Case Sensetive.");
                    }

                }
                case 3 -> { // Case three takes all the people and values and displays them
                    for (String i : people.keySet()) {
                        System.out.printf("%s :", i);
                        System.out.printf(" $%.2f\n", people.get(i));
                    }
                }
                case 4 -> { // Case four takes the total and divides it evenly
                    total = 0.0;
                    counter = 0;
                    for (Double i : people.values()) {
                        total += i;
                        counter++;
                        System.out.print("\nThe total is after person ");
                        System.out.printf("%s: $%.2f", counter, total);
                    }
                    total /= people.size();
                    System.out.println();
                }
                case 5 -> { // Case five Takes care of giving everyone's proper pay value
                    if (!amountToSend.isEmpty() && !amountToRecieve.isEmpty()) {
                        amountToSend.clear();
                        amountToRecieve.clear();
                    }

                    if (total != 0) {
                        for (String i : people.keySet()) {

                            if (people.get(i) - total < 0) {
                                amountToSend.put(i, Math.abs(people.get(i) - total));
                            } else {
                                amountToRecieve.put(i, Math.abs(people.get(i) - total));
                            }
                        }
                        System.out.println("Owe/Owed has been calculated! Run option 6 to see the amounts owe/owed.");
                    } else {
                        System.out.println("This method cannot be done, try dividing equally first.");
                    }
                    total = 0.0;
                }
                case 6 -> { // Case six is meant to show who owes what to who

                    if (!amountToSend.isEmpty() && !amountToRecieve.isEmpty()) {
                        for (String i : amountToSend.keySet()) {
                            System.out.printf("\n%s owes %.2f", i, amountToSend.get(i) / amountToRecieve.size());
                        }
                        for (String i : amountToRecieve.keySet()) {
                            System.out.printf("\n%s is owed %.2f", i, amountToRecieve.get(i) / amountToSend.size());
                        }
                    } else {
                        System.out.println("This method cannot be done, try showing who is owed first or adding more than 1 person.");
                    }
                    System.out.println();
                }
                case 7 -> { // Is an end statement meant to stop the While-loop
                    System.out.println("Thank you for using, Exiting!\n");
                }


                default -> System.out.println("\nThat is not an option, please try again!\n");
            }
        }
        obj.close();
    }

    public static void printMenu() {
        System.out.printf("*****************************" +
                          "\n*            Menu           *" +
                          "\n*                           *" +
                          "\n* 1) Add new person         *" +
                          "\n* 2) Remove person          *" +
                          "\n* 3) List all people/values *" +
                          "\n* 4) Divide Equally         *" +
                          "\n* 5) Calculate Owe/Owed     *" +
                          "\n* 6) Show Owe/Owed          *" +
                          "\n* 7) Exit                   *" +
                          "\n*****************************\n");
    }
}