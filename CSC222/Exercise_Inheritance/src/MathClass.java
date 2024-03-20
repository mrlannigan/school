public class MathClass extends Course {
    /**
     * Set the course id
     */
    public MathClass() {
        super("MTH163");
    }

    /**
     * Override the way this course calculates its final grade
     * Using average scoring.
     */
    @Override
    public int calcFinalGrade(int[] grades) {
        int total = 0;

        for (int grade : grades) {
            total += grade;
        }

        return total / grades.length;
    }
}
