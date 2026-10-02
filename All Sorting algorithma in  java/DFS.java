import java.util.*;

public class DFS {

    static void dfs(int node, List<List<Integer>> graph,
                    boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(1).add(0);
        graph.get(2).add(0);
        graph.get(3).add(1);
        graph.get(4).add(1);

        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");
        dfs(0, graph, visited);
    }
}
