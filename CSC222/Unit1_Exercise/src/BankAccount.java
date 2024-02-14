import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program Name: Bank Account
 *
 * <p>
 * Description: Maintain the balance of a bank account.
 * This will enable deposit and withdraws as well as the
 * ability to borrow money from the bank and provide a
 * payment schedule.
 * <p>
 * <p>
 * Topics Covered: Method/Branch/Loop
 */
public class BankAccount {
    /**
     * Maintain a class instance of Scanner
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * Repeated stdout divider constant
     */
    private final String DIVIDER = "-------------------------------------";

    /**
     * Stored balance
     */
    private double balance = 0;

    public static void main(String[] args) {
        int oranges = 2;
        double price = 12.99;
        System.out.printf("%.1f Oranges: $%.0f\n", (float)oranges, price);

        // Create an instance of the bank account
        BankAccount bankAccount = new BankAccount();

        while (true) {
            // Show the menu and execute the user selection until false is returned
            if (!bankAccount.showMenu()) {
                break;
            }
        }
    }

    /**
     * Show the user a function menu.
     * <p>
     * The expectation of this menu is to denote if the program should
     * continue based on the boolean return.
     *
     * @return boolean
     */
    boolean showMenu() {
        System.out.println(DIVIDER);
        System.out.println("Deposit..........press 1");
        System.out.println("Withdrawal.......press 2");
        System.out.println("Loan.............press 3");

        // Ask for the user input to the menu
        switch (askForMenuItem()) {
            case 1:
                showDeposit();
                break;
            case 2:
                showWithdraw();
                break;
            case 3:
                showLoan();
                break;
            default:
                // returning false, so we don't return true at the end of this method.
                return false;
        }

        // Indicate that we should continue the program.
        return true;
    }

    /**
     * Expose the current the balance without allowing external modification of it
     *
     * @return the bank account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Handle a deposit.
     */
    void showDeposit() {
        System.out.println(DIVIDER);
        double amount = askForDouble("How much money would you like to deposit");
        if (amount > 0) {
            // the amount is greater than 0, so we can succeed
            balance += amount;
            System.out.println("Successful Transaction");
            System.out.printf("New Balance: $%.2f\n", getBalance());
        } else {
            // The amount is below 0, fail the transaction
            System.out.println("Unable to deposit a negative amount. Use the withdraw function.");
            System.out.printf("Current Balance: $%.2f\n", getBalance());
        }
    }

    /**
     * Handle a withdraw.
     */
    void showWithdraw() {
        System.out.println(DIVIDER);
        double amount = askForDouble("How much money would you like to withdraw");
        if (amount > 0 && amount <= getBalance()) {
            // The amount is both greater than 0 and the bank account has the balance to withdraw from
            balance -= amount;
            System.out.println("Successful Transaction");
            System.out.printf("New Balance: $%.2f\n", getBalance());
        } else if (amount > getBalance()) {
            // The amount is greater than the current balance, so decline the transaction
            System.out.println("Unable to complete transaction, not enough funds.");
            System.out.printf("Current Balance: $%.2f\n", getBalance());
        } else {
            // It doesn't make sense to withdraw negative funds.
            System.out.println("Unable to deposit a negative amount. Use the withdraw function.");
            System.out.printf("Current Balance: $%.2f\n", getBalance());
        }
    }

    /**
     * Create a loan.
     */
    void showLoan() {
        // Capture user input
        System.out.println(DIVIDER);
        double loanAmount = askForDouble("Loan Amount");
        int termInMonths = askForInt("Months");
        double interestRate = askForDouble("Interest Rate (0.05 = 5%)");

        // Calculate monthly payment
        System.out.println(DIVIDER);
        double monthlyInterestRate = interestRate / 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -termInMonths));

        // Update balance with loan amount
        balance += loanAmount;

        // Display loan information
        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("New Balance: $%.2f\n", getBalance());
        System.out.println(DIVIDER);

        // EXTRA CREDIT: Print out payment schedule
        System.out.println("Month\tLoan Amount\t\tPayment\t\tInterest");
        int monthTracker = 0;
        // Loop while we have remaining loan amount and print the payment schedule for each month
        // Note: I noticed I was having doubles that were greater than 0 but in the thousands of
        //       precision, so I multiply by 100 then use Math.round to get rounding to the nearest penny.
        while (Math.round(loanAmount * 100) > 0) {
            double monthInterest = loanAmount * monthlyInterestRate;
            loanAmount -= monthlyPayment - monthInterest;
            monthTracker += 1;
            System.out.printf("%d\t\t$ %.2f\t\t$ %.2f\t\t$ %.2f\n", monthTracker, loanAmount, monthlyPayment, monthInterest);
        }
    }

    /**
     * Utility method for asking for a double number
     */
    double askForDouble(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextDouble();
    }

    /**
     * Utility method for asking for an integer
     */
    int askForInt(String prompt) {
        System.out.printf("%s: ", prompt);
        return input.nextInt();
    }

    /**
     * Utility method for asking the menu item
     */
    int askForMenuItem() {
        try {
            return askForInt("Select an option");
        } catch (InputMismatchException err) {
            // catch an invalid entry and default to 0
            // this will result in the menu case statement not matching any case
            // and ending the program
            return 0;
        }
    }
}
