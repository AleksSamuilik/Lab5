import java.util.Scanner;

public class RandomArray {

    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNumber(n);
        }
        boolean valid = true;
        while (valid) {
            valid = false;
            bubbleSort(arr);
            loopExit:
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        arr[i] = randomNumber(n);
                        valid = true;
                        break loopExit;
                    } else if (arr[i] < arr[j]) {
                        break;
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
        loopExit:
        for (int i = arr.length - 1; i > 0; i--) {
            boolean valid = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    valid = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                } else if (valid && j == i - 1) {
                    break loopExit;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        int i = 0;
        for (int xxx : arr) {
            i++;
            System.out.println(i + ": " + xxx);
        }
    }

    public static int readUserInput() {
        System.out.println("This program prints an array of dimension N, filled with random numbers.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number from 1 to 100: ");
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            try {
                int xxx = Integer.parseInt(string);
                if (xxx > 0 && xxx < 101) {
                    scanner.close();
                    return xxx;
                } else
                    System.out.println("Sorry. Try again!");
            } catch (NumberFormatException e) {
                System.out.println("Sorry. Try again!");
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = readUserInput();
        int[] arrGo = randomArray(n);
        printArray(arrGo);
    }
}