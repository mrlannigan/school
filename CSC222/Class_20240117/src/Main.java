import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        double num1;
        double num2;
        double num3;

        Scanner input = new Scanner(System.in);

        num1 = askForNumber(input);
        num2 = askForNumber(input);
        num3 = askForNumber(input);
        input.nextLine();

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.printf("Name: \t\t%s\n", name);
        System.out.printf("Average: \t%d\n", (int)(num1 + num2 + num3) / 3);
    }

    private static double askForNumber(Scanner input) {
        System.out.print("Enter a number: ");
        return input.nextDouble();
    }
}
