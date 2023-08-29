import java.util.ArrayList;
import java.util.List;

public class UndirectedCycleDetection {
    private static List<Integer> cycle;

    public static boolean hasCycleUndirected(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        cycle = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && hasCycleDFSUndirected(graph, i, visited, -1)) {
                return true;
            }
        }

        return false;
    }

    // Helper function for cycle detection in an Undirected Graph using DFS
    private static boolean hasCycleDFSUndirected(ArrayList<Edge>[] graph, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (Edge edge : graph[u]) {
            int v = edge.dst;

            if (!visited[v]) {
                if (hasCycleDFSUndirected(graph, v, visited, u)) {
                    cycle.add(u);
                    return true;
                }
            } else if (v != parent && !cycle.contains(v)) {
                cycle.add(u);
                cycle.add(v);
                return true;
            }
        }

        return false;
    }

    public static List<Integer> getCycle() {
        return cycle;
    }
}
