import java.util.Scanner;

public class CarBrand {
    public static void main(String[] args) {
        String brandName;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter car brand: ");
        brandName = input.nextLine();

        System.out.printf("My favorite car brand is %s.", brandName);
    }
}
