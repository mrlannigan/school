import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate the grades
        int[] grades = generateGrades(5);

        // Init the course classes
        MathClass mathClass = new MathClass();
        ComputerScienceClass csClass = new ComputerScienceClass();

        // Show the selected grades
        displayGrades(grades);
        System.out.println();

        // Display the math class final grade
        mathClass.displayFinalGrade(grades);
        System.out.println();

        // Display the CS class final grade
        csClass.displayFinalGrade(grades);
    }

    /**
     * Utility method to generate x number of grades
     */
    public static int[] generateGrades(int count) {
        int[] grades = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            grades[i] = random.nextInt(100);
        }

        return grades;
    }

    /**
     * Utility method to display the grades for verification
     */
    public static void displayGrades(int[] grades) {
        System.out.print("Grades:\t");
        for (int grade : grades) {
            System.out.print(grade + "\t");
        }
        System.out.println();
    }
}
