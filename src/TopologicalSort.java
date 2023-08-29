import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(graph, i, visited, stack);
            }
        }

        System.out.println("Topological Sorting:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    private static void dfsTopologicalSort(ArrayList<Edge>[] graph, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        for (Edge edge : graph[u]) {
            int v = edge.dst;
            if (!visited[v]) {
                dfsTopologicalSort(graph, v, visited, stack);
            }
        }

        stack.push(u);
    }

}
