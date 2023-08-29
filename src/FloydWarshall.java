import java.util.ArrayList;

public class FloydWarshall {
    public static void floydWarshall(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        int[][] dist = new int[numVertices][numVertices];

        // Initialize distances
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Populate distances from edges
        for (int u = 0; u < numVertices; u++) {
            for (Edge edge : graph[u]) {
                int v = edge.dst;
                int weight = edge.weight;
                dist[u][v] = weight;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("Shortest distances using Floyd-Warshall Algorithm:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(dist[i] [j] + "  ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        FloydWarshall f=new FloydWarshall();
//        f.floydWarshall();
//    }
}
