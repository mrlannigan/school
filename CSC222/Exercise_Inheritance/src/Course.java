public class Course {
    private String id;

    /**
     * Provide constructor to set the course id
     */
    public Course(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Base signature for extending classes to implement.
     * Will throw if not implemented.
     */
    public int calcFinalGrade(int[] grades) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Display the course information and its final grade
     */
    public void displayFinalGrade(int[] grades) {
        System.out.println("Course Name: " + getId());
        System.out.println("Final Grade: " + calcFinalGrade(grades));
    }
}
