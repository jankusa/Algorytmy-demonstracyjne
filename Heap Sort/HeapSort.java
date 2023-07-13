import java.util.Scanner;

public class HeapSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        System.out.print("[" + arr[0]);
        for(int i = 1; i < n; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    static int left(int i) {
        return 2*i + 1;
    }

    static int right(int i) {
        return 2*i + 2;
    }

    static void heapify(int A[], int n, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < n && A[l] > A[largest]) {
            largest = l;
        }
        if(r < n && A[r] > A[largest]) {
            largest = r;
        }
        if(largest != i) {
            int t = A[i];
            A[i] = A[largest];
            A[largest] = t;
            heapify(A, n, largest);
        }
    }

    static void buildHeap(int A[]) {
        for(int i = A.length/2-1; i >= 0; i--) {
            heapify(A, A.length, i);
        }
    }

    static void heapSort(int A[]) {
        buildHeap(A);
        int i;
        for(i = A.length - 1; i >= 1; i--) {
            int t = A[i];
            A[i] = A[0];
            A[0] = t;
            heapify(A, i, 0);
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
            System.out.println("Now, let's sort the array using the Heap Sort algorithm:");
            heapSort(A);
            printArray(A);
        }
    }
}