/*Riddhi Gupta
SE CMPN B - B1
Roll no - 05*/
import java.util.*;
class Dijkstra_SSSP{
    static void initialiseSingleSource(int dist[], int path[], int src){
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
        dist[src] = 0;
    }
    static void getGraph(int arr[][], Scanner sc){
        System.out.println("Enter a adjacency matrix for graph having directed edges and non-negative weights");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }
    static int min(int dist[], HashSet<Integer> visited){
        int minimum = Integer.MAX_VALUE, minimumVertex = -1;
        for (int i = 0; i < dist.length; i++) {
            if(dist[i]<minimum && !visited.contains(i)){
                minimum = dist[i];
                minimumVertex = i;
            }
        }
        return minimumVertex;
    }
    static void printSolution(int dist[], int path[]){
        System.out.println("Shortest Distance: ");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + ": " + dist[i]);
        }
        System.out.println("Shortest Path: ");
        for (int i = 0; i < path.length; i++) {
            System.out.print(i);
            int temp = i;
            while(path[temp]!=-1){
                System.out.print(" <-- " + path[temp]);
                temp = path[temp];
            }
            System.out.println();
        }
    }
    static void dijkstra(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        getGraph(graph, sc);
        System.out.println("Enter source vertex: ");
        int src = sc.nextInt();
        int dist[] = new int[n];
        int path[] = new int[n];
        initialiseSingleSource(dist, path, src);
        HashSet<Integer> visited = new HashSet<Integer>(n);
        while(visited.size()<n){
            int u = min(dist, visited);
            visited.add(u);
            for (int i = 0; i < n; i++) {
                if(graph[u][i]!=0 && (dist[u]+graph[u][i])<dist[i]){
                    dist[i] = dist[u] + graph[u][i];
                    path[i] = u;
                }
            }
        }
        printSolution(dist, path);
    }
    public static void main (String[] args) {
        dijkstra();
    }
}