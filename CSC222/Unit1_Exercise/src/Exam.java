import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        for (int i = 1; i <= 5; i++) {
            if (number * i > 10) {
                System.out.println(number);
            }
        }

        AddNumbers();
    }

    public static int DoubleNumber() {
        int number = 5;
        return number * 2;
    }

    public static int TimesTen(int number) {
        return number * 10;
    }

    public static void AddNumbers() {
        int num1 = TimesTen(5);
        int num2 = DoubleNumber();
        System.out.println(num1 + num2);
    }
}
