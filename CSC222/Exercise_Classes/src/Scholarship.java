public class Scholarship {
    private Student student;

    private int amount = 0;

    /**
     * Do the logic to determine the value of the scholarship based on the given student
     * @param student Student applying for a scholarship
     */
    public void applyStudent(Student student) {
        this.student = student;

        // Normalize the major and allow for "Computer Science" and "CS" entries
        boolean hasCSMajor = switch (student.getMajor().toLowerCase()) {
            case "computer science" -> true;
            case "cs" -> true;
            default -> false;
        };

        // Pull Status and GPA
        Student.Status status = student.getStatus();
        double gpa = student.getGPA();

        // Start amount logic
        if (
                status == Student.Status.SENIOR && (
                        gpa == 4.0 || hasCSMajor
                )
        ) {
            setAmount(10000);
        } else if (
                (
                        status == Student.Status.SOPHOMORE && gpa == 4.0
                ) || (
                        status == Student.Status.JUNIOR && gpa >= 3.0 && hasCSMajor
                )
        ) {
            setAmount(5000);
        } else if (
                (
                        status == Student.Status.FRESHMAN && (
                                gpa >= 3.5 || hasCSMajor
                        )
                ) || (
                        status == Student.Status.SOPHOMORE && gpa >= 3.0 && hasCSMajor
                ) || (
                        status == Student.Status.JUNIOR && gpa >= 3.5
                )
        ) {
            setAmount(1000);
        }
    }

    /**
     * Display the result of scholarship application
     */
    public void displayResult() {
        if (this.amount > 0) {
            // display the valid scholarship
            System.out.printf("%s qualifies for a $%,d scholarship.", student.getName(), getAmount());
        } else {
            // student did not qualify
            System.out.printf("%s does not qualify for a scholarship.", student.getName());
        }
        System.out.println("\n");
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
