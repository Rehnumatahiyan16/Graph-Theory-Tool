import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void dijkstra(ArrayList<Edge>[] graph, int startVertex) {
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startVertex] = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        minHeap.offer(startVertex);

        while (!minHeap.isEmpty()) {
            int currentVertex = minHeap.poll();

            for (Edge edge : graph[currentVertex]) {
                int neighbor = edge.dst;
                int newDist = dist[currentVertex] + edge.weight;

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    minHeap.offer(neighbor);
                }
            }
        }

        System.out.println("Shortest distances from vertex " + startVertex + " using Dijkstra's Algorithm:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("To vertex " + i + ": " + dist[i]);
        }
    }
}
