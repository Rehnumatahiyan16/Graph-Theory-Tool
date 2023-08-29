import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static boolean bellmanFord(ArrayList<Edge>[] graph, int startVertex) {
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (Edge edge : graph[u]) {
                    int v = edge.dst;
                    int weight = edge.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        // Check for negative cycle
        for (int u = 0; u < numVertices; u++) {
            for (Edge edge : graph[u]) {
                int v = edge.dst;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    return true; // Negative cycle found
                }
            }
        }

        return false; // No negative cycle
    }
    public static void printShortestPathBellmanFord(ArrayList<Edge>[] graph, int source) {
        int numVertices = graph.length;
        int[] distance = new int[numVertices];
        int[] parent = new int[numVertices];

        // Initialize distances and parent array
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source] = 0;

        // Run the Bellman-Ford algorithm to compute shortest paths
        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (Edge edge : graph[u]) {
                    int v = edge.dst;
                    int weight = edge.weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                        parent[v] = u;
                    }
                }
            }
        }

        // Print the shortest distances in the specified format
        System.out.println("Shortest distances from vertex " + source + " using Bellman-Ford Algorithm:");
        for (int i = 0; i < numVertices; i++) {
            if (i == source) {
                continue; // Skip the source vertex itself
            }
            System.out.println("To vertex " + i + ": " + distance[i]);
        }

        // Print the shortest paths
        System.out.println("\nShortest paths from vertex " + source + " using Bellman-Ford Algorithm:");
        for (int i = 0; i < numVertices; i++) {
            if (i == source) {
                continue; // Skip the source vertex itself
            }
            System.out.print("To vertex " + i + ": ");
            printPath(parent, i);
            System.out.println();
        }
    }

    private static void printPath(int[] parent, int vertex) {
        if (vertex == -1) {
            return; // Base case: reached the source vertex
        }
        printPath(parent, parent[vertex]);
        System.out.print(vertex + " ");
    }

}
