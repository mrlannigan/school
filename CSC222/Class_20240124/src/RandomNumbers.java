import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        int []arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 100);
            System.out.println(arr[i]);
        }
    }
}
