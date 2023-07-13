import java.util.Scanner;

public class QuickSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        System.out.print("[" + arr[0]);
        for(int i = 1; i < n; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.print("]");
        System.out.println();
    }
    static int partition(int A[], int p, int r) {
        int pivot = A[r];
        int i = p-1;
        for(int j = p; j < r; j++)
        {
            if(A[j] <= pivot)
            {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1];
        A[i+1] = A[r];
        A[r] = t;
        return i+1;
    }

    static void quickSort(int A[], int p, int r) {
        if(p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n;
            System.out.println("Enter the length of the array: [int]");
            n = in.nextInt();
            int[] A = new int[n];
            System.out.println("Enter " + n + " values for the array: " + n + "x[int]");
            for(int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            System.out.println("Entered array:");
            printArray(A);
            System.out.println("Now, let's sort the array using the Quick Sort algorithm:");
            quickSort(A, 0, n-1);
            printArray(A);
        }
    }
}