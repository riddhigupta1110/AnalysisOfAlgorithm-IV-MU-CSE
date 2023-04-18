//Riddhi Gupta - SE CMPN B B1 - 05
import java.util.*;
class SumOfSubset {
	static void printArray(int arr[]){
    	System.out.println("Solution: ");
    	for(int i=0; i<arr.length; i++){
        	System.out.print(arr[i] + " ");
    	}
    	System.out.println();
	}
	static void sumOfSubset(int s, int k, int r, int w[], int x[], int m){
        	x[k] = 1;
    	if(s+w[k] == m){
        	printArray(x);
        	return;
    	}
    	else if((s+w[k]+w[k+1])<=m){
        	sumOfSubset(s+w[k], k+1, r-w[k], w, x, m);
    	}
    	if( ((s+r-w[k])>=m) && ((s+w[k+1])<=m) ){
        	x[k] = 0;
        	sumOfSubset(s, k+1, r-w[k], w, x, m);
    	}
   	 
	}
	static void callerSumOfSubset(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of integers: ");
    	int n = sc.nextInt();
    	int w[] = new int[n];
    	int sum=0;
    	System.out.println("Enter the positive integers: ");
    	for(int i=0; i<n; i++){
        	w[i] = sc.nextInt();
        	sum += w[i];
    	}
    	System.out.println("Enter the sum: ");
    	int S = sc.nextInt();
    	int x[] = new int[n];
    	for(int i=0; i<n; i++){
        	x[i] = 0;
    	}
    	sumOfSubset(0, 0, sum, w, x, S);
   	 
	}
	public static void main(String[] args) {
    	callerSumOfSubset();
	}
}
