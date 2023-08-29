import java.util.ArrayList;

public class PrintGraphMatrix {
    public static void printGraphMatrix(ArrayList<Edge>[] graph) {
        int numVertices = graph.length;
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        // Populate the adjacency matrix
        for (ArrayList<Edge> edges : graph) {
            for (Edge edge : edges) {
                adjacencyMatrix[edge.src][edge.dst] = 1;
            }
        }

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
