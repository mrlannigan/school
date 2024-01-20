public class UserPurchases {
    public static void main(String[] args) {
        // What is the cost of each item if 4 are purchased in dollar format? Example output: $5.55
        // How much tax is added if 5% tax is applied to the total in dollar format?

        double totalItemAmount = 27.36;
        int totalItemsPurchased = 4;

        System.out.printf("The individual cost of the %d items is $%.2f\n", totalItemsPurchased, totalItemAmount / totalItemsPurchased);
        System.out.printf("5%% Sales tax: $%.2f", totalItemAmount * 0.05);
    }
}
