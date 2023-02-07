import java.util.Scanner;
class MergeSort_QuickSort {
	static void mergeSort(int arr[], int l, int r) {
    	int k=1;
    	if (l < r) {
        	int mid = (l + r) / 2;
        	mergeSort(arr, l, mid);
        	mergeSort(arr, mid + 1, r);
        	merge(arr, l, mid, r);
    	}
	}
	static void merge(int arr[], int l, int mid, int r){
    	int i = l, j = mid + 1, f = l;
        int temp[] = new int[100000];
    	while (i <= mid && j <= r) {
        	if (arr[i] < arr[j]) {
            	temp[f] = arr[i]; 
            	i++;
        	} else {
            	temp[f] = arr[j]; 
            	j++;
        	}
        	f++;
    	}
    	if (i > mid) {  	// if elements on the left half are still left
        	while (j <= r) {
            	temp[f] = arr[j]; 
            	f++; 
            	j++;
        	}
    	} else {		// if elements on the right half are still left 
        	while (i <= mid) {
            	temp[f] = arr[i]; 
            	f++;
            	i++;
        	}
    	}
for (f = l; f <= r; f++){   // transfering all elements from temporary to arr
    arr[f] = temp[f];
} 	
        		
	}
	static void quicksort(int arr[], int lowIndex, int highIndex){
    	if(lowIndex > highIndex)
        		return;
    	int pivot = arr[highIndex];
    	int leftPointer = lowIndex;
    	int rightPointer = highIndex;
    	while(leftPointer < rightPointer){
        	while(arr[leftPointer]<=pivot && leftPointer<rightPointer){
            	leftPointer++;
        	}
        	while(arr[rightPointer]>=pivot && leftPointer<rightPointer){
            	rightPointer--;
        	}
        	swap(arr, leftPointer, rightPointer);
    	}
    	swap(arr, leftPointer, highIndex);
    	quicksort(arr, lowIndex, leftPointer-1);
    	quicksort(arr, leftPointer+1, highIndex);
	}
	static void swap(int arr[], int lp, int rp){
    	int t = arr[lp];
    	arr[lp] = arr[rp];
    	arr[rp] = t;
	}
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of elements: ");
    	int n = sc.nextInt();
    	int arr1[] = new int[n];
    	int arr2[] = new int[n];
    	System.out.println("Enter elements: ");
    	for (int i = 0; i < n; i++) {
        	arr1[i] = sc.nextInt(); arr2[i] = arr1[i];
    	}
    	long startMS = System.nanoTime();
    	mergeSort(arr1, 0, n - 1);
    	System.out.println("Merge Sort - After sorting array: ");
    	for (int i = 0; i < n; i++) {
        	System.out.print(arr1[i] + " ");
    	}
    	System.out.println();
    	long endMS = System.nanoTime();
    	System.out.println("Elapsed time = " + (endMS - startMS));
    	long startQS = System.nanoTime();
    	quicksort(arr2, 0, n-1);
    	System.out.println("Quick Sort - After sorting array: ");
    	for (int j = 0; j < n; j++){ 
        		System.out.print(arr2[j] + " ");
    	}
    	System.out.println();
    	long endQS = System.nanoTime();
    	System.out.println("Elapsed time = " + (endQS - startQS));
	}
}
