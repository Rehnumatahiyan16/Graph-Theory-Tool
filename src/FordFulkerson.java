import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    public static int fordFulkerson(ArrayList<Edge>[] graph, int source, int sink) {
        int numVertices = graph.length;
        int[][] residualGraph = new int[numVertices][numVertices];

        // Initialize the residual graph
        for (int u = 0; u < numVertices; u++) {
            for (Edge edge : graph[u]) {
                int v = edge.dst;
                int weight = edge.weight;
                residualGraph[u][v] = weight;
            }
        }

        int[] parent = new int[numVertices];
        int maxFlow = 0;

        while (bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
    private static boolean bfs(int[][] graph, int source, int sink, int[] parent) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }
}
