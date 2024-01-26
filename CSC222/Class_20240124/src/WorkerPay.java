import java.util.Scanner;

public class WorkerPay {
    private final Scanner input = new Scanner(System.in);

    private String workerName;
    private double hours = 0;
    private double wagePerHour = 0;
    private final int overtimeHourThreshold = 40;

    public static void main(String[] args) {
        WorkerPay workerPay = new WorkerPay();

        // Input
        workerPay.getWorkerName();
        workerPay.getWorkerWage();

        while (true) {
            if (!workerPay.getHoursWorked()) {
                break;
            }
        }

        System.out.printf("Worker      : %s\n", workerPay.getName());
        System.out.printf("Total Hours : %.1f\n", workerPay.getHours());
        System.out.printf("Pay         : %s\n", workerPay.getFriendlyPayOutput());
    }

    public void getWorkerName() {
        System.out.print("Enter worker name: ");
        workerName = input.nextLine();
    }

    public void getWorkerWage() {
        System.out.print("Enter worker wage: ");
        wagePerHour = input.nextDouble();
    }

    public boolean getHoursWorked() {
        System.out.print("Enter hours worked: ");
        try {
            double userInput = input.nextDouble();
            hours += userInput;

            return userInput > 0;
        } catch (java.util.InputMismatchException e) {
            // Consume the input because on an exception scanner doesn't consume
            input.nextLine();
            return false;
        }
    }

    public double calcOvertimeWage() {
        if (hours <= overtimeHourThreshold) {
            return 0;
        }

        double overtimeHourRate = 1.5;
        return (hours - overtimeHourThreshold) * overtimeHourRate * wagePerHour;
    }

    public double calcRegularWage() {
        double calcHours = hours;

        if (calcHours > overtimeHourThreshold) {
            calcHours = overtimeHourThreshold;
        }

        return calcHours * wagePerHour;
    }

    public String getFriendlyPayOutput() {
        double overtimePay = calcOvertimeWage();
        double regularPay = calcRegularWage();

        if (overtimePay > 0) {
            return String.format("$%.2f ($%.2f OT)", regularPay + overtimePay, overtimePay);
        } else {
            return String.format("$%.2f", regularPay);
        }
    }

    public String getName() {
        return workerName;
    }

    public double getHours() {
        return hours;
    }
}
