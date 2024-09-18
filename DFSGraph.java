import java.util.*;

public class DFSGraph {

    
    private Map<Integer, List<Integer>> adjList;

    
    public DFSGraph() {
        adjList = new HashMap<>();
    }

   
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);  // For undirected graph
    }

   
    public void dfs(int startVertex) {
       
        Set<Integer> visited = new HashSet<>();
        dfsUtil(startVertex, visited);
    }


    private void dfsUtil(int vertex, Set<Integer> visited) {
       
        visited.add(vertex);
        System.out.print(vertex + " ");


        for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph();


        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        
        System.out.println("DFS traversal starting from vertex 0:");
        graph.dfs(0);
    }
}
