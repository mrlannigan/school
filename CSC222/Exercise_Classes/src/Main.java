import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // EXTRA CREDIT
        System.out.print("How many students do you want to model? ");
        int studentCount = input.nextInt();
        input.nextLine(); // clear buffer
        System.out.println();

        for (int i = 0; i < studentCount; i++) {
            // Create the student
            Student student = Student.createFromUserInput(input);

            // Init a new scholarship
            Scholarship scholarship = new Scholarship();

            // Apply student to scholarship
            scholarship.applyStudent(student);

            // Communicate the result
            scholarship.displayResult();
        }
    }
}
