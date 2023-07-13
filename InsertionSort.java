/**
 * InsertionSort
 */

import java.util.Scanner;

public class InsertionSort {
    void insertionSort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int j;
            int t = arr[i];
            for(j = i; j > 0 && arr[j-1] > t; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            InsertionSort o = new InsertionSort();
            int n;
            System.out.println("Enter the length of the array: [int]");
            n = in.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " values for the array: " + n + "x[int]");
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println("Entered array:");
            o.printArray(arr);
            System.out.println("Now, let's sort the array using the Insertion Sort:");
            o.insertionSort(arr);
            o.printArray(arr);
        }
    }
}