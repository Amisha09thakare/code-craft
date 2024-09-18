import java.util.*;

public class DFSGraph {

    // Graph class representing the graph using adjacency list
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the adjacency list
    public DFSGraph() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);  // For undirected graph
    }

    // Depth-First Search function
    public void dfs(int startVertex) {
        // Create a boolean array to keep track of visited vertices
        Set<Integer> visited = new HashSet<>();
        dfsUtil(startVertex, visited);
    }

    // Recursive DFS helper function
    private void dfsUtil(int vertex, Set<Integer> visited) {
        // Mark the current vertex as visited and print it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recursively visit all the adjacent vertices
        for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph();

        // Add edges to the graph (undirected graph)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform DFS starting from vertex 0
        System.out.println("DFS traversal starting from vertex 0:");
        graph.dfs(0);
    }
}
