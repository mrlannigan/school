import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static java.lang.Integer.MIN_VALUE;

public class NumberMath {
    /**
     * Maintain a class instance of Scanner
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * Integer array to store user inputted values
     */
    private final int []arr = new int[5];

    char []letters = new char[20];

    int [][]numbers = new int[4][12];

    public static void main(String[] args) {
        NumberMath program = new NumberMath();

        program.fillArray();

        while (true) {
            // Show the menu and execute the user selection until false is returned
            if (!program.showMenu()) {
                break;
            }
        }
    }

    /**
     * Loop the length of the array and ask the user for an integer
     */
    void fillArray() {
        for (int i = 0; i < arr.length; i += 1) {
            arr[i] = askForInt("Enter a number");
        }

        for (int i = 0; i < letters.length; i += 1) {
            arr[i] = input.nextInt();
        }

        int acc = 0;
        for (int[] j : numbers) {
            for (int k : j) {
                acc += k;
            }
        }
    }

    /**
     * Program control menu to execute functions on the user input values
     * @return boolean whether to continue the program
     */
    boolean showMenu() {
        System.out.println("-------------------------------------");
        System.out.println("Display Numbers........press 1");
        System.out.println("Find Max...............press 2");
        System.out.println("Calculate Average......press 3");
        System.out.println("Exit...................press 4");
        System.out.println();

        // Ask for the user input to the menu
        switch (askForMenuItem()) {
            case 1:
                showNumbers();
                break;
            case 2:
                showMax();
                break;
            case 3:
                showAverage();
                break;
            case 4:
            default:
                // returning false, so we don't return true at the end of this method.
                return false;
        }

        // Indicate that we should continue the program.
        return true;
    }

    /**
     * Show all the numbers in the array in a single line
     */
    void showNumbers() {
        System.out.print("Numbers:");
        for (int j : arr) {
            System.out.printf(" %d", j);
        }
        System.out.println();
    }

    /**
     * Find the max value in the array
     */
    void showMax() {
        /**
         * We use the integer MIN_VALUE so that we can support all
         * integer numbers in the array.
         */
        int acc = MIN_VALUE;
        for (int j : arr) {
            if (j > acc) {
                acc = j;
            }
        }
        System.out.printf("Max Number: %d\n", acc);
    }

    /**
     * Display the average of all the values in the array
     */
    void showAverage() {
        int acc = 0;
        for (int j : arr) {
            acc += j;
        }
        System.out.printf("Average Number: %.1f\n", (double)acc / arr.length);
    }

    /**
     * Utility method for asking for an integer
     */
    int askForInt(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextInt();
    }

    /**
     * Utility method for asking the menu item
     */
    int askForMenuItem() {
        try {
            return askForInt("Select an option");
        } catch (InputMismatchException err) {
            // catch an invalid entry and default to 0
            // this will result in the menu case statement not matching any case
            // and ending the program
            return 0;
        }
    }
}
