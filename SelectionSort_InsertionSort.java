
import java.util.*;
public class SelectionSort_InsertionSort {
    static void selectionSort(int arr[]){
        long startSS = System.nanoTime();
        System.out.println("Selection Sort: ");
        int min;
        for(int i=0; i<arr.length-1; i++){
            System.out.print("Pass "+ (i+1) + ": ");
                min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            print(arr);
        }
            long endSS = System.nanoTime();
            System.out.println("Elapsed time = " + (endSS - startSS));
    }
    static void insertionSort(int arr[]){
        long startIS = System.nanoTime();
        System.out.println("Insertion Sort: ");
        int j;
        for(int i=1; i<arr.length; i++){
            System.out.print("Pass "+ i + ": ");
            j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            print(arr);
        }
        long endIS = System.nanoTime();
        System.out.println("Elapsed time = " + (endIS - startIS));
    }
    static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements to sort: ");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }
        selectionSort(arr1);
        insertionSort(arr2);
    }
}
