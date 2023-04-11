import java.util.*;
class Prim{
	static void initialise(int dist[], int path[], int src){
    	for (int i = 0; i < dist.length; i++) {
        	dist[i] = Integer.MAX_VALUE;
        	path[i] = -1;
    	}
    	dist[src] = 0;
	}
	static void getGraph(int arr[][], Scanner sc){
    	System.out.println("Enter a adjacency matrix: ");
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
	static void printSolution(int dist[], int path[], int src){
    	int mstW = 0;
    	System.out.println("Shortest Path: ");
    	for (int i = 0; i < path.length; i++) {
    	    if(i==src)
    	        continue;
        	System.out.println(i + " - " + path[i] + " : " + dist[i]);
        	mstW += dist[i];
    	}
    	System.out.println("Minimum Weight = " + mstW);
	}	 
	static void prim(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of vertices");
    	int n = sc.nextInt();
    	int graph[][] = new int[n][n];
    	getGraph(graph, sc);
    	System.out.println("Enter source vertex: ");
    	int src = sc.nextInt();
    	int dist[] = new int[n];
    	int path[] = new int[n];
    	initialise(dist, path, src);
    	HashSet<Integer> visited = new HashSet<>(n);
    	while(visited.size()<n){
        	int u = min(dist, visited);
        	visited.add(u);
        	for (int i = 0; i < n; i++) {
            	if(graph[u][i]!=0 && graph[u][i]<dist[i] && !visited.contains(i)){
                	dist[i] = graph[u][i];
                	path[i] = u;
            	}
        	}   
    	}
    	printSolution(dist, path, src);
	}
}
class Kruskal {
    static void kruskal(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = input.nextInt();

        int[][] graph = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        int[] parent = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> mst = new ArrayList<Edge>();

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).u;
            int v = edges.get(i).v;
            int weight = edges.get(i).weight;

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            if (parentU != parentV) {
                mst.add(new Edge(u, v, weight));
                parent[parentU] = parentV;
            }
        }
        int sum=0;
        System.out.println("Minimum Spanning Tree:");
        for (Edge e : mst) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
            sum+=e.weight;
        }
        System.out.println("Minimum Weight: " + sum);
    }
    public static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    public static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}
public class MinimumSpanningTree{
    public static void main(String[] args) {
        //Both Kruskal's and Prim's algorithm work with negative edge weights
        System.out.println("Minimum Spanning Tree using Kruskal's Algorithm(for undirected graph): ");
        Kruskal ob1 = new Kruskal();
        ob1.kruskal();
        System.out.println("Minimum Spanning Tree using Prim's Algorithm(for undirected graph): ");
        Prim ob2 = new Prim();
        ob2.prim();
    }
}
