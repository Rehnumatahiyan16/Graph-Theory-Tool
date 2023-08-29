import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(ArrayList<Edge>[] graph, int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (Edge edge : graph[currentVertex]) {
                int neighbor = edge.dst;
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void bfsDisconnectedGraph(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
            }
        }
    }
}
