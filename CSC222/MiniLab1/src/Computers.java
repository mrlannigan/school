public class Computers {
    public static void main(String[] args) {
        // How many students will share each computer in the classroom? (Use values with a datatype of double and truncate all decimal places from your answer)
        // Based on your answer are enough computers available?  If not, how could you fix this in your code?

        int computerCount = 7;
        int studentCount = 26;

        double studentToComputerRatio = (double)studentCount / computerCount;

        System.out.printf("Students sharing each computer: %.0f\n", studentToComputerRatio);

        if (studentToComputerRatio <= 1) {
            System.out.println("No changes are needed to the classroom.");
        } else {
            System.out.println("There are not enough computers for each student.");
            System.out.printf("Purchase %d more computers to make sure each student has a computer.", studentCount - computerCount);
        }
    }
}
