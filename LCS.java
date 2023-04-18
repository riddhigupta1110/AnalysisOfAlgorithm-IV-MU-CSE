import java.util.*;
class LCS {
	static void lcs(String X, String Y, int m, int n)
	{
		int[][] L = new int[m + 1][n + 1];
		char[][] A = new char[m+1][n+1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1)){
				    L[i][j] = L[i - 1][j - 1] + 1;
				    A[i][j] = 'd';
				}
				else{
				    if(L[i-1][j] > L[i][j-1]){
				        L[i][j] = L[i-1][j];
				        A[i][j] = 'u';
				    }
				    else{
				        L[i][j] = L[i][j-1];
				        A[i][j] = 'l';
				    }
				}
			}
		}
		int index = L[m][n];
		int temp = index-1;
		char[] lcs = new char[index];
		int i = m; int j = n;
		while (i > 0 && j > 0) {
		    if(A[i][j]=='d'){
		        lcs[temp] = X.charAt(i-1);
		        i--; j--;temp--;
		    }
		    else if(A[i][j] == 'u'){
		        i--;
		    }
		    else if(A[i][j] == 'l'){
		        j--;
		    }
		}
		System.out.println("Matrix L:");
		for(i=0; i<m+1; i++){
		    for(j=0; j<n+1; j++){
		        System.out.print(L[i][j] + " ");
		    }
		    System.out.println();
		}
		System.out.println("Matrix A:");
		for(i=1; i<m+1; i++){
		    for(j=1; j<n+1; j++){
		        System.out.print(A[i][j] + " ");
		    }
		    System.out.println();
		}
		System.out.print("LCS of " + X + " and " + Y + " is ");
		for (int k = 0; k < index; k++)
			System.out.print(lcs[k]);
		System.out.println("\nLength = " + index);
	}
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter two words: ");
		String X = sc.next();
		String Y = sc.next();
		int m = X.length(); int n = Y.length();
		lcs(X, Y, m, n);
	}
}
