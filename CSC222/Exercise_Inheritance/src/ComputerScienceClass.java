public class ComputerScienceClass extends Course {
    /**
     * Provide the CS Class course id
     */
    public ComputerScienceClass() {
        super("CSC222");
    }

    /**
     * Override the way this course calculates its final grade
     * Uses highest score
     */
    @Override
    public int calcFinalGrade(int[] grades) {
        int highestGrade = 0;

        for (int grade : grades) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
        }

        return highestGrade;
    }
}
