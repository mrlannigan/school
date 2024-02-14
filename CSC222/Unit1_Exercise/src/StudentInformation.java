import java.util.Scanner;

/**
 * Program Name: Student Information
 *
 * <p>
 * Description: Capture student information
 * then provide some calculations from that data
 * for display. This program will provide the name,
 * major, height converted to feet and inches, BMI,
 * and course completion percentage.
 * <p>
 * <p>
 * Topics Covered: Input/Output/Processing
 */
public class StudentInformation {
    /**
     * <p>
     * Provide a unique instance of a Scanner to each instance of StudentInformation.
     * This will allow the other class methods that ask for user input from stdin to
     * not have to pass around the Scanner instance to each invocation of those class
     * methods. I know this isn't something we've covered yet, but I can't stand writing
     * "sout" and nextLine/Double over and over.
     * </p>
     *
     * <p>
     * It's worth noting that I do not know the idiosyncrasies of having multiple
     * instances of my StudentInformation reading from the same InputStream. I _think_
     * the way it works is that each StreamReader (i.e. Scanner) will simply read from
     * the System.in stream and not necessarily consume from the stream. This is an
     * obvious edge case for this assignment, but something I was thinking about
     * around java's streams.
     * </p>
     */
    private final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Create instance of this class to reference unique Scanner
        StudentInformation info = new StudentInformation();

        // Gather information from user input
        String name = info.askForString("Enter your name");
        String major = info.askForString("Enter your major");
        double heightInInches = info.askForDouble("Enter your height (in)");
        double weightInPounds = info.askForDouble("Enter your weight (lbs)");
        double coursesTaken = info.askForDouble("Enter courses taken");
        double coursesRemaining = info.askForDouble("Enter courses remaining");

        // Calculate the number of feet in the height, rounding to the nearest whole foot
        int heightFeet = (int) heightInInches / 12;
        // Modulo operator to return the remaining inches
        int heightRemainingInches = (int) heightInInches % 12;
        // Calculate the BMI with the given formula
        double bmi = 703 * weightInPounds / (heightInInches * heightInInches);
        // Calculate the course completion and represent as a percentage of total completion
        double courseCompletionPercentage = coursesTaken / (coursesRemaining + coursesTaken) * 100;

        // Start output
        System.out.println("\n\nPERSONAL INFORMATION\n"); // delineate the input section
        System.out.printf("Name: %s\n", name); // show the given name
        System.out.printf("Major: %s\n", major); // show the given major
        System.out.printf("Height: %d'%d\"\n", heightFeet, heightRemainingInches); // show the calculated height
        System.out.printf("BMI: %.2f\n", bmi); // show the calculated BMI to the hundredth position
        System.out.printf("Course Completion Percentage: %.0f%%\n", courseCompletionPercentage); // show the rounded course completion
    }

    /**
     * Ask the user for a string.
     * <p>
     * This is not a static method so that we can access this class instance's
     * Scanner input variable. This is also a public method which means, that
     * another class/function outside of this class could invoke this method.
     * <p>
     * I do not know in the Java world what the preference is for preferring
     * private methods/variables over public ones. I'm sure we will get to those
     * reasons later in the course.
     *
     * @param prompt The prompt to display to the user without any delimiter
     * @return The user's inputted string
     */
    String askForString(String prompt) {
        System.out.printf("%s: ", prompt); // display the prompt
        return input.nextLine(); // wait for the next line from the Scanner
    }

    /**
     * Ask the user for a number
     * <p>
     * Similar to `askForString` this is not a static method so it can use the
     * class instance of the Scanner. This is also a public method.
     *
     * @param prompt The prompt to display to the user without any delimiter
     * @return The user's inputted number as a double
     */
    double askForDouble(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextDouble();
    }
}
