import java.util.ArrayList;

public class DirectedCycleDetection {
    private static boolean hasCycle;

    public static boolean hasCycleDirected(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];
        hasCycle = false;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                hasCycleDFSDirected(graph, i, visited, recStack);
            }
        }

        return hasCycle;
    }

    private static void hasCycleDFSDirected(ArrayList<Edge>[] graph, int u, boolean[] visited, boolean[] recStack) {
        visited[u] = true;
        recStack[u] = true;

        for (Edge edge : graph[u]) {
            int v = edge.dst;

            if (!visited[v]) {
                hasCycleDFSDirected(graph, v, visited, recStack);
            } else if (recStack[v]) {
                hasCycle = true;
                printCycle(graph, u, v);
            }
        }

        recStack[u] = false;
    }

    private static void printCycle(ArrayList<Edge>[] graph, int startVertex, int endVertex) {
        System.out.print("Cycle detected: ");
        ArrayList<Integer> cycleVertices = new ArrayList<>();
        cycleVertices.add(startVertex);

        for (int v = startVertex; v != endVertex; v = graph[v].get(0).dst) {
            cycleVertices.add(graph[v].get(0).dst);
        }

        // Print all vertices in the cycle
        for (int i = 0; i < cycleVertices.size(); i++) {
            System.out.print(cycleVertices.get(i));
            if (i < cycleVertices.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }

}
