import java.util.Scanner;

public class Main {
    static void printArray(int arr[]) {
        int n = arr.length;
        System.out.print("[" + arr[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    static void countingSort(int arr[], int max_val) {
        int[] counts = new int[max_val+1];
        for(int i = 0; i <= max_val; i++) {
            counts[i] = 0;
        }
        for(int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for(int i = 1; i <= max_val; i++) {
            counts[i] += counts[i-1];
        }
        int[] sorted = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            sorted[counts[arr[i]] - 1] = arr[i];
            counts[arr[i]]--;
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter the length of the array:   [int]");
        n = in.nextInt();
        int max_value = 100;
        int[] A = new int[n];
        System.out.println("Enter " + n + " values from the range of 0 to " + max_value + ":   "+ n + "x[int]");
        int i = 0;
        while (i < n) {
            if (in.hasNextInt()) {
                A[i] = in.nextInt();
                i++;
            } else {
                in.next();
            }
        }
        System.out.println("Entered array:");
        printArray(A);
        System.out.println("Now, let's sort the array using the Counting Sort algorithm:");
        countingSort(A, max_value);
        printArray(A);
    }
}