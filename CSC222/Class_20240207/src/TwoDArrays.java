import java.util.Random;

public class TwoDArrays {
    public static void main(String[] args) {
        int [][]numbers = new int[5][3];
        Random random = new Random();

        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = random.nextInt(100);
                System.out.printf("%d\t", numbers[row][col]);
            }
            System.out.print("\n");
        }
    }
}
