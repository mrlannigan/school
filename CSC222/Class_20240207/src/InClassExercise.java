import java.util.Random;

public class InClassExercise {

    // make a method to swap 2 positions in a 2d array
    // the position is a zero index position marker using rows then columns
    public static void main(String[] args) {
        int [][]arr = new int[10][10];

        fillArray(arr);

        swapPositions(arr, 0, 12);
        System.out.println();
        swapPositions(arr, 0, 99);
    }

    public static void fillArray(int[][]myArray) {
        Random random = new Random();
        for (int row = 0; row < myArray.length; row++) {
            for (int col = 0; col < myArray[row].length; col++) {
                myArray[row][col] = random.nextInt(100);
            }
        }
    }

    public static int getPositionRow(int[][]myArray, int position) {
        int colHeight = myArray.length;
        return (int)Math.floor((double)position / colHeight);
    }

    public static int getPositionCol(int[][]myArray, int position) {
        int rowWidth = myArray[0].length;
        return position % rowWidth;
    }

    public static boolean isPositionOutOfBounds(int[][]myArray, int position) {
        int rowWidth = myArray[0].length;
        int colHeight = myArray.length;

        return position >= rowWidth * colHeight;
    }

    public static int getValueAtPosition(int[][]myArray, int position) {
        if (isPositionOutOfBounds(myArray, position)) {
            throw new RuntimeException("Position is out of bounds of array");
        }

        int row = getPositionRow(myArray, position);
        int col = getPositionCol(myArray, position);

        return myArray[row][col];
    }

    public static void setValueAtPosition(int[][]myArray, int position, int value) {
        if (isPositionOutOfBounds(myArray, position)) {
            throw new RuntimeException("Position is out of bounds of array");
        }

        int row = getPositionRow(myArray, position);
        int col = getPositionCol(myArray, position);

        myArray[row][col] = value;
    }

    public static void swapPositions(int[][]myArray, int firstPosition, int secondPosition) {
        int firstValue = getValueAtPosition(myArray, firstPosition);
        int secondValue = getValueAtPosition(myArray, secondPosition);
        System.out.printf("1st Value (@ %d): %d\n", firstPosition, firstValue);
        System.out.printf("2nd Value (@ %d): %d\n", secondPosition, secondValue);

        setValueAtPosition(myArray, firstPosition, secondValue);
        setValueAtPosition(myArray, secondPosition, firstValue);

        System.out.printf("NEW 1st Value (@ %d): %d\n", firstPosition, getValueAtPosition(myArray, firstPosition));
        System.out.printf("NEW 2nd Value (@ %d): %d\n", secondPosition, getValueAtPosition(myArray, secondPosition));
    }
}
