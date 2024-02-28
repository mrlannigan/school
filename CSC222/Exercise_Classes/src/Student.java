import java.util.Scanner;

public class Student {

    public enum Status {
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }

    private String name;
    private Status status;
    private double gpa;
    private String major;

    /**
     * Static factory method to return a new student instance based on user input
     */
    public static Student createFromUserInput(Scanner input) {
        Student student = new Student();
        System.out.print("Enter a student name: ");
        student.setName(input.nextLine());
        System.out.print("Enter a status (freshman, sophomore, junior, senior): ");
        student.setStatus(input.nextLine());
        System.out.print("Enter a major: ");
        student.setMajor(input.nextLine());
        System.out.print("Enter a GPA (0.0 - 4.0): ");
        student.setGPA(input.nextDouble());

        input.nextLine(); // read till next line
        return student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Convert/normalize user input string to a status enum
     */
    public void setStatus(String status) {
        this.status = switch (status.toLowerCase()) {
            case "freshman" -> Status.FRESHMAN;
            case "sophomore" -> Status.SOPHOMORE;
            case "junior" -> Status.JUNIOR;
            case "senior" -> Status.SENIOR;
            default -> throw new IllegalStateException("Unexpected value: " + status);
        };
    }

    public double getGPA() {
        return gpa;
    }

    /**
     * Validate user input GPA
     */
    public void setGPA(double gpa) {
        if (gpa < 0 || gpa > 4) {
            throw new IllegalStateException("GPA out of range: " + gpa);
        }
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
