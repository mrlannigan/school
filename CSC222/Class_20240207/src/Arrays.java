public class Arrays {
    public static void main(String[] args) {
        int []arr = new int[5];
        int []arr2 = {2,3,4,5};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }

        doubleNumbers(arr2);
        display(arr2);
        System.out.printf("2nd element: %d\n", arr2[1]);
        sumNumbers(arr2);

        if (findInArray(arr2, 10)) {
            System.out.println("Found value in the array");
        } else {
            System.out.println("Value not found in array");
        }
    }

    public static void display(int[]myArr) {
        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    public static void doubleNumbers(int[]myArr) {
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] *= 2;
        }
    }

    public static void sumNumbers(int[]myArr) {
        int acc = 0;
        for (int j : myArr) {
            acc += j;
        }
        System.out.printf("Sum: %d\n", acc);
    }

    public static boolean findInArray(int[]myArr, int value) {
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] == value) {
                return true;
            }
        }

        return false;
    }
}
