import java.util.Scanner;
public class FloydWarshall_APSS {
	static void printArray(int arr[][], int n){
    	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
            	System.out.print(arr[i][j]+" ");
        	}
        	System.out.println();
    	}
	}

	private static void getAdjacenyMatrix(int arr[][], int n, Scanner s) {
    	System.out.println("Enter the adjacency matrix: ");
            System.out.println("Note: Enter 999 if path does not exist.");
    	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
            	arr[i][j] = s.nextInt();
        	}
    	}
        }
	static void initialisePathMatrix(int p[][], int d[][], int n, Scanner s){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if(i==j || d[i][j]==999)
                        p[i][j] = -1;
                    else if(d[i][j]!=999 && i!=j)
                        p[i][j] = i+1;
                }
            }
	}
	static void apss(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of vertices: ");
    	int n = sc.nextInt();
    	int d0[][] = new int[n][n];
    	int p0[][] = new int[n][n];
    	getAdjacenyMatrix(d0, n, sc);
    	initialisePathMatrix(p0, d0, n, sc);
    	System.out.println("D0: ");
    	printArray(d0, n);
    	System.out.println("P0: ");
    	printArray(p0, n);
    	for (int k = 0; k < n; k++) {
        	for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
                	if((d0[i][k]+d0[k][j])<d0[i][j]){
                    	d0[i][j] = d0[i][k] + d0[k][j];
                    	p0[i][j] = k+1;
                	}
            	}

        	}
            	System.out.println("D"+(k+1)+": ");
            	printArray(d0, n);
            	System.out.println("P"+(k+1)+": ");
            	printArray(p0, n);
            	System.out.println();
    	}
	}
	public static void main(String[] args) {
    	apss();
	}
}
