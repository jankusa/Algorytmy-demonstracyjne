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

    static void countingSort(int arr[], int max_val, int e) {
        int[] counts = new int[max_val+1];
        for(int i = 0; i <= max_val; i++) {
            counts[i] = 0;
        }
        for(int i = 0; i < arr.length; i++) {
            counts[(arr[i]/e)%10]++;
        }
        for(int i = 1; i <= max_val; i++) {
            counts[i] += counts[i-1];
        }
        int[] sorted = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            sorted[counts[(arr[i]/e) % 10] - 1] = arr[i];
            counts[(arr[i]/e) % 10]--;
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }

    static int get_max(int arr[]) {
        if(arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void radixSort(int arr[]) {
        int max = get_max(arr);
        for(int e = 1; max/e > 0; e*=10) {
            countingSort(arr, 10, e);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter the length of the array: [int]");
        n = in.nextInt();
        int[] A = new int[n];
        System.out.println("Enter " + n + " values for the array: " + n + "x[int]");
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
        System.out.println("Now, let's sort the array using the Radix Sort algorithm:");
        radixSort(A);
        printArray(A);
    }
}