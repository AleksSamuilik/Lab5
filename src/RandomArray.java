import java.util.Scanner;

public class RandomArray {

    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNumber(n);
        }
        int count = 1;
        while (count > 0) {
            count = 0;
            bubbleSort(arr);
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        arr[i] = randomNumber(n);
                        count++;
                    }
                }
            }
        }
        return arr;
    }

    public static int randomNumber(int n) {
        int a = 0;
        int b = 10 * n;
        return a + (int) (Math.random() * b);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void printMass(int[] arr) {
        int i = 0;
        for (int xxx : arr) {
            i++;
            System.out.println(i + ": " + xxx);
        }
    }

    public static int toPrint() {
        System.out.println("This program prints an array of dimension N, filled with random numbers.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number from 1 to 100: ");
        String string = scanner.nextLine();
        scanner.close();
        try {

            int xxx = Integer.parseInt(string);
            if (xxx > 0) {
                return xxx;
            } else
                System.out.println("Sorry. Restart the program and try again!");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Sorry. Restart the program and try again!");
            System.exit(0);
        }
        return 0;
    }

    public static void main(String[] args) {

        int n = toPrint();
        int[] arrGo = randomArray(n);
        printMass(arrGo);

    }
}