import java.util.*;

public class Main {
    public static void main(String[] args) {
        String name;
        Double value = 0.0;
        double input = -1;
        Scanner obj = new Scanner(System.in);

        /*
        System.out.print("Enter the name of the person: ");
        name = obj.nextLine();

        while (input != 0) {
            System.out.print("Enter the value this person paid (enter 0 when done): ");
            input = Double.parseDouble(obj.nextLine());
            value += input;
            System.out.println(value);
        }
        people.put(name, value);
        input = -1;
        */
        runMenu();
    }
    public static void runMenu() {
        Integer input = 0;
        HashMap<String, Double> people = new HashMap<String, Double>();
       // while (input != 6) {

            printMenu();
            switch (input) {
                case 0:
                    System.out.println("Case 1 executed");
                    break;

                case 1:

                    break;

                default:
            }
        //}
    }

    public static void printMenu() {
        System.out.println("*****************************");
        System.out.println("*            Menu           *");
        System.out.println("*                           *");
        System.out.println("* 1) Add new person         *");
        System.out.println("* 2) Divide Equally         *");
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