import java.util.Scanner;

public class MergeSort {

    static void printArray(int arr[]) {
        int n = arr.length;
        System.out.print("[" + arr[0]);
        for(int i = 1; i < n; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    static void merge(int arr[], int l, int q, int r) {
        int sizeL = q - l + 1;
        int sizeR = r - q;
        int L[] = new int[sizeL+1];
        int R[] = new int[sizeR+1];
        for(int i = 0; i < sizeL; i++) {
            L[i] = arr[l+i];
        }
        for(int i = 0; i < sizeR; i++) {
            R[i] = arr[q+i+1];
        }
        L[sizeL] = R[sizeR] = Integer.MAX_VALUE;
        for(int i = 0, j = 0, k = l; k <= r; k++) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if(l < r) {
            int q = (l+r)/2;
            mergeSort(arr, l, q);
            mergeSort(arr, q+1, r);
            merge(arr, l, q, r);
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
            System.out.println("Now, let's sort the array using the Merge Sort algorithm:");
            mergeSort(A, 0, A.length-1);
            printArray(A);
        }
    }
}