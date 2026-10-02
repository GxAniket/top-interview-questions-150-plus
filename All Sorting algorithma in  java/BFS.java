
import java.util.*;

public class BFS {

    static void bfs(int start, List<List<Integer>> graph,
                    boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(1).add(0);
        graph.get(2).add(0);
        graph.get(3).add(1);
        graph.get(4).add(1);

        boolean[] visited = new boolean[vertices];

        System.out.print("BFS Traversal: ");
        bfs(0, graph, visited);
    }
}
