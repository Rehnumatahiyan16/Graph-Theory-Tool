import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void dfs(ArrayList<Edge>[] graph, int startVertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (Edge edge : graph[currentVertex]) {
                int neighbor = edge.dst;
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void dfsDisconnectedGraph(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
}
