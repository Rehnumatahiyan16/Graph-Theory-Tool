import java.util.ArrayList;
import java.util.Arrays;

public class TarjanArticulation {
    private static int time = 0;
    public static void tarjanArticulationPointsAndBridges(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;

        int[] disc = new int[numVertices];
        int[] low = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] parent = new int[numVertices];
        boolean[] articulationPoints = new boolean[numVertices];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(visited, false);

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfsTarjan(graph, i, disc, low, visited, parent, articulationPoints);
            }
        }

        // Print articulation points
        System.out.println("Articulation Points:");
        for (int i = 0; i < numVertices; i++) {
            if (articulationPoints[i]) {
                System.out.print(i + " ");
            }
        }

        // Print bridges
        System.out.println("\nBridges:");
        for (int u = 0; u < numVertices; u++) {
            for (Edge edge : graph[u]) {
                int v = edge.dst;
                if (low[u] < low[v]) {
                    System.out.println(u + " - " + v);
                }
            }
        }
    }
    private static void dfsTarjan(ArrayList<Edge>[] graph, int u, int[] disc, int[] low, boolean[] visited, int[] parent, boolean[] articulationPoints) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;
        try {
        for (Edge edge : graph[u]) {
            int v = edge.dst;

            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfsTarjan(graph, v, disc, low, visited, parent, articulationPoints);

                low[u] = Math.min(low[u], low[v]);

                // Check for articulation points
                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u])) {
                    articulationPoints[u] = true;
                }

                // Check for bridges
                if (low[v] > disc[u]) {
                    System.out.println(u + " - " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
        catch (ArrayIndexOutOfBoundsException ex) {
        }
        }
}


