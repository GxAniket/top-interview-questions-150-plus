
import java.util.*;

public class KruskalsMST {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static boolean union(int[] parent, int[] rank,
                         int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY) {
            return false; // Adding this edge creates a cycle
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }

    static void kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;
        int selectedEdges = 0;

        System.out.println("Edge   Weight");

        for (Edge edge : edges) {
            if (union(parent, rank, edge.src, edge.dest)) {
                System.out.println(
                    edge.src + " - " + edge.dest
                    + "     " + edge.weight
                );

                totalWeight += edge.weight;
                selectedEdges++;

                if (selectedEdges == vertices - 1) {
                    break;
                }
            }
        }

        if (selectedEdges != vertices - 1) {
            System.out.println("Graph is disconnected.");
        } else {
            System.out.println(
                "Total MST Weight: " + totalWeight
            );
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        kruskalMST(vertices, edges);
    }
}
