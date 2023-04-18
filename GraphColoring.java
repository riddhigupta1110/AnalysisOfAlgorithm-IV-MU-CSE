//Riddhi Gupta - SE CMPN B1 - 05
import java.util.*;
class GraphColoring{
  static void printGraphColoringSolution(int color[]){
	System.out.print("Solution: ");
	for (int i = 0; i < color.length; i++) {
  	System.out.print(color[i] + " ");
	}
	System.out.println();
  }
  static void nextValue(int graph[][], int m, int color[], int k){
	int i;
	while(true){
  	color[k] = (color[k]+1)%(m+1);
  	if(color[k] == 0){
    	return;
  	}
  	for (i = 0; i < graph.length; i++) {
    	if(graph[k][i]!=0 && color[k]==color[i]){
      	break;
    	}
  	}
  	if(i==(graph.length)){
    	return;
  	}
	}
  }
  static void mColoring(int graph[][], int m, int color[], int k){
	while(true){
  	nextValue(graph, m , color, k);
  	if(color[k]==0){
    	return;
  	}
  	if(k==(graph.length-1)){
    	printGraphColoringSolution(color);
  	}
  	else{
    	mColoring(graph, m, color, k+1);
  	}
	}
  }
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of vertices: ");
	int n = sc.nextInt();
	int graph[][] = new int[n][n];
	System.out.println("Enter adjacency matrix: ");
	for (int i = 0; i < n; i++) {
  	for (int j = 0; j < n; j++) {
    	graph[i][j] = sc.nextInt();
  	}
	}
	System.out.println("Enter number of colours: ");
	int m = sc.nextInt();

	int color[] = new int[n];
	mColoring(graph, m, color, 0);
  }
}
