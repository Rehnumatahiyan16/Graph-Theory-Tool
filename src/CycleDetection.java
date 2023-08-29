import java.util.ArrayList;

public class CycleDetection {
    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && hasCycleDFS(graph, i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycleDFS(ArrayList<Edge>[] graph, int u, boolean[] visited, boolean[] recStack) {
        visited[u] = true;
        recStack[u] = true;

        for (Edge edge : graph[u]) {
            int v = edge.dst;

            if (!visited[v]) {
                if (hasCycleDFS(graph, v, visited, recStack)) {
                    return true;
                }
            } else if (recStack[v]) {
                return true;
            }
        }

        recStack[u] = false;
        return false;
    }
}
